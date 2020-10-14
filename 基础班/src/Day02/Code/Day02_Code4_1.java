package Day02.Code;

public class Day02_Code4_1 {
/*
	public double conversion(String str) {
	// 如果第一个字符是数字或者负号或者小数点，就验证后面的字符
		if(Character.isDigit(str.charAt(0)) || Character.hashCode(str.charAt(0)) == 45 || Character.hashCode(str.charAt(i)) != 46) {
	// 遍历输入的字符串，如果第一个字符之后有一个字符不是数字，就陷入输入循环
			for(int i = 1; i < str.length(); i++) {
				if(!Character.isDigit(str.charAt(i))) {
					System.out.println("请输入数字！！");
					break;
				}
	// 如果第一个字符是小数点，后面又出现小数点，陷入输入循环
				if(Character.hashCode(str.charAt(0)) == 46 & Character.hashCode(str.charAt(i)) == 46) {
					System.out.println("请输入数字！！");
					break;
				}
	// 如果每个字符都是数字，且最后一个字符也是数字，而且只有一个小数点，或第一个字符是负号，就把字符串转成double
				if(Character.isDigit(str.charAt(i)) && i == (str.length()-1)) {
				double num = Double.parseDouble(str);
//				flag1 = false;
				return num;
				}
			}		
		} else {
			System.out.println("请输入数字！！");
		}

	} 	

	public static void main(String[] args) {
		
		boolean flag1 = true;
		boolean flag2 = true;
		double num1 = 0.0;
		double num2 = 0.0;
		int temp1 = 0;
		int temp2 = 0;
		
		Scanner scanner = new Scanner(System.in);
		while (flag1) {
			System.out.println("请输入数字1的值：");
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
			System.out.println("请输入数字2的值：");
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
		double max = num1 > num2 ? num1 : num2;
		System.out.println("两个数字中较大的数为： " + max);
	
	}

 */
}
