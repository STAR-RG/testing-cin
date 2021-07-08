describe('calculatorRetrieveCtrl', function(){
	var scope, location, httpBackend;

	beforeEach(function(){
		module('LightCalc');
		module('MyTemplates');
	});

	beforeEach(function(done){
		inject(function($rootScope, $controller, $location, $httpBackend){
			scope = $rootScope.$new();
			location = $location;
			location.path('/hugobessa');

			$controller('calculatorRetrieveCtrl', {
		        "$scope": scope,
		        "$location": location,
		        "$routeParams": {name: 'hugobessa'}
		    });

		    httpBackend = $httpBackend;
		    httpBackend.when('GET', '/calculator?name=hugobessa').respond([{
		    	"operations": [
			    	{
				    	"id": 400,
				    	"text": '2 + 23.4 - 4.4 ÷ 2.12 x 7.5',
				    	"calculator": 40,
					    "createdAt": "2015-06-12T05:19:54.810Z",
					    "updatedAt": "2015-06-12T05:19:54.810Z",
				  	},

			    	{
				    	"id": 401,
				    	"text": '2 + 5 - 4 ÷ 2 x 7',
				    	"calculator": 40,
					    "createdAt": "2015-06-12T05:19:54.810Z",
					    "updatedAt": "2015-06-12T05:19:54.810Z",
				  	},
		    	],
		    	"name": "hugobessa",
			    "createdAt": "2015-06-12T05:19:54.810Z",
			    "updatedAt": "2015-06-12T05:19:54.810Z",
			    "id": 40
		  	}]);

		  	scope.$apply();
		  	httpBackend.flush();

		  	scope.$watch(function(){
		  		return scope.calculator;
		  	}, function(nv, ov){
				if(nv !== undefined){
					done();
				}
			});

			scope.$apply();
		});
	});

	describe('Check list of operations', function(){
		it('should show operations 2 + 23.4 - 4.4 ÷ 2.12 x 7.5 and 2 + 5 - 4/2 * 7 on the operations list', function(){
			scope.calculator.operations[0].text.should.equals('2 + 23.4 - 4.4 ÷ 2.12 x 7.5');
			scope.calculator.operations[1].text.should.equals('2 + 5 - 4 ÷ 2 x 7');
		});
	});
});