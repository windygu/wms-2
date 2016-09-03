import * as Vue from 'vue'

export default Vue.extend({
    template: require('./views/Table.html'),
    data(){
        return {}
    },
    props: {
        tableData: Object
    },
    components: {}
});