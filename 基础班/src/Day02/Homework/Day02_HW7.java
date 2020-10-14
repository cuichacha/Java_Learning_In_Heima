package Day02.Homework;

public class Day02_HW7 {
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		int c = a++ + 6 + ++b - a-- + --a + b--;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}