import PropertyType from "../Metadata/PropertyType";
import valueObjectsMetadata from '../../metadata/valueObjects'

export default class MetadataHelper {
    static getEntityByPlural(metadata: Array<EntityMetadataInterface>, value: String) {
        for (let entity of metadata) {
            if (entity.plural == value) {
                return entity;
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