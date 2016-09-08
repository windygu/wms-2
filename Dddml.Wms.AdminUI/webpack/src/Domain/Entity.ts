import AggregatesMetadata from "../Metadata/EntityCollectionMetadata";
import EntityCollection from "./EntityCollection";
import EntityMetadata from "../Metadata/EntityMetadata";

export default class Entity {
    private _data: EntityInterface;
    private metadata: EntityMetadata;
    private _hierarchies: EntityHierarchyInterface[];

    constructor(hierarchies: EntityHierarchyInterface[],
                data: EntityInterface = {}) {
        this._data         = data;
        this.metadata     = AggregatesMetadata
            .getAggregates()
            .getMetadataByHierarchies(hierarchies);
        this._hierarchies = hierarchies;
    }

    get name() {
        return this.metadata.name;
    }

    get label() {
        return this.metadata.label;
    }

    get hierarchies(): EntityHierarchyInterface[] {
        return this._hierarchies;
    }

    property(name: string, value: any) {
        if (value) {
            this.data[name] = value;
        } else {
            return this.data[name];
        }
    }

    entities(name: string) {
        if (this.data[name]) {
            return new EntityCollection(this.hierarchies, this.data[name]);
        }

        throw new Error(
            `名为 ${name} 的实体集不存在。\n
            数据：${JSON.stringify(this.data)}`);
    }

    get data(){
        return this._data;
    }
}