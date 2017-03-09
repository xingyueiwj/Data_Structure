package test.string;

public class MyStringBufferTest {
	public static void main(String[] args) {
		MyStringBuffer msb1 = new MyStringBuffer("lihonglei");
		MyStringBuffer msb2 = new MyStringBuffer("zhangxuhui");
		System.out.println("msb1的连接前输出值: ");
		msb1.myPrint();
		MyStringBuffer msb3 = msb1.concat(msb2);
		System.out.println("msb1的连接后输出值: ");
		msb1.myPrint();
		System.out.println("msb3的输出值: ");
		msb3.myPrint();
	}
}
