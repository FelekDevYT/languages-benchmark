import std.stdio;
import std.conv;

void main(string[] args) {
    long counter = 1;
    int N = args[1].to!int;
    int M = args[2].to!int;

    for (int i = 1; i < N; i++) {
        for (int j = 1; j < M; j++) {
            counter += i * j;
        }
    }
    writeln(counter);
}