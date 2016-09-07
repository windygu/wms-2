import * as Vue from 'vue'
import TreeNode from './TreeNode.component'

export default Vue.extend({
    template: require('./View/Tree.html'),
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