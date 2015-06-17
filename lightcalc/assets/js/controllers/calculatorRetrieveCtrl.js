angular.module('LightCalc').controller('calculatorRetrieveCtrl', ['Calculators', 'Operations', '$scope', '$routeParams', '$location', function(Calculators, Operations, $scope, $routeParams, $location){
/* Controller handles calculations and binding*/
    var calculators = Calculators.get({name: $routeParams.name});
    calculators.$promise.then(function(data){
        if(calculators.length > 0){
            $scope.calculator = calculators[0];
        } else {
            $location.path('/');
        }
    });
    // Bound to the output display
    
    $scope.output = "0";
    
    var newNumber = true;
   
    var partialNumber = "";
    var tokens = [];
    
    /*
    * Runs every time a number button is clicked.
    * Updates the output display and sets 
    * newNumber flag
    */
    
    var updateOutput = function(){
    	var i = 0;
    	$scope.output = "";
    	if(tokens.length > 0) {
	        if(tokens[0].type === 'operator'){
	        	i = 1;
	        	tokens[1].value = -Math.abs(tokens[1].value);
	        } 

	        for (; i < tokens.length; i++){
	        	$scope.output += tokens[i].value;
	        	if(i < tokens.length - 1 || partialNumber.length > 0){
	        		$scope.output += ' ';
	        	}
	        }
	    }

	    if(partialNumber.length > 0){
	    	$scope.output += partialNumber;
	    }
    }

    var doBinaryOperation = function(symbol){
    	newNumber = false;
    	if(partialNumber.length > 0){
    		tokens.push({type: 'number', value: parseFloat(partialNumber)});
    		partialNumber = '';
    	}
    	if(tokens.length === 0){
        	throw "Você tem que apertar algum dígito antes de realizar uma operação";
        } else if(tokens.length > 0){
        	if(tokens[tokens.length - 1].type === 'number'){
        		tokens.push({type: 'operator', value: symbol});
        	} else {
	        	tokens[tokens.length - 1].value = symbol;
	        }
	        updateOutput();
        }
    }

    var calculate = function() {
    	var i, j, noDivMultTokens = [], value = 0;

        if(tokens[0].type === 'operator'){
        	i = 1;
        	tokens[1].value = -Math.abs(tokens[1].value);
        } else {
        	i = 0;
        }

        j = i;

        for(;i < tokens.length; i++){
        	if(tokens[i].value === '÷'){
        		noDivMultTokens.pop();
        		if(tokens[i+1] !== 0){
        			noDivMultTokens.push({
	        			type:'number',
	        			value: (tokens[i-1].value / tokens[i+1].value)
	        		});
	        		i++;
        		} else {
					throw "Divisão por zero";
        		}
        	} else if(tokens[i].value === 'x'){
        		noDivMultTokens.pop();
        		noDivMultTokens.push({
        			type:'number',
        			value: (tokens[i-1].value * tokens[i+1].value)
        		});
        		i++;
        	} else {
        		noDivMultTokens.push(tokens[i]);
        	}
        }

        value = noDivMultTokens[j].value;

        for(; j < noDivMultTokens.length; j++){
        	if(noDivMultTokens[j].type === 'operator'){
	        	if(noDivMultTokens[j].value === '+'){
	        		value = value + noDivMultTokens[j+1].value;
	        	} else {
	        		value = value - noDivMultTokens[j+1].value;
	        	}
	        }
        }

        return value;
    };

    $scope.putDigit = function(btn) {
    	if(newNumber)
    		tokens = [];
        if((tokens.length === 0 && partialNumber.length === 0)|| newNumber) {
            if (btn === '.')
                partialNumber = '0.';
            else
                partialNumber = String(btn);
            newNumber = false;
        } else {
            if(partialNumber.length === 0 && btn === '.')
                partialNumber = '0.';
            else
                partialNumber += String(btn);
        }

        updateOutput();
    };

    $scope.add = function() {
        doBinaryOperation('+');
    };

    $scope.subtract = function() {
        if(tokens.length === 0 && partialNumber.length === 0){
        	$scope.putDigit('-');	
        } else {
        	doBinaryOperation('-');
        }
    };
    
    $scope.divide = function() {
        doBinaryOperation('÷');
    };

    $scope.multiply = function() {
        doBinaryOperation('x');
    };

    $scope.equals = function(){
    	if(partialNumber.length > 0){
    		tokens.push({type: 'number', value: parseFloat(partialNumber)});
    		partialNumber = '';
    	}

        var operation = Operations.save({
            calculator: $scope.calculator.id,
            text: $scope.output,
        });

    	operation.$promise.then(function(data){
    		tokens = [{type: 'number', value: calculate()}];
    		updateOutput();
    		newNumber = true;
            $scope.calculator.operations.push(data);
    	}).catch(function(){
    		tokens = [{type: 'number', value: calculate()}];
    		updateOutput();
    		newNumber = true;
    		throw "Não foi possível salvar a operação. Verifique sua conexão com a internet.";
    	});

        return operation;
    }

    $scope.loadOperation = function(operation){
        tokens = [];
        partialNumber = '';
        var operationTokens = operation.text.split(' ');

        for(var i in operationTokens){
            switch(operationTokens[i]){
                case '+':
                    tokens.push({type: 'operator', value: operationTokens[i]});
                    break;
                case '-':
                    tokens.push({type: 'operator', value: operationTokens[i]});
                    break;
                case 'x':
                    tokens.push({type: 'operator', value: operationTokens[i]});
                    break;
                case '÷':
                    tokens.push({type: 'operator', value: operationTokens[i]});
                    break;
                default:
                    tokens.push({type: 'number', value: parseFloat(operationTokens[i])});
            } 
        }

        updateOutput();
    }
    
    /* 
    * Initializes the appropriate values
    * when the clear button is clicked.
    */
    $scope.clear = function() {
        tokens = [];
        newNumber = true;
        $scope.output = "0"; 
    };
}]);