angular.module('LightCalc').factory('Operations', ['$resource', function OperationsFactory($resource){
	return $resource('/operation/:slug/');
}]);