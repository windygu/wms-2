import Navigator from '../src/Navigator/Navigator';
import * as Vue from 'vue'
import MetadataHelper from "../src/Helper/MetadataHelper";
import Application from "../src/Application";

var application = Application.getInstance();

export default Vue.extend({
    template: require('./View/App.html'),
    data(){
        return {
            application: application,
            currentEntity: {},
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
    ready(){
        this.currentEntity = MetadataHelper.getEntityByPlural(
            application.entitiesMetadata,
            this.$route.params.name
        );
    }
});