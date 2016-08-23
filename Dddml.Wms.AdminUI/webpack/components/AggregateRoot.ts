import VTable from './Bootstrap/Table';
import AggregateCollection from '../src/AggregateCollection';
import Navigator from './Bootstrap/Navigator';
import * as Vue from 'vue'

export default Vue.extend({
    template: require('./View/AggregateRoot.html'),
    data(){
        return {
            table: {},
        }
    },
    components: {
        VTable,
        Navigator
    },
    props: {
        metadata: Object
    },
    route: {
        data() {
            this.$http.get(this.metadata.plural).then((response) => {
                let aggregateCollection = new AggregateCollection(
                    response.data,
                    this.metadata
                );

                this.table = aggregateCollection.toTable();
            }, (response) => {
                // error callback
            });

            this.$root.navigator.build(this.$route);
        }
    }
});