import Table from './Table';
import Aggregate from './Aggregate';

export default class AggregateCollection {
    public data;
    public metadata;

    constructor(data, metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    toTable() {
        let table = new Table(
            this.metadata.name,
            this.data
        );

        for (let i = 0; i < table.rows.length; i++) {
            let aggregate = new Aggregate(table.rows[i], this.metadata);

            table.rows[i].detailRoute = {
                name: 'aggregate',
                params: {
                    name: this.metadata.plural,
                    id: aggregate.getStringId()
                }
            };
        }

        return table;
    }
}