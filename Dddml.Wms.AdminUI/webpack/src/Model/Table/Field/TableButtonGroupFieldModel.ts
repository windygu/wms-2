export default class TableButtonGroupFieldModel implements TableFieldModelInterface {
    private _buttons: ButtonModelInterface[];

    get buttons(): ButtonModelInterface[] {
        return this._buttons;
    }

    addButton(button: ButtonModelInterface) {
        this._buttons.push(button);
    }
}