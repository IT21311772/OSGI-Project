package osgi_servicepublisher;

public class QueueX {

	private int[] queArray;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;
	
	public QueueX(int S) {
		maxSize = S;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		setnItems(0);
	}
	
	
	public void insert(int j) {
		if(rear == maxSize - 1) {
			
			System.out.println("Allocated Queue is Full for this Quarter/ Allocated Stock is overved");
			
		}else {
			queArray[++rear] = j;
			setnItems(getnItems() + 1);
			
		}
		
	}
	
	public int remove() {
		
		if(getnItems() == 0 ) {
			System.out.println("No items Are available!");
			return -99;
		}else {
			setnItems(getnItems() - 1);
			System.out.println("You have taken an Item out");
			return queArray[front++];
		}
		
		
	}


	public int getnItems() {
		return nItems;
	}


	public void setnItems(int nItems) {
		this.nItems = nItems;
	}


}
