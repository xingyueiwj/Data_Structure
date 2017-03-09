package test.array;

public class LinList {
	Node head;
	Node current;
	int size;
	LinList(){
		head = current=new Node(null);
		size=0;
	}
	public void index(int i)throws Exception{
		if(i<-1||i>size-1){
			throw new Exception("参数错误！");
		}
		if(i==-1){
			return;
		}
		current = head.next;
		int j = 0;
		while((current!=null)&&j<i){
			current = current.next;
			j++;
		}
	}
	
	public void insert(int i,Object obj)throws Exception{
		if(i<0||i>size){
			throw new Exception("参数错误");
		}
		index(i-1);
		current.setNext(new Node(obj,current.next));
		size++;
	}
	public Object delete(int i)throws Exception{
		if(size==0){
			throw new Exception("没有可以删除的元素");
		}
		if(i<0||i>size-1){
			throw new Exception("参数错误");
		}
		index(i-1);
		Object obj = current.next.getElement();
		current.setNext(current.next.next);
		size--;
		return obj;
	}
	public Object getData(int i)throws Exception{
		if(i<-1||i>size-1){
			throw new Exception("参数错误");
		}
		index(i);
		return current.getElement();
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
}
