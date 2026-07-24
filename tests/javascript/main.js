const N = parseInt(process.argv[2]);
const M = parseInt(process.argv[3]);
let counter = 1n;
for (let i = 1; i < N; i++) {
    for (let j = 1; j < M; j++) {
        counter += BigInt(i * j);
    }
}
console.log(counter.toString());