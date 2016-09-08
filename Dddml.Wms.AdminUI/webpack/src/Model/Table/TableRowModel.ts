import TableFieldModel from "./AbstractTableFieldModel";
import Entity from "../../Domain/Entity";

export default class TableRowModel {
    private _fields: TableFieldModel[];

    get fields(): TableFieldModel[] {
        return this._fields;
    }

    set fields(value: Array) {
        this._fields = value;
    }

    add(field: TableFieldModel) {
        this._fields.push(field);
    }

    static createFromEntity(entity: Entity): TableRowModel {
        let row = new TableRowModel();

        for (let name in entity.data) {
            row.add(new TableFieldModel(entity.data[name]));
        }

        return row;
    }
}