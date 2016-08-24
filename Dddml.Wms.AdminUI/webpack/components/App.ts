import Navigator from '../src/Navigator/Navigator';
import Metadata from "Metadata.ts";
import * as Vue from 'vue'
import data from './../metadata/aggregates';

let metadata = new Metadata(data);

export default Vue.extend({
    template: require('./View/App.html'),
    data(){
        return {
            metadata: metadata,
            current: {},
            navigator: new Navigator(metadata)
        }
    },
    props: {
        userImg: String
    },
    methods: {
        changeAggregate(aggregate){
            this.current = aggregate
        }
    },
    ready(){
        this.current = this.metadata.getAggregateByPlural(
            this.$route.params.name
        );
    }
});