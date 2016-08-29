import VTable from './Bootstrap/Table'
import Entity from '../src/Entity';
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'
import RouteHelper from "../src/Helper/RouteHelper";
import MetadataHelper from "../src/Helper/MetadataHelper";
import ObjectHelper from '../src/Helper/ObjectHelper';

export default Vue.extend({
    template: require('./View/Entity.html'),
    data(){
        return {
            entity: new Entity({}, {}),
            children: {},
            currentChild: {}
        }
    },
    components: {
        VTable,
        Navigator
    },
    props: {
        metadata: Object
    },
    computed: {
        hasCurrentChild(){
            return ObjectHelper.isNotEmpty(this.currentChild);
        }
    },
    methods: {
        changeChild(key){
            this.currentChild = this.children[key];
        }
    },
    route: {
        data: function (transition) {
            let route = RouteHelper.createEntityApiRoute(this.$route);

            this.$http.get(route).then((response) => {
                this.metadata = MetadataHelper.getMetadataByChainingName(
                    this.$root.application.entitiesMetadata,
                    this.$route.params.chainingName
                );

                this.entity      = new Entity(response.data, this.metadata);
                let entitiesList = this.entity.getChildEntities();
                let children     = [];

                for (let name in entitiesList) {
                    children[name] = entitiesList[name].toTable(this.$route);
                }

                this.children = children;
                this.$root.navigator.build(this.$route);
                transition.next();
            }, (response) => {
                // error callback
            });
        }
    }
});