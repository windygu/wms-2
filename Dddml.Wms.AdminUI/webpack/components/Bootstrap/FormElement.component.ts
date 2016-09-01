import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/FormElement.html'),
    data(){
        return {}
    },
    components: {},
    props: {
        element: {
            type: Object,
            twoWay: true
        }
    }
});