import Entity from "../../Domain/Entity";
import FieldModel from "./TableFieldMode";

export default class TableFieldsModel {
    private fields: FieldModel[];

    constructor(fields: FieldModel[] = []) {
        this.fields = fields;
    }

    add(field: FieldModel) {
        this.fields.push(field);
    }

    getFields(): FieldModel[] {
        return this.fields;
    }

    static createFromEntity(entity: Entity): TableFieldsModel {
        let fields = new TableFieldsModel();

        for (let property in entity) {
            fields.add(new FieldModel(entity[property]));
        }

        return fields;
    }
}