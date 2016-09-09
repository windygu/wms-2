interface EntityMetadataInterface {
    name: string;
    plural: string;
    label: string;
    collectionLabel: string;
    id: PropertyMetadataInterface;
    properties: Array<PropertyMetadataInterface>
    entities?: Array<EntityMetadataInterface>
}