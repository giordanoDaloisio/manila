/**
 */
package it.disim.univaq.qml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.disim.univaq.qml.FeatureModel#getRoot <em>Root</em>}</li>
 *   <li>{@link it.disim.univaq.qml.FeatureModel#getGroups <em>Groups</em>}</li>
 *   <li>{@link it.disim.univaq.qml.FeatureModel#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link it.disim.univaq.qml.FeatureModel#getQualityProperties <em>Quality Properties</em>}</li>
 *   <li>{@link it.disim.univaq.qml.FeatureModel#getRequirement <em>Requirement</em>}</li>
 * </ul>
 *
 * @see it.disim.univaq.qml.QmlPackage#getFeatureModel()
 * @model
 * @generated
 */
public interface FeatureModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Feature)
	 * @see it.disim.univaq.qml.QmlPackage#getFeatureModel_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Feature getRoot();

	/**
	 * Sets the value of the '{@link it.disim.univaq.qml.FeatureModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Feature value);

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link it.disim.univaq.qml.Group}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see it.disim.univaq.qml.QmlPackage#getFeatureModel_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<Group> getGroups();

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link it.disim.univaq.qml.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see it.disim.univaq.qml.QmlPackage#getFeatureModel_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraint();

	/**
	 * Returns the value of the '<em><b>Quality Properties</b></em>' containment reference list.
	 * The list contents are of type {@link it.disim.univaq.qml.QualityProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Properties</em>' containment reference list.
	 * @see it.disim.univaq.qml.QmlPackage#getFeatureModel_QualityProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<QualityProperty> getQualityProperties();

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' containment reference.
	 * @see #setRequirement(Requirement)
	 * @see it.disim.univaq.qml.QmlPackage#getFeatureModel_Requirement()
	 * @model containment="true"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link it.disim.univaq.qml.FeatureModel#getRequirement <em>Requirement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' containment reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

} // FeatureModel
