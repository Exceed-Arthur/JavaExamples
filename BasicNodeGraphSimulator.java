import java.util.*;
import java.util.function.Supplier;
import java.util.Arrays;

class NodeGraph {
  public static void main(String[] args) {
    List<Node> NodeList = RandomNodeList(); // Get random list of nodes to be altered with arbitrary connections
    ArbitrarilyConnectNodes(NodeList); // Arbitarily connect nodes with each other
    int NodeListLength = NodeList.size(); // Get length of Node List
    int i; // Instantiate variable to loop with
    for (i=0; i<NodeListLength; i++) {
      Node currentNode = NodeList[i] // Get current node that we are iterating on
      List<Node> adjacents = new ArrayList<Node>(); // Default to null, but may contain adjacent nodes (arrayList)
      String NodeListString = Arrays.toString(myList.toArray());  // Get String version of adjacent nodes list
      System.out.println(String.format("Current Node -<- (%s=%.2f) --- Adjacent Nodes -> (%s)" currentNode, currentNode.data, currentNode.adjacent_nodes));
    }
  }
  
  class Random Node {
    this.data = RandomDouble(); // Instantiate random decimal number to put in data property
    this.adjacent_nodes; // Create empty property for "Adjacent" or directly accessible-nodes
    List<Node> NodeList = new ArrayList<Node>(); // Create a new list containing our custom Node Object type
    this.adjacent_nodes = NodeList; // This instance can now accept new Nodes as adjacent nodes
  }
  
  private static Double RandomDouble() {
    Double double = Math.Random() * 1000.00;
    return double;
  }
  
  private static int RandomInt(boolean... MaxVal){ // User has option to declare maximum value to return
    int int_ = (int) ((Math.Floor(Math.Random()*25) + 3); // Random number between 3 and 25
    return int_;
  }

  private static Node[] RandomNodeList() {
    List<Node> NodeList = new ArrayList<Node>(); // Create a new list containing our custom Node Object type
    int iterations = RandomInt(); // Get new random integer to iterate through
    int i; // create iteration value to loop with
    for (i=1; i<iterations; i++) {
      Node newNode = new Node(); // Get new instance of our custom node class
      NodeList.add(newNode); // Add it to our list of saved nodes
    }
    return NodeList;
  }

  private static boolean RandomBool() {
    if (Math.Floor(Math.Random()) > 0) {
      return True // Returns True half the time (ideally/theoretically)
    }
    return False; // Returns False half the time (theoretically/ideally)
  }

  
  private static void ArbitrarilyConnectNodes(Node[] OriginalNodes) {
    System.out.println("\nConnecting nodes in a random fashion so we can traverse the list programatically.");
    int maxVal = OriginalNodes.size();
    int iterations = RandomInt(maxVal); // Get new random integer to iterate through (with maximum at size of node list)
    int i; // create iteration value to loop with
    for (i=0; i<iterations; i++) {
      Node currentNode = OriginalNodes[i]; // Get current instance of our custom node class with our index
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
