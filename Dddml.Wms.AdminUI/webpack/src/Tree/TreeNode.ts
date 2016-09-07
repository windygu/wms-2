export default class TreeNode {
    public title: string;
    public id: string;
    public level: number        = 0;
    public folded: boolean      = true;//是否折叠
    public children: TreeNode[] = [];
    public data: {};
    public selected: boolean    = false;

    get icon() {
        if (this.folded) {
            return 'glyphicon-plus';
        } else {
            return 'glyphicon-minus';
        }
    }

    setChildren(children: TreeNode[]) {
        for (let child of children) {
            child.level = this.level + 1;
        }

        this.children = children;
    }

    addChild(child: TreeNode) {
        child.level = this.level + 1;

        this.children.push(child);
    }
}