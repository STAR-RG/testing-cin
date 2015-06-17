var request = require('supertest');
var assert = require('assert');

describe('OperationsController', function() {

  describe('#list()', function() {

    describe('there\'s no operation registered', function(){
      beforeEach(function(done){
        Operation.destroy({}).exec(function(){
            done();
        });
      })
      it('should return an empty array', function (done) {
        request(sails.hooks.http.app)
          .get('/operation')
          .send()
          .end(function(err, res){
            assert.equal(res.status, 200);
            assert.equal(res.body.length, 0);
            done()
          });

      });
    });

    describe('there\'s one operation registered', function(){
      var calculator, operation;
      beforeEach(function(done){
        Calculator.destroy({}).exec(function(err){
          Calculator.create({name: 'testecalc'}).exec(function(err, created){
            calculator = created;
            Operation.create({text: '2 + 2', calculator: calculator}).exec(function(err, created){
              operation = created
              done();
            })
          });
        });
      });

      it('should return one operation', function (done) {
        request(sails.hooks.http.app)
          .get('/operation')
          .send()
          .end(function(err, res){
            assert.equal(res.status, 200);
            assert.equal(res.body[0].id, operation.id);
            done()
          });
      });
    })
  });


  describe('#create()', function() {
    var calculator;
    beforeEach(function(done){
      Calculator.destroy({}).exec(function(err){
        Calculator.create({name: 'testecalc'}).exec(function(err, created){
          calculator = created;
          done();
        });
      });
    });
    it('should create an operation in testecalc calculator', function (done) {
      request(sails.hooks.http.app)
        .post('/operation/')
        .send({text:'2 + 3', calculator: calculator.id})
        .end(function(err, res){
          assert.equal(res.status, 201);
          
          Operation.find({calculator: calculator.id}).exec(function(err, found){
            assert.equal(found[0].text, '2 + 3');
            done();
          })
          
        });
    });

    it('should fail creating an operation in an inexistent calculator', function (done) {
      request(sails.hooks.http.app)
        .post('/operation/')
        .send({text:'2 + 3', calculator: 'asdasdsadas'})
        .end(function(err, res){
          assert.equal(res.status, 400);
          done()          
        });
    });

  });

});