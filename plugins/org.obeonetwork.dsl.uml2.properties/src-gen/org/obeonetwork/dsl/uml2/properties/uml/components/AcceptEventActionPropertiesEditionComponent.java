/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.uml2.properties.uml.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.obeonetwork.dsl.uml2.properties.uml.parts.AcceptEventActionPropertiesEditionPart;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;


// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class AcceptEventActionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for clientDependency ReferencesTable
	 */
	private	ReferencesTableSettings clientDependencySettings;
	
	/**
	 * Settings for inStructuredNode EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings inStructuredNodeSettings;
	
	/**
	 * Settings for activity EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings activitySettings;
	
	/**
	 * Settings for outgoing ReferencesTable
	 */
	private	ReferencesTableSettings outgoingSettings;
	
	/**
	 * Settings for incoming ReferencesTable
	 */
	private	ReferencesTableSettings incomingSettings;
	
	/**
	 * Settings for inPartition ReferencesTable
	 */
	private	ReferencesTableSettings inPartitionSettings;
	
	/**
	 * Settings for inInterruptibleRegion ReferencesTable
	 */
	private	ReferencesTableSettings inInterruptibleRegionSettings;
	
	/**
	 * Settings for redefinedNode ReferencesTable
	 */
	private	ReferencesTableSettings redefinedNodeSettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public AcceptEventActionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject acceptEventAction, String editing_mode) {
		super(editingContext, acceptEventAction, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = UmlViewsRepository.class;
		partKey = UmlViewsRepository.AcceptEventAction.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final AcceptEventAction acceptEventAction = (AcceptEventAction)elt;
			final AcceptEventActionPropertiesEditionPart basePart = (AcceptEventActionPropertiesEditionPart)editingPart;
			// init values
			if (acceptEventAction.getName() != null && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(UMLPackage.eINSTANCE.getString(), acceptEventAction.getName()));
			
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.visibility)) {
				basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), acceptEventAction.getVisibility());
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.clientDependency)) {
				clientDependencySettings = new ReferencesTableSettings(acceptEventAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
				basePart.initClientDependency(clientDependencySettings);
			}
			basePart.setIsLeaf(acceptEventAction.isLeaf());
			
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.inStructuredNode)) {
				// init part
				inStructuredNodeSettings = new EObjectFlatComboSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_InStructuredNode());
				basePart.initInStructuredNode(inStructuredNodeSettings);
				// set the button mode
				basePart.setInStructuredNodeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.activity)) {
				// init part
				activitySettings = new EObjectFlatComboSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_Activity());
				basePart.initActivity(activitySettings);
				// set the button mode
				basePart.setActivityButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.outgoing)) {
				outgoingSettings = new ReferencesTableSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_Outgoing());
				basePart.initOutgoing(outgoingSettings);
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.incoming)) {
				incomingSettings = new ReferencesTableSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_Incoming());
				basePart.initIncoming(incomingSettings);
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.inPartition)) {
				inPartitionSettings = new ReferencesTableSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_InPartition());
				basePart.initInPartition(inPartitionSettings);
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.inInterruptibleRegion)) {
				inInterruptibleRegionSettings = new ReferencesTableSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
				basePart.initInInterruptibleRegion(inInterruptibleRegionSettings);
			}
			if (isAccessible(UmlViewsRepository.AcceptEventAction.Properties.redefinedNode)) {
				redefinedNodeSettings = new ReferencesTableSettings(acceptEventAction, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());
				basePart.initRedefinedNode(redefinedNodeSettings);
			}
			basePart.setIsUnmarshall(acceptEventAction.isUnmarshall());
			
			// init filters
			
			
			basePart.addFilterToClientDependency(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInClientDependencyTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			basePart.addFilterToClientDependency(new EObjectFilter(UMLPackage.eINSTANCE.getDependency()));
			// Start of user code for additional businessfilters for clientDependency
			
			// End of user code
			
			
			basePart.addFilterToInStructuredNode(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof StructuredActivityNode); //$NON-NLS-1$ 
				}
			
			});
			// Start of user code for additional businessfilters for inStructuredNode
			
			// End of user code
			
			basePart.addFilterToActivity(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof Activity); //$NON-NLS-1$ 
				}
			
			});
			// Start of user code for additional businessfilters for activity
			
			// End of user code
			
			basePart.addFilterToOutgoing(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInOutgoingTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			basePart.addFilterToOutgoing(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for outgoing
			
			// End of user code
			
			basePart.addFilterToIncoming(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInIncomingTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			basePart.addFilterToIncoming(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for incoming
			
			// End of user code
			
			basePart.addFilterToInPartition(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInInPartitionTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			basePart.addFilterToInPartition(new EObjectFilter(UMLPackage.eINSTANCE.getActivityPartition()));
			// Start of user code for additional businessfilters for inPartition
			
			// End of user code
			
			basePart.addFilterToInInterruptibleRegion(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInInInterruptibleRegionTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			basePart.addFilterToInInterruptibleRegion(new EObjectFilter(UMLPackage.eINSTANCE.getInterruptibleActivityRegion()));
			// Start of user code for additional businessfilters for inInterruptibleRegion
			
			// End of user code
			
			basePart.addFilterToRedefinedNode(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInRedefinedNodeTable((EObject)element));
					return element instanceof Resource;
				}
			
			});
			basePart.addFilterToRedefinedNode(new EObjectFilter(UMLPackage.eINSTANCE.getActivityNode()));
			// Start of user code for additional businessfilters for redefinedNode
			
			// End of user code
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}















	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		AcceptEventAction acceptEventAction = (AcceptEventAction)semanticObject;
		if (UmlViewsRepository.AcceptEventAction.Properties.name == event.getAffectedEditor()) {
			acceptEventAction.setName((java.lang.String)EEFConverterUtil.createFromString(UMLPackage.eINSTANCE.getString(), (String)event.getNewValue()));
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.visibility == event.getAffectedEditor()) {
			acceptEventAction.setVisibility((VisibilityKind)event.getNewValue());
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.clientDependency == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof Dependency) {
					clientDependencySettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					clientDependencySettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.isLeaf == event.getAffectedEditor()) {
			acceptEventAction.setIsLeaf((Boolean)event.getNewValue());
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.inStructuredNode == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET)  {
				inStructuredNodeSettings.setToReference((StructuredActivityNode)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD)  {
				StructuredActivityNode eObject = UMLFactory.eINSTANCE.createStructuredActivityNode();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				inStructuredNodeSettings.setToReference(eObject);
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.activity == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET)  {
				activitySettings.setToReference((Activity)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD)  {
				Activity eObject = UMLFactory.eINSTANCE.createActivity();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				activitySettings.setToReference(eObject);
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.outgoing == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof ActivityEdge) {
					outgoingSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					outgoingSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.incoming == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof ActivityEdge) {
					incomingSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					incomingSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.inPartition == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof ActivityPartition) {
					inPartitionSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					inPartitionSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.inInterruptibleRegion == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof InterruptibleActivityRegion) {
					inInterruptibleRegionSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					inInterruptibleRegionSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.redefinedNode == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof ActivityNode) {
					redefinedNodeSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					redefinedNodeSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (UmlViewsRepository.AcceptEventAction.Properties.isUnmarshall == event.getAffectedEditor()) {
			acceptEventAction.setIsUnmarshall((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {	
			AcceptEventActionPropertiesEditionPart basePart = (AcceptEventActionPropertiesEditionPart)editingPart;
			if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(UMLPackage.eINSTANCE.getString(), msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.visibility))
				basePart.setVisibility((Enumerator)msg.getNewValue());
			
			if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.clientDependency))
				basePart.updateClientDependency();
			if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.isLeaf))
				basePart.setIsLeaf((Boolean)msg.getNewValue());
			
			if (UMLPackage.eINSTANCE.getActivityNode_InStructuredNode().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.inStructuredNode))
				basePart.setInStructuredNode((EObject)msg.getNewValue());
			if (UMLPackage.eINSTANCE.getActivityNode_Activity().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.activity))
				basePart.setActivity((EObject)msg.getNewValue());
			if (UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.outgoing))
				basePart.updateOutgoing();
			if (UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.incoming))
				basePart.updateIncoming();
			if (UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.inPartition))
				basePart.updateInPartition();
			if (UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.inInterruptibleRegion))
				basePart.updateInInterruptibleRegion();
			if (UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.redefinedNode))
				basePart.updateRedefinedNode();
			if (UMLPackage.eINSTANCE.getAcceptEventAction_IsUnmarshall().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.AcceptEventAction.Properties.isUnmarshall))
				basePart.setIsUnmarshall((Boolean)msg.getNewValue());
			
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == UmlViewsRepository.AcceptEventAction.Properties.isLeaf || key == UmlViewsRepository.AcceptEventAction.Properties.isUnmarshall;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (UmlViewsRepository.AcceptEventAction.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (UmlViewsRepository.AcceptEventAction.Properties.visibility == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if (UmlViewsRepository.AcceptEventAction.Properties.isLeaf == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if (UmlViewsRepository.AcceptEventAction.Properties.isUnmarshall == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getAcceptEventAction_IsUnmarshall().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getAcceptEventAction_IsUnmarshall().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
