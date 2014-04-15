
public class Simulation {

	public static void main(String[] args) {

		/*initialize 1000 time slots*/

		double lambda = 0.02;
		double p = 1;

		int numServers = 1;
		int numQueues = 1;

		/*initialize the queues
		 * */
		//testing with 1 queue first

		MyQueue queue = new MyQueue(lambda);
		System.out.println(queue);


		/*initialize connectivity matrix
		 * i.e. queue n is connected to queue k
		 * */
		boolean[][] matrix = new boolean[numServers][numQueues];

		for(int n = 0; n < numServers ; n++){
			for(int k = 0 ; k < numQueues ; k++){
				if(Math.random() <= p){
					matrix[n][k] = true;
				}
				else{
					matrix[n][k] = false;
				}

			}
		}
		
		/*Simulate*/
		
		

	}

}
