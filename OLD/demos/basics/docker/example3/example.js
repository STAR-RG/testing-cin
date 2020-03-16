var express = require('express');

var app = express();


app.get('/', function(req, res) {
    res.send('Hello, CIn!');
});

app.listen(5000, function() {
    console.log('Listening on port 5000');
});
