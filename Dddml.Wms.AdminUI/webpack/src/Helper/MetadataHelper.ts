import PropertyType from "../Metadata/PropertyType";
import valueObjectsMetadata from '../../metadata/valueObjects'
import customerValueObjectMetadata from '../../metadata/customerValueObject'

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

        for (let valueObject of customerValueObjectMetadata) {
            if (metadata.type == valueObject.name) {
                return valueObject;
            }
        }

        throw new Error('类型错误');
    }

    static getMetadataByChainingName(metadata: Array<EntityMetadataInterface>, chainingName: string) {

        let chaining = JSON.parse(decodeURIComponent(chainingName));

        let root = chaining.shift();
        let name = root.name;

        let data = MetadataHelper.getEntityByPlural(metadata, name);

        if (chaining.length == 0) {
            return data;
        }

        for (let item of chaining) {
            data = MetadataHelper.getEntityByPlural(data.entities, item.name);

            if (!data) {
                throw new Error('没有该实体的定义');
            }
        }

        return data;
    }
}