routes.$inject = ['$stateProvider'];

import template from './header.html';

export default function routes($stateProvider) {
  $stateProvider
    .state('header', {
      abstract: true ,
      url: '',
      template: template,
      controller: 'HeaderController',
      controllerAs: 'header'
    })
}