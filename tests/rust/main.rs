use std::env;
use std::hint::black_box;

fn main() {
    let mut counter: i64 = 1;
    let args: Vec<String> = env::args().collect();
    let mut n = args[1].parse().unwrap();
    let mut m = args[2].parse().unwrap();

    for i in 1..n {
        for j in 1..m {
            counter += black_box(i * j);
        }
    }
    println!("{}", counter);
}