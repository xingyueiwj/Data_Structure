package test.array;


public class SeqList{
	final int defaultSize = 0;
	int maxSize;
	public int size;
	Object[]listArray;
	public SeqList(){
		initiate(defaultSize);
	}
	public SeqList(int size){
		initiate(size);
	}
	private void initiate(int sz){
		maxSize = sz;
		size = 0;
		listArray = new Object[sz];
	}
	public void insert(int i,Object obj)throws Exception{
		if(size==maxSize){
			throw new Exception("顺序表已经满了");
		}
		if(i<0||i>size){
			throw new Exception("插入位置参数错误");
		}
		for(int j = size;j>i;j--){
			listArray[j] = listArray[i];
		}
		listArray[i]=obj;
		size++;
	}
	public Object delete(int i) throws Exception{
		if(size==0){
			throw new Exception("顺序表已空，无法删除");
		}
		if(i<0||i>size){
			throw new Exception("删除位置参数错误");
		}
		Object it = listArray[i];
		for(int j=i;j<size-1;j++){
			listArray[j] = listArray[j+1];
		}
		size--;
		return it;
	}
	public int MoreDataDelete(SeqList L,Object x)throws Exception{
		int i,j;
		int tag = 0;
		for(i=0;i<L.size();i++){
			if(x.equals(L.get(i))){
				L.delete(i);
				i--;
				tag = 1;
			}
		}
		return tag;
	}
	private Object get(int i)throws Exception {
		if(i<0||i>size){
			throw new Exception("获取的位置错误");
		}
		return listArray[i];
	}
	private int size() {
		return size;
	}
	public Object getData(int i) {
		return listArray[i];
	}
}
