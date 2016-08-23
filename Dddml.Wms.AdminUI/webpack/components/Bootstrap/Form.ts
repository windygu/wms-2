import FormElement from './FormElement';
import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/Form.html'),
    data(){
        return {}
    },
    components: {
        FormElement
    },
    props: {
        form: Object
    },
    methods: {
        submit: function () {
            this.$dispatch('submit', this.form);
        }
    }
});