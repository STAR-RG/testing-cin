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
		    	"operations": [],
		    	"name": "hugobessa",
			    "createdAt": "2015-06-12T05:19:54.810Z",
			    "updatedAt": "2015-06-12T05:19:54.810Z",
			    "id": 40
		  	}]);


		    httpBackend.when('POST', '/operation', {
		    	'text': '2 + 5 - 4 ÷ 2 x 7',
		    	'calculator': 40
		    }).respond({
		    	"id": 400,
		    	"text": '2 + 5 - 4 ÷ 2 x 7',
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

			scope.$apply()


		});
	});

	describe('Write on the keyboard', function(){
		it('should show operation 2 + 5 - 4/2 * 7 on the screen', function(){
			scope.putDigit(2);
			scope.add(2);
			scope.putDigit(5);
			scope.subtract();
			scope.putDigit(4);
			scope.divide();
			scope.putDigit(2);
			scope.multiply();
			scope.putDigit(7);

			scope.output.should.equals('2 + 5 - 4 ÷ 2 x 7');
		});

		it('should show operation with decimal values 2 + 23.4 - 4.4/2.12 * 7.5 on the screen', function(){
			scope.putDigit(2);
			scope.add();
			scope.putDigit(2);
			scope.putDigit(3);
			scope.putDigit('.');
			scope.putDigit(4);
			scope.subtract();
			scope.putDigit(4);
			scope.putDigit('.');
			scope.putDigit(4);
			scope.divide();
			scope.putDigit(2);
			scope.putDigit('.');
			scope.putDigit(1);
			scope.putDigit(2);
			scope.multiply();
			scope.putDigit(7);
			scope.putDigit('.');
			scope.putDigit(5);

			scope.output.should.equals('2 + 23.4 - 4.4 ÷ 2.12 x 7.5');
		});

		it('should show operation with decimal values 2 + 23.4 - 4.4/2.12 * 7.5 on the screen and then, whene clear is called, show 0', function(){
			scope.putDigit(2);
			scope.add();
			scope.putDigit(2);
			scope.putDigit(3);
			scope.putDigit('.');
			scope.putDigit(4);
			scope.subtract();
			scope.putDigit(4);
			scope.putDigit('.');
			scope.putDigit(4);
			scope.divide();
			scope.putDigit(2);
			scope.putDigit('.');
			scope.putDigit(1);
			scope.putDigit(2);
			scope.multiply();
			scope.putDigit(7);
			scope.putDigit('.');
			scope.putDigit(5);

			scope.output.should.equals('2 + 23.4 - 4.4 ÷ 2.12 x 7.5');

			scope.clear();

			scope.output.should.equals('0');
		});
	});

	describe('create operation', function(){

		it('should calculate 2 + 5 - 4 / 2 * 7 and show the result, -7, on the screen', function(done){
			
			scope.putDigit(2);
			scope.add();
			scope.putDigit(5);
			scope.subtract();
			scope.putDigit(4);
			scope.divide();
			scope.putDigit(2);
			scope.multiply();
			scope.putDigit(7);

			var resp = scope.equals();
			scope.$apply();
			httpBackend.flush();

			resp.$promise.then(function(){
				scope.output.should.equals('-7');
				done();
			});

			scope.$apply();

		});

		it('should calculate 2 + 23.4 - 4.4/2.12 * 7.5 and show the result, 9.499999999999998, on the screen', function(done){
			
			scope.putDigit(2);
			scope.add();
			scope.putDigit(2);
			scope.putDigit(3);
			scope.putDigit('.');
			scope.putDigit(4);
			scope.subtract();
			scope.putDigit(4);
			scope.putDigit('.');
			scope.putDigit(4);
			scope.divide();
			scope.putDigit(2);
			scope.putDigit('.');
			scope.putDigit(1);
			scope.putDigit(2);
			scope.multiply();
			scope.putDigit(7);
			scope.putDigit('.');
			scope.putDigit(5);


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
})