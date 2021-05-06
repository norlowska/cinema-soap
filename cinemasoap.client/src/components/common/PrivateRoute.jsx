import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import PropTypes from 'prop-types';

const PrivateRoute = ({ component: Component, isAuthenticated, ...rest }) => {
  return isAuthenticated ? (
    <Route {...rest} render={props => <Component {...props} />} />
  ) : (
    <Redirect to='/login' />
  );
};

PrivateRoute.propTypes = {
  component: PropTypes.elementType.isRequired,
  // isAuthenticated: PropTypes.bool.isRequired,
};

export default PrivateRoute;
