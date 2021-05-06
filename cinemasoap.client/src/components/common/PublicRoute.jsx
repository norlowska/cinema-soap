import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import PropTypes from 'prop-types';

const PublicRoute = ({ component: Component, isAuthenticated, restricted, ...rest }) => {
  return (
    <Route
      {...rest}
      render={props =>
        isAuthenticated && restricted ? <Redirect to='/' /> : <Component {...props} />
      }
    />
  );
};

PublicRoute.propTypes = {
  component: PropTypes.elementType.isRequired,
  // isAuthenticated: PropTypes.bool.isRequired,
  restricted: PropTypes.bool,
};

export default PublicRoute;
