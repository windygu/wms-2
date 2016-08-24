import * as Vue from 'vue'
import * as VueRouter from 'vue-router'
import ApiClient from "./ApiClient";
import defaultFilter from './Filter/defaultFilter';
import routes from '../routes';

export default class Application {
    vue;
    router;
    apiClient: ApiClient;
    config;

    constructor(config) {
        this.config = config;

        this.initVue();
    }

    private initVue() {
        this.vue = Vue;
        this.vue.filter('default', defaultFilter);

        this.apiClient = new ApiClient(this.vue, this.config['appClient.baseUrl']);

        this.vue.use(VueRouter);
        this.router = new VueRouter();

        this.router.map(routes);
    }

    run(component, selector: string) {
        this.router.start(component, selector);
    }
}