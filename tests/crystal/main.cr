n = ARGV[0].to_i64
m = ARGV[1].to_i64

counter = 1_i64
(1...n).each do |i|
  (1...m).each do |j|
    counter += i * j
  end
end

puts counter