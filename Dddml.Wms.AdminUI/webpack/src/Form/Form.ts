import FormElement from "./FormElement";
import ValueObjectForm from './ValueObjectForm';
import PropertyMetadata from '../Metadata/PropertyMetadata';
import ObjectHelper from '../Helper/ObjectHelper';

export default class Form {
    public formName;
    public elements;
    public valueObjectForms;
    public config;

    constructor(metadata, config) {
        this.formName = metadata.name;
        this.elements = [];
        this.valueObjectForms = [];
        this.config = config || {};
    }

    addElement(element) {
        this.elements.push(element);
    }

    addValueObjectForm(form) {
        this.valueObjectForms.push(form);
    }

    hasDisplayableField(fieldName) {
        return this.hasDisplayableFields() &&
            this.config.displayableFields[fieldName];
    }

    hasDisplayableFields() {
        let fields = this.config.displayableFields;

        return (fields instanceof Object) &&
            ObjectHelper.isNotEmpty(fields)
    }

    getData() {
        let data = {};
        for (let i = 0; i < this.elements.length; i++) {
            data[this.elements[i].elementName] = this.elements[i].value;
        }

        return data;
    }

    toJson() {
        return JSON.stringify(this.getData());
    }

    static createForm(metadata, config) {
        let form = new Form(metadata, config);

        let proMetadata = new PropertyMetadata(metadata.id);

        if (proMetadata.isNormalType()) {
            form.addElement(new FormElement(
                metadata.id.name,
                metadata.id.name
            ));
        } else {
            form.addValueObjectForm(
                ValueObjectForm.create(
                    metadata.id.name,
                    proMetadata.getValueObjectMetadata()
                )
            )
        }

        for (let i = 0; i < metadata.properties.length; i++) {
            let proMetadata = new PropertyMetadata(metadata.properties[i]);

            if (form.hasDisplayableField(metadata.properties[i].name)) {
                if (proMetadata.isNormalType()) {
                    form.addElement(new FormElement(
                        metadata.properties[i].name,
                        metadata.properties[i].name
                    ));
                } else {
                    form.addValueObjectForm(
                        ValueObjectForm.create(
                            metadata.properties[i].name,
                            proMetadata.getValueObjectMetadata()
                        )
                    )
                }
            }
        }

        return form;
    }
}