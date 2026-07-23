#include <stdio.h>

int main() {
    long long counter = 1;
    for (int i = 1; i < 1000000; i++) {
        for (int j = 1; j < 1000; j++) {
            counter += i * j;
        }
    }
    printf("%lld\n", counter);
    return 0;
}