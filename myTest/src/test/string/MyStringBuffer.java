package test.string;

public class MyStringBuffer {
	private char[] value;
	private int count;
	private void expandCapacity(int newCapacity){
		char newValue[] = new char[newCapacity];
		arrayCopy(value,0,newValue,0,count);
	}
	//数组copy
	static void arrayCopy(char[]src,int srcPos,char[]dst,int dstPos,int length){
		if(src.length-srcPos<length||dst.length-dstPos<length){
			throw new StringIndexOutOfBoundsException(length);
		}
		for(int i=0;i<length;i++){
			dst[dstPos++] = src[srcPos++];
		}
	}
	//构造函数
	public MyStringBuffer(String str){
		char[] chararray = str.toCharArray();
		value = chararray;
		count = chararray.length;
	}
	public MyStringBuffer concat(MyStringBuffer str){
		int otherLen = str.length();
		if(otherLen==0){
			return this;
		}
		expandCapacity(count+otherLen);
		arrayCopy(str.toArray(),0,this.toArray(),this.length(),str.length());
		count = count + otherLen;
		return this;
	}
	public char[]toArray(){
		return value;
	}
	public int length(){
		return count;
	}
	public void myPrint(){
		for(int i=0;i<count;i++){
			System.out.println(value[i]);
		}
		System.out.println();
	}
}
