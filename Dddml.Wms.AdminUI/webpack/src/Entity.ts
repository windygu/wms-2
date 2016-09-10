import EntityCollection from '../src/EntityCollection';
import MetadataHelper from "./Helper/MetadataHelper";
import PropertyType from "./Dddml/Metadata/PropertyType";

export default class Entity {
    public data;
    public metadata: EntityMetadataInterface;
    public childrenMetadata;

    constructor(data, metadata) {
        this.data             = data;
        this.metadata         = metadata;
        this.childrenMetadata = {};
    }

    getStringId(encode = true) {
        let id;
        let idName = this.metadata.id.name;

        if (PropertyType.isValueObject(this.metadata.id)) {
            let voMetadata = MetadataHelper.getValueObjectMetadata(this.metadata.id);
            let properties = [];

            for (let property of voMetadata.properties) {
                let propertyName = property.name;

                properties.push(this.data[idName][propertyName]);
            }
            id = properties.join(',');
        } else {
            id = this.data[idName];
        }

        return encode ? encodeURI(id) : id;
    }

    getFields() {
        let fields     = [];
        let properties = this.metadata.properties;

        if (properties) {
            fields = _.map(properties, 'name');
        }

        return fields;
    }

    getChildEntityMetadata(name = null) {
        if (!this.childrenMetadata.length && this.metadata.entities) {
            let entities = this.metadata.entities;
            for (let entity of entities) {
                this.childrenMetadata[entity.plural] = entity;
            }
        }
        if (name) {
            return this.childrenMetadata[name];
        }

        return this.childrenMetadata;
    }

    getChildEntityNames() {
        let metadata = this.getChildEntityMetadata();

        return Object.keys(metadata);
    }

    getChildEntities() {
        let children = {};
        let names    = this.getChildEntityNames();

        for (let name of names) {
            children[name] = new EntityCollection(
                this.data[_.lowerFirst(name)],
                this.getChildEntityMetadata(name)
            );
        }

        return children;
    }
}