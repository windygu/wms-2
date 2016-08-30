import Entity from "../Entity";

export default class EntityChainHelper {
    static createGetEntityApiRoute($route, root: boolean = false) {
        let route: string = '';

        let chaining = EntityChainHelper.chainingNameToArray($route.params.chainingName);

        if (root) {
            chaining = [chaining.shift()];
        }

        for (let item of chaining) {
            route += `${item.name}/${item.id}/`;
        }

        return route.substr(0, route.length - 1);
    }

    static root($route){
        let chaining = EntityChainHelper.chainingNameToArray($route.params.chainingName);

        return chaining.shift();
    }

    static chainingNameToArray(chainingName: string) {
        let chaining: any = decodeURIComponent(chainingName);

        return JSON.parse(chaining);
    }

    static arrayToChainingName(chaining: Array<{name: string, id: string}>) {
        return encodeURIComponent(JSON.stringify(chaining))
    }

    static createChainingName(data, metadata, $route = null) {
        let entity      = new Entity(data, metadata);
        let chainingArr = [];

        chainingArr.push({
            name: metadata.plural,
            id: entity.getStringId()
        });

        let routeChainingName: any;
        if ($route) {
            routeChainingName = decodeURIComponent($route.params.chainingName);
            routeChainingName = JSON.parse(routeChainingName);

            for (let item of chainingArr) {
                routeChainingName.push(item);
            }

            chainingArr = routeChainingName;
        }

        return EntityChainHelper.arrayToChainingName(chainingArr);
    }
}