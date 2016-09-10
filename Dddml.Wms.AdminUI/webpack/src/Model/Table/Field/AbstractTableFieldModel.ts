export default class AbstractTableFieldModel {
    static TEXT_TYPE         = 'text';
    static BUTTON_GROUP_TYPE = 'buttonGroup';
    static NUMBER_TYPE       = 'number';
    static CHECKBOX_TYPE     = 'checkbox';
    static DECIMAL_TYPE      = 'decimal';
    static DATETIME_TYPE     = 'datetime';

    protected data: any;

    constructor(data: any) {
        this.data = data;
    }
}