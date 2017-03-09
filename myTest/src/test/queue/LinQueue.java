package test.queue;

import test.array.Node;

public class LinQueue implements Queue
{
	Node front;
	Node rear;
	int count;
	public LinQueue(){
		initiate();
	}
	public LinQueue(int sz){
		initiate();
	}
	private void initiate(){
		front = rear = null;
		count = 0;
	}
	
	@Override
	public void append(Object obj) throws Exception {
		Node newNode = new Node(obj,null);
		if(rear!=null){
			rear.next = newNode;
		}
		rear = newNode;
		if(front==null){
			front = newNode;
		}
		count++;
	}

	@Override
	public Object delete() throws Exception {
		if(count==0){
			throw new Exception("队列已空!");
		}
		Node temp = front;
		front = front.next;
		count--;
		return temp.getElement();
	}

	@Override
	public Object getFront() throws Exception {
		if(count==0){
			throw new Exception("队列已空!");
		}
		return front.getElement();
	}

	@Override
	public boolean notEmpty() {
		return count!=0;
	}

}
