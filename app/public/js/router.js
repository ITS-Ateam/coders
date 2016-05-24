angular.module('ateam')
    .config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('landing', {
                url: '/landing',
                templateUrl: '/templates/landing.html',
                controller: 'landingCtrl'
            })
            .state('home', {
                url: '/home',
                templateUrl: '/templates/home.html',
                controller: 'homeCtrl'
            })
            .state('about', {
              url: '/about',
              templateUrl: '/templates/about.html'
            });

        $urlRouterProvider.otherwise('/landing');
  }]);
