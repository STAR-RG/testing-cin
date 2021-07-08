# lightcalc

a [Sails](http://sailsjs.org) application that uses angularjs to make beautiful and light calculators with isolates operations histories.

## Running application

Install nodejs

In the application folder, run "npm install" with the required permissions.

OBS.: in Ubuntu, you haave to run "sudo npm install", for example

After npm install all the project dependencies, run "bower install" to download the frontend depencies.

For last, run "sails lift", and then the application will be running at http://localhost:1337.


## Running tests

There are two sets of tests in the application: the backend tests, which test the REST api provided by sails, and the frontend tests, which test the angularjs application.

### Backend tests

To run the backend tests you have to install mocha globally running "npm install mocha -g" with the required permissions. 

After mocha is installed run the command "mocha test/bootstrap.test.js test/unit/**.*.test.js" in the project root folder.

### Frontend tests

To run the backend tests you have to install karma tests runner globally running "npm install karma -g" with the required permissions. 

After karma is installed run the command "karma start" in the project root folder.


## Demo version

[http://lightcalc.herokuapp.com](http://lightcalc.herokuapp.com)