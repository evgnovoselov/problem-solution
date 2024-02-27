import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        while (count-- > 0) {
            String echo = scanner.nextLine();
            System.out.println(echo);
        }
    }
}
