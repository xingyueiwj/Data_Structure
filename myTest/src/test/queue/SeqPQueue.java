package test.queue;

public class SeqPQueue {
	static final int defaultSize = 10;
	int front;
	int rear;
	int count;
	int maxSize;
	Element[]data;
	public SeqPQueue(){
		this.initiate(defaultSize);
	}
	public SeqPQueue(int sz){
		this.initiate(sz);
	}
	private void initiate(int sz){
		maxSize = sz;
		front = rear = 0;
		count = 0;
		data = new Element[sz];
	}
	public void append(Object obj)throws Exception{
		if(count>=maxSize){
			throw new Exception("队列已满!");
		}
		data[rear] = (Element)obj;
		rear = rear + 1;
		count++;
	}
	public Element delete()throws Exception{
		if(count==0){
			throw new Exception("队列已空!");
		}
		//寻找优先级高的数据元素
		Element min = data[0];
		int minIndex = 0;
		for(int i=0;i<count;i++){
			if(data[i].getPriority()<min.getPriority()){
				min = data[i];
				minIndex = i;
			}
		}
		//移位
		for(int i=minIndex+1;i<count;i++){
			data[i-1] = data[i];
		}
		rear = rear-1;
		count--;
		return min;
	}
	public Object getFront()throws Exception{
		if(count==0){
			throw new Exception("队列已空!");
		}
		Element min = data[0];
		int minIndex = 0;
		for(int i=0;i<count;i++){
			if(data[i].getPriority()<min.getPriority()){
				min = data[i];
				minIndex = i;
			}
		}
		return min;
	}
	public boolean notEmpty(){
		return count!=0;
	}
}
