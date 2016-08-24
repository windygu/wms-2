import Application from './src/Application'
import AppComponent from './components/App'
import appConfig from './config/application'
import aggregatesMetadata from './metadata/aggregates';
import valueObjectsMetadata from './metadata/valueObjects'

var app = new Application(
    aggregatesMetadata,
    valueObjectsMetadata,
    appConfig
);

app.run(AppComponent, '#app');