import VTable from './Bootstrap/Table';
import EntityCollection from '../src/EntityCollection';
import Navigator from './Bootstrap/Navigator';
import Alert from './Bootstrap/Alert';
import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/AggregateRoot.html'),
    data(){
        return {
            table: {},
            showError: false,
            errorMessage: ""
        }
    },
    components: {
        VTable,
        Navigator,
        Alert
    },
    props: {
        metadata: Object
    },
    route: {
        data() {
            this.$http.get(this.metadata.plural).then((response) => {
                let entityCollection = new EntityCollection(
                    response.data,
                    this.metadata
                );

                this.table = entityCollection.toTable();
            }, (response) => {
                this.showError    = true;
                this.errorMessage = response.statusText;
            });

            this.$root.navigator.build(this.$route);
        }
    }
});