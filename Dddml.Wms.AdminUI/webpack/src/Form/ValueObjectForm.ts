import FormElement from "./FormElement";
import MetadataHelper from "../Helper/MetadataHelper";
import PropertyType from "../Dddml/Metadata/PropertyType";

export default class ValueObjectForm {
    public name: string;
    public elements: Array<FormElement>;
    public metadata: ValueObjectMetadataInterface;
    public parentData;

    constructor(name: string, metadata: ValueObjectMetadataInterface, parentData = {}) {
        this.name       = name;
        this.metadata   = metadata;
        this.parentData = parentData;
        this.elements   = [];

        this.build();
    }

    protected addItemFromMetadata(metadata: PropertyMetadataInterface) {
        if (PropertyType.isBuildInType(metadata)) {
            this.parentData[this.name][metadata.name] = "";

            this.elements.push(new FormElement(metadata, this.parentData[this.name]));
        } else if (PropertyType.isValueObject(metadata)) {
            this.parentData[this.name][metadata.name] = {};

            let childForm = new ValueObjectForm(
                metadata.name,
                MetadataHelper.getValueObjectMetadata(metadata),
                this.parentData[this.name]
            );

            for (let element of childForm.elements) {
                this.elements.push(element);
            }
        }
    }

    protected build() {
        for (let property of this.metadata.properties) {
            this.addItemFromMetadata(property);
        }
    }
}
