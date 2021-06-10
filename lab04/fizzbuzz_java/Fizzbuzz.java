public class Fizzbuzz {

    public static void main(String[] args) {
        
        for (int i = 1; i <= 100; i ++) {
            System.out.println(fizzbuzzNum(i));
        }
    }

    public static String fizzbuzzNum(int n) {
        if (n%15 == 0) {
            return "Fizzbuzz";
        }

        else if (n%5 == 0) {
            return "Buzz";
        }

        else if (n%3 == 0) {
            return "Fizz";
        }

        else {
            return Integer.toString(n);
        }
    }

}