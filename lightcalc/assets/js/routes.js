angular.module('LightCalc').config(['$routeProvider', function($routeProvider){
	$routeProvider
		.when('/', {
			templateUrl: 'templates/calculator/create.html',
			controller: 'calculatorCreateCtrl'
		})
		.when('/:name/', {
			templateUrl: '/templates/calculator/retrieve.html',
			controller: 'calculatorRetrieveCtrl'
		})
		.otherwise({redirectTo: '/'});
}]);