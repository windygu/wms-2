import EntityCollectionMetadata from "./EntityCollectionMetadata";
export default class EntityMetadata {
    private rawMetadata: EntityMetadataInterface;

    constructor(metadata: EntityMetadataInterface) {
        this.rawMetadata = metadata;
    }

    get name() {
        return this.rawMetadata.name;
    }

    get plural() {
        return this.rawMetadata.plural;
    }

    get label() {
        return this.rawMetadata.label;
    }

    get collectionLabel() {
        return this.rawMetadata.collectionLabel;
    }

    get id() {
        return this.rawMetadata.id;
    }

    get properties() {
        return this.rawMetadata.properties;
    }

    get entities() {
        return new EntityCollectionMetadata(this.rawMetadata.entities);
    }
}