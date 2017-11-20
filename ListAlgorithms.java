import java.util.HashSet;
import java.util.Iterator;


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

        Node<Integer> previous = list.head;
        Node<Integer> current1 = list.head;
        Node<Integer> current2 = previous.next;

        while (current1 != null) {
            while (current2 != null) {
                if (current2.data.compareTo(current1.data) == 0) {
                    previous.next = current2.next;
                    current2 = current2.next;
                }
                else {
                    previous = current2;
                    current2 = current2.next;
                }
            }
            current1 = current1.next;
        }
        return list;

    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = {1,2,1,2,1,2,3,4,5,6,6,7,6,8,9,8,9};
        for (int i: arr) {
            list.insert(i);
        }

        LinkedList<Integer>listNoDups = removeDuplicates(list);
        System.out.println(list.toString());

        listNoDups = removeDuplicatesNoDS(list);
        System.out.println(list.toString());

    }

}