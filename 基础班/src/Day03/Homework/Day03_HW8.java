package Day03.Homework;

public class Day03_HW8 {
	public static void main(String[] args) {
		int count1 = 0;
		int count2 = 0;
		for (int j = 9999; j >= 1000; j--) {
			int ge = j % 10;
			int shi = (j / 10) % 10;
			int bai = (j / 10 / 10) % 10;
			int qian = j / 10 / 10 / 10;
			
			if ((ge + shi) == (bai + qian)) {
				System.out.print(j + " ");
				count1++;
				count2++;
			}
			if (count1 == 5) {
				System.out.println();
				count1 = 0;
			}
		}
		System.out.println("总个数为：" + count2);
	}
}