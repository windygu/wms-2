import VTable from './Bootstrap/Table'
import Entity from '../src/Entity';
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'

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
    methods: {
        changeChild(key){
            this.currentChild = this.children[key];
        }
    },
    route: {
        data(){
            this.$http.get(this.$route.params.name + '/' + this.$route.params.id).then((response) => {
                this.entity = new Entity(response.data, this.metadata);
                let entitiesList = this.entity.getChildEntities();
                let children = [];

                for (let name in entitiesList) {
                    children[name] = entitiesList[name].toTable();
                }

                this.children = children;
            }, (response) => {
                // error callback
            });

            this.$root.navigator.build(this.$route);
        }
    }
});