package test.recursion;

public class Tower {
	public static void towers(int n,char fromPeg,char toPeg,char auxPeg){
		if(n==1){
			System.out.println("move disk 1 from peg "+fromPeg+" to peg "+toPeg);
			return;
		}
		towers(n-1,fromPeg,auxPeg,toPeg);
		System.out.println("move disk "+n+" from peg "+fromPeg+" toPeg "+toPeg);
		towers(n-1,auxPeg,toPeg,fromPeg);
	}
	public static void main(String[]args){
		towers(4,'A','C','B');
	}
}
