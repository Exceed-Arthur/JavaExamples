import java.util.*;
import java.util.function.Supplier;
import java.util.Arrays;
class NodeGraph {
  public static void main(String[] args) {
    ArrayList<Node> NodeList = RandomNodeList(); // Get random list of nodes to be altered with arbitrary connections
    
    NodeList = ArbitrarilyConnectNodes(NodeList); // Arbitarily connect nodes with each other
    int NodeListLength = NodeList.size(); // Get length of Node List
    System.out.println(String.format("Node List size: %d", NodeListLength));
    int i; // Instantiate variable to loop with
    for (i=0; i<NodeListLength; i++) {
      Node currentNode = NodeList.get(i); // Get current node that we are iterating on
      List<Node> adjacents = null;
      adjacents = currentNode.adjacent_nodes; // Get instance variable property of adjacent nodes
      String NodeListString = null; // Get String version of adjacent nodes list, default to null
      
      if (adjacents != null) {
        NodeListString = Arrays.toString(adjacents.toArray());  // Get String version of adjacent nodes list
        System.out.println(String.format("\nCurrent Node -<- (%s=%.2f) --- Adjacent Nodes -> (%s)\n", currentNode, currentNode.data, NodeListString));
      }
      else {
        System.out.println(String.format("\nCurrent Node -<- (%s=%.2f) --- Adjacent Nodes -> Null/None", currentNode, currentNode.data));
      }
    }
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

  private static boolean RandomBool() {
    Double answer = (Math.random()*1.00);
    if (answer > 0.5)  {
      return true; // Returns True half the time (ideally/theoretically)
    }
    else {
    return false;
  }
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
      boolean tool = RandomBool();
  
        for (j=0; j < iterations1-1; j++) {
          boolean book = RandomBool();
          
          if (book) { // Some Nodes could have up to 25 Adjacent Nodes (that is our maximum RandomInt)
            currentNode.addAdjacents(OriginalNodes.get(RandomInt(OriginalNodes.size()))); // Add it to our list of saved nodes in our instance variable
            Node RandomNode = OriginalNodes.get(RandomInt(OriginalNodes.size()));
            System.out.println(String.format("Adding (%s=%.2f) to Node %s", RandomNode, RandomNode.data, currentNode));
          }
        }
      } 
    return OriginalNodes;
    }
  
  
}
