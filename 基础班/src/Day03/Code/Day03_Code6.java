package Day03.Code;

public class Day03_Code6 {
	public static void main(String[] args) {
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