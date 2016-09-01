import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/Navigator.html'),
    data(){
        return {}
    },
    props: {
        navigator: {}
    }
});