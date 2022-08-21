// happy coding 👻
// @ts-ignore
function fibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
var n = 7;
var sum = 0;
var arr = ' ';
for (var i = 1; i <= n; i++) {
    arr += ' ' + fibonacci(i) + ' ';
    sum += fibonacci(i);
}
console.log(n + " phần tử đầu tiên trong dãy fibonacci là: " + arr);
console.log("Tổng gồm " + n + " phần tử đầu tiên trong dãy fibonacci là: " + sum);
