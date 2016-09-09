import EntityMetadata from "./EntityMetadata";

export default class EntityCollectionMetadata {
    private rawMetadata: EntityMetadataInterface[] = [];

    constructor(metadata: EntityMetadataInterface[]) {
        this.rawMetadata = metadata;
    }

    public entity(value: String) {
        let metadata = _.find(this.rawMetadata, (o: EntityMetadataInterface)=> {
            return o.plural == value;
        });

        return new EntityMetadata(metadata);
    }

    public all() {
        let entities: EntityMetadata[] = [];

        for (let metadata of this.rawMetadata) {
            entities.push(new EntityMetadata(metadata));
        }

        return entities;
    }
}