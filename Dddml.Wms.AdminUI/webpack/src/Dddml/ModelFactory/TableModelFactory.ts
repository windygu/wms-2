import EntityCollection from "../Domain/EntityCollection";
import TableRowModel from "../../Model/Table/TableRowModel";
import Entity from "../Domain/Entity";
import TABLES_CONFIG from '../../../config/view/tables';
import TableModel from "../../Model/Table/TableModel";
import TableRowModelFactory from "./TableRowModelFactory";

export default class TableModelFactory {
    static createTableModel(entityCollection: EntityCollection, displayedFields: string[]): TableModel {
        let rows: TableRowModel[] = [];

        let columns: string[] = Object.keys(TABLES_CONFIG[entityCollection.name].displayableFields);
        columns.push('操作');

        for (let entity of entityCollection.all()) {
            rows.push(
                TableRowModelFactory.create(
                    entity,
                    columns
                )
            );
        }

        return new TableModel(entityCollection.name, rows, columns);
    }


}