import EntityCollectionMetadata from "./EntityCollectionMetadata";

export default class EntityMetadata {
    private _rawData: EntityMetadataInterface;

    constructor(metadata: EntityMetadataInterface) {
        this._rawData = metadata;
    }

    get name() {
        return this._rawData.name;
    }

    get plural() {
        return this._rawData.plural;
    }

    get label() {
        return this._rawData.label;
    }

    get collectionLabel() {
        return this._rawData.collectionLabel;
    }

    get id() {
        return this._rawData.id;
    }

    get properties() {
        return this._rawData.properties;
    }

    get propertyNames() {
        return _.map(this.properties, 'name');
    }

    get entities() {
        return new EntityCollectionMetadata(this._rawData.entities);
    }
}