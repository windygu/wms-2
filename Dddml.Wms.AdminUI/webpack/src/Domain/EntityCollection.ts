import Entity from "./Entity";
import AggregatesMetadata from "../Metadata/EntityCollectionMetadata";
import EntityMetadata from "../Metadata/EntityMetadata";

export default class EntityCollection {
    private data: EntityInterface[];
    private metadata: EntityMetadata;
    private _hierarchies: EntityHierarchyInterface[];

    get name() {
        return this.metadata.plural;
    }

    get label() {
        return this.metadata.collectionLabel;
    }

    get hierarchies(): EntityHierarchyInterface[] {
        return this._hierarchies;
    }

    constructor(hierarchies: EntityHierarchyInterface[],
                data: EntityInterface[] = []) {
        this.data         = data;
        this._hierarchies = hierarchies;
        this.metadata     = AggregatesMetadata
            .getAggregates()
            .getMetadataByHierarchies(hierarchies);
    }

    static create(hierarchies: EntityHierarchyInterface[],
                  data: EntityInterface[] = []) {
        return new EntityCollection(hierarchies, data);
    }

    /**
     * 获得实体
     *
     * @param hierarchies 层次
     * @param absolute 是否从根层次开始索引，否的话，从当前位置开始索引
     */
    public findEntity(hierarchies: EntityHierarchyInterface[], absolute: boolean = true) {

    }

    /**
     * 获取下级实体
     *
     * @param id
     */
    public subEntity(id: string|ValueObjectInterface) {

    }

    public findEntities(hierarchies: EntityHierarchyInterface[], name: string, absolute: boolean = true) {

    }

    public subEntities(name: string) {

    }

    public all() {
        let entities = [];
        for (let entity of this.data) {
            let hierarchies = _.concat(this.hierarchies, [{
                name: this.metadata.name,
                id: entity[this.metadata.id.name]
            }]);

            entities.push(new Entity(hierarchies, entity));
        }
    }
}