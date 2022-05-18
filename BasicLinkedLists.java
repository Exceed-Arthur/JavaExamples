import java.util.*;
import java.lang.Math.*;

class LinkedLists {

    public static void main(String[] args) {
        int pre_int1 = (int) Math.round(Math.floor(Math.random() * 99999.99)); // Generate a random number between 0 and 100 as a decimal
        Double random1 = RandomBig(); // Create Random Number as Data
        Node head = new Node(random1, "Head"); // Create root node with that random data
        List<Node> LinkedListPre = new ArrayList<Node>(); // Instantiate List to add our Nodes to for easy reading
        LinkedListPre.add(head); // Put our head at beginning of this new list
        int i = 0; // Instantiate I for looping
        Node current = head; // Create holding variable so we know which node we are on
        System.out.println(String.format("\nInitializing LinkedList Simulator Demo...\n________________________________________________________________\n\n%d. Created Root Node with Data: %.2f", (i+1), random1));
        for (i=0; i < random1; i++) { // For loop at random number of nodes to create
            int pre_int = (int) Math.round(Math.floor(Math.random() * 99999.99)); // Ramdom integer betweem 
            String Name = String.valueOf(pre_int); // Gemerate random number for node name but represent it as a string (Why? Because the head node is named with a string, but we want a way to create random identifiers (numbers))
            Double random = RandomBig();
            Node Node2 = new Node(random, Name);
            current.next = Node2;
            current = Node2;
            LinkedListPre.add(Node2);
            System.out.println(String.format("%d. Created Node %s -> Current Data: %.2f", (i+2), Node2, random));
        }
        int length_of_linked_list = LinkedListPre.size();
        Double head_data = head.data; // Get node data (verify it exists)
        System.out.println(String.format("\n\nSuccessfully created linked list simulation with %d nodes.\nThe root contains the data -> int data:  %.2f", length_of_linked_list, head_data));
        int ij; // Already instantiated i so use ij
        System.out.println("\nReading Simulated Linked List!!\n_______________________________________________\n");
        for (ij=0; ij<length_of_linked_list; ij++) {
            Node node = LinkedListPre.get(ij);
            try {
            System.out.println(String.format("%d. Current Node: (%s=%.2f  -<- Next Node -> (%s=%.2f)", (ij+1), node, node.data, node.next, node.next.data));
            } catch (Exception e) { // There is no value to show from null object at tail end, as there is no next node. at final node
                System.out.println(String.format("%d. Current Node: (%s=%.2f)  -<- Next Node -> %s", (ij+1), node, node.data, null));
            }
        }
    }

    public static int CountNodes(Node root) { // "This isn't a real linked list" --> But I am still using a real implementation of a linked list Counter in a practical way 
        Node current = root;
        Node next;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static List GenerateRandomLinkedList() { // Use other functions to build node objects together
        List<Node> Nodes = new ArrayList<Node>();
        int iterations = (int) Math.round(RandomBig()) + 1;
        int i;
        for (i=0; i < iterations; i++) {
            Nodes.add(CreateNodeRandom());
        }
        return Nodes;
    }
    public static Double RandomBig() { // Gemerate Ramdom precise number
        Double random_1 = Math.random();
        Double oneth = Math.floor(random_1 * 100.00 + 1.00 - random_1);
        return oneth;
    }
    private static Node CreateNodeRandom() { // Build random node with a name and value
        int pre_int = (int) Math.round(Math.floor(Math.random() * 99999.99));
        String Name = String.valueOf(pre_int);
        Node node = new Node(RandomBig(), Name);
        return node;
    }
    
    public static class Node { // Stock Node object
        Double data;
        String name;
        public Node(Double data, String name) { // Constructor function for custom data and name
            this.data = data;
            this.name = name;
        }
        Node next;
        // Getters and Setters below, simple enough
        public void setData(Double data) {
            this.data = data;
        }
        public Double getData() {
            return this.data;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Double getName() {
            return this.data;
        }
    }
}

