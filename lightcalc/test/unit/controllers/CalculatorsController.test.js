var request = require('supertest');
var assert = require('assert');

describe('CalculatorsController', function() {

  describe('#list()', function() {
    beforeEach(function(done){
      Calculator.destroy({}).exec(function(){
        done();
      });
    });

    it('should return an empty array', function (done) {
      request(sails.hooks.http.app)
        .get('/calculator')
        .end(function(err, res){
          assert.equal(res.status, 200);
          assert.equal(res.body.length, 0);
          done()
        });
    });
  });

  describe('#create()', function() {
    beforeEach(function(done){
      Calculator.create({name: 'FantasmaOpera'}).exec(function(){
        done();
      });
    });

    it('should create a calculator', function (done) {
      var calculator = {name: 'hugobessa'};

      request(sails.hooks.http.app)
        .post('/calculator')
        .send(calculator)
        .end(function(err, res){
          assert(res.status, 201);
          Calculator.find({name: 'hugobessa'}).exec(function(err, found){
            assert.equal(found[0].name, 'hugobessa', done);
            done();
          })
        });
    });

    it('should return error trying to save a calculator with a short name', function (done) {
      var calculator = {name: 'hugobes'};

      request(sails.hooks.http.app)
        .post('/calculator')
        .send(calculator)
        .end(function(err, res){
          assert.equal(res.status, 400);
          done();
        });
    });

    it('should return error trying to save a calculator with a long name', function (done) {
      var calculator = {name: 'hugobessahugobessahugobessahugobessahugobessahugobessa'};

      request(sails.hooks.http.app)
        .post('/calculator')
        .send(calculator)
        .end(function(err, res){
          assert.equal(res.status, 400);
          done();
        });
    });

    it('should return error trying to save a calculator with a not alphanumeric name', function (done) {
      var calculator = {name: 'hugãoteste'};

      request(sails.hooks.http.app)
        .post('/calculator')
        .send(calculator)
        .end(function(err, res){
          assert.equal(res.status, 400);
          done();
        });
    });

    it('should return error trying to save duplicate calculator name', function (done) {
		  var calculator = {name: 'FantasmaOpera'};

      request(sails.hooks.http.app)
        .post('/calculator')
        .send(calculator)
        .expect(400, done);        
    });
  });
});


