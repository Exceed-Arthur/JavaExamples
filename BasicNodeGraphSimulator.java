import java.util.*;
import java.util.function.Supplier;

class NodeGraph {
  public static void main(String[] args) {
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
  private static int RandomInt(){
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
  private static void ArbitrarilyConnectNodes(Node[] OriginalNodes) {
    int iterations = RandomInt(); // Get new random integer to iterate through
    int i; // create iteration value to loop with
    for (i=0; i<iterations; i++) {
      Node currentNode = OriginalNodes[i]; // Get current instance of our custom node class with our index
      currentNode.adjacent_nodes.add(newNode); // Add it to our list of saved nodes in our instance variable
      
    }
    
  } 
  private static 
}
