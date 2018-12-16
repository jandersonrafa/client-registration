import './clientListing.css';

import angular from 'angular';
import uirouter from 'angular-ui-router';

import routing from './clientListing.routes';
import ClientListingController from './clientListing.controller';
import greeting    from '../../directives/greeting.directive';

export default angular.module('app.clientListing', [uirouter, greeting])
  .config(routing)
  .controller('ClientListingController', ClientListingController)
  .name;