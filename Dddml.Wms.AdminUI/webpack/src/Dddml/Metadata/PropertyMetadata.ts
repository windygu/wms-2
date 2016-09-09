export default class PropertyMetadata {
    private _rawData: PropertyMetadataInterface;

    constructor(metadata: PropertyMetadataInterface) {
        this._rawData = metadata;
    }

    get name() {
        return _.trimEnd(this._rawData.name, '?');
    }

    get label() {
        return this._rawData.label;
    }

    get type() {
        return this._rawData.type;
    }

    get required(): boolean {
        return this._rawData.name.slice(-1) == '?' ? false : true;
    }
}