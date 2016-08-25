import StringHelper from './Helper/StringHelper';
import AggregateCollection from '../src/AggregateCollection';

export default class Aggregate {
    public data;
    public metadata;
    public childMetadatas;

    constructor(data, metadata) {
        this.data = data;
        this.metadata = metadata;
        this.childMetadatas = {};
    }

    getStringId(encode = true) {
        let id;
        let idName = this.metadata.id.name;

        if (this.metadata.id.properties) {
            let properties = [];

            for (let i = 0; i < this.metadata.id.properties.length; i++) {
                let propertyName = this.metadata.id.properties[i];

                properties.push(this.data[idName][propertyName]);
            }
            id = properties.join(',');
        } else {
            id = this.data[idName];
        }

        return encode ? encodeURI(id) : id;
    }

    getFields() {
        let fields = [];
        let properties = this.metadata.properties;

        if (properties) {
            for (let i = 0; i < properties.length; i++) {
                fields.push(properties[i].name);
            }
        }

        return fields;
    }

    getChildEntityMetadata(name = null) {
        if (!this.childMetadatas.length && this.metadata.entities) {
            let entities = this.metadata.entities;
            for (let i = 0; i < entities.length; i++) {
                this.childMetadatas[entities[i].plural] = entities[i];
            }
        }
        if (name) {
            return this.childMetadatas[name];
        }

        return this.childMetadatas;
    }

    getChildEntityMetadataNames() {
        let metadata = this.getChildEntityMetadata();

        return Object.keys(metadata);
    }

    getChildEntities() {
        let children = {};
        let names = this.getChildEntityMetadataNames();

        for (let i = 0; i < names.length; i++) {
            let name = names[i];

            children[name] = new AggregateCollection(
                this.data[StringHelper.lcfirst(name)],
                this.getChildEntityMetadata(name)
            );
        }

        return children;
    }
}