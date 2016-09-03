import tableConfig from '../../../config/view/tables';
import FieldsModel from "./TableFieldsModel";
import EntityCollection from "../../Domain/EntityCollection";

export default class TableListModel {
    public name;
    public rows: FieldsModel[];
    public operations: LinkButtonModelInterface[];
    public columns: string[];

    constructor(name: string, rows: FieldsModel[] = []) {
        this.name       = name;
        this.rows       = rows;
        this.operations = [];
        this.columns    = Object.keys(tableConfig[this.name].displayableFields);
    }

    static createFromEntityCollection(entities: EntityCollection): TableListModel {
        let fields: FieldsModel[] = [];

        for (let entity of entities.all()) {
            fields.push(FieldsModel.createFromEntity(entity));
        }

        let table = TableListModel(entities.name, fields);
    }
}