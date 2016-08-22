import tableConfig from '../config/view/tables';

export default class Table {
    constructor(name, rows = []) {
        this.name = name;
        this.rows = rows;
        this.routes = [];
        this.columns = Object.keys(tableConfig[this.name].displayableFields);
    }
}