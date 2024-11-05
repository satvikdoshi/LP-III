package Assignment1;

import java.util.Scanner;

public class FibonacciIterative{
    public static void main(String[] args) {
        
        int a = 0, b = 1, c = 0; 

        // System.out.println(a);
        // System.out.println(b);

        System.out.println("Enter Nth no: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n == 0 || n == 1) { System.out.println(n); return;}

        for(int i=2;i<=n;i++){
            c = a + b;
            a = b; 
            b = c;
        }
        System.out.println(c);
        scanner.close();
    }
}