// happy coding 👻
// @ts-ignore
function fibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

let n = 7;
let sum = 0;
let arr = ' ';
for (let i = 1; i <= n; i++) {
    arr += ' ' + fibonacci(i) + ' ';
    sum += fibonacci(i);
}
console.log(n + " phần tử đầu tiên trong dãy fibonacci là: " + arr);
console.log("Tổng gồm " + n + " phần tử đầu tiên trong dãy fibonacci là: " + sum);
