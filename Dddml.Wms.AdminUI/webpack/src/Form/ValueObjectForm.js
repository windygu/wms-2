import FormElement from "./FormElement";

export default class ValueObjectForm {
    constructor(name, metadata) {
        this.valueObjectName = name;
        this.elements = [];
    }

    addElement(element) {
        this.elements.push(element);
    }

    static create(name, metadata) {
        let form = new ValueObjectForm(name, metadata);
        for (let i = 0; i < metadata.properties.length; i++) {
            let element = new FormElement(
                metadata.properties[i].name,
                name + '_' + metadata.properties[i].name
            );

            form.addElement(element);
        }

        return form;
    }
}