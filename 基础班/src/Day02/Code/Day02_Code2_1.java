package Day02.Code;

import java.util.Scanner;

public class Day02_Code2_1 {
	public static void main(String[] args) {
		boolean flag1 = true;
		boolean flag2 = true;
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
	
		Scanner scanner1 = new Scanner(System.in);
		while (flag1) {
			System.out.println("请输入整数1：");
			String str1 = scanner1.nextLine();
			// 如果只有一个数字，直接转换
			if((Character.isDigit(str1.charAt(0))) & (str1.length() == 1)) {
				num1 = Integer.parseInt(str1);
				flag1 = false;
			}
			// 如果第一个字符是数字或者负号，就验证后面的字符
			if(Character.isDigit(str1.charAt(0)) || Character.hashCode(str1.charAt(0)) == 45) {
			// 遍历输入的字符串，如果第一个字符之后有一个字符不是数字，就陷入输入循环
				for(int i = 1; i < str1.length(); i++) {
					if(!Character.isDigit(str1.charAt(i))) {
						System.out.println("请输入整数！！");
						break;
					} else if(i == (str1.length() - 1)) {
						num1 = Integer.parseInt(str1);
						flag1 = false;
					}
				}
			} else {
				System.out.println("请输入整数！！");
			}
		}
		Scanner scanner2 = new Scanner(System.in);
		while (flag2) {
			System.out.println("请输入整数2：");
			String str2 = scanner2.nextLine();
			// 如果只有一个数字，直接转换
			if(Character.isDigit(str2.charAt(0)) & str2.length() == 1) {
				num2 = Integer.parseInt(str2);
				flag2 = false;
			}
			// 如果第一个字符是数字或者负号，就验证后面的字符
			if(Character.isDigit(str2.charAt(0)) || Character.hashCode(str2.charAt(0)) == 45) {
			// 遍历输入的字符串，如果第一个字符之后有一个字符不是数字，就陷入输入循环
				for(int i = 1; i < str2.length(); i++) {
					if(!Character.isDigit(str2.charAt(i))) {
						System.out.println("请输入整数！！");
						break;
					} else if(i == (str2.length() - 1)) {
						num2 = Integer.parseInt(str2);
						flag2 = false;
					}
				}
			} else {
				System.out.println("请输入整数！！");
			}
		}

		sum = num1 + num2;
		System.out.println("您输入的整数和为： " + sum);
	}
}
