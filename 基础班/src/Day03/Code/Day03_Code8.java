package Day03.Code;

public class Day03_Code8 {
	public static void main(String[] args) {
		for (int j = 1; j <= 100; j++) {
			if (j % 5 == 0) {
				continue;
			}
			System.out.println(j);
		}
	}
}