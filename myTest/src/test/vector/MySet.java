package test.vector;

public class MySet {
	private MyVector values = new MyVector();

	public void add(Object obj) {
		if (obj == null) {
			return;
		}
		if (values.indexOf(obj) > 0) {
			values.add(obj);
		}
	}

	public void remove(Object obj) {
		values.remove(obj);
	}

	public boolean contain(Object obj) {
		return values.contain(obj);
	}

	public boolean include(Object obj) {
		if (obj instanceof MySet) {
			MySet set = (MySet) obj;
			int counter = 0;
			while (counter < values.size()) {
				Object temp = values.get(counter);
				counter++;
				if (!contain(temp)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	public boolean equals(Object obj){
		if(obj instanceof MySet){
			MySet set = (MySet)obj;
			if(include(set)&&set.include(this)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public int size(){
		return values.size();
	}
	public boolean isEmpty(){
		return values.size()>0;
	}
	public void print(){
		int counter = 0;
		while(counter<values.size()){
			System.out.println(values.get(counter)+" ");
			counter++;
		}
	}
}
