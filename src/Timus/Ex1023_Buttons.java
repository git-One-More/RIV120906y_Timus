package Timus;
import java.util.Scanner;
public class Ex1023_Buttons {
	public static void main(String[] args) {
		long i = 3;
		long a;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		while (a % i != 0) {
			i++;
		}
		System.out.println(i - 1);
	}
}