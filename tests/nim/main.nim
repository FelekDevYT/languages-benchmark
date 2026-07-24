import os
import strutils

let N = parseInt(paramStr(1))
let M = parseInt(paramStr(2))

var counter = 1'i64

for i in 1 ..< N:
  for j in 1 ..< M:
    counter += i * j

echo counter