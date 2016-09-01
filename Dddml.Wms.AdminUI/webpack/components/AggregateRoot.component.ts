import VTable from './Bootstrap/Table';
import EntityCollection from '../src/EntityCollection';
import Navigator from './Bootstrap/Navigator.component';
import Alert from './Bootstrap/Alert.component';
import * as Vue from 'vue'
import MetadataHelper from "../src/Helper/MetadataHelper";

export default Vue.extend({
    template: require('./View/AggregateRoot.html'),
    data(){
        return {
            table: {},
            showError: false,
            errorMessage: "",
            metadata: null,
        }
    },
    components: {
        VTable,
        Navigator,
        Alert
    },
    computed:{
        title(){
            if(this.metadata){
                return this.metadata.collectionLabel;
            }
        }
    },
    route: {
        data() {
            this.$http.get(this.$route.params.name).then((response) => {
                this.metadata = MetadataHelper.getEntityByPlural(
                    this.$root.application.entitiesMetadata,
                    this.$route.params.name
                );

                let entityCollection = new EntityCollection(
                    response.data,
                    this.metadata
                );

                this.table = entityCollection.toTable();
            }, (response) => {
                this.showError    = true;
                this.errorMessage = response.statusText;
            });

            this.$root.navigator.buildEntities(this.$route);
        }
    }
});