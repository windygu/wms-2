import Application from './src/Application'
import App from './vue/App'

var app = Application.getInstance();

app.run(App, '#app', true);