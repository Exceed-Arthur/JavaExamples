package com.exceed.io.JavaEx;


import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.function.Supplier;
import java.lang.Math.*;



class LinkedLists {

    public static void Main(String[] args) {
        Node head = new Node(RandomBig());
        List<Node> LinkedListPre = new ArrayList<Node>(); 
        LinkedListPre.add(head);
        int Big = RandomBig();
        int i;
        Node current = head;
        for (i=0; i < Big; i++) {
            Node Node2 = new Node(RandomBig());
            current.next = Node2;
            current = Node2;
            LinkedListPre.add(Node2);
        }
  

        int length_of_linked_list = LinkedListPre.size();
        int head_data = head.data;
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
        int iterations = RandomBig() + 1;
        int i;
        for (i=0; i < iterations; i++) {
            Nodes.add(CreateNodeRandom());
        }
        return Nodes;
    }
    public static int RandomBig() {
        Double random_1 = Math.random();
        int oneth = Math.floor(random_1 * 100 + 1 - random_1);
        return oneth;
    }
    public static Node CreateNodeRandom() {
        return Node(RandomBig());
    }
    
}

class Node {
    int data;
    public Node(int data) {
        data = data;
    }
    Node next;
    public void setData(int data) {
        data = data;
    }
    public int getData() {
        return data;
    }
}
