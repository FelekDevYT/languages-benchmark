import Foundation

let N = Int(CommandLine.arguments[1])!
let M = Int(CommandLine.arguments[2])!
var counter: Int64 = 1
for i in 1..<N {
    for j in 1..<M {
        counter += Int64(i * j)
    }
}
print(counter)