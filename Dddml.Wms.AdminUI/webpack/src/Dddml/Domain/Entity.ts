import EntityCollection from "./EntityCollection";
import EntityMetadata from "../Metadata/EntityMetadata";
import AggregatesMetadata from "../Metadata/AggregatesMetadata";

export default class Entity {
    private _rawData: EntityInterface;
    private _metadata: EntityMetadata;
    private _hierarchies: EntityHierarchyInterface[];

    constructor(hierarchies: EntityHierarchyInterface[],
                data: EntityInterface = {}) {
        this._rawData     = data;
        this._metadata    = AggregatesMetadata
            .getInstance()
            .getMetadataByHierarchies(_.keys(hierarchies));
        this._hierarchies = hierarchies;
    }

    get name() {
        return this._metadata.name;
    }

    get label() {
        return this._metadata.label;
    }

    get hierarchies(): EntityHierarchyInterface[] {
        return this._hierarchies;
    }

    get metadata(): EntityMetadata {
        return this._metadata;
    }

    property(name: string, value: any) {
        if (value) {
            this._rawData[name] = value;
        } else {
            return this._rawData[name];
        }
    }

    entities(name: string) {
        if (this._rawData[name]) {
            return new EntityCollection(name, this.hierarchies, this._rawData[name]);
        }

        throw new Error(
            `名为 ${name} 的实体集不存在。\n
            数据：${JSON.stringify(this._rawData)}`);
    }

    get raw() {
        return this._rawData;
    }
}