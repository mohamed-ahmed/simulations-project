import java.util.ArrayDeque;
/**
 * This class implements a simple Queue, with standard operations
 *      constructor
 *      isEmpty
 *      enqueue, dequeue
 * In addition, this queue keeps track of the number of times the 
 * dequeue operation has been called since the las time the queue was empty
 *
 * In keeping with the supplemental problem, this queue only holds
 * PrintRequests!
 *
 * @author  Henry M. Walker
 * @version 22 April 2013
 * @see     http://www.cs.grinnell.edu/~walker/courses/207.sp13/suppl-prob.shtml#3
 */
public class MySimpleQueue
{
    /**
     * Although this class could be a subclass of library class, most
     * Java library classes come with an extensive collection of operations
     * This class provides a stripped down interface
     */

    private ArrayDeque<Double> que;
    private int numDequeuesSinceEmpty;
        
    public MySimpleQueue ()
    {
        que = new ArrayDeque<Double> ();
        numDequeuesSinceEmpty = 0;
    }

    /** 
     * @return number of dequeue operations since queue was empty
     */
    public int getNumDequeues ()
    {
        return numDequeuesSinceEmpty;
    }

    /**
     * @return true if queue is empty; false otherwise
     */
    public boolean isEmpty ()
    {
        return que.isEmpty();
    }

    /**
     * @param PrintRequest to be added to the queue
     */
    public void enqueue(Double pr)
    {
        que.addLast (pr);
    }

    /**
     * @return head of queue, or null if no head exists
     */
    public Double dequeue ()
    {
        if (que.isEmpty())
            {
                numDequeuesSinceEmpty = 0;
                return null;
            }
        Double pr = que.removeFirst();
        if (que.isEmpty())
            numDequeuesSinceEmpty = 0;
        else
            numDequeuesSinceEmpty++;
        return pr;
    }

    /**
     * String representation of a Queue useful for run-time tracing
     * Elements listed from tail of queue to head
     */
    public String toString ()
    {
        String str = "(";
        String separator = "";
        for (Double pr: que)
            {
                str += separator + pr;
                separator = " ";
            }
        str += ")";
        return str;
    }

    /**
     * Testing for MySimpleQueue
     */
    public static void main (String args [])
    {
        MySimpleQueue queue = new MySimpleQueue ();
        int i;
        System.out.println ("Checking initialization ");
        System.out.println ("   queue empty:" + queue.isEmpty());
        System.out.println ("   dequeues since empty:  " 
                                               + queue.getNumDequeues ());
 
        System.out.println ("Enqueue 5 items");
        for (i = 1; i <= 5; i++)
            {
                queue.enqueue (new Double(i));
                System.out.println ("enqueue #" + i);
                System.out.println ("   queue empty: " + queue.isEmpty());
                System.out.println ("   dequeues since empty:  " 
                                               + queue.getNumDequeues ());
            }

        System.out.println ("Current Queue: " + queue);

        System.out.println ("now dequeue 6 items");
          for (i = 1; i <= 5; i++)
            {
        	  Double pr = queue.dequeue ();      
                System.out.println ("   item dequeued:  " + pr);
                System.out.println ("   queue empty: " + queue.isEmpty());
                System.out.println ("   dequeues since empty:  " 
                                               + queue.getNumDequeues ());
            }


    }
}