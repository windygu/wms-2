import * as VueResource from 'vue-resource'

export default class ApiClient {
    constructor(vue, baseUrl) {
        vue.use(VueResource);
        vue.http.options.root = baseUrl;
    }
}