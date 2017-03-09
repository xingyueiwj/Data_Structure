package test.matrix;

/**
 * 三元组类
 * @author Administrator
 *
 */
public class Three {
	public int row;
	public int col;
	public double value;
	public Three(int r,int c,double v){
		row = r;
		col = c;
		value = v;
	}
	Three(){
		this(0, 0, 0.0);
	}
}
