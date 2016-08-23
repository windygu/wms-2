import tableConfig from '../config/view/tables';

export default class Table {
    public name;
    public rows;
    public routes;
    public columns;

    constructor(name, rows = []) {
        this.name = name;
        this.rows = rows;
        this.routes = [];
        this.columns = Object.keys(tableConfig[this.name].displayableFields);
    }
}