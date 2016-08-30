import NavigatorItem from './NavigatorItem'
import MetadataHelper from "../Helper/MetadataHelper";
import Application from "../Application";
import EntityChainHelper from "../Helper/EntityChainHelper";

export default class Navigator {
    public items;
    public app;

    constructor(application: Application) {
        this.items = [];
        this.app   = application;
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

    protected reset() {
        this.items = [];
    }

    protected buildEntities($route) {
        let metadata = this.getEntityMetadata($route.params.name);

        this.addItem(
            new NavigatorItem(metadata.collectionLabel, {
                name: 'entities',
                params: {
                    name: $route.params.name
                }
            })
        );
    }

    protected buildEntity($route) {
        let chaining = EntityChainHelper.chainingNameToArray($route.params.chainingName);
        let root     = chaining[0];

        this.addItem(
            new NavigatorItem(root.name, {
                name: 'entities',
                params: {
                    name: root.name,
                }
            })
        );

        for (let i = 0; i < chaining.length; i++) {
            this.addItem(
                new NavigatorItem(chaining[i].name + ':' + chaining[i].id, {
                    name: 'entity',
                    params: {
                        chainingName: EntityChainHelper.arrayToChainingName(
                            chaining.slice(0, i + 1)
                        )
                    }
                })
            );
        }
    }

    protected buildCreateEntity($route) {
        let metadata = this.getEntityMetadata($route.params.name);

        this.addItem(
            new NavigatorItem('创建 ' + metadata.label, {
                name: 'createEntity',
                params: {
                    name: $route.params.name
                }
            })
        );
    }

    protected buildMergePatchEntity($route) {

    }
}