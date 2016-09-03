import EntityCollectionMetadata from "../../src/Metadata/EntityCollectionMetadata";
import * as Vue from 'vue';

var aggregatesMetadata = EntityCollectionMetadata.getAggregates();

export default Vue.extend({
    template: require('./views/AggregatesMenu.html'),
    data(){
        return {
            links: [],
        }
    },
    ready(){
        let links: LinkModelInterface[] = [];

        for (let metadata of aggregatesMetadata.all()) {
            links.push({
                label: metadata.label,
                route: {
                    name: 'entities',
                    params: {
                        name: metadata.plural
                    }
                }
            })
        }

        this.links = links;
    }
});