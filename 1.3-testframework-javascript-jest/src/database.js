const mongoose = require("mongoose");

class Database {
  constructor() {
    this.connection = mongoose.connect("mongodb://localhost/testing-cin", {
      useNewUrlParser: true,
      useUnifiedTopology: true
    });
  }
}

module.exports = new Database().connection;
