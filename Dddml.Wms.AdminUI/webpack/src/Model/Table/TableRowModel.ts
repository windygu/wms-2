import Entity from "../../Domain/Entity";
import TableFieldModelFactory from "./Field/TableFieldModelFactory";

export default class TableRowModel {
    private _fields: TableFieldModelInterface[];

    get fields(): TableFieldModelInterface[] {
        return this._fields;
    }

    add(field: TableFieldModelInterface) {
        this._fields.push(field);
    }

    static createFromEntity(entity: Entity, displayedFields: string[]): TableRowModel {
        let row = new TableRowModel();

        for (let name of displayedFields) {
            row.add(TableFieldModelFactory.createFromEntity(entity, name));
        }

        return row;
    }
}