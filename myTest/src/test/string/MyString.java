package test.string;

/**
 * 字符串类的设计
 * @author Administrator
 *
 */
public class MyString {
	private char[]value;
	private int count;
	/**
	 * 字符串copy
	 * @param src
	 * @param srcPos
	 * @param dst
	 * @param dstPos
	 * @param length
	 */
	static void arrayCopy(char[]src,int srcPos,char[]dst,int dstPos,int length){
		if(src.length-srcPos<length||dst.length-dstPos<length){
			throw new StringIndexOutOfBoundsException(length);
		}
		for(int i=0;i<length;i++){
			dst[dstPos++] = src[srcPos++];
		}
	}
	//构造函数1
	public MyString(){
		value = new char[0];
		count=0;
	}
	//构造函数2
	/**
	 * 用value数组中从offset下标开始,个数为count的字符串创建对象
	 * @param value
	 * @param offset
	 * @param count
	 */
	public MyString(char[]value,int offset,int count){
		if(offset<0){
			throw new StringIndexOutOfBoundsException(count);
		}
		if(count<0){
			throw new StringIndexOutOfBoundsException(offset+count);
		}
		this.value = new char[count];
		this.count = count;
		arrayCopy(value,offset,this.value,0,count);
	}
	//构造函数3
	public MyString(char[]value){
		this.count = value.length;
		this.value = new char[count];
		arrayCopy(value,0,this.value,0,count);
	}
	//构造函数4,初始化字符串
	public MyString(String str){
		char[]chararray = str.toCharArray();
		value = chararray;
		count = chararray.length;
	}
	//取字符
	public char charAt(int index){
		if((index<0)||(index>=count)){
			throw new StringIndexOutOfBoundsException(index);
		}
		return value[index];
	}
	//取长度
	public int length(){
		return count;
	}
	//比较
	public int compareTo(MyString anotherString){
		int len1 = count;
		int len2 = anotherString.count;
		int n = Math.min(len1, len2);
		char v1[] = value;
		char v2[] = anotherString.value;
		int k = 0;
		int lim = n;
		while(k<lim){
			char c1 = v1[k];
			char c2 = v2[k];
			if(c1!=c2){
				return c1-c2;
			}
			k++;
		}
		return len1-len2;
	}
	//取子串
	public MyString substring(int beginIndex,int endIndex){
		if(beginIndex<0){
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if(endIndex>count){
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		if(beginIndex>endIndex){
			throw new StringIndexOutOfBoundsException(endIndex-beginIndex);
		}
		return ((beginIndex==0&&(endIndex==count))?
		this:new MyString(value,beginIndex,endIndex-beginIndex));
	}
	public MyString substring(int beginIndex){
		return substring(beginIndex,count);
	}
	public MyString concat(MyString str){
		int otherLen = str.length();
		char[]strarray = str.toArray();
		if(otherLen==0){
			return this;
		}
		char buf[] = new char[count+otherLen];
		arrayCopy(value,0,buf,0,count);//原来的字符
		arrayCopy(strarray,0,buf,count,otherLen);//新加的字符
		return new MyString(buf);//覆盖当前对象
	}
	public MyString insert(MyString str,int pos){
		if(pos<0||pos>count){
			throw new StringIndexOutOfBoundsException(pos);
		}
		if(pos!=0){
			MyString str1 = this.substring(0,pos);
			MyString str2 = this.substring(pos);
			MyString res1 = str1.concat(str);
			MyString res2 = res1.concat(str2);
			return res2;
		}else{
			return str.concat(this);
		}
	}
	
	public MyString delete(int beginIndex,int endIndex){
		if(beginIndex<0){
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if(endIndex>count){
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		if(beginIndex>endIndex){
			throw new StringIndexOutOfBoundsException(endIndex-beginIndex);
		}
		if((beginIndex==0)&&(endIndex==count)){
			return new MyString();
		}else{
			MyString str1 = this.substring(0,beginIndex);
			MyString str2 = this.substring(endIndex);
			return str1.concat(str2);
		}
	}
	public void myPrint(){
		for(int i=0;i<count;i++){
			System.out.print(value[i]);
		}
		System.out.println();
	}
	public char[]toArray(){
		char[] buf = new char[count];
		arrayCopy(value,0,buf,0,count);
		return buf;
	}
	
	/**
	 * 模式匹配算法一
	 * @param subStr
	 * @param start
	 * @return
	 */
	public int indexOf_KMPA(MyString subStr,int start){
		int[] next = getNext(subStr);
		int i = start,j=0,v;
		while(i<this.length()&&j<subStr.length()){
			if(j==-1||this.charAt(i)==subStr.charAt(j)){
				i++;
				j++;
			}else{
				j=next[j];
			}
		}
		if(j==subStr.length()){
			v=i-subStr.length();
		}else{
			v=-1;
		}
		return v;
	}
	
	/**
	 * 模式匹配算法二
	 * @param
	 * @return
	 */
	public int indexOf_KMPB(MyString subStr,int start){
		int[] next = getNext(subStr);
		int i = start,j=0,v;
		while(i<this.length()&&j<subStr.length()){
			if(this.charAt(i)==subStr.charAt(j)){
				i++;
				j++;
			}else if(j==0){
				i++;
			}else{
				j = next[j];
			}
		}
		if(j==subStr.length()){
			v = i-subStr.length();
		}else{
			v = -1;
		}
		return v;
	}
	private int[] getNext(MyString str) {
		int j = 1,k=0;
		int [] next = new int[str.length()];
		next[0] = -1;
		next[1] = 0;
		while(j<str.length()-2){
			if(str.charAt(j)==str.charAt(k)){
				next[j+1] = k+1;
				j++;
				k++;
			}else if(k==0){
				next[j+1] = 0;
				j++;
			}else{
				k = next[k];
			}
		}
		return next;
	}
	
	public int indexOf_BF_Count(MyString subStr,int start){
		int i = start,j = 0,v;
		int count = 0;
		while(i<this.length()&&j<subStr.length()){
			if(this.charAt(i)==subStr.charAt(j)){
				i++;
				j++;
			}else{
				i = i-j+1;
				j=0;
			}
			count++;
		}
		return count;
	}
	
	public int indexOf_KMPB_Count(MyString subStr,int start){
		int [] next = getNext(subStr);
		int i = start,j = 0,v;
		int count = 0;
		while(i<this.length()&&j<subStr.length()){
			if(this.charAt(i)==subStr.charAt(j)){
				i++;
				j++;
			}else if(j==0){
				i++;
			}else{
				j = next[j];
			}
			count++;
		}
		return count;
	}
}
