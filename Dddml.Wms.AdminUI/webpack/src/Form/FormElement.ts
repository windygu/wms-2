export default class FormElement {
    public label;
    public name;
    private parentData;

    constructor(metadata: PropertyMetadataInterface, parentData) {
        this.label      = metadata.name;
        this.name       = metadata.name;
        this.parentData = parentData;
    }

    get value() {
        return this.parentData[this.name];
    }

    set value(value) {
        this.parentData[this.name] = value;
    }
}