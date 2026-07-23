use std::env;

fn main() {
    let mut counter: i64 = 1;
    let args: Vec<String> = env::args().collect();
    let mut n = args[1].parse().unwrap();
    let mut m = args[2].parse().unwrap();

    for i in 1..n {
        for j in 1..m {
            counter += i * j;
        }
    }
    println!("{}", counter);
}