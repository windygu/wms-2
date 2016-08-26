import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/Alert.html'),
    data(){
        return {}
    },
    props: {
        show: false,
        type: 'alert-danger',
        title: '',
        content: '',
    }
});