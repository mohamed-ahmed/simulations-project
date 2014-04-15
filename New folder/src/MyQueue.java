import java.util.ArrayList;


public class MyQueue {

	private double lambda;
	private ArrayList<TimeSlot> list;
	private int length;


	/*
	 * @param numSevers - number of servers 
	 * @param p - connectivity probability
	 * @param lambda - arrival probability
	 */
	public MyQueue(double lambda){
		this.lambda = lambda;
		list = new ArrayList<TimeSlot>();
		
		for(int i = 0 ; i < 1000 ; i++){
			list.add(new TimeSlot());
		}
		
		for(int i = 0; i < list.size() ; i++){
			initializeTimeSlot(list.get(i));
		}

		
	}




	/**
	 * Initializes time slot with given probabilities for given number of servers;
	 */

	private void initializeTimeSlot(TimeSlot slot){
		if(Math.random() <= lambda){
			slot.arrival = true;			
		}
		else{
			slot.arrival = false;
		}

		
	}
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}



}
