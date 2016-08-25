import ValueObjectForm from "./ValueObjectForm";
import PropertyType from "../Metadata/PropertyType";
import FormElement from "./FormElement";
import MetadataHelper from "../Helper/MetadataHelper";

export default class EntityForm {
    public data;
    public aggregateMetadata: AggregateMetadataInterface;
    public elements: Array<FormElement>;
    public valueObjectForms: Array<ValueObjectForm>;
    public config;

    get name() {
        return this.aggregateMetadata.name;
    }

    constructor(aggregateMetadata: AggregateMetadataInterface,
                config,
                data = {}) {
        this.data              = data;
        this.aggregateMetadata = aggregateMetadata;
        this.config            = config;
        this.valueObjectForms  = [];
        this.elements          = [];

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
        this.addItemFromMetadata(this.aggregateMetadata.id);

        for (let property of this.aggregateMetadata.properties) {
            if (this.hasDisplayableField(property.name)) {
                this.addItemFromMetadata(property);
            }
        }
    }
};
