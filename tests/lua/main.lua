local N = tonumber(arg[1])
local M = tonumber(arg[2])
local counter = 1
for i = 1, N-1 do
    for j = 1, M-1 do
        counter = counter + i * j
    end
end
print(counter)