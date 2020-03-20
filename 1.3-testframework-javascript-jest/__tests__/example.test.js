function sum(a, b) {
  return a + b;
}

function sub(a, b) {
  return a - b;
}

describe("My first test", () => {
  it("Sum 2 + 3 and sub 3 always should be equal 2", () => {
    const result = sub(sum(2, 3), 3);

    expect(result).toBe(2);
  });
});
