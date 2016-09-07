import * as Vue from 'vue'
import TreeNode from './TreeNode.component'

export default Vue.extend({
    template: require('./View/TreeNode.html'),
    data(){
        return {}
    },
    props: {
        //tableData: Object
    },
    components: {
        TreeNode
    }
});