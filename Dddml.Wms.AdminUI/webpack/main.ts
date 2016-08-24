import Application from './src/Application'
import AppComponent from './components/App'
import routes from './routes';

var app = new Application(
    routes,
    '/index_dev.php/api'
);

app.run(AppComponent, '#app');