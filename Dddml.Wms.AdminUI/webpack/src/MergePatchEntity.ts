export default class MergePatchEntity {
    public parent;
    public data = {
        'commandType': 'MergePatch',
    };
    public name;

    constructor(name: string, parent: MergePatchEntity = null) {
        this.parent = parent;
        this.name   = _.lowerFirst(name);
    }

    setProperty(property, value: any) {
        this.data[property] = value;

        if (this.parent) {
            if (!Array.isArray(this.parent.data[this.name])) {
                this.parent.data[this.name] = [];
            }

            this.parent.data[this.name] = [this.data];
        }
    }

    getParent() {
        if (this.parent) {
            return this.parent;
        }

        return this;
    }

    getRoot() {
        let root = this;
        while (root.parent) {
            root = root.parent;
        }

        return root;
    }
}