export default class FormElement {
    public label;
    public elementName;
    public value;

    constructor(label, name, value = '') {
        this.label = label;
        this.elementName = name;
        this.value = value;
    }
}