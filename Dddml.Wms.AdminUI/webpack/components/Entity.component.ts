import Entity from '../src/Entity';
import Navigator from './Bootstrap/Navigator.component';
import SubEntities from './Bootstrap/SubEntities.component';
import * as Vue from 'vue'
import EntityChainHelper from "../src/Helper/EntityChainHelper";
import MetadataHelper from "../src/Helper/MetadataHelper";

export default Vue.extend({
    template: require('./View/Entity.html'),
    data(){
        return {
            entity: {},
            children: {},
            metadata: null,
        }
    },
    components: {
        Navigator,
        SubEntities,
    },
    computed: {
        title(){
            if (this.metadata) {
                return this.metadata.label;
            }
        },
        idName(){
            if (this.metadata) {
                return this.metadata.id.name;
            }
        },
        idData(){
            if (this.entity.data) {
                return this.entity.data[this.metadata.id.name]
            }
        },
        fields(){
            if (this.entity.getFields) {
                return this.entity.getFields();
            } else {
                return [];
            }
        },
        entityNames(){
            if (this.entity.getChildEntityNames) {
                return this.entity.getChildEntityNames();
            } else {
                return [];
            }
        }
    },
    route: {
        data () {
            let route = EntityChainHelper.createGetEntityApiRoute(this.$route);

            this.$http.get(route).then((response) => {
                this.metadata = MetadataHelper.getMetadataByChainingName(
                    this.$root.application.entitiesMetadata,
                    this.$route.params.chainingName
                );

                this.entity   = new Entity(response.data, this.metadata);
                this.children = this.entity.getChildEntities();
                this.$root.navigator.buildEntity(this.$route);
            }, (response) => {
                // error callback
            });
        }
    }
});