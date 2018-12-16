routes.$inject = ['$stateProvider'];

import template from './home.html';

export default function routes($stateProvider) {
    $stateProvider
        .state('header.home', {
            url: '/home',
            views: {
                [`content@${'header'}`]: {
                    template: template,
                    controller: 'HomeController',
                    controllerAs: 'home'
                },
            },
        })
}