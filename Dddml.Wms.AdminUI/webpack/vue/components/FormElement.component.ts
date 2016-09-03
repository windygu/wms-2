import * as Vue from 'vue'

export default Vue.extend({
    template: require('./views/FormElement.html'),
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