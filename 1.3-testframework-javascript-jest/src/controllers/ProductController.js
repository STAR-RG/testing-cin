const Product = require("../models/Product");

class ProductController {
  async store(req, res) {
    const product = await Product.create(req.body);

    return res.json(product);
  }
}

module.exports = new ProductController();
