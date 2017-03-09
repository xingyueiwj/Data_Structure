package test.queue;

public class Element {
	private Object elem;
	private int priority;
	Element(Object obj,int i){
		elem = obj;
		priority = i;
	}
	public Object getElem() {
		return elem;
	}
	public void setElem(Object elem) {
		this.elem = elem;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
