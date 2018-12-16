import 'bootstrap/dist/css/bootstrap.css';
import './app.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './app.config';
import header from './features/header';
import home from './features/home';
import clientListing from './features/clientListing';

angular.module('app', [uirouter, header, home, clientListing])
  .config(routing);
