import VForm from './Bootstrap/Form'
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'
import FormFactory from "../src/Form/FormFactory";
import Entity from "../src/Entity";
import EntityChainHelper from "../src/Helper/EntityChainHelper";
import MetadataHelper from "../src/Helper/MetadataHelper";

export default Vue.extend({
    template: require('./View/MergePatchEntity.html'),
    data(){
        return {
            rootEntity: {},
            form: {},
            metadata: null,
        }
    },
    components: {
        VForm,
        Navigator
    },
    computed: {
        title(){
            if (this.metadata) {
                return this.metadata.label;
            }
        }
    },
    events: {
        submit(form){
            let jsonData = form.data;

            let entity = new Entity(form.data, form.metadata);

            this.$http.put(this.$route.params.name + '/' + entity.getStringId(), jsonData).then((response) => {
                console.log(response.data);
            }, (response) => {
                // error callback
            });
        }
    },
    route: {
        data(){
            let route = EntityChainHelper.createGetEntityApiRoute(this.$route, true);

            this.$http.get(route).then((response) => {
                this.rootEntity = response.data;

                this.metadata = MetadataHelper.getMetadataByChainingName(
                    this.$root.application.entitiesMetadata,
                    this.$route.params.chainingName
                );

                this.form = FormFactory.createEntityForm(
                    this.metadata
                );

                this.$root.navigator.buildMergePatchEntity(this.$route);
            }, (response) => {
                // error callback
            });
        }
    }
});
