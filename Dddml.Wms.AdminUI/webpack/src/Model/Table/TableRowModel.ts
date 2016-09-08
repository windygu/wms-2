import TableFieldModel from "./TableFieldMode";
import Entity from "../../Domain/Entity";
import * as _ from 'lodash';

export default class TableRowModel {
    private fields: TableFieldModel[];
    public operations: LinkButtonModelInterface[];

    add(field: TableFieldModel) {
        this.fields.push(field);
    }

    static createFromEntity(entity: Entity): TableRowModel {
        let row = new TableRowModel();

        for (let name in entity.data) {
            row.add(new TableFieldModel(entity.data[name]));
        }

        return row;
    }
}