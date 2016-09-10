import AbstractTableFieldModel from "../../Model/Table/Field/AbstractTableFieldModel";
import TableTextFieldModel from "../../Model/Table/Field/TableTextFieldModel";
import TableButtonGroupFieldModel from "../../Model/Table/Field/TableButtonGroupFieldModel";
import PropertyMetadata from "../Metadata/PropertyMetadata";
import TableNumberFieldModel from "../../Model/Table/Field/TableNumberFieldModel";
import TableBoolFieldModel from "../../Model/Table/Field/TableBoolFieldModel";
import TableDecimalFieldModel from "../../Model/Table/Field/TableDecimalFieldModel";
import TableDateTimeFieldModel from "../../Model/Table/Field/TableDateTimeFieldModel";
import TableValueObjectFieldModel from "../Model/Table/Field/TableValueObjectFieldModel";

export default class TableFieldModelFactory {
    static TYPE_MAP = {
        'string': AbstractTableFieldModel.TEXT_TYPE,
        'int': AbstractTableFieldModel.NUMBER_TYPE,
        'long': AbstractTableFieldModel.NUMBER_TYPE,
        'bool': AbstractTableFieldModel.CHECKBOX_TYPE,
        'decimal': AbstractTableFieldModel.DECIMAL_TYPE,
        'DateTime': AbstractTableFieldModel.DECIMAL_TYPE,
    };

    static create(metadata: PropertyMetadata, data: any) {
        switch (metadata.type) {
            case 'string':
                return new TableTextFieldModel(data);
            case 'int':
            case 'long':
                return new TableNumberFieldModel(data);
            case 'bool':
                return new TableBoolFieldModel(data);
            case 'decimal':
                return new TableDecimalFieldModel(data);
            case 'DateTime':
                return new TableDateTimeFieldModel(data);
            default:
                return new TableValueObjectFieldModel(data);
        }
    }
}