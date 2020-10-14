package Day03.Homework;

public class Day03_HW4 {
	public static void main(String[] args) {
		int j = 5;
		do {
			System.out.println(j);
			j--;
		} while (j > 0);
		System.out.println("----------------");
		
		int k = 0;
		int sum = 0;
		do {
			k++;
			if (k % 2 == 0) {
				sum += k;
			}
		} while (k <= 100);
		System.out.println(sum);
	}
}