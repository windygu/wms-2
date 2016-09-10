import Entity from "../Domain/Entity";
import TableRowModel from "../../Model/Table/TableRowModel";
import TableFieldModelFactory from "./TableFieldModelFactory";

export default class TableRowModelFactory {
    static create(entity: Entity, displayedFields: string[]) {
        let row            = new TableRowModel();
        let entityMetadata = entity.metadata;

        for (let name of displayedFields) {
            row.add(
                TableFieldModelFactory.create(
                    entityMetadata.property(name),
                    name
                )
            );
        }

        return row;
    }
}