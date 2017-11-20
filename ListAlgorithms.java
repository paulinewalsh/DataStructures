import java.util.HashSet;
import java.util.Iterator;

/* These problems are all taken from Cracking the Coding Interview, 5th Ed */
public class ListAlgorithms {


    /* Remove duplicates from unsorted linked list. 
       Time: O(n) - n operations to traverse list, constant to add and access hashset
       Space: O(n) auxiliary space required
    */
    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {

        Node<Integer> previous = list.head;
        Node<Integer> current = previous;
        HashSet<Integer> map = new HashSet<>();

        while (current != null) {
            if (map.contains(current.data)) {
                previous.next = current.next;
                current = current.next;
            }
            else {
                map.add(current.data);
                previous = current;
                current = current.next;
            }   
        }
        return list;
    }

    /* Remove duplicates without auxiliary data structure.
       Only solution is brute force.
       O(n^2) to check each entry against every other entry
    */
    public static LinkedList<Integer> removeDuplicatesNoDS(LinkedList<Integer> list) {

        Node<Integer> current1 = list.head;

        while (current1 != null) {
            Node<Integer> current2 = current1;
            while (current2.next != null) {
                // System.out.println(current2.data);
                if (current2.next.data.compareTo(current1.data) == 0) {
                    current2.next = current2.next.next;
                }
                else {
                    current2 = current2.next;                
                }
            }
            current1 = current1.next;
        }
        return list;
    }

    /* Get kth to last node.
        Time complexity: O(n) -- n operations to find length, then either n-k or n/2 + k to get that node. */
    public static Node<Integer> getKthToLast(LinkedList<Integer> list, int k) {

        Node<Integer> slow = list.head;
        Node<Integer> fast = list.head;
        int length = 0;
        int slowIndex = 0;

        while (fast != null) {
            if (fast.next == null) 
                break;// end of list
            fast = moveFast(fast); 
            slow = slow.next;
            slowIndex++;
            if (fast == null)  { //end of list
                length +=1;
                break;
            }
            else {
                length +=2;
            }        
        }

        int index = length - k + 1;
        Node<Integer> target = getNode(list, slow, slowIndex, index);
        return target;
        
      
    }

    public static Node<Integer> getNode(LinkedList<Integer> list, Node<Integer> current, int currentIndex, int targetIndex) {
        // If slow pointer has already passed index, we need to traverse the beginning of the list again.
        if (targetIndex - currentIndex < 0) {
            current = list.head;
            for (int i = 1; i <= targetIndex; i++) {
               current = current.next;
            }
        }
        else {
            while (currentIndex <= targetIndex) {
                current = current.next;
                currentIndex++;
            }
        }
        return current;
    }

    public static Node<Integer> moveFast(Node<Integer> current) {
        current = current.next;
        if (current != null)
            current = current.next;
        return current;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2,3,4,5,6,6,7,6,8,9,8,9};

        LinkedList<Integer> list = new LinkedList<>();
        for (int i: arr) {
            list.insert(i);
        }

        list = removeDuplicates(list);
        System.out.println(list.toString());

        list = new LinkedList<>();
        for (int i: arr) {
            list.insert(i);
        }

        list = removeDuplicatesNoDS(list);
        System.out.println(list.toString());


        Node<Integer> n = getKthToLast(list, 3);
        System.out.println(n.data);

        n = getKthToLast(list, 8);
        System.out.println(n.data);

    }

}