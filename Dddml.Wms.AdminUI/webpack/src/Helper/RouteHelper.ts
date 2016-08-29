import Entity from "../Entity";

export default class RouteHelper {
    static createEntityApiRoute($route) {
        let chaining: any = decodeURIComponent($route.params.chainingName);
        let route: string = '';

        chaining = JSON.parse(chaining);

        for (let item of chaining) {
            route += `${item.name}/${item.id}/`;
        }

        return route.substr(0, route.length - 1);
    }

    static createChainingName(data, metadata, $route = null) {
        let entity      = new Entity(data, metadata);
        let chainingObj = [];

        chainingObj.push({
            name: metadata.plural,
            id: entity.getStringId()
        });

        if ($route) {
            let routeChainingName: any = decodeURIComponent($route.params.chainingName);
            routeChainingName          = JSON.parse(routeChainingName);

            for (let item of chainingObj) {
                routeChainingName.push(item);
            }

            chainingObj = routeChainingName;
        }
//console.log(routeChainingName);

        return encodeURIComponent(JSON.stringify(chainingObj));
    }
}