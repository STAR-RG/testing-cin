const { sum, sub, buildObject, sumPositiveNumber } = require("../src");

describe("Expect to be", () => {
  it("Sum 2 + 3 and sub 3 always shold be equal 2", () => {
    const result = sub(sum(2, 3), 3);

    expect(result).toBe(2);
  });
});

describe("Expect to equal", () => {
  it("Should correctly build object", () => {
    const obj = buildObject(3);

    expect(obj).toEqual({ "1": 1, "2": 2, "3": 3 });
  });
});

describe("Expect to throw exception", () => {
  it("Shouldn't sum unless both numbers are positive", () => {
    const result = () => sumPositiveNumber(-3, 3);

    expect(result).toThrow("Not allowed zero or negative numbers");
  });
});
