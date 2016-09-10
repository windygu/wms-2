import tableConfig from '../../../config/view/tables';
import TableRowModel from "./TableRowModel";
import EntityCollection from "../../Dddml/Domain/EntityCollection";

export default class TableModel {
    public name;
    public rows: TableRowModel[];
    public columns: string[];

    constructor(name: string, rows: TableRowModel[] = [], columns: string[]) {
        this.name    = name;
        this.rows    = rows;
        this.columns = columns;
    }
    //
    //static createFromEntityCollection(entities: EntityCollection): TableModel {
    //    //todo
    //    let rows: TableRowModel[] = [];
    //
    //    for (let entity of entities.all()) {
    //        rows.push(TableRowModel.createFromEntity(entity));
    //    }
    //
    //    return new TableModel(entities.name, rows);
    //}
}