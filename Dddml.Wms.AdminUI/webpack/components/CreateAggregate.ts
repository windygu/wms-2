import VForm from './Bootstrap/Form'
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'
import FormFactory from "../src/Form/FormFactory";

export default Vue.extend({
    template: require('./View/CreateAggregate.html'),
    data(){
        return {
            form: FormFactory.createAggregateForm(
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
            let jsonData = form.toJson();

            this.$http.put(this.$route.params.name + '/' + form.idElement.value, jsonData).then((response) => {
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
