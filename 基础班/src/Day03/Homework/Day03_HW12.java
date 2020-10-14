package Day03.Homework;

import java.util.Scanner;

public class Day03_HW12{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int num = 0;
		while (flag) {
			System.out.print("请输入生成行数： ");
			String str = scanner.nextLine();
			// 遍历输入的字符串，如果有一个字符不是数字，就陷入输入循环
			for(int i = 0; i < str.length(); i++){
				if(!Character.isDigit(str.charAt(i))) {
					System.out.println("请输入正确的数字！！");
					break;
			// 如果数字正确，且所有字符都是数字，就转成int，并退出循环
				} else if (i == (str.length()-1)) {
					num = Integer.parseInt(str);
					flag = false;
				}
			}
		}
		
		int lineNumber = num;
		int lineCount = 1;
		for (int k = 1; k <= lineNumber; k++) {
			for (int j = 1; j <= lineNumber - lineCount; j++){
				System.out.print(" ");
			}
			for (int n = 1; n <= lineCount; n++){
				System.out.print(" ");
				System.out.print("*");	
			}
			lineCount += 1;
			System.out.println();
		}
	}
}