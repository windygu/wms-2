import AbstractTableFieldModel from "./AbstractTableFieldModel";

export default class TableButtonGroupFieldModel extends AbstractTableFieldModel {
    get buttons(): ButtonModelInterface[] {
        return <ButtonModelInterface[]>this.data;
    }

    addButton(button: ButtonModelInterface):TableButtonGroupFieldModel {
        this.data.push(button);

        return this;
    }
}