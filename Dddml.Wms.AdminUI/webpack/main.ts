import * as Vue from 'vue'
import App from './components/App'
import * as VueRouter from 'vue-router'
import * as VueResource from 'vue-resource'
import routes from './routes';

Vue.filter('default', function (value, defaultValue) {
    if (!value) {
        return defaultValue;
    }

    return value;
});

Vue.use(VueResource);
Vue.http.options.root = '/index_dev.php/api';

Vue.use(VueRouter);
var router = new VueRouter();

router.map(routes);

router.start(App, '#app');