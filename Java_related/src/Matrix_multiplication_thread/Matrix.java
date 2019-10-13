package Matrix_multiplication_thread;

import java.util.Scanner;

public class Matrix {
	public static double[][] multiplyMatrix(double[][] a,double[][] b){
		if(a[0].length!=b.length){
			System.out.println("第一个矩阵的列不等于第二个矩阵的行！无法进行矩阵相乘运算！");
			return null;
		}
		else{
			double[][] c=new double[a.length][b[0].length];
			for(int i=0;i<a.length;i++){
				for(int j=0;j<b[0].length;j++)
					for(int t=0;t<a[0].length;t++)
					{
						c[i][j]+=a[i][t]*b[t][j];
						}
			System.out.println();

			}
			return c;
			}
		}
	
	public static void displayMatrix(double[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		}
	public static double[][] createMatrix(){

		Scanner input=new Scanner(System.in);
		System.out.println("请输入您要输入的矩阵的行");
		int m= input.nextInt();
		System.out.println("请输入您要输入的矩阵的列"); 
		int n=input.nextInt();
		double[][] x=new double[m][n];
		System.out.println("请输入您的矩阵");

		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				x[i][j]=input.nextDouble();
			return x;
		}
	public static void main(String[] args){
		int m=0,n=0,k=0;
		double[][] a=new double[m][n];
		double[][] b=new double[n][k];
		double[][] c=new double[m][k];

		a=createMatrix();
		b=createMatrix();
		long startTime = System.currentTimeMillis();
		c= multiplyMatrix(a,b);
		long endTime = System.currentTimeMillis();
		System.out.println("a矩阵");
		displayMatrix(a);
		System.out.println("b矩阵");
		displayMatrix(b);
		System.out.println("两个矩阵相乘得：");
		displayMatrix(c);
		System.out.println("两个矩阵相乘耗费时间为："+(endTime-startTime));


		}
	}