import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.function.Supplier;
import java.lang.Math.*;



class LinkedLists {

    public static void main(String[] args) {
        Node head = new Node(RandomBig());
        List<Node> LinkedListPre = new ArrayList<Node>(); 
        LinkedListPre.add(head);
        Double Big = RandomBig();
        int i;
        Node current = head;
        for (i=0; i < Big; i++) {
            Node Node2 = new Node(RandomBig());
            current.next = Node2;
            current = Node2;
            LinkedListPre.add(Node2);
        }
  

        int length_of_linked_list = LinkedListPre.size();
        Double head_data = head.data;
        System.out.println(String.format("Successfully created linked list with %d nodes.\nThe root contains the data -> int data:  %d", length_of_linked_list, head_data));
    }

    public static int CountNodes(Node root) {
        Node current = root;
        Node next;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    
    public static List GenerateRandomLinkedList() {
        List<Node> Nodes = new ArrayList<Node>();
        int iterations = (int) Math.round(RandomBig()) + 1;
        int i;
        for (i=0; i < iterations; i++) {
            Nodes.add(CreateNodeRandom());
        }
        return Nodes;
    }
    public static Double RandomBig() {
        Double random_1 = Math.random();
        Double oneth = Math.floor(random_1 * 100.00 + 1.00 - random_1);
        return oneth;
    }
    private static Node CreateNodeRandom() {
        Node node = new Node(RandomBig());
        return node;
    }
    
    public static class Node {
        Double data;
        public Node(Double data) {
            data = data;
        }
        Node next;
        public void setData(Double data) {
            data = data;
        }
        public Double getData() {
            return data;
        }
    }
    
}

