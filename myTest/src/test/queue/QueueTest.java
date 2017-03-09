package test.queue;

import test.stack.SeqStack;

/**
 * 队列的应用,使用队列和堆栈的特性
 * @author Administrator
 *
 */
public class QueueTest {
	public static void huiwen(String str)throws Exception{
		int n = str.length();
		SeqStack myStack = new SeqStack();
		SeqQueue myQueue = new SeqQueue();
		for(int i=0;i<n;i++){
			myQueue.append(str.substring(i, i+1));
			myStack.push(str.substring(i, i+1));
		}
//		for(int j=0;j<n/2;j++){
//			if(!myQueue.delete().equals(myStack.pop())){
//				System.out.println(str+"不是回文!");
//				return;
//			}
//		}
//		System.out.println(str+"是回文!");
		while(myQueue.notEmpty()&&myStack.notEmpty()){
			if(!myQueue.delete().equals(myStack.pop())){
				System.out.println(str+"不是回文!");
				return;
			}
		}
		System.out.println(str+"是回文!");
	}
	
	public static void main(String[]args){
		String str1 = "ABCDEDCBA";
		String str2="ABCDEDBAC";
		try{
			long currentTimeMillis = System.currentTimeMillis();
			for(int i=0;i<1001;i++){
				huiwen(str1);
				huiwen(str2);
			}
			long currentTimeMillis1 = System.currentTimeMillis();
			System.out.println((currentTimeMillis1-currentTimeMillis));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
