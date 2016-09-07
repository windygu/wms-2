import * as Vue from 'vue'
import TreeNode from './TreeNode.component'

export default Vue.extend({
    template: require('./View/Tree.html'),
    data(){
        return {
            selectedNode: {},
        }
    },
    props: {
        nodes: Array,
    },
    computed: {
        container(){
            return this.$parent;
        },
        tree(){
            return this;
        }
    },
    components: {
        TreeNode
    },
    methods: {}
});