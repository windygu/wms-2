export default abstract class AbstractTableFieldModel {
    private value: string;

    constructor(value: any) {
        this.value = value;
    }

    abstract get html();
}