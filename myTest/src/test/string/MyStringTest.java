package test.string;

public class MyStringTest {
	public static void main(String[] args) {
//		char[]var1 = {'d','u','j','i','a','n','h','u','a'};
//		char[]var2 = {'y','a','n','g','j','i','n','f','e','n','g'};
//		int length1 = var1.length;
//		MyString ms1 = new MyString(var1,0,length1);
//		MyString ms2 = new MyString(var2);
//		MyString ms3 = new MyString("lihonglei");
//		MyString ms4 = new MyString("zhangxuhui");
//		MyString ms5 = ms1.concat(ms2);
//		ms1.myPrint();
//		ms5.myPrint();
//		MyString ms6 = ms4.substring(0,4);
//		ms6.myPrint();
//		MyString ms7 = ms4.insert(new MyString("123"), 4);
//		ms7.myPrint();
//		MyString ms8 = ms4.delete(3,6);
//		ms8.myPrint();
//		MyString ms2 = new MyString("a");
//		MyString ms3 = new MyString("lihonglei");
//		MyString a = ms2.insert(ms3, 0);//将自己接到后面
//		a.myPrint();
		int count;
//		MyString ms1 = new MyString("cddcdc");
//		count = ms1.indexOf_BF_Count(new MyString("abcde"), 0);
//		System.out.println("例子1:");
//		System.out.println("indexOf_BF:");
//		System.out.println("count="+count);
//		count = ms1.indexOf_KMPB_Count(new MyString("abcde"), 0);
//		System.out.println("indexOf_KMPB:");
//		System.out.println("count="+count);
		
		MyString ms2 = new MyString("aaaaaaaa");
		count = ms2.indexOf_BF_Count(new MyString("aaaab"), 0);
		System.out.println("例子2:");
		System.out.println("indexOf_BF:");
		System.out.println("count="+count);
		count = ms2.indexOf_KMPB_Count(new MyString("aaaab"), 0);
		System.out.println("indexOf_KMPB:");
		System.out.println("count="+count);
	}
}

