import * as Vue from 'vue'
import * as VueRouter from 'vue-router'
import defaultFilter from './Filter/defaultFilter';
import routes from '../routes';
import config from './../config/application'
import * as VueResource from 'vue-resource'
import FormFactory from "./Form/FormFactory";

export default class Application {
    protected static instance: Application;

    routesConfig;
    config;

    constructor(
                config,
                routesConfig) {
        this.routesConfig = routesConfig;
        this.config       = config;

        this.initVue();

        this.initForm();
    }

    private initVue() {
        Vue.filter('default', defaultFilter);

        Vue.use(VueResource);
        Vue.http.options.root = this.config['appClient.baseUrl'];

        Vue.use(VueRouter);
    }

    private initForm() {
        FormFactory.application = this;
    }

    public run(component, selector: string, debug: boolean = false) {
        Vue.config.debug = debug;

        var router = new VueRouter();

        router.map(this.routesConfig);
        router.start(component, selector);
    }

    static getInstance(): Application {
        if (!Application.instance) {
            Application.instance = new Application(
                config,
                routes
            )
        }

        return Application.instance;
    }
}