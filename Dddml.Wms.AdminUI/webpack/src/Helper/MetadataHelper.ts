import PropertyType from "../Metadata/PropertyType";
import valueObjectsMetadata from '../../metadata/valueObjects'

export default class MetadataHelper {
    static getAggregateByPlural(metadata: AggregateMetadataInterface, value: String) {
        for (let agg of metadata) {
            if (agg.plural == value) {
                return agg;
            }
        }
    }

    static getValueObjectMetadata(metadata: PropertyMetadataInterface) {
        if (!PropertyType.isValueObject(metadata)) {
            return false;
        }

        for (let valueObject of valueObjectsMetadata) {
            if (valueObject.type == metadata.name) {
                return valueObject;
            }
        }

        return false;
    }
}