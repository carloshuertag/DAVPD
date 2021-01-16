public final class CountingTechniques {
    public static double factorial(double n){
        return n == 0.0 ? 1.0 : n * factorial(n - 1.0);
    }
    public static double permutation(double n, double r) {
        return factorial(n) / factorial(n - r);
    }
    public static double combinatorial(double n, double r) {
        return permutation(n, r) / factorial(r);
    }
}