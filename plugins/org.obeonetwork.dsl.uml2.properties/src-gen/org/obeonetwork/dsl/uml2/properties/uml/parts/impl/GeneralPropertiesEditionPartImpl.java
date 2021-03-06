/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.uml2.properties.uml.parts.impl;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FlatReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.imageviewer.EEFImageViewer;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;

import org.obeonetwork.dsl.uml2.properties.uml.providers.UmlMessages;


/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cédric Brun</a>
 * @generated
 */
public class GeneralPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GeneralPropertiesEditionPart {

	protected Text name;
	protected EMFComboViewer visibility;
	protected Button ordered;
	protected Button abstract_;
	protected Button leaf;
	protected Button static_;
	protected Button unique;
	protected Button query;
	protected Button readOnly;
	protected Button derived;
	protected Button derivedUnion;
	protected Button substitutable;
	protected Button active;
	protected Button behavior;
	protected Button service;
	protected Button reentrant;
	protected Button indirectlyInstantiated;
	protected EObjectFlatComboViewer type;
	protected EMFComboViewer direction;
	protected EMFComboViewer aggregation;
	protected Text upperValue;
	protected Text lowerValue;
	protected Text defaultValue;
	protected ReferencesTable memberEnd;
	protected List<ViewerFilter> memberEndBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> memberEndFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable supplier;
	protected List<ViewerFilter> supplierBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> supplierFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable client;
	protected List<ViewerFilter> clientBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> clientFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer kind;
	protected EObjectFlatComboViewer source;
	protected EObjectFlatComboViewer target;
	protected EObjectFlatComboViewer effect;
	protected EObjectFlatComboViewer guard;
	protected ReferencesTable ownedRule;
	protected List<ViewerFilter> ownedRuleBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ownedRuleFilters = new ArrayList<ViewerFilter>();
	protected EEFImageViewer icon;
	protected Text body;
	protected EMFComboViewer extendedCase;
	protected EMFComboViewer addition;
	protected EMFComboViewer pseudostatekind;
	protected EObjectFlatComboViewer role;
	protected FlatReferencesTable usecase;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * @generated
	 */
	public GeneralPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
    super(editionComponent);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * @generated
	 */
	public Composite createFigure(final Composite parent) {
    view = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout();
    layout.numColumns = 3;
    view.setLayout(layout);
    createControls(view);
    return view;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * @generated
	 */
	public void createControls(Composite view) { 
    CompositionSequence generalStep = new BindingCompositionSequence(propertiesEditionComponent);
    generalStep.addStep(UmlViewsRepository.General.name);
    generalStep.addStep(UmlViewsRepository.General.visibility);
    CompositionStep qualifiersStep = generalStep.addStep(UmlViewsRepository.General.Qualifiers.class);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.ordered);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.abstract_);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.leaf);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.static_);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.unique);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.query);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.readOnly);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.derived);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.derivedUnion);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.substitutable);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.active);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.behavior);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.service);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.reentrant);
    qualifiersStep.addStep(UmlViewsRepository.General.Qualifiers.indirectlyInstantiated);
    
    generalStep.addStep(UmlViewsRepository.General.type);
    generalStep.addStep(UmlViewsRepository.General.direction);
    generalStep.addStep(UmlViewsRepository.General.aggregation);
    generalStep.addStep(UmlViewsRepository.General.upperValue);
    generalStep.addStep(UmlViewsRepository.General.lowerValue);
    generalStep.addStep(UmlViewsRepository.General.defaultValue);
    generalStep.addStep(UmlViewsRepository.General.memberEnd);
    generalStep.addStep(UmlViewsRepository.General.supplier);
    generalStep.addStep(UmlViewsRepository.General.client);
    generalStep.addStep(UmlViewsRepository.General.kind);
    generalStep.addStep(UmlViewsRepository.General.source);
    generalStep.addStep(UmlViewsRepository.General.target);
    generalStep.addStep(UmlViewsRepository.General.effect);
    generalStep.addStep(UmlViewsRepository.General.guard);
    generalStep.addStep(UmlViewsRepository.General.ownedRule);
    generalStep.addStep(UmlViewsRepository.General.icon);
    generalStep.addStep(UmlViewsRepository.General.body);
    generalStep.addStep(UmlViewsRepository.General.extendedCase);
    generalStep.addStep(UmlViewsRepository.General.addition);
    generalStep.addStep(UmlViewsRepository.General.pseudostatekind);
    generalStep.addStep(UmlViewsRepository.General.role);
    generalStep.addStep(UmlViewsRepository.General.usecase);
    
    composer = new PartComposer(generalStep) {

      @Override
      public Composite addToPart(Composite parent, Object key) {
        if (key == UmlViewsRepository.General.name) {
          return createNameText(parent);
        }
        if (key == UmlViewsRepository.General.visibility) {
          return createVisibilityEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.class) {
          return createQualifiersHBox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.ordered) {
          return createOrderedCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.abstract_) {
          return createAbstract_Checkbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.leaf) {
          return createLeafCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.static_) {
          return createStatic_Checkbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.unique) {
          return createUniqueCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.query) {
          return createQueryCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.readOnly) {
          return createReadOnlyCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.derived) {
          return createDerivedCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.derivedUnion) {
          return createDerivedUnionCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.substitutable) {
          return createSubstitutableCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.active) {
          return createActiveCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.behavior) {
          return createBehaviorCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.service) {
          return createServiceCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.reentrant) {
          return createReentrantCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.Qualifiers.indirectlyInstantiated) {
          return createIndirectlyInstantiatedCheckbox(parent);
        }
        if (key == UmlViewsRepository.General.type) {
          return createTypeFlatComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.direction) {
          return createDirectionEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.aggregation) {
          return createAggregationEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.upperValue) {
          return createUpperValueText(parent);
        }
        if (key == UmlViewsRepository.General.lowerValue) {
          return createLowerValueText(parent);
        }
        if (key == UmlViewsRepository.General.defaultValue) {
          return createDefaultValueText(parent);
        }
        if (key == UmlViewsRepository.General.memberEnd) {
          return createMemberEndAdvancedReferencesTable(parent);
        }
        if (key == UmlViewsRepository.General.supplier) {
          return createSupplierAdvancedReferencesTable(parent);
        }
        if (key == UmlViewsRepository.General.client) {
          return createClientAdvancedReferencesTable(parent);
        }
        if (key == UmlViewsRepository.General.kind) {
          return createKindEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.source) {
          return createSourceFlatComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.target) {
          return createTargetFlatComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.effect) {
          return createEffectFlatComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.guard) {
          return createGuardFlatComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.ownedRule) {
          return createOwnedRuleAdvancedReferencesTable(parent);
        }
        if (key == UmlViewsRepository.General.icon) {
          return createIconImageViewer(parent);
        }
        if (key == UmlViewsRepository.General.body) {
          return createBodyTextarea(parent);
        }
        if (key == UmlViewsRepository.General.extendedCase) {
          return createExtendedCaseEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.addition) {
          return createAdditionEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.pseudostatekind) {
          return createPseudostatekindEMFComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.role) {
          return createRoleFlatComboViewer(parent);
        }
        if (key == UmlViewsRepository.General.usecase) {
          return createUsecaseFlatReferencesTable(parent);
        }
        return parent;
      }
    };
    composer.compose(view);
  }

	/**
	 * @generated
	 */
	
	protected Composite createNameText(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.name, UmlMessages.GeneralPropertiesEditionPart_NameLabel);
    name = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
    name.setLayoutData(nameData);
    name.addFocusListener(new FocusAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
      }

    });
    name.addKeyListener(new KeyAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
        }
      }

    });
    EditingUtils.setID(name, UmlViewsRepository.General.name);
    EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.name, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createNameText

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createVisibilityEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.visibility, UmlMessages.GeneralPropertiesEditionPart_VisibilityLabel);
    visibility = new EMFComboViewer(parent);
    visibility.setContentProvider(new ArrayContentProvider());
    visibility.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
    visibility.getCombo().setLayoutData(visibilityData);
    visibility.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	@generated
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
      }

    });
    visibility.setID(UmlViewsRepository.General.visibility);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.visibility, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createVisibilityEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createQualifiersHBox(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
    gridData.horizontalSpan = 3;
    container.setLayoutData(gridData);
    HorizontalBox qualifiersHBox = new HorizontalBox(container);
    //Apply constraint for checkbox
    GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
    constraint.horizontalAlignment = GridData.BEGINNING;
    qualifiersHBox.setLayoutData(constraint);
    return qualifiersHBox;
  }

	/**
	 * @generated
	 */
	
	protected Composite createOrderedCheckbox(Composite parent) {
    ordered = new Button(parent, SWT.CHECK);
    ordered.setText(getDescription(UmlViewsRepository.General.Qualifiers.ordered, UmlMessages.GeneralPropertiesEditionPart_OrderedLabel));
    ordered.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.ordered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(ordered.getSelection())));
      }

    });
    GridData orderedData = new GridData(GridData.FILL_HORIZONTAL);
    orderedData.horizontalSpan = 2;
    ordered.setLayoutData(orderedData);
    EditingUtils.setID(ordered, UmlViewsRepository.General.Qualifiers.ordered);
    EditingUtils.setEEFtype(ordered, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.ordered, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createOrderedCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createAbstract_Checkbox(Composite parent) {
    abstract_ = new Button(parent, SWT.CHECK);
    abstract_.setText(getDescription(UmlViewsRepository.General.Qualifiers.abstract_, UmlMessages.GeneralPropertiesEditionPart_Abstract_Label));
    abstract_.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.abstract_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(abstract_.getSelection())));
      }

    });
    GridData abstract_Data = new GridData(GridData.FILL_HORIZONTAL);
    abstract_Data.horizontalSpan = 2;
    abstract_.setLayoutData(abstract_Data);
    EditingUtils.setID(abstract_, UmlViewsRepository.General.Qualifiers.abstract_);
    EditingUtils.setEEFtype(abstract_, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.abstract_, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createAbstract_Checkbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createLeafCheckbox(Composite parent) {
    leaf = new Button(parent, SWT.CHECK);
    leaf.setText(getDescription(UmlViewsRepository.General.Qualifiers.leaf, UmlMessages.GeneralPropertiesEditionPart_LeafLabel));
    leaf.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.leaf, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(leaf.getSelection())));
      }

    });
    GridData leafData = new GridData(GridData.FILL_HORIZONTAL);
    leafData.horizontalSpan = 2;
    leaf.setLayoutData(leafData);
    EditingUtils.setID(leaf, UmlViewsRepository.General.Qualifiers.leaf);
    EditingUtils.setEEFtype(leaf, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.leaf, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createLeafCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createStatic_Checkbox(Composite parent) {
    static_ = new Button(parent, SWT.CHECK);
    static_.setText(getDescription(UmlViewsRepository.General.Qualifiers.static_, UmlMessages.GeneralPropertiesEditionPart_Static_Label));
    static_.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.static_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(static_.getSelection())));
      }

    });
    GridData static_Data = new GridData(GridData.FILL_HORIZONTAL);
    static_Data.horizontalSpan = 2;
    static_.setLayoutData(static_Data);
    EditingUtils.setID(static_, UmlViewsRepository.General.Qualifiers.static_);
    EditingUtils.setEEFtype(static_, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.static_, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createStatic_Checkbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createUniqueCheckbox(Composite parent) {
    unique = new Button(parent, SWT.CHECK);
    unique.setText(getDescription(UmlViewsRepository.General.Qualifiers.unique, UmlMessages.GeneralPropertiesEditionPart_UniqueLabel));
    unique.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.unique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unique.getSelection())));
      }

    });
    GridData uniqueData = new GridData(GridData.FILL_HORIZONTAL);
    uniqueData.horizontalSpan = 2;
    unique.setLayoutData(uniqueData);
    EditingUtils.setID(unique, UmlViewsRepository.General.Qualifiers.unique);
    EditingUtils.setEEFtype(unique, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.unique, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createUniqueCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createQueryCheckbox(Composite parent) {
    query = new Button(parent, SWT.CHECK);
    query.setText(getDescription(UmlViewsRepository.General.Qualifiers.query, UmlMessages.GeneralPropertiesEditionPart_QueryLabel));
    query.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.query, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(query.getSelection())));
      }

    });
    GridData queryData = new GridData(GridData.FILL_HORIZONTAL);
    queryData.horizontalSpan = 2;
    query.setLayoutData(queryData);
    EditingUtils.setID(query, UmlViewsRepository.General.Qualifiers.query);
    EditingUtils.setEEFtype(query, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.query, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createQueryCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createReadOnlyCheckbox(Composite parent) {
    readOnly = new Button(parent, SWT.CHECK);
    readOnly.setText(getDescription(UmlViewsRepository.General.Qualifiers.readOnly, UmlMessages.GeneralPropertiesEditionPart_ReadOnlyLabel));
    readOnly.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.readOnly, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(readOnly.getSelection())));
      }

    });
    GridData readOnlyData = new GridData(GridData.FILL_HORIZONTAL);
    readOnlyData.horizontalSpan = 2;
    readOnly.setLayoutData(readOnlyData);
    EditingUtils.setID(readOnly, UmlViewsRepository.General.Qualifiers.readOnly);
    EditingUtils.setEEFtype(readOnly, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.readOnly, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createReadOnlyCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createDerivedCheckbox(Composite parent) {
    derived = new Button(parent, SWT.CHECK);
    derived.setText(getDescription(UmlViewsRepository.General.Qualifiers.derived, UmlMessages.GeneralPropertiesEditionPart_DerivedLabel));
    derived.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.derived, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(derived.getSelection())));
      }

    });
    GridData derivedData = new GridData(GridData.FILL_HORIZONTAL);
    derivedData.horizontalSpan = 2;
    derived.setLayoutData(derivedData);
    EditingUtils.setID(derived, UmlViewsRepository.General.Qualifiers.derived);
    EditingUtils.setEEFtype(derived, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.derived, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createDerivedCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createDerivedUnionCheckbox(Composite parent) {
    derivedUnion = new Button(parent, SWT.CHECK);
    derivedUnion.setText(getDescription(UmlViewsRepository.General.Qualifiers.derivedUnion, UmlMessages.GeneralPropertiesEditionPart_DerivedUnionLabel));
    derivedUnion.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.derivedUnion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(derivedUnion.getSelection())));
      }

    });
    GridData derivedUnionData = new GridData(GridData.FILL_HORIZONTAL);
    derivedUnionData.horizontalSpan = 2;
    derivedUnion.setLayoutData(derivedUnionData);
    EditingUtils.setID(derivedUnion, UmlViewsRepository.General.Qualifiers.derivedUnion);
    EditingUtils.setEEFtype(derivedUnion, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.derivedUnion, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createDerivedUnionCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createSubstitutableCheckbox(Composite parent) {
    substitutable = new Button(parent, SWT.CHECK);
    substitutable.setText(getDescription(UmlViewsRepository.General.Qualifiers.substitutable, UmlMessages.GeneralPropertiesEditionPart_SubstitutableLabel));
    substitutable.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.substitutable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(substitutable.getSelection())));
      }

    });
    GridData substitutableData = new GridData(GridData.FILL_HORIZONTAL);
    substitutableData.horizontalSpan = 2;
    substitutable.setLayoutData(substitutableData);
    EditingUtils.setID(substitutable, UmlViewsRepository.General.Qualifiers.substitutable);
    EditingUtils.setEEFtype(substitutable, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.substitutable, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createSubstitutableCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createActiveCheckbox(Composite parent) {
    active = new Button(parent, SWT.CHECK);
    active.setText(getDescription(UmlViewsRepository.General.Qualifiers.active, UmlMessages.GeneralPropertiesEditionPart_ActiveLabel));
    active.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.active, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(active.getSelection())));
      }

    });
    GridData activeData = new GridData(GridData.FILL_HORIZONTAL);
    activeData.horizontalSpan = 2;
    active.setLayoutData(activeData);
    EditingUtils.setID(active, UmlViewsRepository.General.Qualifiers.active);
    EditingUtils.setEEFtype(active, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.active, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createActiveCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createBehaviorCheckbox(Composite parent) {
    behavior = new Button(parent, SWT.CHECK);
    behavior.setText(getDescription(UmlViewsRepository.General.Qualifiers.behavior, UmlMessages.GeneralPropertiesEditionPart_BehaviorLabel));
    behavior.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.behavior, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(behavior.getSelection())));
      }

    });
    GridData behaviorData = new GridData(GridData.FILL_HORIZONTAL);
    behaviorData.horizontalSpan = 2;
    behavior.setLayoutData(behaviorData);
    EditingUtils.setID(behavior, UmlViewsRepository.General.Qualifiers.behavior);
    EditingUtils.setEEFtype(behavior, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.behavior, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createBehaviorCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createServiceCheckbox(Composite parent) {
    service = new Button(parent, SWT.CHECK);
    service.setText(getDescription(UmlViewsRepository.General.Qualifiers.service, UmlMessages.GeneralPropertiesEditionPart_ServiceLabel));
    service.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.service, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(service.getSelection())));
      }

    });
    GridData serviceData = new GridData(GridData.FILL_HORIZONTAL);
    serviceData.horizontalSpan = 2;
    service.setLayoutData(serviceData);
    EditingUtils.setID(service, UmlViewsRepository.General.Qualifiers.service);
    EditingUtils.setEEFtype(service, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.service, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createServiceCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createReentrantCheckbox(Composite parent) {
    reentrant = new Button(parent, SWT.CHECK);
    reentrant.setText(getDescription(UmlViewsRepository.General.Qualifiers.reentrant, UmlMessages.GeneralPropertiesEditionPart_ReentrantLabel));
    reentrant.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.reentrant, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reentrant.getSelection())));
      }

    });
    GridData reentrantData = new GridData(GridData.FILL_HORIZONTAL);
    reentrantData.horizontalSpan = 2;
    reentrant.setLayoutData(reentrantData);
    EditingUtils.setID(reentrant, UmlViewsRepository.General.Qualifiers.reentrant);
    EditingUtils.setEEFtype(reentrant, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.reentrant, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createReentrantCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createIndirectlyInstantiatedCheckbox(Composite parent) {
    indirectlyInstantiated = new Button(parent, SWT.CHECK);
    indirectlyInstantiated.setText(getDescription(UmlViewsRepository.General.Qualifiers.indirectlyInstantiated, UmlMessages.GeneralPropertiesEditionPart_IndirectlyInstantiatedLabel));
    indirectlyInstantiated.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	@generated
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.Qualifiers.indirectlyInstantiated, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(indirectlyInstantiated.getSelection())));
      }

    });
    GridData indirectlyInstantiatedData = new GridData(GridData.FILL_HORIZONTAL);
    indirectlyInstantiatedData.horizontalSpan = 2;
    indirectlyInstantiated.setLayoutData(indirectlyInstantiatedData);
    EditingUtils.setID(indirectlyInstantiated, UmlViewsRepository.General.Qualifiers.indirectlyInstantiated);
    EditingUtils.setEEFtype(indirectlyInstantiated, "eef::Checkbox"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.Qualifiers.indirectlyInstantiated, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createIndirectlyInstantiatedCheckbox

    // End of user code
    return parent;
  }

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createTypeFlatComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.type, UmlMessages.GeneralPropertiesEditionPart_TypeLabel);
    type = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.General.type, UmlViewsRepository.SWT_KIND));
    type.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

    type.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.type, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getType()));
      }

    });
    GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
    type.setLayoutData(typeData);
    type.setID(UmlViewsRepository.General.type);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.type, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createTypeFlatComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createDirectionEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.direction, UmlMessages.GeneralPropertiesEditionPart_DirectionLabel);
    direction = new EMFComboViewer(parent);
    direction.setContentProvider(new ArrayContentProvider());
    direction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData directionData = new GridData(GridData.FILL_HORIZONTAL);
    direction.getCombo().setLayoutData(directionData);
    direction.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	@generated
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.direction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDirection()));
      }

    });
    direction.setID(UmlViewsRepository.General.direction);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.direction, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createDirectionEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createAggregationEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.aggregation, UmlMessages.GeneralPropertiesEditionPart_AggregationLabel);
    aggregation = new EMFComboViewer(parent);
    aggregation.setContentProvider(new ArrayContentProvider());
    aggregation.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData aggregationData = new GridData(GridData.FILL_HORIZONTAL);
    aggregation.getCombo().setLayoutData(aggregationData);
    aggregation.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	@generated
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.aggregation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAggregation()));
      }

    });
    aggregation.setID(UmlViewsRepository.General.aggregation);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.aggregation, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createAggregationEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createUpperValueText(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.upperValue, UmlMessages.GeneralPropertiesEditionPart_UpperValueLabel);
    upperValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData upperValueData = new GridData(GridData.FILL_HORIZONTAL);
    upperValue.setLayoutData(upperValueData);
    upperValue.addFocusListener(new FocusAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.upperValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperValue.getText()));
      }

    });
    upperValue.addKeyListener(new KeyAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.upperValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperValue.getText()));
        }
      }

    });
    EditingUtils.setID(upperValue, UmlViewsRepository.General.upperValue);
    EditingUtils.setEEFtype(upperValue, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.upperValue, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createUpperValueText

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createLowerValueText(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.lowerValue, UmlMessages.GeneralPropertiesEditionPart_LowerValueLabel);
    lowerValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData lowerValueData = new GridData(GridData.FILL_HORIZONTAL);
    lowerValue.setLayoutData(lowerValueData);
    lowerValue.addFocusListener(new FocusAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.lowerValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerValue.getText()));
      }

    });
    lowerValue.addKeyListener(new KeyAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.lowerValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerValue.getText()));
        }
      }

    });
    EditingUtils.setID(lowerValue, UmlViewsRepository.General.lowerValue);
    EditingUtils.setEEFtype(lowerValue, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.lowerValue, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createLowerValueText

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createDefaultValueText(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.defaultValue, UmlMessages.GeneralPropertiesEditionPart_DefaultValueLabel);
    defaultValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
    GridData defaultValueData = new GridData(GridData.FILL_HORIZONTAL);
    defaultValue.setLayoutData(defaultValueData);
    defaultValue.addFocusListener(new FocusAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
      }

    });
    defaultValue.addKeyListener(new KeyAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
       * @generated
       */
      @Override
      @SuppressWarnings("synthetic-access")
      public void keyPressed(KeyEvent e) {
        if (e.character == SWT.CR) {
          if (propertiesEditionComponent != null)
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.defaultValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValue.getText()));
        }
      }

    });
    EditingUtils.setID(defaultValue, UmlViewsRepository.General.defaultValue);
    EditingUtils.setEEFtype(defaultValue, "eef::Text"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.defaultValue, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createDefaultValueText

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	protected Composite createMemberEndAdvancedReferencesTable(Composite parent) {
    String label = getDescription(UmlViewsRepository.General.memberEnd, UmlMessages.GeneralPropertiesEditionPart_MemberEndLabel);		 
    this.memberEnd = new ReferencesTable(label, new ReferencesTableListener() {
      public void handleAdd() { addMemberEnd(); }
      public void handleEdit(EObject element) { editMemberEnd(element); }
      public void handleMove(EObject element, int oldIndex, int newIndex) { moveMemberEnd(element, oldIndex, newIndex); }
      public void handleRemove(EObject element) { removeFromMemberEnd(element); }
      public void navigateTo(EObject element) { }
    });
    this.memberEnd.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.memberEnd, UmlViewsRepository.SWT_KIND));
    this.memberEnd.createControls(parent);
    this.memberEnd.addSelectionListener(new SelectionAdapter() {
      
      public void widgetSelected(SelectionEvent e) {
        if (e.item != null && e.item.getData() instanceof EObject) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.memberEnd, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
        }
      }
      
    });
    GridData memberEndData = new GridData(GridData.FILL_HORIZONTAL);
    memberEndData.horizontalSpan = 3;
    this.memberEnd.setLayoutData(memberEndData);
    this.memberEnd.disableMove();
    memberEnd.setID(UmlViewsRepository.General.memberEnd);
    memberEnd.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
    return parent;
  }

	/**
	 * @generated
	 */
	protected void addMemberEnd() {
    TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(memberEnd.getInput(), memberEndFilters, memberEndBusinessFilters,
    "memberEnd", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
      @Override
      public void process(IStructuredSelection selection) {
        for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
          EObject elem = (EObject) iter.next();
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.memberEnd,
            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
        }
        memberEnd.refresh();
      }
    };
    dialog.open();
  }

	/**
	 * @generated
	 */
	protected void moveMemberEnd(EObject element, int oldIndex, int newIndex) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.memberEnd, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
    memberEnd.refresh();
  }

	/**
	 * @generated
	 */
	protected void removeFromMemberEnd(EObject element) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.memberEnd, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
    memberEnd.refresh();
  }

	/**
	 * @generated
	 */
	protected void editMemberEnd(EObject element) {
    EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
    PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
    if (provider != null) {
      PropertiesEditingPolicy policy = provider.getPolicy(context);
      if (policy != null) {
        policy.execute();
        memberEnd.refresh();
      }
    }
  }

	/**
	 * @generated
	 */
	protected Composite createSupplierAdvancedReferencesTable(Composite parent) {
    String label = getDescription(UmlViewsRepository.General.supplier, UmlMessages.GeneralPropertiesEditionPart_SupplierLabel);		 
    this.supplier = new ReferencesTable(label, new ReferencesTableListener() {
      public void handleAdd() { addSupplier(); }
      public void handleEdit(EObject element) { editSupplier(element); }
      public void handleMove(EObject element, int oldIndex, int newIndex) { moveSupplier(element, oldIndex, newIndex); }
      public void handleRemove(EObject element) { removeFromSupplier(element); }
      public void navigateTo(EObject element) { }
    });
    this.supplier.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.supplier, UmlViewsRepository.SWT_KIND));
    this.supplier.createControls(parent);
    this.supplier.addSelectionListener(new SelectionAdapter() {
      
      public void widgetSelected(SelectionEvent e) {
        if (e.item != null && e.item.getData() instanceof EObject) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.supplier, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
        }
      }
      
    });
    GridData supplierData = new GridData(GridData.FILL_HORIZONTAL);
    supplierData.horizontalSpan = 3;
    this.supplier.setLayoutData(supplierData);
    this.supplier.disableMove();
    supplier.setID(UmlViewsRepository.General.supplier);
    supplier.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
    return parent;
  }

	/**
	 * @generated
	 */
	protected void addSupplier() {
    TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(supplier.getInput(), supplierFilters, supplierBusinessFilters,
    "supplier", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
      @Override
      public void process(IStructuredSelection selection) {
        for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
          EObject elem = (EObject) iter.next();
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.supplier,
            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
        }
        supplier.refresh();
      }
    };
    dialog.open();
  }

	/**
	 * @generated
	 */
	protected void moveSupplier(EObject element, int oldIndex, int newIndex) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.supplier, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
    supplier.refresh();
  }

	/**
	 * @generated
	 */
	protected void removeFromSupplier(EObject element) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.supplier, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
    supplier.refresh();
  }

	/**
	 * @generated
	 */
	protected void editSupplier(EObject element) {
    EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
    PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
    if (provider != null) {
      PropertiesEditingPolicy policy = provider.getPolicy(context);
      if (policy != null) {
        policy.execute();
        supplier.refresh();
      }
    }
  }

	/**
	 * @generated
	 */
	protected Composite createClientAdvancedReferencesTable(Composite parent) {
    String label = getDescription(UmlViewsRepository.General.client, UmlMessages.GeneralPropertiesEditionPart_ClientLabel);		 
    this.client = new ReferencesTable(label, new ReferencesTableListener() {
      public void handleAdd() { addClient(); }
      public void handleEdit(EObject element) { editClient(element); }
      public void handleMove(EObject element, int oldIndex, int newIndex) { moveClient(element, oldIndex, newIndex); }
      public void handleRemove(EObject element) { removeFromClient(element); }
      public void navigateTo(EObject element) { }
    });
    this.client.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.client, UmlViewsRepository.SWT_KIND));
    this.client.createControls(parent);
    this.client.addSelectionListener(new SelectionAdapter() {
      
      public void widgetSelected(SelectionEvent e) {
        if (e.item != null && e.item.getData() instanceof EObject) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.client, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
        }
      }
      
    });
    GridData clientData = new GridData(GridData.FILL_HORIZONTAL);
    clientData.horizontalSpan = 3;
    this.client.setLayoutData(clientData);
    this.client.disableMove();
    client.setID(UmlViewsRepository.General.client);
    client.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
    return parent;
  }

	/**
	 * @generated
	 */
	protected void addClient() {
    TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(client.getInput(), clientFilters, clientBusinessFilters,
    "client", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
      @Override
      public void process(IStructuredSelection selection) {
        for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
          EObject elem = (EObject) iter.next();
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.client,
            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
        }
        client.refresh();
      }
    };
    dialog.open();
  }

	/**
	 * @generated
	 */
	protected void moveClient(EObject element, int oldIndex, int newIndex) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.client, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
    client.refresh();
  }

	/**
	 * @generated
	 */
	protected void removeFromClient(EObject element) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.client, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
    client.refresh();
  }

	/**
	 * @generated
	 */
	protected void editClient(EObject element) {
    EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
    PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
    if (provider != null) {
      PropertiesEditingPolicy policy = provider.getPolicy(context);
      if (policy != null) {
        policy.execute();
        client.refresh();
      }
    }
  }

	/**
	 * @generated
	 */
	
	protected Composite createKindEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.kind, UmlMessages.GeneralPropertiesEditionPart_KindLabel);
    kind = new EMFComboViewer(parent);
    kind.setContentProvider(new ArrayContentProvider());
    kind.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData kindData = new GridData(GridData.FILL_HORIZONTAL);
    kind.getCombo().setLayoutData(kindData);
    kind.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	@generated
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.kind, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getKind()));
      }

    });
    kind.setID(UmlViewsRepository.General.kind);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.kind, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createKindEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createSourceFlatComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.source, UmlMessages.GeneralPropertiesEditionPart_SourceLabel);
    source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.General.source, UmlViewsRepository.SWT_KIND));
    source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

    source.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.source, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSource()));
      }

    });
    GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
    source.setLayoutData(sourceData);
    source.setID(UmlViewsRepository.General.source);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.source, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createSourceFlatComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createTargetFlatComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.target, UmlMessages.GeneralPropertiesEditionPart_TargetLabel);
    target = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.General.target, UmlViewsRepository.SWT_KIND));
    target.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

    target.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.target, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getTarget()));
      }

    });
    GridData targetData = new GridData(GridData.FILL_HORIZONTAL);
    target.setLayoutData(targetData);
    target.setID(UmlViewsRepository.General.target);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.target, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createTargetFlatComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createEffectFlatComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.effect, UmlMessages.GeneralPropertiesEditionPart_EffectLabel);
    effect = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.General.effect, UmlViewsRepository.SWT_KIND));
    effect.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

    effect.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.effect, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEffect()));
      }

    });
    GridData effectData = new GridData(GridData.FILL_HORIZONTAL);
    effect.setLayoutData(effectData);
    effect.setID(UmlViewsRepository.General.effect);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.effect, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createEffectFlatComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createGuardFlatComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.guard, UmlMessages.GeneralPropertiesEditionPart_GuardLabel);
    guard = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.General.guard, UmlViewsRepository.SWT_KIND));
    guard.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

    guard.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.guard, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getGuard()));
      }

    });
    GridData guardData = new GridData(GridData.FILL_HORIZONTAL);
    guard.setLayoutData(guardData);
    guard.setID(UmlViewsRepository.General.guard);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.guard, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createGuardFlatComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	protected Composite createOwnedRuleAdvancedReferencesTable(Composite parent) {
    String label = getDescription(UmlViewsRepository.General.ownedRule, UmlMessages.GeneralPropertiesEditionPart_OwnedRuleLabel);		 
    this.ownedRule = new ReferencesTable(label, new ReferencesTableListener() {
      public void handleAdd() { addOwnedRule(); }
      public void handleEdit(EObject element) { editOwnedRule(element); }
      public void handleMove(EObject element, int oldIndex, int newIndex) { moveOwnedRule(element, oldIndex, newIndex); }
      public void handleRemove(EObject element) { removeFromOwnedRule(element); }
      public void navigateTo(EObject element) { }
    });
    this.ownedRule.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.ownedRule, UmlViewsRepository.SWT_KIND));
    this.ownedRule.createControls(parent);
    this.ownedRule.addSelectionListener(new SelectionAdapter() {
      
      public void widgetSelected(SelectionEvent e) {
        if (e.item != null && e.item.getData() instanceof EObject) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.ownedRule, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
        }
      }
      
    });
    GridData ownedRuleData = new GridData(GridData.FILL_HORIZONTAL);
    ownedRuleData.horizontalSpan = 3;
    this.ownedRule.setLayoutData(ownedRuleData);
    this.ownedRule.disableMove();
    ownedRule.setID(UmlViewsRepository.General.ownedRule);
    ownedRule.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
    return parent;
  }

	/**
	 * @generated
	 */
	protected void addOwnedRule() {
    TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(ownedRule.getInput(), ownedRuleFilters, ownedRuleBusinessFilters,
    "ownedRule", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
      @Override
      public void process(IStructuredSelection selection) {
        for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
          EObject elem = (EObject) iter.next();
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.ownedRule,
            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
        }
        ownedRule.refresh();
      }
    };
    dialog.open();
  }

	/**
	 * @generated
	 */
	protected void moveOwnedRule(EObject element, int oldIndex, int newIndex) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.ownedRule, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
    ownedRule.refresh();
  }

	/**
	 * @generated
	 */
	protected void removeFromOwnedRule(EObject element) {
    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.ownedRule, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
    ownedRule.refresh();
  }

	/**
	 * @generated
	 */
	protected void editOwnedRule(EObject element) {
    EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
    PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
    if (provider != null) {
      PropertiesEditingPolicy policy = provider.getPolicy(context);
      if (policy != null) {
        policy.execute();
        ownedRule.refresh();
      }
    }
  }

	/**
	 * @generated
	 */
	protected Composite createIconImageViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.icon, UmlMessages.GeneralPropertiesEditionPart_IconLabel);
    icon = new EEFImageViewer(parent, SWT.BORDER);
    GridData iconData = new GridData();
    // Start of user code  for icon layout data customization
        iconData.widthHint = 200;
        iconData.heightHint = 200;
        iconData.horizontalAlignment = SWT.CENTER;
        iconData.verticalAlignment = SWT.CENTER;
    
    // End of user code
    icon.setLayoutData(iconData);
    icon.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.icon, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getIcon()));
      }
    });
    icon.setID(UmlViewsRepository.General.icon);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.icon, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createIconImageViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createBodyTextarea(Composite parent) {
    Label bodyLabel = createDescription(parent, UmlViewsRepository.General.body, UmlMessages.GeneralPropertiesEditionPart_BodyLabel);
    GridData bodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
    bodyLabelData.horizontalSpan = 3;
    bodyLabel.setLayoutData(bodyLabelData);
    body = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
    GridData bodyData = new GridData(GridData.FILL_HORIZONTAL);
    bodyData.horizontalSpan = 2;
    bodyData.heightHint = 80;
    bodyData.widthHint = 200;
    body.setLayoutData(bodyData);
    body.addFocusListener(new FocusAdapter() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
       * @generated
       */
      public void focusLost(FocusEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.body, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, body.getText()));
      }

    });
    EditingUtils.setID(body, UmlViewsRepository.General.body);
    EditingUtils.setEEFtype(body, "eef::Textarea"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.body, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createBodyTextArea

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createExtendedCaseEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.extendedCase, UmlMessages.GeneralPropertiesEditionPart_ExtendedCaseLabel);
    extendedCase = new EMFComboViewer(parent);
    GridData extendedCaseData = new GridData(GridData.FILL_HORIZONTAL);
    extendedCase.getCombo().setLayoutData(extendedCaseData);
    extendedCase.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
    extendedCase.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.extendedCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getExtendedCase()));
      }

    });
    extendedCase.setContentProvider(new EMFListContentProvider());
    EditingUtils.setID(extendedCase.getCombo(), UmlViewsRepository.General.extendedCase);
    EditingUtils.setEEFtype(extendedCase.getCombo(), "eef::Combo"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.extendedCase, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createExtendedCaseEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createAdditionEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.addition, UmlMessages.GeneralPropertiesEditionPart_AdditionLabel);
    addition = new EMFComboViewer(parent);
    GridData additionData = new GridData(GridData.FILL_HORIZONTAL);
    addition.getCombo().setLayoutData(additionData);
    addition.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
    addition.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.addition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAddition()));
      }

    });
    addition.setContentProvider(new EMFListContentProvider());
    EditingUtils.setID(addition.getCombo(), UmlViewsRepository.General.addition);
    EditingUtils.setEEFtype(addition.getCombo(), "eef::Combo"); //$NON-NLS-1$
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.addition, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createAdditionEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @generated
	 */
	
	protected Composite createPseudostatekindEMFComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.pseudostatekind, UmlMessages.GeneralPropertiesEditionPart_PseudostatekindLabel);
    pseudostatekind = new EMFComboViewer(parent);
    pseudostatekind.setContentProvider(new ArrayContentProvider());
    pseudostatekind.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
    GridData pseudostatekindData = new GridData(GridData.FILL_HORIZONTAL);
    pseudostatekind.getCombo().setLayoutData(pseudostatekindData);
    pseudostatekind.addSelectionChangedListener(new ISelectionChangedListener() {

      /**
       * {@inheritDoc}
       * 
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       * 	@generated
       */
      public void selectionChanged(SelectionChangedEvent event) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.pseudostatekind, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPseudostatekind()));
      }

    });
    pseudostatekind.setID(UmlViewsRepository.General.pseudostatekind);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.pseudostatekind, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createPseudostatekindEMFComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createRoleFlatComboViewer(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.role, UmlMessages.GeneralPropertiesEditionPart_RoleLabel);
    role = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.General.role, UmlViewsRepository.SWT_KIND));
    role.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

    role.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.role, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getRole()));
      }

    });
    GridData roleData = new GridData(GridData.FILL_HORIZONTAL);
    role.setLayoutData(roleData);
    role.setID(UmlViewsRepository.General.role);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.role, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createRoleFlatComboViewer

    // End of user code
    return parent;
  }

	/**
	 * @param parent
	 * @generated
	 */
	protected Composite createUsecaseFlatReferencesTable(Composite parent) {
    createDescription(parent, UmlViewsRepository.General.usecase, UmlMessages.GeneralPropertiesEditionPart_UsecaseLabel);
    usecase = new FlatReferencesTable(parent);
    usecase.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
    usecase.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(SelectionChangedEvent event) {
        if (event.getSelection() instanceof StructuredSelection) 
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralPropertiesEditionPartImpl.this, UmlViewsRepository.General.usecase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ((StructuredSelection)event.getSelection()).toList()));
      }

    });
    GridData usecaseData = new GridData(GridData.FILL_HORIZONTAL);
    usecase.setLayoutData(usecaseData);
    usecase.setID(UmlViewsRepository.General.usecase);
    SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.General.usecase, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
    // Start of user code for createUsecaseFlatReferencesTable

    // End of user code
    return parent;
  }



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * @generated
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getName()
	 * @generated
	 */
	public String getName() {
    return name.getText();
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setName(String newValue)
	 * @generated
	 */
	public void setName(String newValue) {
    if (newValue != null) {
      name.setText(newValue);
    } else {
      name.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.name);
    if (eefElementEditorReadOnlyState && name.isEnabled()) {
      name.setEnabled(false);
      name.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
      name.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getVisibility()
	 * @generated
	 */
	public Enumerator getVisibility() {
    Enumerator selection = (Enumerator) ((StructuredSelection) visibility.getSelection()).getFirstElement();
    return selection;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initVisibility(Object input, Enumerator current)
	 */
	public void initVisibility(Object input, Enumerator current) {
		visibility.setInput(input);
		visibility.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.visibility);
		if (eefElementEditorReadOnlyState && visibility.isEnabled()) {
			visibility.setEnabled(false);
			visibility.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !visibility.isEnabled()) {
			visibility.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setVisibility(Enumerator newValue)
	 * @generated
	 */
	public void setVisibility(Enumerator newValue) {
    visibility.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.visibility);
    if (eefElementEditorReadOnlyState && visibility.isEnabled()) {
      visibility.setEnabled(false);
      visibility.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !visibility.isEnabled()) {
      visibility.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getOrdered()
	 * @generated
	 */
	public Boolean getOrdered() {
    return Boolean.valueOf(ordered.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setOrdered(Boolean newValue)
	 * @generated
	 */
	public void setOrdered(Boolean newValue) {
    if (newValue != null) {
      ordered.setSelection(newValue.booleanValue());
    } else {
      ordered.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.ordered);
    if (eefElementEditorReadOnlyState && ordered.isEnabled()) {
      ordered.setEnabled(false);
      ordered.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !ordered.isEnabled()) {
      ordered.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getAbstract_()
	 * @generated
	 */
	public Boolean getAbstract_() {
    return Boolean.valueOf(abstract_.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setAbstract_(Boolean newValue)
	 * @generated
	 */
	public void setAbstract_(Boolean newValue) {
    if (newValue != null) {
      abstract_.setSelection(newValue.booleanValue());
    } else {
      abstract_.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.abstract_);
    if (eefElementEditorReadOnlyState && abstract_.isEnabled()) {
      abstract_.setEnabled(false);
      abstract_.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !abstract_.isEnabled()) {
      abstract_.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getLeaf()
	 * @generated
	 */
	public Boolean getLeaf() {
    return Boolean.valueOf(leaf.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setLeaf(Boolean newValue)
	 * @generated
	 */
	public void setLeaf(Boolean newValue) {
    if (newValue != null) {
      leaf.setSelection(newValue.booleanValue());
    } else {
      leaf.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.leaf);
    if (eefElementEditorReadOnlyState && leaf.isEnabled()) {
      leaf.setEnabled(false);
      leaf.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !leaf.isEnabled()) {
      leaf.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getStatic_()
	 * @generated
	 */
	public Boolean getStatic_() {
    return Boolean.valueOf(static_.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setStatic_(Boolean newValue)
	 * @generated
	 */
	public void setStatic_(Boolean newValue) {
    if (newValue != null) {
      static_.setSelection(newValue.booleanValue());
    } else {
      static_.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.static_);
    if (eefElementEditorReadOnlyState && static_.isEnabled()) {
      static_.setEnabled(false);
      static_.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !static_.isEnabled()) {
      static_.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getUnique()
	 * @generated
	 */
	public Boolean getUnique() {
    return Boolean.valueOf(unique.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setUnique(Boolean newValue)
	 * @generated
	 */
	public void setUnique(Boolean newValue) {
    if (newValue != null) {
      unique.setSelection(newValue.booleanValue());
    } else {
      unique.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.unique);
    if (eefElementEditorReadOnlyState && unique.isEnabled()) {
      unique.setEnabled(false);
      unique.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !unique.isEnabled()) {
      unique.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getQuery()
	 * @generated
	 */
	public Boolean getQuery() {
    return Boolean.valueOf(query.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setQuery(Boolean newValue)
	 * @generated
	 */
	public void setQuery(Boolean newValue) {
    if (newValue != null) {
      query.setSelection(newValue.booleanValue());
    } else {
      query.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.query);
    if (eefElementEditorReadOnlyState && query.isEnabled()) {
      query.setEnabled(false);
      query.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !query.isEnabled()) {
      query.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getReadOnly()
	 * @generated
	 */
	public Boolean getReadOnly() {
    return Boolean.valueOf(readOnly.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setReadOnly(Boolean newValue)
	 * @generated
	 */
	public void setReadOnly(Boolean newValue) {
    if (newValue != null) {
      readOnly.setSelection(newValue.booleanValue());
    } else {
      readOnly.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.readOnly);
    if (eefElementEditorReadOnlyState && readOnly.isEnabled()) {
      readOnly.setEnabled(false);
      readOnly.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !readOnly.isEnabled()) {
      readOnly.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getDerived()
	 * @generated
	 */
	public Boolean getDerived() {
    return Boolean.valueOf(derived.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setDerived(Boolean newValue)
	 * @generated
	 */
	public void setDerived(Boolean newValue) {
    if (newValue != null) {
      derived.setSelection(newValue.booleanValue());
    } else {
      derived.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.derived);
    if (eefElementEditorReadOnlyState && derived.isEnabled()) {
      derived.setEnabled(false);
      derived.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !derived.isEnabled()) {
      derived.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getDerivedUnion()
	 * @generated
	 */
	public Boolean getDerivedUnion() {
    return Boolean.valueOf(derivedUnion.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setDerivedUnion(Boolean newValue)
	 * @generated
	 */
	public void setDerivedUnion(Boolean newValue) {
    if (newValue != null) {
      derivedUnion.setSelection(newValue.booleanValue());
    } else {
      derivedUnion.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.derivedUnion);
    if (eefElementEditorReadOnlyState && derivedUnion.isEnabled()) {
      derivedUnion.setEnabled(false);
      derivedUnion.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !derivedUnion.isEnabled()) {
      derivedUnion.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getSubstitutable()
	 * @generated
	 */
	public Boolean getSubstitutable() {
    return Boolean.valueOf(substitutable.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setSubstitutable(Boolean newValue)
	 * @generated
	 */
	public void setSubstitutable(Boolean newValue) {
    if (newValue != null) {
      substitutable.setSelection(newValue.booleanValue());
    } else {
      substitutable.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.substitutable);
    if (eefElementEditorReadOnlyState && substitutable.isEnabled()) {
      substitutable.setEnabled(false);
      substitutable.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !substitutable.isEnabled()) {
      substitutable.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getActive()
	 * @generated
	 */
	public Boolean getActive() {
    return Boolean.valueOf(active.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setActive(Boolean newValue)
	 * @generated
	 */
	public void setActive(Boolean newValue) {
    if (newValue != null) {
      active.setSelection(newValue.booleanValue());
    } else {
      active.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.active);
    if (eefElementEditorReadOnlyState && active.isEnabled()) {
      active.setEnabled(false);
      active.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !active.isEnabled()) {
      active.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getBehavior()
	 * @generated
	 */
	public Boolean getBehavior() {
    return Boolean.valueOf(behavior.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setBehavior(Boolean newValue)
	 * @generated
	 */
	public void setBehavior(Boolean newValue) {
    if (newValue != null) {
      behavior.setSelection(newValue.booleanValue());
    } else {
      behavior.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.behavior);
    if (eefElementEditorReadOnlyState && behavior.isEnabled()) {
      behavior.setEnabled(false);
      behavior.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !behavior.isEnabled()) {
      behavior.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getService()
	 * @generated
	 */
	public Boolean getService() {
    return Boolean.valueOf(service.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setService(Boolean newValue)
	 * @generated
	 */
	public void setService(Boolean newValue) {
    if (newValue != null) {
      service.setSelection(newValue.booleanValue());
    } else {
      service.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.service);
    if (eefElementEditorReadOnlyState && service.isEnabled()) {
      service.setEnabled(false);
      service.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !service.isEnabled()) {
      service.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getReentrant()
	 * @generated
	 */
	public Boolean getReentrant() {
    return Boolean.valueOf(reentrant.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setReentrant(Boolean newValue)
	 * @generated
	 */
	public void setReentrant(Boolean newValue) {
    if (newValue != null) {
      reentrant.setSelection(newValue.booleanValue());
    } else {
      reentrant.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.reentrant);
    if (eefElementEditorReadOnlyState && reentrant.isEnabled()) {
      reentrant.setEnabled(false);
      reentrant.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !reentrant.isEnabled()) {
      reentrant.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getIndirectlyInstantiated()
	 * @generated
	 */
	public Boolean getIndirectlyInstantiated() {
    return Boolean.valueOf(indirectlyInstantiated.getSelection());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setIndirectlyInstantiated(Boolean newValue)
	 * @generated
	 */
	public void setIndirectlyInstantiated(Boolean newValue) {
    if (newValue != null) {
      indirectlyInstantiated.setSelection(newValue.booleanValue());
    } else {
      indirectlyInstantiated.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.Qualifiers.indirectlyInstantiated);
    if (eefElementEditorReadOnlyState && indirectlyInstantiated.isEnabled()) {
      indirectlyInstantiated.setEnabled(false);
      indirectlyInstantiated.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !indirectlyInstantiated.isEnabled()) {
      indirectlyInstantiated.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getType()
	 * @generated
	 */
	public EObject getType() {
    if (type.getSelection() instanceof StructuredSelection) {
      Object firstElement = ((StructuredSelection) type.getSelection()).getFirstElement();
      if (firstElement instanceof EObject)
        return (EObject) firstElement;
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initType(EObjectFlatComboSettings)
	 */
	public void initType(EObjectFlatComboSettings settings) {
		type.setInput(settings);
		if (current != null) {
			type.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setType(EObject newValue)
	 * @generated
	 */
	public void setType(EObject newValue) {
    if (newValue != null) {
      type.setSelection(new StructuredSelection(newValue));
    } else {
      type.setSelection(new StructuredSelection()); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.type);
    if (eefElementEditorReadOnlyState && type.isEnabled()) {
      type.setEnabled(false);
      type.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
      type.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTypeButtonMode(ButtonsModeEnum newValue) {
		type.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterType(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToType(ViewerFilter filter) {
    type.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterType(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToType(ViewerFilter filter) {
    type.addBusinessRuleFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getDirection()
	 * @generated
	 */
	public Enumerator getDirection() {
    Enumerator selection = (Enumerator) ((StructuredSelection) direction.getSelection()).getFirstElement();
    return selection;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initDirection(Object input, Enumerator current)
	 */
	public void initDirection(Object input, Enumerator current) {
		direction.setInput(input);
		direction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.direction);
		if (eefElementEditorReadOnlyState && direction.isEnabled()) {
			direction.setEnabled(false);
			direction.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !direction.isEnabled()) {
			direction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setDirection(Enumerator newValue)
	 * @generated
	 */
	public void setDirection(Enumerator newValue) {
    direction.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.direction);
    if (eefElementEditorReadOnlyState && direction.isEnabled()) {
      direction.setEnabled(false);
      direction.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !direction.isEnabled()) {
      direction.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getAggregation()
	 * @generated
	 */
	public Enumerator getAggregation() {
    Enumerator selection = (Enumerator) ((StructuredSelection) aggregation.getSelection()).getFirstElement();
    return selection;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initAggregation(Object input, Enumerator current)
	 */
	public void initAggregation(Object input, Enumerator current) {
		aggregation.setInput(input);
		aggregation.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.aggregation);
		if (eefElementEditorReadOnlyState && aggregation.isEnabled()) {
			aggregation.setEnabled(false);
			aggregation.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !aggregation.isEnabled()) {
			aggregation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setAggregation(Enumerator newValue)
	 * @generated
	 */
	public void setAggregation(Enumerator newValue) {
    aggregation.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.aggregation);
    if (eefElementEditorReadOnlyState && aggregation.isEnabled()) {
      aggregation.setEnabled(false);
      aggregation.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !aggregation.isEnabled()) {
      aggregation.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getUpperValue()
	 * @generated
	 */
	public String getUpperValue() {
    return upperValue.getText();
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setUpperValue(String newValue)
	 * @generated
	 */
	public void setUpperValue(String newValue) {
    if (newValue != null) {
      upperValue.setText(newValue);
    } else {
      upperValue.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.upperValue);
    if (eefElementEditorReadOnlyState && upperValue.isEnabled()) {
      upperValue.setEnabled(false);
      upperValue.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !upperValue.isEnabled()) {
      upperValue.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getLowerValue()
	 * @generated
	 */
	public String getLowerValue() {
    return lowerValue.getText();
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setLowerValue(String newValue)
	 * @generated
	 */
	public void setLowerValue(String newValue) {
    if (newValue != null) {
      lowerValue.setText(newValue);
    } else {
      lowerValue.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.lowerValue);
    if (eefElementEditorReadOnlyState && lowerValue.isEnabled()) {
      lowerValue.setEnabled(false);
      lowerValue.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !lowerValue.isEnabled()) {
      lowerValue.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getDefaultValue()
	 * @generated
	 */
	public String getDefaultValue() {
    return defaultValue.getText();
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setDefaultValue(String newValue)
	 * @generated
	 */
	public void setDefaultValue(String newValue) {
    if (newValue != null) {
      defaultValue.setText(newValue);
    } else {
      defaultValue.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.defaultValue);
    if (eefElementEditorReadOnlyState && defaultValue.isEnabled()) {
      defaultValue.setEnabled(false);
      defaultValue.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !defaultValue.isEnabled()) {
      defaultValue.setEnabled(true);
    }	
    
  }



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initMemberEnd(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initMemberEnd(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		memberEnd.setContentProvider(contentProvider);
		memberEnd.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.memberEnd);
		if (eefElementEditorReadOnlyState && memberEnd.getTable().isEnabled()) {
			memberEnd.setEnabled(false);
			memberEnd.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !memberEnd.getTable().isEnabled()) {
			memberEnd.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#updateMemberEnd()
	 * @generated
	 */
	public void updateMemberEnd() {
  memberEnd.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterMemberEnd(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToMemberEnd(ViewerFilter filter) {
    memberEndFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterMemberEnd(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToMemberEnd(ViewerFilter filter) {
    memberEndBusinessFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#isContainedInMemberEndTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInMemberEndTable(EObject element) {
    return ((ReferencesTableSettings)memberEnd.getInput()).contains(element);
  }



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initSupplier(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initSupplier(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		supplier.setContentProvider(contentProvider);
		supplier.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.supplier);
		if (eefElementEditorReadOnlyState && supplier.getTable().isEnabled()) {
			supplier.setEnabled(false);
			supplier.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !supplier.getTable().isEnabled()) {
			supplier.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#updateSupplier()
	 * @generated
	 */
	public void updateSupplier() {
  supplier.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterSupplier(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToSupplier(ViewerFilter filter) {
    supplierFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterSupplier(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToSupplier(ViewerFilter filter) {
    supplierBusinessFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#isContainedInSupplierTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInSupplierTable(EObject element) {
    return ((ReferencesTableSettings)supplier.getInput()).contains(element);
  }



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initClient(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initClient(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		client.setContentProvider(contentProvider);
		client.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.client);
		if (eefElementEditorReadOnlyState && client.getTable().isEnabled()) {
			client.setEnabled(false);
			client.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !client.getTable().isEnabled()) {
			client.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#updateClient()
	 * @generated
	 */
	public void updateClient() {
  client.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterClient(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToClient(ViewerFilter filter) {
    clientFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterClient(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToClient(ViewerFilter filter) {
    clientBusinessFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#isContainedInClientTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInClientTable(EObject element) {
    return ((ReferencesTableSettings)client.getInput()).contains(element);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getKind()
	 * @generated
	 */
	public Enumerator getKind() {
    Enumerator selection = (Enumerator) ((StructuredSelection) kind.getSelection()).getFirstElement();
    return selection;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initKind(Object input, Enumerator current)
	 */
	public void initKind(Object input, Enumerator current) {
		kind.setInput(input);
		kind.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.kind);
		if (eefElementEditorReadOnlyState && kind.isEnabled()) {
			kind.setEnabled(false);
			kind.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !kind.isEnabled()) {
			kind.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setKind(Enumerator newValue)
	 * @generated
	 */
	public void setKind(Enumerator newValue) {
    kind.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.kind);
    if (eefElementEditorReadOnlyState && kind.isEnabled()) {
      kind.setEnabled(false);
      kind.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !kind.isEnabled()) {
      kind.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getSource()
	 * @generated
	 */
	public EObject getSource() {
    if (source.getSelection() instanceof StructuredSelection) {
      Object firstElement = ((StructuredSelection) source.getSelection()).getFirstElement();
      if (firstElement instanceof EObject)
        return (EObject) firstElement;
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initSource(EObjectFlatComboSettings)
	 */
	public void initSource(EObjectFlatComboSettings settings) {
		source.setInput(settings);
		if (current != null) {
			source.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setSource(EObject newValue)
	 * @generated
	 */
	public void setSource(EObject newValue) {
    if (newValue != null) {
      source.setSelection(new StructuredSelection(newValue));
    } else {
      source.setSelection(new StructuredSelection()); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.source);
    if (eefElementEditorReadOnlyState && source.isEnabled()) {
      source.setEnabled(false);
      source.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
      source.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue) {
		source.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterSource(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToSource(ViewerFilter filter) {
    source.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterSource(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToSource(ViewerFilter filter) {
    source.addBusinessRuleFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getTarget()
	 * @generated
	 */
	public EObject getTarget() {
    if (target.getSelection() instanceof StructuredSelection) {
      Object firstElement = ((StructuredSelection) target.getSelection()).getFirstElement();
      if (firstElement instanceof EObject)
        return (EObject) firstElement;
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initTarget(EObjectFlatComboSettings)
	 */
	public void initTarget(EObjectFlatComboSettings settings) {
		target.setInput(settings);
		if (current != null) {
			target.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.target);
		if (eefElementEditorReadOnlyState && target.isEnabled()) {
			target.setEnabled(false);
			target.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
			target.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setTarget(EObject newValue)
	 * @generated
	 */
	public void setTarget(EObject newValue) {
    if (newValue != null) {
      target.setSelection(new StructuredSelection(newValue));
    } else {
      target.setSelection(new StructuredSelection()); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.target);
    if (eefElementEditorReadOnlyState && target.isEnabled()) {
      target.setEnabled(false);
      target.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
      target.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setTargetButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTargetButtonMode(ButtonsModeEnum newValue) {
		target.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterTarget(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToTarget(ViewerFilter filter) {
    target.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterTarget(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToTarget(ViewerFilter filter) {
    target.addBusinessRuleFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getEffect()
	 * @generated
	 */
	public EObject getEffect() {
    if (effect.getSelection() instanceof StructuredSelection) {
      Object firstElement = ((StructuredSelection) effect.getSelection()).getFirstElement();
      if (firstElement instanceof EObject)
        return (EObject) firstElement;
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initEffect(EObjectFlatComboSettings)
	 */
	public void initEffect(EObjectFlatComboSettings settings) {
		effect.setInput(settings);
		if (current != null) {
			effect.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.effect);
		if (eefElementEditorReadOnlyState && effect.isEnabled()) {
			effect.setEnabled(false);
			effect.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !effect.isEnabled()) {
			effect.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setEffect(EObject newValue)
	 * @generated
	 */
	public void setEffect(EObject newValue) {
    if (newValue != null) {
      effect.setSelection(new StructuredSelection(newValue));
    } else {
      effect.setSelection(new StructuredSelection()); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.effect);
    if (eefElementEditorReadOnlyState && effect.isEnabled()) {
      effect.setEnabled(false);
      effect.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !effect.isEnabled()) {
      effect.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setEffectButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEffectButtonMode(ButtonsModeEnum newValue) {
		effect.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterEffect(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToEffect(ViewerFilter filter) {
    effect.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterEffect(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToEffect(ViewerFilter filter) {
    effect.addBusinessRuleFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getGuard()
	 * @generated
	 */
	public EObject getGuard() {
    if (guard.getSelection() instanceof StructuredSelection) {
      Object firstElement = ((StructuredSelection) guard.getSelection()).getFirstElement();
      if (firstElement instanceof EObject)
        return (EObject) firstElement;
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initGuard(EObjectFlatComboSettings)
	 */
	public void initGuard(EObjectFlatComboSettings settings) {
		guard.setInput(settings);
		if (current != null) {
			guard.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.guard);
		if (eefElementEditorReadOnlyState && guard.isEnabled()) {
			guard.setEnabled(false);
			guard.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !guard.isEnabled()) {
			guard.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setGuard(EObject newValue)
	 * @generated
	 */
	public void setGuard(EObject newValue) {
    if (newValue != null) {
      guard.setSelection(new StructuredSelection(newValue));
    } else {
      guard.setSelection(new StructuredSelection()); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.guard);
    if (eefElementEditorReadOnlyState && guard.isEnabled()) {
      guard.setEnabled(false);
      guard.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !guard.isEnabled()) {
      guard.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setGuardButtonMode(ButtonsModeEnum newValue)
	 */
	public void setGuardButtonMode(ButtonsModeEnum newValue) {
		guard.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterGuard(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToGuard(ViewerFilter filter) {
    guard.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterGuard(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToGuard(ViewerFilter filter) {
    guard.addBusinessRuleFilter(filter);
  }



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initOwnedRule(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initOwnedRule(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ownedRule.setContentProvider(contentProvider);
		ownedRule.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.ownedRule);
		if (eefElementEditorReadOnlyState && ownedRule.getTable().isEnabled()) {
			ownedRule.setEnabled(false);
			ownedRule.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ownedRule.getTable().isEnabled()) {
			ownedRule.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#updateOwnedRule()
	 * @generated
	 */
	public void updateOwnedRule() {
  ownedRule.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterOwnedRule(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToOwnedRule(ViewerFilter filter) {
    ownedRuleFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterOwnedRule(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToOwnedRule(ViewerFilter filter) {
    ownedRuleBusinessFilters.add(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#isContainedInOwnedRuleTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInOwnedRuleTable(EObject element) {
    return ((ReferencesTableSettings)ownedRule.getInput()).contains(element);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getIcon()
	 * @generated
	 */
	public String getIcon() {
    ISelection selection = icon.getSelection();
    if (selection instanceof StructuredSelection && ((StructuredSelection)selection).getFirstElement() instanceof String) {
      return (String)((StructuredSelection)selection).getFirstElement();
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initIcon(String key, String newValue)
	 */
	public void initIcon(String key, String newValue) {
		if (newValue != null) {
			icon.initViewer(key, newValue);
		} else {
			icon.initViewer(key, ""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.icon);
		if (eefElementEditorReadOnlyState && icon.isEnabled()) {
			icon.setEnabled(false);
			icon.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !icon.isEnabled()) {
			icon.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setIcon(String newValue)
	 * @generated
	 */
	public void setIcon(String newValue) {
    if (newValue != null) {
      icon.setSelection(new StructuredSelection(newValue));
    } else {
      icon.setSelection(new StructuredSelection("")); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.icon);
    if (eefElementEditorReadOnlyState && icon.isEnabled()) {
      icon.setEnabled(false);
      icon.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !icon.isEnabled()) {
      icon.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getBody()
	 * @generated
	 */
	public String getBody() {
    return body.getText();
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setBody(String newValue)
	 * @generated
	 */
	public void setBody(String newValue) {
    if (newValue != null) {
      body.setText(newValue);
    } else {
      body.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.body);
    if (eefElementEditorReadOnlyState && body.isEnabled()) {
      body.setEnabled(false);
      body.setBackground(body.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
      body.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !body.isEnabled()) {
      body.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getExtendedCase()
	 * @generated
	 */
	public Object getExtendedCase() {
    if (extendedCase.getSelection() instanceof StructuredSelection) {
      return ((StructuredSelection) extendedCase.getSelection()).getFirstElement();
    }
    return "";
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initExtendedCase(Object input, Object currentValue)
	 */
	public void initExtendedCase(Object input, Object currentValue) {
		extendedCase.setInput(input);
		if (currentValue != null) {
			extendedCase.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setExtendedCase(Object newValue)
	 * @generated
	 */
	public void setExtendedCase(Object newValue) {
    if (newValue != null) {
      extendedCase.modelUpdating(new StructuredSelection(newValue));
    } else {
      extendedCase.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.extendedCase);
    if (eefElementEditorReadOnlyState && extendedCase.isEnabled()) {
      extendedCase.setEnabled(false);
      extendedCase.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !extendedCase.isEnabled()) {
      extendedCase.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterExtendedCase(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToExtendedCase(ViewerFilter filter) {
    extendedCase.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getAddition()
	 * @generated
	 */
	public Object getAddition() {
    if (addition.getSelection() instanceof StructuredSelection) {
      return ((StructuredSelection) addition.getSelection()).getFirstElement();
    }
    return "";
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initAddition(Object input, Object currentValue)
	 */
	public void initAddition(Object input, Object currentValue) {
		addition.setInput(input);
		if (currentValue != null) {
			addition.setSelection(new StructuredSelection(currentValue));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setAddition(Object newValue)
	 * @generated
	 */
	public void setAddition(Object newValue) {
    if (newValue != null) {
      addition.modelUpdating(new StructuredSelection(newValue));
    } else {
      addition.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.addition);
    if (eefElementEditorReadOnlyState && addition.isEnabled()) {
      addition.setEnabled(false);
      addition.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !addition.isEnabled()) {
      addition.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterAddition(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToAddition(ViewerFilter filter) {
    addition.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getPseudostatekind()
	 * @generated
	 */
	public Enumerator getPseudostatekind() {
    Enumerator selection = (Enumerator) ((StructuredSelection) pseudostatekind.getSelection()).getFirstElement();
    return selection;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initPseudostatekind(Object input, Enumerator current)
	 */
	public void initPseudostatekind(Object input, Enumerator current) {
		pseudostatekind.setInput(input);
		pseudostatekind.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.pseudostatekind);
		if (eefElementEditorReadOnlyState && pseudostatekind.isEnabled()) {
			pseudostatekind.setEnabled(false);
			pseudostatekind.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pseudostatekind.isEnabled()) {
			pseudostatekind.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setPseudostatekind(Enumerator newValue)
	 * @generated
	 */
	public void setPseudostatekind(Enumerator newValue) {
    pseudostatekind.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.pseudostatekind);
    if (eefElementEditorReadOnlyState && pseudostatekind.isEnabled()) {
      pseudostatekind.setEnabled(false);
      pseudostatekind.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !pseudostatekind.isEnabled()) {
      pseudostatekind.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#getRole()
	 * @generated
	 */
	public EObject getRole() {
    if (role.getSelection() instanceof StructuredSelection) {
      Object firstElement = ((StructuredSelection) role.getSelection()).getFirstElement();
      if (firstElement instanceof EObject)
        return (EObject) firstElement;
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initRole(EObjectFlatComboSettings)
	 */
	public void initRole(EObjectFlatComboSettings settings) {
		role.setInput(settings);
		if (current != null) {
			role.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.role);
		if (eefElementEditorReadOnlyState && role.isEnabled()) {
			role.setEnabled(false);
			role.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !role.isEnabled()) {
			role.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setRole(EObject newValue)
	 * @generated
	 */
	public void setRole(EObject newValue) {
    if (newValue != null) {
      role.setSelection(new StructuredSelection(newValue));
    } else {
      role.setSelection(new StructuredSelection()); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.role);
    if (eefElementEditorReadOnlyState && role.isEnabled()) {
      role.setEnabled(false);
      role.setToolTipText(UmlMessages.General_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !role.isEnabled()) {
      role.setEnabled(true);
    }	
    
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#setRoleButtonMode(ButtonsModeEnum newValue)
	 */
	public void setRoleButtonMode(ButtonsModeEnum newValue) {
		role.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterRole(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToRole(ViewerFilter filter) {
    role.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterRole(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToRole(ViewerFilter filter) {
    role.addBusinessRuleFilter(filter);
  }



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#initUsecase(ReferencesTableSettings)
	 */
	public void initUsecase(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		usecase.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(UmlViewsRepository.General.usecase);
		if (eefElementEditorReadOnlyState && usecase.isEnabled()) {
			usecase.setEnabled(false);
			usecase.setToolTipText(UmlMessages.General_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !usecase.isEnabled()) {
			usecase.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#updateUsecase()
	 * @generated
	 */
	public void updateUsecase() {
  usecase.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addFilterUsecase(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToUsecase(ViewerFilter filter) {
    usecase.addFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#addBusinessFilterUsecase(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToUsecase(ViewerFilter filter) {
    usecase.addBusinessRuleFilter(filter);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralPropertiesEditionPart#isContainedInUsecaseTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInUsecaseTable(EObject element) {
    return ((ReferencesTableSettings)usecase.getInput()).contains(element);
  }






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * @generated
	 */
	public String getTitle() {
    return UmlMessages.General_Part_Title;
  }



}
