import React from 'react';
import { HomePage } from './pages';
import { routeConstants } from './constants';

const routes = [
  {
    path: '/',
    exact: true,
    type: routeConstants.PUBLIC_ROUTE,
    component: HomePage,
  },
];

export default routes;
