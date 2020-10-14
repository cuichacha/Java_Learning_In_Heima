package Day03.Homework;

public class Day03_HW7 {
	public static void main(String[] args) {
		int count = 0;
		for (int j = 1; j <= 100; j++) {
			
			
			
			if (j == 9 | (j % 10 == 9) | (j / 10 == 9)) {
				continue;
			}
			if (count % 5 == 0) {
				System.out.println();
			}
			System.out.print(j + " ");
			count++;
		}
	}
}