package Day02.Code;

import java.util.Scanner;

public class Day02_Code5_1 {
	public static void main(String[] args) {
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		double num1 = 0.0;
		double num2 = 0.0;
		double num3 = 0.0;
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		
		Scanner scanner = new Scanner(System.in);
		while (flag1) {
			System.out.println("请输入身高1的值：");
			String str1 = scanner.nextLine();
			for(int i=0;i<str1.length();i++){
			// 只要有一个字符不是数字，就陷入输入数字的循环，但是小数点除外
				if(!Character.isDigit(str1.charAt(i)) && Character.hashCode(str1.charAt(i)) != 46){
					System.out.println("请输入数字！！");
					break;
			// 如果有小数点，开始记小数点的个数
				} if (Character.hashCode(str1.charAt(i)) == 46) {
					temp1++; 
			// 如果小数点个数超过1个，也不是正确的数字形式
				} if (temp1 > 1) {
					System.out.println("请输入数字！！");
					temp1 = 0;
					break;
			// 如果每个字符都是数字，且最后一个字符也是数字，而且只有一个小数点，就把字符串转成double
				} if (Character.isDigit(str1.charAt(i)) && i == (str1.length()-1) && temp1 < 2) {
					num1 = Double.parseDouble(str1);
					flag1 = false;
				} 
			}
		}

		while (flag2) {
			System.out.println("请输入身高2的值：");
			String str2 = scanner.nextLine();
			for(int i=0;i<str2.length();i++){
			// 只要有一个字符不是数字，就陷入输入数字的循环，但是小数点除外
				if(!Character.isDigit(str2.charAt(i)) && Character.hashCode(str2.charAt(i)) != 46){
					System.out.println("请输入数字！！");
					break;
			// 如果有小数点，开始记小数点的个数
				} if (Character.hashCode(str2.charAt(i)) == 46) {
					temp2++; 
			// 如果小数点个数超过1个，也不是正确的数字形式
				} if (temp2 > 1) {
					System.out.println("请输入数字！！");
					temp2 = 0;
					break;
			// 如果每个字符都是数字，且最后一个字符也是数字，而且只有一个小数点，就把字符串转成double
				} if (Character.isDigit(str2.charAt(i)) && i == (str2.length()-1) && temp2 < 2) {
					num2 = Double.parseDouble(str2);
					flag2 = false;
				} 
			}
		}

		while (flag3) {
			System.out.println("请输入身高3的值：");
			String str3 = scanner.nextLine();
			for(int i=0;i<str3.length();i++){
			// 只要有一个字符不是数字，就陷入输入数字的循环，但是小数点除外
				if(!Character.isDigit(str3.charAt(i)) && Character.hashCode(str3.charAt(i)) != 46){
					System.out.println("请输入数字！！");
					break;
			// 如果有小数点，开始记小数点的个数
				} if (Character.hashCode(str3.charAt(i)) == 46) {
					temp3++; 
			// 如果小数点个数超过1个，也不是正确的数字形式
				} if (temp3 > 1) {
					System.out.println("请输入数字！！");
					temp3 = 0;
					break;
			// 如果每个字符都是数字，且最后一个字符也是数字，而且只有一个小数点，就把字符串转成double
				} if (Character.isDigit(str3.charAt(i)) && i == (str3.length()-1) && temp3 < 2) {
					num3 = Double.parseDouble(str3);
					flag3 = false;
				} 
			}
		}

		double tempMax = num1 > num2 ? num1 : num2;
		double max = tempMax > num3 ? tempMax : num3;
		System.out.println("最高的人的身高为： " + max);
	
	}
}