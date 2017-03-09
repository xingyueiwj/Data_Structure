package test.matrix;

import test.vector.MyVector;

public class Matrix {
	private MyVector values;
	private int h;
	private int w;
	public Matrix(int h,int w){
		if(!(h>0&&w>0)){
			throw new ArrayIndexOutOfBoundsException("h or w <"+1);
		}
		values = new MyVector(h);
		for(int i=0;i<h;i++){
			MyVector row = new MyVector(w);
			values.add(row);
			for(int j=0;j<w;j++){
				row.add(null);
			}
		}
		this.h = h;
		this.w = w;
	}
	public void set(int row,int col,Object value){
		if(!(row>=0&&w>0&&row<h&&col<w)){
			throw new ArrayIndexOutOfBoundsException("h or w <"+"-1");
		}
		MyVector selrow = (MyVector)values.get(row);
		selrow.set(row, value);
	}
	public Object get(int row,int col){
		if(!(row >= 0&&w>=0&&row<h&&col<w)){
			throw new ArrayIndexOutOfBoundsException("h or w<"+"-1");
		}
		MyVector selrow = (MyVector)values.get(row);
		return selrow.get(col);
	}
	public int width(){
		return w;
	}
	public int height(){
		return h;
	}
	public Matrix add(Matrix b){
		if(height() != b.height()||width()!=b.width()){
			throw new ArrayIndexOutOfBoundsException("Matrix error");
		}
		Matrix result = new Matrix(height(),width());
		for(int i=0;i<height();i++){
			for(int j=0;j<width();j++){
				Integer i1 = (Integer)get(i,j);
				Integer i2 = (Integer)(b.get(i, j));
				result.set(i, j, new Integer(i1.intValue()+i2.intValue()));
			}
		}
		return result;
	}
	public void print(){
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				System.out.println(get(i,j)+" ");
			}
			System.out.println();
		}
	}
}






















