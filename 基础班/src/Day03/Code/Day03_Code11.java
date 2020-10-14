package Day03.Code;

import java.util.Random;

public class Day03_Code11 {
	public static void main(String[] args) {
		Random random = new Random();
		for (int j = 0; j < 10; j++) {
			int num = random.nextInt(31) + 20;
			System.out.println(num);
		}
	}
}