package test.stack;

/**
 * 使用数组制作的顺序堆栈
 * @author Administrator
 *
 */
public class TestStack {
	public static void main(String[] args) {
		SeqStack myStack = new SeqStack();
		int test[] = {1,3,5,7,9};
		int n = 5;
		try{
			for(int i=0;i<n;i++){
				myStack.push(new Integer(test[i]));
			}
			System.out.println("栈顶元素:-->"+myStack.getTop());
			System.out.println("出栈顺序为:-->");
			while(myStack.notEmpty()){
				System.out.println(myStack.pop()+" ");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
