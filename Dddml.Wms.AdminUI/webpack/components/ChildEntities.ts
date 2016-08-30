import * as Vue from 'vue'
import VTable from './Bootstrap/Table'
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

            let chaining = EntityChainHelper.chainingNameToArray(this.$route.params.chainingName);
            chaining.push({
                name: key,
            });

            this.createRoute = {
                name: 'mergePatchEntity',
                params: {
                    chainingName: EntityChainHelper.arrayToChainingName(chaining),
                }
            };

            this.current = this.tables[key];
        }
    },
});