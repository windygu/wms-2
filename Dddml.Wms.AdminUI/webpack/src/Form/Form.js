import FormElement from "./FormElement";
import ObjectHelper from '../Helper/ObjectHelper';

export default class Form {
    constructor(metadata, config) {
        this.formName = metadata.name;
        this.elements = [];
        this.displayableElements = [];
        this.config = config || {};
        this.idElement = {};
    }

    addElement(element) {
        this.elements.push(element);
    }

    addDisplayableElement(element) {
        this.displayableElements.push(element);
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

        form.idElement = new FormElement(
            metadata.id.name,
            metadata.id.name
        );

        if (!form.hasDisplayableFields()) {
            form.displayableElements = form.elements;
        }

        for (let i = 0; i < metadata.properties.length; i++) {
            let element = new FormElement(
                metadata.properties[i].name,
                metadata.properties[i].name
            );

            form.addElement(element);

            if (form.hasDisplayableField(metadata.properties[i].name)) {
                form.addDisplayableElement(element);
            }
        }

        return form;
    }
}