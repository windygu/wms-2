import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/Index.html'),
    data(){
        return {}
    },
    route: {
        data(){
            this.$root.navigator.reset();
        }
    },
    components: {
        Navigator
    },
});