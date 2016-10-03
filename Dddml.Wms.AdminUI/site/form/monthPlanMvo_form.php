<?php
use Symfony\Component\Form\Extension\Core\Type\FormType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;

return $app['form.factory']->createBuilder(FormType::class, $data)
    ->add('description', TextType::class, [
        'required' => false,
        'label'    => 'Description',
    ])
    ->add('version', IntegerType::class, [
        'required' => false,
        'label'    => 'Version',
    ])
    ->add('active', CheckboxType::class, [
        'required' => false,
        'label'    => 'Active',
    ])
    ->add('yearPlanDescription', TextType::class, [
        'required' => false,
        'label'    => 'Year Plan Description',
    ])
    ->add('yearPlanCreatedBy', TextType::class, [
        'required' => false,
        'label'    => 'Year Plan Created By',
    ])
    ->add('yearPlanUpdatedBy', TextType::class, [
        'required' => false,
        'label'    => 'Year Plan Updated By',
    ])
    ->add('yearPlanVersion', IntegerType::class, [
        'required' => false,
        'label'    => 'Year Plan Version',
    ])
    ->add('yearPlanCreatedAt', DateTimeType::class, [
        'required' => false,
        'label'    => 'Year Plan Created At',
    ])
    ->add('yearPlanUpdatedAt', DateTimeType::class, [
        'required' => false,
        'label'    => 'Year Plan Updated At',
    ])
    ->add('yearPlanActive', CheckboxType::class, [
        'required' => false,
        'label'    => 'Year Plan Active',
    ])
    ->add('yearPlanDeleted', CheckboxType::class, [
        'required' => false,
        'label'    => 'Year Plan Deleted',
    ])
    ->add('personBirthDate', DateTimeType::class, [
        'required' => false,
        'label'    => 'Person Birth Date',
    ])
    ->add('personEmail', TextType::class, [
        'required' => false,
        'label'    => 'Person Email',
    ])
    ->add('personCreatedBy', TextType::class, [
        'required' => false,
        'label'    => 'Person Created By',
    ])
    ->add('personUpdatedBy', TextType::class, [
        'required' => false,
        'label'    => 'Person Updated By',
    ])
    ->add('personCreatedAt', DateTimeType::class, [
        'required' => false,
        'label'    => 'Person Created At',
    ])
    ->add('personUpdatedAt', DateTimeType::class, [
        'required' => false,
        'label'    => 'Person Updated At',
    ])
    ->add('personActive', CheckboxType::class, [
        'required' => false,
        'label'    => 'Person Active',
    ])
    ->add('personDeleted', CheckboxType::class, [
        'required' => false,
        'label'    => 'Person Deleted',
    ])
    ->add('personVersion', IntegerType::class, [
        'required' => false,
        'label'    => 'Person Version',
    ])
    ->add('createdBy', TextType::class, [
        'required' => false,
        'label'    => 'Created By',
    ])
    ->add('createdAt', DateTimeType::class, [
        'required' => false,
        'label'    => 'Created At',
    ])
    ->add('updatedBy', TextType::class, [
        'required' => false,
        'label'    => 'Updated By',
    ])
    ->add('updatedAt', DateTimeType::class, [
        'required' => false,
        'label'    => 'Updated At',
    ])
    ->getForm();

