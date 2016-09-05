import tableConfig from '../../../config/view/tables';
import FieldsModel from "./TableFieldsModel";
import EntityCollection from "../../Domain/EntityCollection";
import TableRowModel from "./TableRowModel";

export default class TableListModel {
    public name;
    public rows: TableRowModel[];
    public operations: LinkButtonModelInterface[];
    public columns: string[];

    constructor(name: string, rows: TableRowModel[] = []) {
        this.name       = name;
        this.rows       = rows;
        this.operations = [];
        this.columns    = Object.keys(tableConfig[this.name].displayableFields);
    }

    static createFromEntityCollection(entities: EntityCollection): TableListModel {
        //todo
        let rows: TableRowModel[] = [];

        for (let entity of entities.all()) {
            rows.push(FieldsModel.createFromEntity(entity));
        }

        let table = TableListModel(entities.name, fields);
    }
}