angular.module('LightCalc').directive('isNameFree', ['Calculators', '$q', '$timeout',function(Calculators, $q, $timeout) {
  return {
    require: 'ngModel',
    link: function(scope, elm, attrs, ctrl) {

      ctrl.$asyncValidators.isNameFree = function(modelValue, viewValue) {

        if (ctrl.$isEmpty(modelValue)) {
          // consider empty model valid
          return $q.when();
        }

        var def = $q.defer();

        var calculators = Calculators.get({name: modelValue});
        calculators.$promise.then(function(){
          if (calculators.length === 0) {
            // The username is available
            def.resolve();
          } else {
            def.reject();
          }
        })


        return def.promise;
      };
    }
  };
}]);