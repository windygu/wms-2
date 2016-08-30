import * as Vue from 'vue'
import VTable from './Bootstrap/Table'
import ObjectHelper from "../src/Helper/ObjectHelper";

export default Vue.extend({
    template: require('./View/ChildEntities.html'),
    data(){
        return {
            current: {}
        }
    },
    components: {
        VTable,
    },
    props: {
        entities: Array,
        names: Array,
    },
    computed: {
        hasSelected(){
            return ObjectHelper.isNotEmpty(this.current);
        }
    },
    methods: {
        changeEntity(key){
            this.current = this.entities[key];
        }
    },
});