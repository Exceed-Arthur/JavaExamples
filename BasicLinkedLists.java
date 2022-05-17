import java.util.*;
import java.util.function.Supplier;
class LinkedLists {
    public static void Main(String[] args) {
    
    }
    public class Node(int data) {
        this.data = data;
        Node next;
        public static setData(int data) {
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
    public static List GenerateRandomLinkedList() {
        List<Node> Nodes = new ArrayList<Node>();
        int iterations = RandomBig() + 1;
        int i;
        for (i=0, i < iterations, i++) {
            Nodes.add(CreateNodeRandom());
        }
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
