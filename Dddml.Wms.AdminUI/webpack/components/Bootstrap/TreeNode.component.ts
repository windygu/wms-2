import * as Vue from 'vue'
import TreeNodeComponent from './TreeNode.component'
import TreeNode from '../../src/Tree/TreeNode'

export default Vue.extend({
    name: 'tree-node',
    template: require('./View/TreeNode.html'),
    data(){
        return {}
    },
    props: {
        node: Object
    },
    components: {
        'tree-node': TreeNodeComponent,
    },
    computed: {
        container(){
            return this.$parent.container;
        },
        tree(){
            return this.$parent.tree;
        }
    },
    methods: {
        updateChildren(node: TreeNode){
            if (_.isEmpty(node.children)) {
                this.$http.get(this.$route.params.name + '?parentId=' + node.id).then((response) => {
                    node.setChildren(_.map(response.data, (entity: any)=> {
                        let node   = new TreeNode();
                        node.title = entity.locatorId;
                        node.id    = entity.locatorId;
                        node.data  = entity;

                        return node;
                    }));
                }, (response) => {
                    // error callback
                });
            }

            node.folded = !node.folded;
        },
        onSelected(node: TreeNode){
            if (!_.isEmpty(this.tree.selectedNode)) {
                this.tree.selectedNode.selected = false;
            }

            node.selected = true;

            this.tree.selectedNode = node;

            this.container.updateDetail(node.data);
        },
    }
});