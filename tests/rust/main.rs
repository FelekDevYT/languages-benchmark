fn main() {
    let mut counter: i64 = 1;
    for i in 1..=1000000 {
        for j in 1..1000 {
            counter += i * j;
        }
    }

    println!("{}", counter);
}
