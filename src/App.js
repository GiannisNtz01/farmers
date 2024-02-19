// App.js
import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Dashboard from './components/Dashboard';
import CreateCompensation from './components/CreateCompensation';
import EditCompensation from './components/EditCompensation';
import CompensationDetails from './components/CompensationDetails';

function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/dashboard" component={Dashboard} />
          <Route path="/compensations/new" component={CreateCompensation} />
          <Route path="/compensations/:id/edit" component={EditCompensation} />
          <Route path="/compensations/:id" component={CompensationDetails} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
