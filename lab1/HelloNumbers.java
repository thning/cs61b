public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int add = 1;
        while (x <= 45) {
            System.out.print(x + " ");
            x = x + add;
            add ++;
        }
    }
}