import VTable from './Bootstrap/Table';
import EntityCollection from '../src/EntityCollection';
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
                let entityCollection = new EntityCollection(
                    response.data,
                    this.metadata
                );

                this.table = entityCollection.toTable();
            }, (response) => {
                // error callback
            });

            this.$root.navigator.build(this.$route);
        }
    }
});