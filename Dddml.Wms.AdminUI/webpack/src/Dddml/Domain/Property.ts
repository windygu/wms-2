export default class Property {
    private _rawData: PropertyMetadataInterface;

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

    get raw(): PropertyMetadataInterface {
        return this._rawData;
    }

    constructor(data: PropertyMetadataInterface) {
        this._rawData = data;
    }
}