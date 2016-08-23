import VForm from './Bootstrap/Form'
import FormCls from '../src/Form/Form';
import Navigator from './Bootstrap/Navigator';
import formConfig from '../config/view/forms';
import * as Vue from 'vue'

export default{
    template: require('./View/CreateEntity.html'),
    data(){
        return {
            form: FormCls.createForm(this.metadata, formConfig[this.metadata.name])
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
}