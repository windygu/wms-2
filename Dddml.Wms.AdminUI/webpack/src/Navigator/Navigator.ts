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

        this.addItem(
            new NavigatorItem(metadata.collectionLabel, {
                name: 'entities',
                params: {
                    name: route.params.name
                }
            })
        );

        if (route.name == 'entity') {
            this.addItem(
                new NavigatorItem(metadata.label, {
                    name: 'entity',
                    params: {
                        name: route.params.name,
                        id: route.params.id
                    }
                })
            );
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