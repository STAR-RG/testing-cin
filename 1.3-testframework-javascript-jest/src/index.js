function sum(a, b) {
  return a + b;
}

function sub(a, b) {
  return a - b;
}

function buildObject(length) {
  let obj;

  for (let i = 1; i <= length; i++) {
    // faz a copia do objeto e cria uma key com o valor do i atual  e.g. {'1' : 1, '2': 2}
    obj = { ...obj, [i]: i };
  }

  return obj;
}

function sumPositiveNumber(a, b) {
  if (a <= 0 || b <= 0) {
    throw new Error("Not allowed zero or negative numbers");
  }

  return sum(a, b);
}

module.exports = { sum, sub, buildObject, sumPositiveNumber };
