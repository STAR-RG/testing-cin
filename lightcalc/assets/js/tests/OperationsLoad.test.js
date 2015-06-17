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

		  	httpBackend.when('POST', '/operation', {
		    	'text': '2 + 23.4 - 4.4 ÷ 2.12 x 7.5',
		    	'calculator': 40
		    }).respond({
		    	"id": 400,
		    	"text": '2 + 23.4 - 4.4 ÷ 2.12 x 7.5',
		    	"calculator": {
			    	"operations": [400],
			    	"name": "hugobessa",
				    "createdAt": "2015-06-10T05:19:54.810Z",
				    "updatedAt": "2015-06-10T05:19:54.810Z",
				    "id": 40
			  	},
			    "createdAt": "2015-06-12T05:19:54.810Z",
			    "updatedAt": "2015-06-12T05:19:54.810Z",
		  	});

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

	describe('Load operation', function(){
		it('should show operation 2 + 23.4 - 4.4 ÷ 2.12 x 7.5 on the screen', function(){
			scope.loadOperation(scope.calculator.operations[0]);

			scope.output.should.equals('2 + 23.4 - 4.4 ÷ 2.12 x 7.5');
		});

		it('should show operation 2 + 23.4 - 4.4 ÷ 2.12 x 7.5 result, 9.499999999999998, on the screen', function(done){
			scope.loadOperation(scope.calculator.operations[0]);

			scope.output.should.equals('2 + 23.4 - 4.4 ÷ 2.12 x 7.5');

			var resp = scope.equals();
			scope.$apply();
			httpBackend.flush();

			resp.$promise.then(function(){
				scope.output.should.equals('9.499999999999998');
				done();
			});

			scope.$apply();
		});
	});
});