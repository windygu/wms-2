import PropertyType from "../Metadata/PropertyType";
import valueObjectsMetadata from '../../metadata/valueObjects'
import RouteHelper from "./RouteHelper";

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

    static getMetadataByChainingName(metadata: Array<EntityMetadataInterface>, chainingName: string) {

        let chaining = chainingName.split(RouteHelper.entitiesSeparator);

        let root = chaining.shift().split(RouteHelper.entitySeparator);
        let name = root.shift();

        let data = MetadataHelper.getEntityByPlural(metadata, name);

        if (chaining.length == 0) {
            return data;
        }

        for (let item of chaining) {
            let entity = item.split(RouteHelper.entitySeparator);
            let name   = entity.shift();

            data = MetadataHelper.getEntityByPlural(data.entities, name);

            if (!data) {
                throw new Error('没有该实体的定义');
            }
        }

        return data;
    }
}