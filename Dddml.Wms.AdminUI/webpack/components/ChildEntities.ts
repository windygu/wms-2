import * as Vue from 'vue'
import VTable from './Bootstrap/Table'
import ObjectHelper from "../src/Helper/ObjectHelper";
import EntityChainHelper from "../src/Helper/EntityChainHelper";

export default Vue.extend({
    template: require('./View/ChildEntities.html'),
    data(){
        return {
            current: {},
            selected: false,
            createRoute: {},
        }
    },
    components: {
        VTable,
    },
    props: {
        entities: Object,
        names: Array,
    },
    computed: {
        tables() {
            let children = [];

            for (let name in this.entities) {
                children[name] = this.entities[name].toTable(this.$route);
            }

            return children;
        }
    },
    methods: {
        change(key){
            this.selected = true;
            let chaining  = EntityChainHelper.chainingNameToArray(this.$route.params.chainingName);
            chaining.push({
                name: key,
            });

            this.current = this.tables[key];
        }
    },
    route: {
        data(){

        }
    }
});