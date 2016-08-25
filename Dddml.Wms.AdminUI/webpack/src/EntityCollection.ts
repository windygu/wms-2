import Table from './Table';
import Entity from './Entity';

export default class EntityCollection {
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

        for (let row of table.rows) {
            let entity = new Entity(row, this.metadata);

            row.detailRoute = {
                name: 'entity',
                params: {
                    name: this.metadata.plural,
                    id: entity.getStringId()
                }
            };
        }

        return table;
    }
}