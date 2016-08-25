import NavigatorItem from './NavigatorItem'
import MetadataHelper from "../Helper/MetadataHelper";
import Application from "../Application";

export default class Navigator {
    public items;
    public app;
    public aggregateMetadata;

    constructor(application: Application) {
        this.items = [];
        this.app   = application;
    }

    build(route) {
        let metadata = this.getAggregateMetadata(route.params.name);
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

    getAggregateMetadata(name) {
        return MetadataHelper.getAggregateByPlural(
            this.app.aggregatesMetadata,
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