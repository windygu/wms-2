import VForm from './Bootstrap/Form.component'
import Navigator from './Bootstrap/Navigator.component';
import * as Vue from 'vue'
import FormFactory from "../src/Form/FormFactory";
import Entity from "../src/Entity";
import EntityChainHelper from "../src/Helper/EntityChainHelper";
import MetadataHelper from "../src/Helper/MetadataHelper";
import MergePatchEntity from "../src/MergePatchEntity";
import StringHelper from "../src/Helper/StringHelper";

export default Vue.extend({
    template: require('./View/MergePatchEntity.html'),
    data(){
        return {
            rootEntity: {},
            postEntity: {},
            form: {},
            metadata: null,
            name: '',
        }
    },
    components: {
        VForm,
        Navigator
    },
    computed: {
        title(){
            if (this.metadata) {
                return this.metadata.label;
            }
        }
    },
    events: {
        submit(form){
            let entity = new Entity(this.postEntity, MetadataHelper.getEntityByPlural(
                this.$root.application.entitiesMetadata, this.name
            ));

            this.$http.patch(this.name + '/' + entity.getStringId(), this.postEntity).then((response) => {
                console.log(response.data);
            }, (response) => {
                // error callback
            });
        }
    },
    route: {
        data(){
            let route = EntityChainHelper.createGetEntityApiRoute(this.$route, true);

            this.$http.get(route).then((response) => {
                this.rootEntity = response.data;

                let chain = EntityChainHelper.chainingNameToArray(this.$route.params.chainingName);
                chain.pop();

                let metadata                 = this.$root.application.entitiesMetadata;
                let entity: MergePatchEntity = null;
                let data                     = this.rootEntity;

                this.name = MetadataHelper.getEntityByPlural(metadata, chain[0].name).plural;

                for (let item of chain) {
                    metadata = MetadataHelper.getEntityByPlural(metadata, item.name);

                    if (entity) {
                        for (let e of data[_.lowerFirst(item.name)]) {
                            if (e[metadata.id.name] == item.id) {
                                data = e;
                                break;
                            }
                        }
                    }

                    entity = new MergePatchEntity(metadata.plural, entity);
                    entity.setProperty(metadata.id.name, data[metadata.id.name]);
                    if (!entity.parent) {
                        entity.setProperty('version', data.version);
                    }

                    metadata = metadata.entities;
                }

                this.metadata = MetadataHelper.getMetadataByChainingName(
                    this.$root.application.entitiesMetadata,
                    this.$route.params.chainingName
                );

                this.postEntity = entity.getRoot().data;

                entity.data[StringHelper.lcfirst(this.metadata.plural)] = [{
                    'commandType': 'Create',
                }];

                this.form = FormFactory.createEntityForm(
                    this.metadata,
                    entity.data[StringHelper.lcfirst(this.metadata.plural)][0]
                );

                this.$root.navigator.buildMergePatchEntity(this.$route);
            }, (response) => {
                // error callback
            });
        }
    }
});
