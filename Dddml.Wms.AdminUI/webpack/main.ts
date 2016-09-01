import Application from './src/Application'
import AppComponent from './components/App.component'

var app = Application.getInstance();

app.run(AppComponent, '#app', true);