routes.$inject = ['$stateProvider'];

import template from './clientListing.html';

export default function routes($stateProvider) {
  $stateProvider
    .state('header.clientListing', {
      url: '/clientListing',
      views: {
        [`content@${'header'}`]: {
          template: template,
          controller: 'ClientListingController',
          controllerAs: 'clientListing'
        },
      },
    })
}