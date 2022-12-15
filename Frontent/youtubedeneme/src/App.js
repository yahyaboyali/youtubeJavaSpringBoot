import './App.css';
import Dashboard from './layouts/Dashboard';
import NavigationBar from './layouts/NavigationBar';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  return (
    <div className="App">
        <NavigationBar />
        <Dashboard/>
    </div>
  );
}

export default App;
