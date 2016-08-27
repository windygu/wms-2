import Table from './Table';
import Entity from './Entity';
import RouteHelper from "./Helper/RouteHelper";

export default class EntityCollection {
    public data;
    public metadata;

    constructor(data, metadata) {
        this.data     = data;
        this.metadata = metadata;
    }

    toTable($route = null) {
        let table = new Table(
            this.metadata.name,
            this.data
        );

        for (let row of table.rows) {
            let entity       = new Entity(row, this.metadata);
            let chainingName = this.metadata.plural +
                RouteHelper.entitySeparator +
                entity.getStringId();

            if ($route) {
                chainingName = $route.params.chainingName + '..' + chainingName;
            }

            row.detailRoute = {
                name: 'entity',
                params: {
                    chainingName: chainingName
                }
            };
        }

        return table;
    }
}