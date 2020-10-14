package Day02.Code;

import java.util.Scanner;

public class Day02_Code3 {
	public static void main(String[] args) {
		
		boolean flag = true;
		int num = 0;
		int j = 0;

		Scanner scanner = new Scanner(System.in);
		while (flag) {
			System.out.println("请输入一个整数：");
			String str = scanner.nextLine();
			// 如果只有一个数字，直接转换
			if((Character.isDigit(str.charAt(0))) & (str.length() == 1)) {
				num = Math.abs(Integer.parseInt(str));
				System.out.println("整数位数从小到大依次是： " + num);
				flag = false;
			}
			// 如果第一个字符是数字或者负号，就验证后面的字符
			if(Character.isDigit(str.charAt(0)) || Character.hashCode(str.charAt(0)) == 45) {
			// 遍历输入的字符串，如果第一个字符之后有一个字符不是数字，就陷入输入循环
				for(int i = 1; i < str.length(); i++) {
					if(!Character.isDigit(str.charAt(i))) {
						System.out.println("请输入整数！！");
						break;
					} else if(i == (str.length() - 1)) {
						num = Integer.parseInt(str);
						if(num < 0) {
							System.out.println("请输入正数！！");
							break;
						}
			// 对输入的整数进行遍历，每次除10的幂，从个位开始计算
						for(int k = 0; k < str.length(); k++) {
						
						int number = (int) (num / (Math.pow(10 , j)));
						
						int result = number % 10;
						j++;
						System.out.println("整数位数从小到大依次是： " + result);
					}
						flag = false;
					}
				}
			} else {
				System.out.println("请输入整数！！");
			}
		}
		
	}

}