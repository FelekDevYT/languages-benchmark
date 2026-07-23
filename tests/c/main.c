#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    long long counter = 1;
    int N = atoi(argv[1]);
    int M = atoi(argv[2]);

    for (int i = 1; i < N; i++) {
        for (int j = 1; j < M; j++) {
            counter += (long long)i * j;
        }
    }
    printf("%lld\n", counter);
    return 0;
}