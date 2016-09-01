import VForm from './Bootstrap/Form.component'
import Navigator from './Bootstrap/Navigator.component';
import * as Vue from 'vue'
import FormFactory from "../src/Form/FormFactory";
import Entity from "../src/Entity";
import MetadataHelper from "../src/Helper/MetadataHelper";

export default Vue.extend({
    template: require('./View/CreateEntity.html'),
    data(){
        return {
            metadata: null,
            form: {},
        }
    },
    components: {
        VForm,
        Navigator
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
    computed: {
        title(){
            if (this.metadata) {
                return this.metadata.label;
            }
        }
    },
    route: {
        data(){
            this.metadata = MetadataHelper.getEntityByPlural(
                this.$root.application.entitiesMetadata,
                this.$route.params.name
            );

            this.form = FormFactory.createEntityForm(
                this.metadata
            );

            this.$root.navigator.buildCreateEntity(this.$route);
        }
    }
});
