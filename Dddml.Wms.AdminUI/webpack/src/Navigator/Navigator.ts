import NavigatorItem from './NavigatorItem'
import MetadataHelper from "../Helper/MetadataHelper";
import Application from "../Application";

export default class Navigator {
    public items;
    public app;

    constructor(application: Application) {
        this.items = [];
        this.app   = application;
    }

    build(route) {
        let metadata = this.getEntityMetadata(route.params.name);
        this.reset();

        if (route.name == 'entities') {
            this.addItem(
                new NavigatorItem(metadata.collectionLabel, {
                    name: 'entities',
                    params: {
                        name: route.params.name
                    }
                })
            );

            return;
        }

        if (route.name == 'entity') {
            this.addItem(
                new NavigatorItem(route.params.chainingName, {
                    name: 'entity',
                    params: {
                        chainingName: route.params.chainingName
                    }
                })
            );

            return;
        }

        if (route.name == 'createEntity') {
            this.addItem(
                new NavigatorItem('创建 ' + metadata.label, {
                    name: 'createEntity',
                    params: {
                        name: route.params.name
                    }
                })
            );

            return;
        }
    }

    getEntityMetadata(name) {
        return MetadataHelper.getEntityByPlural(
            this.app.entitiesMetadata,
            name
        );
    }

    addItem(item: NavigatorItem) {
        this.items.push(item);
    }

    reset() {
        this.items = [];
    }
}