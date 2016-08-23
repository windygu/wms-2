export default class ObjectValue {
    constructor(data, metadata) {
        this.metadata = metadata;
        this.data = data;
    }

    toString() {
        let properties = [];
        for (let i = 0; i < this.metadata.properties.length; i++) {
            let propertyName = this.metadata.properties[i];

            properties.push(this.data[propertyName]);
        }

        return properties.join(',');
    }
}