import ValueObjectForm from "./ValueObjectForm";
import PropertyType from "../Metadata/PropertyType";
import FormElement from "./FormElement";
import MetadataHelper from "../Helper/MetadataHelper";

export default class EntityForm {
    public data;
    public EntityMetadata: EntityMetadataInterface;
    public elements: Array<FormElement>;
    public valueObjectForms: Array<ValueObjectForm>;
    public config;

    get name() {
        return this.EntityMetadata.name;
    }

    constructor(EntityMetadata: EntityMetadataInterface,
                config,
                data = {}) {
        this.data             = data;
        this.EntityMetadata   = EntityMetadata;
        this.config           = config;
        this.valueObjectForms = [];
        this.elements         = [];

        this.build();
    }

    protected addItemFromMetadata(metadata: PropertyMetadataInterface) {
        if (PropertyType.isBuildInType(metadata)) {
            this.data[metadata.name] = '';

            this.elements.push(new FormElement(metadata, this.data));
        } else if (PropertyType.isValueObject(metadata)) {
            this.data[metadata.name] = {};

            this.valueObjectForms.push(
                new ValueObjectForm(
                    metadata.name,
                    MetadataHelper.getValueObjectMetadata(metadata),
                    this.data
                )
            );
        }
    }

    protected hasDisplayableField(fieldName) {
        return this.config.displayableFields[fieldName];
    }

    protected build() {
        this.addItemFromMetadata(this.EntityMetadata.id);

        for (let property of this.EntityMetadata.properties) {
            if (this.hasDisplayableField(property.name)) {
                this.addItemFromMetadata(property);
            }
        }
    }
};
