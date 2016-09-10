import Table from './Model/Table/TableModel';

export default class EntityCollection {
    public data;
    public metadata;

    constructor(data, metadata) {
        this.data     = data;
        this.metadata = metadata;
    }

    toTable($route = null) {
        //let table = new Table(
        //    this.metadata.name,
        //    this.data
        //);

        //for (let row of table.rows) {
        //    let chainingName = EntityChainHelper.createChainingName(row, this.metadata, $route);
        //
        //    row.detailRoute = {
        //        name: 'entity',
        //        params: {
        //            chainingName: chainingName
        //        }
        //    };
        //}

        //return table;
    }
}