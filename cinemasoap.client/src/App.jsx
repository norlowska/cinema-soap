import React from 'react';
import { Router, Switch, Redirect, Route, NavLink } from 'react-router-dom';
import { Layout, Menu } from 'antd';
import { routeConstants } from './constants';
import { PrivateRoute, PublicRoute } from './components';
import routes from './routes';
import history from './history';
import 'antd/dist/antd.css';
import './App.css';

const { Header, Content } = Layout;

function App() {
  return (
    <Router history={history}>
      <Layout className='app'>
        <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          <NavLink to='/'>
            <div className='logo'>CINEMA</div>
          </NavLink>
          <Menu theme='dark' mode='horizontal' className='menu'>
            <Menu.Item key='login'>Zaloguj</Menu.Item>
          </Menu>
        </Header>
        <Content className='page-container'>
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
        </Content>
      </Layout>
    </Router>
  );
}

export default App;