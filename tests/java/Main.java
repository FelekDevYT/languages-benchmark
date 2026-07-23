public class Main {
    public static void main(String[] args) {
        long counter = 1;
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                counter += (long) i * j;
            }
        }
        System.out.println(counter);
    }
}