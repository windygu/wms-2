import PropertyType from "../Metadata/PropertyType";
import valueObjectsMetadata from '../../metadata/valueObjects'

export default class MetadataHelper {
    static getAggregateByPlural(metadata: Array<AggregateMetadataInterface>, value: String) {
        for (let agg of metadata) {
            if (agg.plural == value) {
                return agg;
            }
        }
    }

    static getValueObjectMetadata(metadata: PropertyMetadataInterface): ValueObjectMetadataInterface {
        if (!PropertyType.isValueObject(metadata)) {
            throw new Error('类型错误');
        }

        for (let valueObject of valueObjectsMetadata) {
            if (metadata.type == valueObject.name) {
                return valueObject;
            }
        }

        throw new Error('类型错误');
    }
}