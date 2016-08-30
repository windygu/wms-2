import Entity from '../src/Entity';
import Navigator from './Bootstrap/Navigator';
import ChildEntities from './ChildEntities';
import * as Vue from 'vue'
import EntityChainHelper from "../src/Helper/EntityChainHelper";
import MetadataHelper from "../src/Helper/MetadataHelper";
import ObjectHelper from '../src/Helper/ObjectHelper';

export default Vue.extend({
    template: require('./View/Entity.html'),
    data(){
        return {
            entity: new Entity({}, {}),
            children: {},
        }
    },
    components: {
        Navigator,
        ChildEntities,
    },
    props: {
        metadata: Object
    },
    route: {
        data () {
            let route = EntityChainHelper.createEntityApiRoute(this.$route);

            this.$http.get(route).then((response) => {
                this.metadata = MetadataHelper.getMetadataByChainingName(
                    this.$root.application.entitiesMetadata,
                    this.$route.params.chainingName
                );

                this.entity      = new Entity(response.data, this.metadata);
                this.children = this.entity.getChildEntities();
                this.$root.navigator.build(this.$route);
            }, (response) => {
                // error callback
            });
        }
    }
});