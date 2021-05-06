import React from 'react';
import { Router, Switch, Redirect, Route } from 'react-router-dom';
import { routeConstants } from './constants';
import { PrivateRoute, PublicRoute } from './components';
import routes from './routes';
import history from './history';
import './App.css';

function App() {
  return (
    <Router history={history}>
      <Switch>
        {routes.map(route => {
          switch (route.type) {
            case routeConstants.PRIVATE_ROUTE:
              return (
                <PrivateRoute
                  key={route.path}
                  exact={route.exact}
                  path={route.path}
                  component={route.component}
                />
              );
            case routeConstants.PUBLIC_ROUTE:
              return (
                <PublicRoute
                  key={route.path}
                  exact={route.exact}
                  path={route.path}
                  component={route.component}
                />
              );
            case routeConstants.RESTRICTED_ROUTE:
              return (
                <PublicRoute
                  key={route.path}
                  restricted
                  exact={route.exact}
                  path={route.path}
                  component={route.component}
                />
              );
            default:
              return <Route key={route.path} path={route.path} component={route.component} />;
          }
        })}
        <Redirect from='*' to='/404' />
      </Switch>
    </Router>
  );
}

export default App;
