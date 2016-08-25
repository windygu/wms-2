import VForm from './Bootstrap/Form'
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'
import FormFactory from "../src/Form/FormFactory";
import Entity from "../src/Entity";

export default Vue.extend({
    template: require('./View/CreateEntity.html'),
    data(){
        return {
            form: FormFactory.createEntityForm(
                this.metadata
            ),
        }
    },
    components: {
        VForm,
        Navigator
    },
    props: {
        metadata: Object
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
            this.$root.navigator.build(this.$route);
        }
    }
});
