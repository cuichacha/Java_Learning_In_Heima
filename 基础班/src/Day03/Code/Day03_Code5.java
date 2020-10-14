package Day03.Code;

public class Day03_Code5 {
	public static void main(String[] args) {
		int gewei = 0;
		int shiwei = 0;
		int baiwei = 0;
		int count = 0;
		for (int j = 100; j <= 999; j++) {
			gewei = j % 10;
			shiwei = (j / 10) % 10;
			baiwei = (j / 10 / 10) % 10;
			if (j == ((gewei * gewei * gewei) + (shiwei * shiwei * shiwei) + (baiwei * baiwei * baiwei))) {
				count++;
				System.out.print(j + " ");
				if (count % 2 == 0) {
					System.out.println();
				}
			}
		}
	}
}