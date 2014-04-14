

/**
 * This class implements a multi-level Queue, with standard operations
 *      constructor
 *      isEmpty, all queues are empty throughout the structure
 *      size, number of items on the queues
 *      enqueue, adding PrintRequest to a specified queue
 *      dequeue, from the top-level, non-empty queue
 *
 * Following specifications for the supplemental problem
 * If a dequeue operation is called k times on a non-empty quue,
 * then a PrintRequest from the next non-empty queue is promoted
 *
 
 */
public class MultiQueue
{
    private int n; // the number of queues
    private int k; //the number of dequeus from a non-empty queue 
                   // before promotion
    private int count;  // the number of PrintRequests 
    private MySimpleQueue [] queArr;

    /**
     * Constructor must know;
     * @param n, the number of queues
     * @param k, the number of dequeus from a non-empty queue 
     *           before promotion of PrintRequest at next lower non-empty queue
     */
    public MultiQueue (int n, int k)
    {
        this.n = n;
        this.k = k;
        this.count = 0;
        queArr = new MySimpleQueue [n];
        int i;
        for (i = 0; i < n; i++)
            queArr[i] = new MySimpleQueue();
    }

    /**
     * determine if none of the queues contain any queues
     */
    public boolean isEmpty ()
    {
        return (count == 0);
    }

    /**
     * @return number of items on the queue
     */
    public int size ()
    {
        return count;
    }

    /**
     * insert item on given queue
     * @param  pr, a PrintRequest
     * @param  qnum, a queue number
     * pre-condition:  0 <= qnum < number of available queues
     */
    public void enqueue (Double pr, int qnum)
    {
        if (qnum > n)
            qnum = n;
        queArr[qnum].enqueue (pr);
        count++;
    }        

    /**
     * remove the PrintRequest from the highest-level non-empty queue
     */
    public Double dequeue ()
    {
        if (isEmpty())
            return null; // no PrintRequest to return

        /* find PrintRequest to be returned, given multi-queue non-empty  */
        int topQueIndex = 0;
        while (topQueIndex < n && queArr[topQueIndex].isEmpty())
            topQueIndex++;
        Double pr = queArr[topQueIndex].dequeue ();
        int numDequeues = queArr[topQueIndex].getNumDequeues ();
        count--;

        /* in the promotion process, 
         *    promotion to one level requires working down the queues
         *    until no more promotions or no more queues
         */
        while (numDequeues > 0 && numDequeues % k == 0)
            {
                int lowerQueIndex = topQueIndex + 1;
                while (lowerQueIndex < n && queArr[lowerQueIndex].isEmpty())
                    lowerQueIndex++;
                if (lowerQueIndex == n) 
                    break; // no more queues to examine
                // move PrintRequest from queue [lowerQueIndex] 
                //                   to queue[topQueIndex] 
                Double promotePR = queArr[lowerQueIndex].dequeue ();
                queArr[topQueIndex].enqueue (promotePR);
                // after moving from queue[lowerNumIndex], 
                //   check if further promotion needed below 
                topQueIndex = lowerQueIndex;
                numDequeues = queArr[topQueIndex].getNumDequeues ();
            }
        return pr;
    }

    /**
     * String representation of a multi-queue useful for run-time tracing
     */
    public String toString ()
    {
        String str="Multi-queue: size = " + size() + "\n";
        int i;
        for (i = 0; i < n; i++)
            {
                str += "   queue " +i+ ":  " + queArr[i] + "\n";
            }
        return str;
    }
    public static void main (String args[])
    {
        /* 5 queues, promote every 3 dequeues */
        MultiQueue mq = new MultiQueue (5, 3);

        System.out.println ("Empty Queue");
        System.out.println (mq);

        /* put 5 elements on queues 0, 2, 4 */
        int i, j;
        for (i = 0; i < 15; i++)
            {
                mq.enqueue (new Double (i), 2*(i%3));
            }

        System.out.println ("5 elements on each of queues 0, 2, 4");
        System.out.println (mq);

        for (i = 0; i < 3; i++)
            {
                System.out.println ("remove 5 elements and check multi-queue");
                for (j = 0; j < 5; j++)
                    System.out.println ("   removed " + mq.dequeue());
                System.out.println ("Status of queues");
                System.out.println (mq);
            }
        System.out.println ("Final queue status");
        System.out.println (mq);
    }
}