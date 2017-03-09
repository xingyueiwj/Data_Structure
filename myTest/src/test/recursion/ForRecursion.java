package test.recursion;

public class ForRecursion {
	public static long fib2(int n){
		long oneBack,twoBack,current = 0;
		int i;
		if(n==0||n==1){
			return n;
		}else{
			oneBack = 1;
			twoBack = 0;
			for(i=2;i<=n;i++){
				current = oneBack + twoBack;
				System.out.println(current);
				twoBack = oneBack;
				oneBack = current;
			}
			return current;
		}
	}
	public static void main(String[] args) {
		fib2(5);
	}
}
