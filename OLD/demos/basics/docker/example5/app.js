var express = require('express');
var app = express();

function index(req, res, next) {
    console.log("Executou!");
    res.send('Hello, CIn!');
}
app.get('/', index);

app.listen(5000, function() {
    console.log('Listening on port 5000');
});