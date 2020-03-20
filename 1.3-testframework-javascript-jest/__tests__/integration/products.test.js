const request = require("supertest");
const { disconnect, drop } = require("../util/databaseActions");
const app = require("../../src/app");

describe("Products", () => {
  afterEach(async () => {
    await drop();
  });

  afterAll(async () => {
    await disconnect();
  });

  it("should de able to create a new product", async () => {
    const response = await request(app)
      .post("/products")
      .send({
        name: "A new product",
        description: "A new description"
      });

    expect(response.status).toBe(200);
    expect(response.body).toHaveProperty("_id");
  });
});
