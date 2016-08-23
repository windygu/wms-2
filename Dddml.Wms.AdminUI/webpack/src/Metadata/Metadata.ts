export default class Metadata {
    public data;

    constructor(data: Array<AggregateMetadataInterface>) {
        this.data = data;
    }

    getAggregateByPlural(value: String) {
        for (let i = 0; i < this.data.length; i++) {
            if (this.data[i].plural == value) {
                return this.data[i];
            }
        }
    }
}