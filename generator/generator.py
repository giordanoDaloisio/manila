import argparse
import os
from pprint import pprint
import re
import sys
import xml.etree.ElementTree as ET
from jinja2 import Environment, PackageLoader, select_autoescape


def camel_to_snake(name):
    name = re.sub('(.)([A-Z][a-z]+)', r'\1_\2', name)
    return re.sub('([a-z0-9])([A-Z])', r'\1_\2', name).lower().strip().replace(" ", "_")

def tree_parser(root):
    params = dict()
    for feature in root.findall('feature'):
        if feature.get('automatic') == 'selected' or feature.get('manual') == 'selected':
            for child in feature:
                params[camel_to_snake(child.get('name'))] = child.get('value')
            params[camel_to_snake(feature.get('name'))] = camel_to_snake(
                feature.get('name'))
    return params

def check_params(params):
    if 'name' not in params:
        sys.exit(
            "Label name not specified. Specify the name of the label in the configuration file")
    if 'positive_value' not in params and 'fairness' in params:
        sys.exit(
            "Positive value of the label not specified. Specify the positive value of the label in the configuration file")
    if 'single_sensitive_var' in params and 'variable_name' not in params:
        sys.exit(
            "Sensitive variable name not specified. Specify the name in the configuration file")
    if 'single_sensitive_var' in params and 'unprivileged_value' not in params:
        sys.exit(
            "Unprivileged value not specified. Specify the value in the configuration file")
    if 'multiple_sensitive_vars' in params and 'variable_names_comma_separated' not in params:
        sys.exit(
            "Sensitive variable names not specified. Specify the names in the configuration file (comma separated)")
    if 'multiple_sensitive_vars' in params and 'unprivileged_values_comma_separated' not in params:
        sys.exit(
            "Unprivileged values not specified. Specify the values in the configuration file (comma separated)")


if __name__ == '__main__':

    parser = argparse.ArgumentParser(
        description="Generate python script from configuration file")
    parser.add_argument('-n', '--name', type=str,
                        help='name of configuration file inside configs folder')

    args = parser.parse_args()
    try:
        tree = ET.parse(args.name)
        root = tree.getroot()
    except:
        sys.exit(
            "File not found in the configs folder. Make sure you add .xml at the end of the file name")
    params = tree_parser(root)
    check_params(params)
    config_name = args.name.split('/')[-1]
    folder_name = './gen/'+config_name.replace('.xml','')
    os.makedirs(folder_name, exist_ok=True)
    env = Environment(loader=PackageLoader('generator'),
                      autoescape=select_autoescape(disabled_extensions=(['py','yml'])), 
                      lstrip_blocks=True, 
                      trim_blocks=True)
    main = env.get_template('main.py.jinja')
    utils = env.get_template('utils.py.jinja')
    demv = env.get_template('demv.py.jinja')
    environment = env.get_template('environment.yml.jinja')
    metrics = env.get_template('metrics.py.jinja')
    trainer = env.get_template('model_trainer.py.jinja')
    methods = env.get_template('methods.py.jinja')
    charts = env.get_template('charts.py.jinja')
    # pprint(params)
    with open(os.path.join(folder_name, 'main.py'), 'w') as f:
        f.write(main.render(params))
    with open(os.path.join(folder_name, 'utils.py'), 'w') as f:
        f.write(utils.render(params))
    with open(os.path.join(folder_name, 'environment.yml'), 'w') as f:
        f.write(environment.render(params))
    with open(os.path.join(folder_name, 'metrics.py'), 'w') as f:
        f.write(metrics.render(params))
    with open(os.path.join(folder_name, 'model_trainer.py'), 'w') as f:
        f.write(trainer.render(params))
    with open(os.path.join(folder_name, 'methods.py'), 'w') as f:
        f.write(methods.render(params))
    if 'demv' in params:
        with open(os.path.join(folder_name, 'demv.py'), 'w') as f:
            f.write(demv.render())
    if 'chart' in params:
        with open(os.path.join(folder_name,'charts.py'), 'w') as f:
            f.write(charts.render())
    sys.exit("Script generated")
