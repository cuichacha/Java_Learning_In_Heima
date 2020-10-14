package Day02.Code;

import java.util.Scanner;

public class Day02_Code6{

	public static void main(String[] args) {
		
		boolean flag = true;
		int num = 0;
		
		Scanner scanner = new Scanner(System.in);
		while (flag) {
			System.out.println("请输入一个年龄：");
			String str = scanner.nextLine();
			// 如果第一个字符是数字或者负号，就验证后面的字符
			if(Character.isDigit(str.charAt(0)) || Character.hashCode(str.charAt(0)) == 45) {
			// 遍历输入的字符串，如果有一个字符不是数字，就陷入输入循环
				for(int i=1;i<str.length();i++){
					if(!Character.isDigit(str.charAt(i))) {
						System.out.println("请输入整数！！");
						break;
						} else if (i == (str.length() - 1)) {
						num = Integer.parseInt(str);
						if (num <=0 || num >= 120) {
							System.out.println("请输入正常年龄！！");
							break;
						} else if (num < 18) {
							System.out.println("不可以上网吧！");
							flag = false;
						} else {
							System.out.println("可以上网吧。");
							flag = false;
						}
					}
				}			
			} else {
				System.out.println("请输入整数！！");
			}
		}
	}
}