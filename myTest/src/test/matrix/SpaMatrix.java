package test.matrix;

import test.vector.MyVector;

public class SpaMatrix {
	int rows;//行数
	int cols;//列数
	int dNum;//非零元素个数
	MyVector v;//数组
	SpaMatrix(int max){//构造函数
		rows=cols=dNum=0;
		v=new MyVector(max);//初始化数组
	}
	public void evaluate(int r,int c,int d,Three[]item)
			throws Exception{
		//给元素赋值
		rows = r;
		cols = c;
		dNum = d;
		for(int i = 0;i<d;i++){
			v.add(i,item[i]);
		}
	}
	public SpaMatrix transpose(){
		SpaMatrix a = new SpaMatrix(v.size());//构造返回对象同时初始化一个数组
		a.cols = rows;
		a.rows = cols;
		a.dNum = dNum;
		for(int i =0;i<dNum;i++){
			Three t = (Three)v.get(i);
			a.v.add(i,new Three(t.col,t.row,t.value));
		}
		return a;
	}
	public void print(){
		System.out.println("矩阵行数为:"+rows);
		System.out.println("矩阵列数为:"+cols);
		System.out.println(",非零元素个数为:"+dNum);
		System.out.println("矩阵非零元素个数三元组为:");
		for(int i = 0;i<dNum;i++){
			System.out.println("a<"+((Three)v.get(i)).row+","+((Three)v.get(i)).col+">="+((Three)v.get(i)).value);
		}
	}
}
