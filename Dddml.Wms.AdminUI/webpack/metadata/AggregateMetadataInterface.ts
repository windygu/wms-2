interface AggregateMetadataInterface {
    name: string;
    plural: string;
    label: string;
    collectionLabel: string;
    id: AggregatePropertyMetadataInterface;
    properties: Array<AggregatePropertyMetadataInterface>
    entities?: Array<AggregateMetadataInterface>
}