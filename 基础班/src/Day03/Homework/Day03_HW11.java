package Day03.Homework;

public class Day03_HW11{
	public static void main(String[] args){
		
		for(int n = 1; n <= 9; n++) {
			for(int j = 1; j <= n; j++){
				System.out.print(n + "*" + j + "=" + (n*j));
				System.out.print(" ");
				
			}
			System.out.println();
			
		}
	}
}