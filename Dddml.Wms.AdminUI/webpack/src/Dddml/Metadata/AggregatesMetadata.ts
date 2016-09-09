import EntityCollectionMetadata from "./EntityCollectionMetadata";
import aggregatesMetadata from '../../../metadata/aggregates';
import EntityMetadata from "./EntityMetadata";

export default class AggregatesMetadata extends EntityCollectionMetadata {
    private static metadata: AggregatesMetadata;

    static getInstance() {
        if (!AggregatesMetadata.metadata) {
            AggregatesMetadata.metadata = new AggregatesMetadata(aggregatesMetadata);
        }

        return AggregatesMetadata.metadata;
    }

    public getMetadataByHierarchies(hierarchies: string[]) {
        if (_.isEmpty(hierarchies)) {
            throw new Error('Hierarchies 不能为空');
        }

        let entityMetadata: EntityMetadata = this.entity(hierarchies.shift());

        for (let name of hierarchies) {
            entityMetadata = entityMetadata.entities.entity(name);
        }

        return entityMetadata;
    }
}