import Navigator from '../src/Navigator/Navigator';
import * as Vue from 'vue'
import aggregateMetadata from './../metadata/aggregates';
import MetadataHelper from "../src/Helper/MetadataHelper";
import Application from "../src/Application";

var application = Application.getInstance();

export default Vue.extend({
    template: require('./View/App.html'),
    data(){
        return {
            application: application,
            currentAggregate: {},
            navigator: new Navigator(application)
        }
    },
    props: {
        userImg: String
    },
    methods: {
        changeAggregate(aggregate){
            this.currentAggregate = aggregate
        }
    },
    ready(){
        this.currentAggregate = MetadataHelper.getAggregateByPlural(
            application.aggregatesMetadata,
            this.$route.params.name
        );
    }
});