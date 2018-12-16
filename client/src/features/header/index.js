import './header.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './header.routes';
import HeaderController from './header.controller';

export default angular.module('app.header', [uirouter])
  .config(routing)
  .controller('HeaderController', HeaderController)
  .name;