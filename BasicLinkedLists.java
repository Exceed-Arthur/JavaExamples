import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.function.Supplier;
import java.lang.Math.*;

class LinkedLists {

    public static void main(String[] args) {
        int pre_int1 = (int) Math.round(Math.floor(Math.random() * 99999.99));
        Double random1 = RandomBig();
        Node head = new Node(random1, "Head");
        List<Node> LinkedListPre = new ArrayList<Node>(); 
        LinkedListPre.add(head);
        int i = 0;
        Node current = head;
        
        System.out.println(String.format("\nInitializing LinkedList Tutorial Demo...\n________________________________________________________________\n\n%d. Created Root Node with Data: %.2f", (i+1), random1));
        for (i=0; i < random1; i++) {
            int pre_int = (int) Math.round(Math.floor(Math.random() * 99999.99));
            String Name = String.valueOf(pre_int);
            Double random = RandomBig();
            Node Node2 = new Node(random, Name);
            current.next = Node2;
            current = Node2;
            LinkedListPre.add(Node2);
            System.out.println(String.format("%d. Created Node %s -> Current Data: %.2f", (i+2), Node2, random));
        }
        int length_of_linked_list = LinkedListPre.size();
        Double head_data = head.data;
        System.out.println(String.format("\n\nSuccessfully created linked list with %d nodes.\nThe root contains the data -> int data:  %.2f", length_of_linked_list, head_data));
        int ij;
        System.out.println("\nInitializing Graph Traversal!\n_______________________________________________\n");
        for (ij=0; ij<length_of_linked_list; ij++) {
            Node node = LinkedListPre.get(ij);
            try {
            System.out.println(String.format("%d. Current Node: (%s=%.2f  -<- Next Node -> (%s=%.2f)", (ij+1), node, node.data, node.next, node.next.data));
            } catch (Exception e) {
                System.out.println(String.format("%d. Current Node: (%s=%.2f)  -<- Next Node -> %s", (ij+1), node, node.data, null));
            }
        }
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
        int pre_int = (int) Math.round(Math.floor(Math.random() * 99999.99));
        String Name = String.valueOf(pre_int);
        Node node = new Node(RandomBig(), Name);
        return node;
    }
    
    public static class Node {
        Double data;
        String name;
        public Node(Double data, String name) {
            this.data = data;
            this.name = name;
        }
        Node next;
        public void setData(Double data) {
            this.data = data;
        }
        public Double getData() {
            return data;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Double getName() {
            return data;
        }
    }
}

