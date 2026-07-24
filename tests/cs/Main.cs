using System;

class Program {
    static void Main(string[] args) {
        long counter = 1;
        int n = int.Parse(args[0]);
        int m = int.Parse(args[1]);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                counter += (long)i * j;
            }
        }
        Console.WriteLine(counter);
    }
}