
public class MyQueue {
	
	int numServers;
	
	public MyQueue(int numSevers, int p, int lambda){
		this.numServers = numServers;
		this.p = p;
		this.lambda = lambda;
	}
	
	ArrayList<AClass> list = new ArrayList<AClass>();
	
	for(int i = 0; i < List.length() ; i++){
		initializeTimeSlot(list[i]);
	}
	
	
	/**
	 * Initializes time slot with given probabilities for given number of servers;
	 * @param numSevers - number of servers 
	 * @param p - connectivity probability
	 * @param lambda - arrival probability
	 */
	private void initializeTimeSlot(AClass slot){
		if(Math.random() < lambda){
			slot.arrival = true;
		}
		
	}

}
