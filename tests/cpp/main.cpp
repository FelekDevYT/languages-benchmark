#include <iostream>
#include <cstdlib>

int main(int argc, char *argv[]) {
    long long counter = 1;
    int N = std::atoi(argv[1]);
    int M = std::atoi(argv[2]);

    for (int i = 1; i < N; ++i) {
        for (int j = 1; j < M; ++j) {
            counter += static_cast<long long>(i) * j;
        }
    }
    std::cout << counter << std::endl;
    return 0;
}