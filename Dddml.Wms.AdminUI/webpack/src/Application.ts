import * as Vue from 'vue'
import * as VueRouter from 'vue-router'
import ApiClient from "./ApiClient";
import defaultFilter from './Filter/defaultFilter';

export default class Application {
    vue;
    router;
    apiClient: ApiClient;

    constructor(routes, baseUrl: string) {
        this.vue = Vue;
        this.vue.filter('default', defaultFilter);

        this.apiClient = new ApiClient(this.vue, baseUrl);

        this.vue.use(VueRouter);
        this.router = new VueRouter();

        this.router.map(routes);
    }

    run(component, selector: string) {
        this.router.start(component, selector);
    }
}