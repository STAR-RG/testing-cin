// Karma configuration
// Generated on Wed Jun 17 2015 00:51:08 GMT-0300 (BRT)

module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['mocha', 'chai'],


    // list of files / patterns to load in the browser
    files: [
        'assets/bower_components/jquery/dist/jquery.js',
        'assets/bower_components/angular/angular.js',
        'assets/bower_components/angular-mocks/angular-mocks.js',
        'assets/bower_components/angular-route/angular-route.js',
        'assets/bower_components/angular-resource/angular-resource.js',
        'assets/bower_components/angular-messages/angular-messages.js',
        'assets/bower_components/angular-show-errors/src/showErrors.js',
        'assets/js/app.js',
        'assets/js/routes.js',
        'assets/js/controllers/*.js',
        'assets/js/directives/*.js',
        'assets/js/services/*.js',
        'assets/js/filters/*.js',
        'assets/templates/**/*.html',
        'assets/js/tests/**/*.test.js'
    ],


    // list of files to exclude
    exclude: [
    ],


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    plugins : [
        'karma-chrome-launcher',
        'karma-firefox-launcher',
        'karma-mocha',
        'karma-chai',
        'karma-ng-html2js-preprocessor'
    ],

    preprocessors: {
        "assets/templates/**/*.html": ["ng-html2js"]
    },

    ngHtml2JsPreprocessor: {
        // the name of the Angular module to create
        moduleName: "MyTemplates"
    },
    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false
  });
};
