package Day03.Homework;

public class Day03_HW3 {
	public static void main(String[] args) {
		int j = 5;
		while (j >= 1) {
			System.out.println(j);
			j--;
		}
		System.out.println("----------------");

		int k = 1;
		int sum = 0;
		while (k <= 100) {
			if (k % 2 != 0) {
				sum += k;
			}
			k++;
		}
		System.out.println(sum);
		System.out.println("----------------");

		int count = 0;
		int height = 8844430;
		double paper = 0.1;
		while (paper <= height) {
			paper *= 2;
			count++;
		}
		System.out.println(count);
	}
}