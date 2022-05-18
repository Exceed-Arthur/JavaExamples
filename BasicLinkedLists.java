import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.ArrayList.size;
class LinkedLists {
    public static void Main(String[] args) {
        RandomLinkedList LinkedListInstance = new RandomLinkedList();
        List<Node> LinkedList = LinkedListInstance.Nodes;
        Node head = LinkedList.head;
        int length_of_linked_list = LinkedList.Size();
        int head_data = head.data;
        System.out.println(String.format("Successfully created linked list with %d nodes.\nThe root contains the data -> int data:  %d", length_of_linked_list, head_data));
    }
    public class Node {
        public Node(int data) {
            this.data = data;
        }

        Node next;
        public static void setData(int data) {
            this.data = data;
        }
        public static int getData() {
            return this.data;
        }
    }
    public static int CountNodes(Node root) {
        Node current = root;
        Node next;
        int count = 0;
        while current.next != null {
            current = current.next;
            count++;
        }
        return count;
    }
    public class RandomLinkedList {
        public RandomLinkedList() {
        } // Empty Constructor Function
        Node head = new Node();
        this.head = head;
        list<Node> Nodes = new ArrayList<Node>();
        Nodes.add(head);
        List LinkedList2 = GenerateRandomLinkedList; 
        Collections.addAll(Nodes, LinkedList2.toArray());
        this.Nodes = Nodes;
    }
        
    public static List GenerateRandomLinkedList() {
        List<Node> Nodes = new ArrayList<Node>();
        int iterations = RandomBig() + 1;
        int i;
        for (i=0, i < iterations, i++) {
            Nodes.add(CreateNodeRandom());
        }
        return Nodes;
    }
    public static Int RandomBig() {
        random_1 = Math.Random();
        Int oneth = Math.floor(random_1 * 100 + 1 - random_1);
        return oneth;
    }
    public static Node CreateNodeRandom() {
        return Node(RandomBig());
    }
    
}
