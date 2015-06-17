angular.module('LightCalc').factory('Calculators', ['$resource', function CalculatorsFactory($resource){
	return $resource('/calculator/:slug/',{},{
		get: {
			isArray: true
		}
	});
}]);