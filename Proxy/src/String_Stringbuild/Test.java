package String_Stringbuild;

public class Test {
	private final int n = 20000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		test.stringTest();
		test.stringBufferTest();
		test.stringBuildTest();
		test.string_essence();
	}
	//String类测试
	public void stringTest(){
		long start = System.currentTimeMillis();
		String s="";
		for(int i=0;i<=n;++i) {
			s+=i;
		}
		System.out.println("String测试时间为："+(System.currentTimeMillis()-start));
	}
	//StringBuffer类测试
	public void stringBufferTest() {
		long start = System.currentTimeMillis();
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i < n; ++i) {
            s.append(i);
        }
        System.out.println("stringBuffer测试时间为:" + (System.currentTimeMillis() - start));
	}
	//StringBuild类测试
	public void stringBuildTest() {
		long start = System.currentTimeMillis();
		StringBuilder s=new StringBuilder("");
		for (int i = 0; i < n; ++i) {
            s.append(i);
        }
        System.out.println("stringBuilder测试时间为:" + (System.currentTimeMillis() - start));
	}
//	java中的String类不可变的（immutable）， 
//	通过使用javap工具我们可以知道其实上面的代码在编译成字节码的时候等同的源代码是：
	public void string_essence(){
		String s1="hello ";
		s1+="world";
		System.out.println(s1);
		String s2="hello";
		//与上类等价
		StringBuffer temp=new StringBuffer();
		temp.append("hello ");
		temp.append("world");
		s2=temp.toString();
		System.out.println(s2);

	}
}
