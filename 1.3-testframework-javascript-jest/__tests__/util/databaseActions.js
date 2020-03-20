const mongoose = require("mongoose");

function drop() {
  return mongoose.connection.dropDatabase();
}

function disconnect() {
  return mongoose.disconnect();
}

module.exports = { disconnect, drop };
