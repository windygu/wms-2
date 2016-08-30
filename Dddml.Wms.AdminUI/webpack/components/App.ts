import Navigator from '../src/Navigator/Navigator';
import * as Vue from 'vue'
import MetadataHelper from "../src/Helper/MetadataHelper";
import Application from "../src/Application";
import EntityChainHelper from "../src/Helper/EntityChainHelper";

var application = Application.getInstance();

export default Vue.extend({
    template: require('./View/App.html'),
    data(){
        return {
            application: application,
            navigator: new Navigator(application)
        }
    },
    props: {
        userImg: String
    },
    methods: {
        changeEntity(entity){
            this.currentEntity = entity
        }
    },
});