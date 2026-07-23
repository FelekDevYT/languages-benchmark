import sys

counter = 1
N = int(sys.argv[1])
M = int(sys.argv[2])

for i in range(1, N):
    for j in range(1, M):
        counter += i * j
print(counter)