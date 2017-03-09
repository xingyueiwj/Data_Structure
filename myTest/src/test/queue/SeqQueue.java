package test.queue;

public class SeqQueue implements Queue{
	static final int defaultSize = 10;
	int front;
	int rear;
	int count;
	int maxSize;
	Object data[];
	public SeqQueue(){
		initiate(defaultSize);
	}
	public SeqQueue(int sz){
		initiate(sz);
	}
	private void initiate(int sz) {
		maxSize = sz;
		front = rear = 0;
		count = 0;
		data = new Object[sz];
	}
	@Override
	public void append(Object obj) throws Exception {
		if(count>0&&front==rear){
			throw new Exception("队列已满!");
		}
		data[rear] = obj;
		rear = (rear+1)%maxSize;
		count++;
	}

	@Override
	public Object delete() throws Exception {
		if(count==0){
			throw new Exception("队列已空!");
		}
		Object temp = data[front];
		front = (front+1)%maxSize;
		count--;
		return temp;
	}

	@Override
	public Object getFront() throws Exception {
		if(count==0){
			throw new Exception("队列已空!");
		}
		return data[front];
	}

	@Override
	public boolean notEmpty() {
		return count!=0;
	}
	
}
