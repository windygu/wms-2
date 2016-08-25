import VTable from './Bootstrap/Table'
import Aggregate from '../src/Aggregate';
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/Aggregate.html'),
    data(){
        return {
            aggregate: new Aggregate({}, {}),
            children: {},
            currentChild: {}
        }
    },
    components: {
        VTable,
        Navigator
    },
    props: {
        metadata: Object
    },
    methods: {
        changeChild(key){
            this.currentChild = this.children[key];
        }
    },
    route: {
        data(){
            this.$http.get(this.$route.params.name + '/' + this.$route.params.id).then((response) => {
                this.aggregate = new Aggregate(response.data, this.metadata);
                let aggregates = this.aggregate.getChildAggregates();
                let children = [];

                for (let name in aggregates) {
                    children[name] = aggregates[name].toTable();
                }

                this.children = children;
            }, (response) => {
                // error callback
            });

            this.$root.navigator.build(this.$route);
        }
    }
});