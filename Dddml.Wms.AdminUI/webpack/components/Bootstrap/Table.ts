import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/Table.html'),
    data(){
        return {}
    },
    props: {
        tableData: Object
    },
    components: {}
});