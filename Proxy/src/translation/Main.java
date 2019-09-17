package translation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int F;
		int C;
		Scanner scan=new Scanner(System.in);
		F=scan.nextInt();
		C=(int)((F-32)*(5.0/9.0));
		System.out.println(C);
		
	}

}
