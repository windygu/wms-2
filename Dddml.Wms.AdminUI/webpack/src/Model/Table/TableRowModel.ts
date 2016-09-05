import TableFieldModel from "./TableFieldMode";
import Entity from "../../Domain/Entity";

export default class TableRowModel {
    private fields: TableFieldModel[];
    public operations: LinkButtonModelInterface[];

    add(field: TableFieldModel) {
        this.fields.push(field);
    }

    static createFromEntity(entity: Entity): TableRowModel {
        let fields = new TableRowModel();

        for (let property of entity.getData()) {
            fields.add(new TableFieldModel(property));
        }

        return fields;
    }
}