describe('calculatorCreateCtrl', function(){
	var scope, location, httpBackend;

	beforeEach(function(){
		module('LightCalc');
		module('MyTemplates');
	});

	beforeEach(inject(function($rootScope, $controller, $location, $httpBackend){
		scope = $rootScope.$new();
		location = $location;
		location.path('/');

	    $controller('calculatorCreateCtrl', {
	        "$scope": scope
	    });
	    httpBackend = $httpBackend;
	    httpBackend.when('POST', '/calculator').respond(201, {
	    	"operations": [],
	    	"name": "teste123123",
		    "createdAt": "2015-06-12T05:19:54.810Z",
		    "updatedAt": "2015-06-12T05:19:54.810Z",
		    "id": 40
	  	});

	  	//httpBackend.when('GET', '/calculator').respond([]);
	  	httpBackend.when('GET', '/calculator?name=').respond(200, []);
	  	httpBackend.when('GET', '/calculator?name=teste123123').respond(200, []);
	  	httpBackend.when('GET', '/calculator?name=teste').respond(200, []);
	  	httpBackend.when('GET', '/calculator?name=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa').respond(200, []);
	  	httpBackend.when('GET', '/calculator?name=hugobessa').respond([{
	    	"operations": [],
	    	"name": "hugobessa",
		    "createdAt": "2015-06-12T05:19:54.810Z",
		    "updatedAt": "2015-06-12T05:19:54.810Z",
		    "id": 40
	  	}]);
	  	httpBackend.when('GET', '/calculator').respond([]);

	    
	}));

	describe('submitForm', function(){

		it('should redirect the user to the calculator if the name is valid', function(done) {
			inject(function($templateCache, $compile){
				templateHtml = $templateCache.get('assets/templates/calculator/create.html');
			    formElem = angular.element("<div>" + templateHtml + "</div>");

				$compile(formElem)(scope);
			    scope.$apply();
			    scope.form.$setDirty();

			    scope.calculatorForm.name = 'teste123123';

				resp = scope.submitForm();
				scope.$apply();
				httpBackend.flush();
				resp.$promise.then(function(){
					location.path().should.equals('/teste123123');
					done();
				})
				scope.$root.$digest();
			});
		});

		it('should fail if the name has less than 8 chars', inject(function($templateCache, $compile){
			templateHtml = $templateCache.get('assets/templates/calculator/create.html');
		    formElem = angular.element("<div>" + templateHtml + "</div>");

			scope.calculatorForm.name = 'teste';

			$compile(formElem)(scope);
		    scope.$apply();

			scope.submitForm();

			(!!scope.form.$error.minlength).should.equal(true);
		}));

		it('should fail if the name has more than 40 chars', inject(function($templateCache, $compile){
			templateHtml = $templateCache.get('assets/templates/calculator/create.html');
		    formElem = angular.element("<div>" + templateHtml + "</div>");

			scope.calculatorForm.name = new Array( 40 + 2 ).join('a');

			$compile(formElem)(scope);
		    scope.$apply();

			scope.submitForm();

			(!!scope.form.$error.maxlength).should.equal(true);
		}));

		it('should fail if the name is not alphanumeric', inject(function($templateCache, $compile){
			templateHtml = $templateCache.get('assets/templates/calculator/create.html');
		    formElem = angular.element("<div>" + templateHtml + "</div>");

			scope.calculatorForm.name = '   asdas';

			$compile(formElem)(scope);
		    scope.$apply();

			scope.submitForm();
			(!!scope.form.$error.pattern).should.equal(true);
		}));

		it('should fail if the name already exists', function(done){
			//this.timeout(6000);
			inject(function($templateCache, $compile, $timeout){
				templateHtml = $templateCache.get('assets/templates/calculator/create.html');
			    formElem = angular.element("<div>" + templateHtml + "</div>");

				$compile(formElem)(scope);
			    scope.calculatorForm.name = 'hugobessa';
			    var promise = scope.form.name.$asyncValidators.isNameFree(scope.calculatorForm.name, scope.calculatorForm.name);
			    scope.$apply();
			    httpBackend.flush();

			    promise.finally(function(data){
			    	scope.submitForm();
			    	(!!scope.form.$error.isNameFree).should.equal(true);
		    		done();
			    });
			    scope.$apply();
			});
		});
	});
});