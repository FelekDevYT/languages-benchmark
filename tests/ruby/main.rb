#!/usr/bin/env ruby

n = ARGV[0].to_i
m = ARGV[1].to_i

counter = 1

(1...n).each do |i|
  (1...m).each do |j|
    counter += i * j
  end
end

puts counter