import Application from './src/Application'
import AppComponent from './components/App'
import config from './config/application'

var app = new Application(config);

app.run(AppComponent, '#app');