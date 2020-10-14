package Day03.Code;

public class Day03_Code4 {
	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		for (int j = 1; j <= 100; j++) {
			if (j % 2 == 0) {
				sum1 += j;
			} else {
				sum2 += j;
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}
}