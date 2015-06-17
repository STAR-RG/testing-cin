angular.module('LightCalc').controller('calculatorCreateCtrl', ['Calculators', '$scope', '$location', function(Calculators, $scope, $location){

	$scope.calculatorForm = {name: ''};

	$scope.submitForm = function(){
		$scope.$broadcast('show-errors-check-validity');

		if ($scope.form.$valid) {
			var calculator = Calculators.save($scope.calculatorForm);
			calculator.$promise.then(function(data){
				$location.path('/'+data.name);
			});

			return calculator;
		}
	}

}]);
