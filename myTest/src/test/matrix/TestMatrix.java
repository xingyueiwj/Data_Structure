package test.matrix;

public class TestMatrix {
	public static void main(String[] args) {
		 Matrix mt1 = new Matrix(3,4);
		 for(int i = 0;i<mt1.height();i++){
			 for(int j=0;j<mt1.width();j++){
				 mt1.set(i, j, new Integer(i+j));
			 }
		 }
		 Matrix mt2 = new Matrix(3,4);
		 for(int i = 0;i<mt2.height();i++){
			 for(int j=0;j<mt2.width();j++){
				 mt2.set(i, j, new Integer((int)(Math.random()*10)));
			 }
		 }
		 System.out.println("Matrix1:");
		 mt1.print();
		 System.out.println("Matrix2:");
		 mt2.print();
		 Matrix mt3 = mt2.add(mt1);
		 System.out.println("results after adding:");
		 mt3.print();
	}
}
