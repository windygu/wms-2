export default class NavigatorItem {
    public label:String;
    public route;

    constructor(label = '', route) {
        this.label = label;
        this.route = route;
    }
}