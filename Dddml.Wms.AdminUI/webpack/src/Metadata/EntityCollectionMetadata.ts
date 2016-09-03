import aggregatesMetadata from '../../metadata/aggregates';
import EntityMetadata from "./EntityMetadata";

export default class EntityCollectionMetadata {
    private static aggregates: EntityCollectionMetadata;
    private rawMetadata: EntityMetadataInterface[] = [];

    static getAggregates() {
        if (!EntityCollectionMetadata.aggregates) {
            EntityCollectionMetadata.aggregates = new EntityCollectionMetadata(aggregatesMetadata);
        }

        return EntityCollectionMetadata.aggregates;
    }

    constructor(metadata: EntityMetadataInterface[]) {
        this.rawMetadata = metadata;
    }

    public entity(value: String) {
        let metadata = _.find(this.rawMetadata, (o: EntityMetadataInterface)=> {
            return o.plural == value;
        });

        return new EntityMetadata(metadata);
    }

    public getMetadataByHierarchies(hierarchies: EntityHierarchyInterface[]) {
        let root = hierarchies.shift();
        let name = root.name;

        let entityMetadata = this.entity(name);

        if (hierarchies.length == 0) {
            return entityMetadata;
        }

        for (let item of hierarchies) {
            entityMetadata = entityMetadata.entities.entity(item.name);

            if (!entityMetadata) {
                throw new Error(`没有该实体的定义：${item.name}`);
            }
        }

        return entityMetadata;
    }

    public all() {
        let entities: EntityMetadata[] = [];
        for (let metadata of this.rawMetadata) {
            entities.push(new EntityMetadata(metadata));
        }
        return entities;
    }
}