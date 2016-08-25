import Application from './src/Application'
import AppComponent from './components/App'

var app = Application.getInstance();

app.run(AppComponent, '#app');