export default class RouteHelper {
    public static entitiesSeparator = '..';
    public static entitySeparator   = '::';

    static buildGetEntityApiRoute($route) {
        let chaining: Array<string> = $route.params.chainingName.split(RouteHelper.entitiesSeparator);

        let route: string = '';

        for (let item of chaining) {
            let entity = item.split(RouteHelper.entitySeparator);
            let name = entity.shift();
            let id   = entity.shift();

            route += `${name}/${id}/`;
        }

        return route.substr(0, route.length-1);
    }
}