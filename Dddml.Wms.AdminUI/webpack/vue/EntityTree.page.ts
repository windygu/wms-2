import * as Vue from 'vue'
import Tree from './components/Tree.component'
import treeMetadata from '../metadata/trees';
import Navigator from './components/Navigator.component';
import TreeNode from "../src/Tree/TreeNode";
import * as _ from 'lodash';
import Entity from "../src/Entity";

export default Vue.extend({
    template: require('./views/EntityTree.html'),
    data(){
        return {
            nodes: [],
            selected: {},
            entityMetadata: null,
        }
    },
    props: {
        //tableData: Object
    },
    components: {
        Tree,
        Navigator
    },
    computed: {
        title(){
            return this.$route.params.name;
        },
        entityTitle(){
            if (this.entityMetadata) {
                return this.entityMetadata.label;
            }
        },
        idName(){
            if (this.entityMetadata) {
                return this.entityMetadata.id.name;
            }
        },
        idData(){
            if (this.selected.data) {
                return this.selected.data[this.entityMetadata.id.name]
            }
        },
        fields(){
            if (this.selected.getFields) {
                return this.selected.getFields();
            } else {
                return [];
            }
        },
    },
    methods: {
        updateDetail(entity){
            this.selected = new Entity(entity, this.entityMetadata);
        }
    },
    route: {
        data(){
            let entityType      = _.find(treeMetadata, {plural: this.$route.params.name}).nodeContentType;
            this.entityMetadata = _.find(this.$root.application.entitiesMetadata, {name: entityType});

            this.$http.get(this.$route.params.name).then((response) => {
                this.nodes = _.map(response.data, (entity: any)=> {
                    let node   = new TreeNode();
                    node.title = entity[this.entityMetadata.id.name];
                    node.id    = entity[this.entityMetadata.id.name];
                    node.data  = entity;

                    return node;
                });

                this.$root.navigator.buildTree(this.$route);
            }, (response) => {
                // error callback
            });
        }
    },
    ready(){
        this.$watch('$route.params.name', function () {
            this.selected = {};
        })
    }
});