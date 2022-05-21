
import java.util.*;

import java.util.Arrays;

class NodeGraph {
  public static void main(String[] args) {
    new Graph();
  }
  
  static class Graph {
    public Graph() {
      ArrayList<Node> NodeList = RandomNodeList(); // Get random list of nodes to be altered with arbitrary connections
      NodeList = ArbitrarilyConnectNodes(NodeList); // Arbitrarily connect nodes with each other
      int NodeListLength = NodeList.size(); // Get length of Node List
      System.out.println(String.format("Node List size: %d", NodeListLength));
      int i; // Instantiate variable to loop with
      Set<Node> set = new HashSet<>(NodeList);
      NodeList.clear();
      NodeList.addAll(set);
      for (i=1; i<NodeListLength; i++) {
        //Collections.shuffle(NodeList); // Randomize list a bit
        Node currentNode = NodeList.get(i-1); // Get current node that we are iterating on
        List<Node> adjacents = null;
        adjacents = currentNode.adjacent_nodes; // Get instance variable property of adjacent nodes
        String NodeListString = null; // Get String version of adjacent nodes list, default to null
        if (adjacents.size() > 0) {
          Set<Node> set1 = new HashSet<>(adjacents);
          adjacents.clear();
          adjacents.addAll(set1);
          NodeListString = Arrays.toString(adjacents.toArray());  // Get String version of adjacent nodes list
          System.out.println(String.format("\nCurrent Node -<- (%s=%.2f) --- Adjacent Nodes -> (%s)\n", currentNode, currentNode.data, NodeListString));
        }
        else {

          System.out.println(String.format("\nCurrent Node -<- (%s=%.2f) --- Adjacent Nodes -> Null/None", currentNode, currentNode.data));
      
          } //Half of singleton nodes are deleted to save memory/sapce
      }
      
      int random_node_index = RandomInt(NodeList.size());
      
      Node chosen_node = NodeList.get(random_node_index);
      System.out.println(String.format("Queue size line 66: %d", CountNodes(chosen_node)));

    }
      
  }
  
  private static int CountNodes(Node head) {
      Queue<Node> queue = new LinkedList<>();
      queue.add(head);
      
      int counter = 0;
      List<Node> already_added = new ArrayList<>();
      
      while (queue.size() > 0) {
        Node currentNode = queue.peek();
        queue.remove();
        if (!already_added.contains(currentNode) && currentNode.adjacent_nodes.size() > 0) {
          System.out.println(currentNode);
          counter++;
          already_added.add(currentNode);
          int z = currentNode.adjacent_nodes.size();
          for (z=0; z<currentNode.adjacent_nodes.size(); z++) {
            if (!already_added.contains(currentNode.adjacent_nodes.get(z))) {
              queue.add(currentNode.adjacent_nodes.get(z));
          }
        }
        }
        else if (!already_added.contains(currentNode)) {
          System.out.println(currentNode);
          counter++;
          already_added.add(currentNode);
        }

      }
      return counter++;
  }

  
  static class Node {
      Double data = RandomDouble(); // Instantiate random decimal number to put in data property
      List<Node> NodeList = new ArrayList<Node>(); // Create a new list containing our custom Node Object type
      List<Node> adjacent_nodes = NodeList;
      public Double getData() {
        return this.data;
      }
      public void setData(Double data) {
        this.data = data;
      }
      public void addAdjacents(Node adjacent) {
        this.adjacent_nodes.add(adjacent);
      }
      public List<Node> getAdjacents() {
        return this.adjacent_nodes;
      }
    } // Constructor allows for data to be added on instantiation automatically
  
  
  
  private static Double RandomDouble() {
    Double trouble = (Math.random() * 1000.00);
    return trouble;
  }
  
  private static int RandomInt(int MaxVal){ // User has option to declare maximum value to return
    int int_ = (int) (Math.floor(Math.random()*MaxVal)); // Random number between 3 and 25
    return int_;
  }

  private static ArrayList<Node> RandomNodeList() {
    ArrayList<Node> NodeList = new ArrayList<Node>(); // Create a new list containing our custom Node Object type
    int iterations = RandomInt(100); // Get new random integer to iterate through
    int i; // create iteration value to loop with
    for (i=1; i<iterations; i++) {
      Node newNode = new Node(); // Get new instance of our custom node class
      NodeList.add(newNode); // Add it to our list of saved nodes
    }
    return NodeList;
  }
	
  private static ArrayList<Node> ArbitrarilyConnectNodes(ArrayList<Node> OriginalNodes) {
    System.out.println("\nConnecting nodes in a random fashion so we can traverse the list programatically.\n");
    int maxVal = OriginalNodes.size();
    int iterations = RandomInt(maxVal); // Get new random integer to iterate through (with maximum at size of node list)
    int i; // create iteration value to loop with
    for (i=0; (i<iterations); i++) {
      
      Node currentNode = OriginalNodes.get(i); // Get current instance of our custom node class with our index
      System.out.println(String.format("Current Node: %s", currentNode));
      int iterations1 = RandomInt(OriginalNodes.size()); // Get new random integer to iterate through
      int j; // create iteration value to loop with
	  for (j=0; j < iterations1; j++) {
	      currentNode.addAdjacents(OriginalNodes.get(RandomInt(OriginalNodes.size()))); // Add it to our list of saved nodes in our instance variable
	      Node RandomNode = OriginalNodes.get(RandomInt(OriginalNodes.size()));
	      System.out.println(String.format("Adding (%s=%.2f) to Node %s", RandomNode, RandomNode.data, currentNode));
	      }
	    }
    Set<Node> set = new HashSet<>(OriginalNodes);
    OriginalNodes.clear();
    OriginalNodes.addAll(set);    
    return OriginalNodes;
    }
}
