package Matrix;

public class TestIntegerMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[][] m1=new Integer[][]{{1,2,3},{4,5,6},{1,1,1}};
		Integer[][] m2=new Integer[][]{{1,1,1},{2,2,2},{0,0,0}};
		IntegerMatrix integerMatrix=new IntegerMatrix();
		System.out.println("\nm1+m2 is");
		GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
		System.out.println("\nm1*m2 is");
		GenericMatrix.printResult(m1, m2, integerMatrix.mulyiplyMartix(m1, m2), '+');
	}
}

 abstract class GenericMatrix <E extends Number>{
	protected abstract E add(E o1,E o2);
	protected abstract E multiply(E o1,E o2);
	protected abstract E zero();
	public E[][] addMatrix(E[][]matrix1,E[][]matrix2){
		if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){
			throw new RuntimeException("The matrices do not have the same size");
			
		}
		E[][] result=(E[][])new Number[matrix1.length][matrix1[0].length];
		for(int i=0;i<result.length;i++)
			for(int j=0;j<result[i].length;j++){
				result[i][j]=add(matrix1[i][j],matrix2[i][j]);
			}
		return result;
	}
	public E[][] mulyiplyMartix(E[][]matrix1,E[][]matrix2){
		if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){
			throw new RuntimeException("The matrices do not have the same size");
			
		}
		E[][] result=(E[][])new Number[matrix1.length][matrix2[0].length];
		for(int i=0;i<result.length;i++)
			for(int j=0;j<result[0].length;j++){
				result[i][j]=zero();
				for(int k=0;k<matrix1[0].length;k++){
					result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
				}
				
			}
		return result;
		
	}
	public static void printResult(Number[][] m1,Number[][] m2,Number[][]m3,char op){
		for(int i=0;i<m1.length;i++){
			for(int j=0;j<m1[0].length;j++)
				System.out.print(" "+m1[i][j]);
			if(i==m1.length/2)
				System.out.print(" "+op+" ");
			else
				System.out.print("   ");
			for(int j=0;j<m2.length;j++)
				System.out.print(" "+m2[i][j]);
			if(i==m1.length/2)
				System.out.print(" = ");
			else
				System.out.print("   ");
			for(int j=0;j<m3.length;j++)
				System.out.print(m3[i][j]+" ");
			System.out.println();
			
		}
	}
 
}
 
class IntegerMatrix extends GenericMatrix<Integer>{
	 
		@Override
		protected Integer add(Integer o1, Integer o2) {
			return o1+o2;
		}
	 
		@Override
		protected Integer multiply(Integer o1, Integer o2) {
			return o1*o2;
		}
	 
		@Override
		protected Integer zero() {
			return 0;
		}
		
	 
	}

	