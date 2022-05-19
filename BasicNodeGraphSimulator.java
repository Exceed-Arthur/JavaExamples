import java.util.*;
import java.util.function.Supplier;
import java.util.Arrays;

class NodeGraph {
  public static void main(String[] args) {
    ArrayList<Node> NodeList = RandomNodeList(); // Get random list of nodes to be altered with arbitrary connections
    ArbitrarilyConnectNodes(NodeList); // Arbitarily connect nodes with each other
    int NodeListLength = NodeList.size(); // Get length of Node List
    int i; // Instantiate variable to loop with
    for (i=0; i<NodeListLength; i++) {
      Node currentNode = NodeList.get(i); // Get current node that we are iterating on
      List<Node> adjacents = new ArrayList<Node>(); // Default to null, but may contain adjacent nodes (arrayList)
      String NodeListString = Arrays.toString(NodeList.toArray());  // Get String version of adjacent nodes list
      System.out.println(String.format("Current Node -<- (%s=%.2f) --- Adjacent Nodes -> (%s)", currentNode, currentNode.data, currentNode.adjacent_nodes));
    }
  }
  static class Node {
    
      Double data = RandomDouble(); // Instantiate random decimal number to put in data property
      List<Node> NodeList = new ArrayList<Node>(); // Create a new list containing our custom Node Object type
      List<Node> adjacent_nodes = null;
      
    } // Constructor allows for data to be added on instantiation automatically
  
  
  
  private static Double RandomDouble() {
    Double trouble = (Math.random() * 1000.00);
    return trouble;
  }
  
  private static int RandomInt(boolean... MaxVal){ // User has option to declare maximum value to return
    int int_ = (int) ((Math.floor(Math.random()*25) + 3)); // Random number between 3 and 25
    return int_;
  }

  private static ArrayList<Node> RandomNodeList() {
    ArrayList<Node> NodeList = new ArrayList<Node>(); // Create a new list containing our custom Node Object type
    int iterations = RandomInt(); // Get new random integer to iterate through
    int i; // create iteration value to loop with
    for (i=1; i<iterations; i++) {
      Node newNode = new Node(); // Get new instance of our custom node class
      NodeList.add(newNode); // Add it to our list of saved nodes
    }
    return NodeList;
  }

  private static boolean RandomBool() {
    if (Math.floor(Math.random()) > 0) {
      return true; // Returns True half the time (ideally/theoretically)
    }
    return false; // Returns False half the time (theoretically/ideally)
  }

  
  private static void ArbitrarilyConnectNodes(ArrayList<Node> OriginalNodes) {
    System.out.println("\nConnecting nodes in a random fashion so we can traverse the list programatically.");
    int maxVal = OriginalNodes.size();
    int iterations = RandomInt(maxVal); // Get new random integer to iterate through (with maximum at size of node list)
    int i; // create iteration value to loop with
    for (i=0; i<iterations; i++) {
      Node currentNode = OriginalNodes.get(i); // Get current instance of our custom node class with our index
      System.out.println(String.format("Current Node: %s", currentNode));
      int iterations1 = RandomInt(); // Get new random integer to iterate through
      int j; // create iteration value to loop with
      if (RandomBool()) { // Half the nodes SHOULD be singleton(ish) instances
        for (j=0; j < iterations1; j++) {
          if (RandomBool()) { // Some Nodes could have up to 25 Adjacent Nodes (that is our maximum RandomInt)
            Node newNode = new Node();
            currentNode.adjacent_nodes.add(newNode); // Add it to our list of saved nodes in our instance variable
            System.out.println(String.format("Adding (%s=%.2f) to Node %s", newNode, currentNode));
          }
        }
      }
    }
    return OriginalNodes; // Nodes have now been altered to contain connections with each other;
    
  } 
}
