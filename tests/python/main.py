counter = 1

for i in range(1000000):
    for j in range(1000):
        counter += i * j
print(counter)