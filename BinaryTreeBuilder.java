import java.util.Arrays;
import java.util.ArrayList; // import the ArrayList class
import java.util.LinkedList;
import java.util.*;
 


public class BinaryTreeBuilder {
    private static String getSpatialModifier(int row) {
        String OriginalString = "";
        int space_count = 64;
        for (int r = 0; r < row; r++) {
            space_count -= Math.pow(3.1, r+1);    
        }
        for (int s=0; s < space_count; s++) {
            OriginalString += " ";
        }
        return OriginalString;
    }
    private static int getRowNodeCount(int row) {
        //System.out.println("Row Count at row "+ String.valueOf(row) + " is " + String.valueOf((int) Math.pow(2, row)));
        return (int) Math.pow(2, row);
    }
    private static int getParentColumn(int row, int column) {
        //System.out.println("Row Count at row "+ String.valueOf(row) + " is " + String.valueOf((int) Math.pow(2, row)));
        row--;
        int preColumn = column;
        column = column/2;
        if (preColumn % 2 != 0) {
            column++;
        }
        return (int) column;
    }
    public static void print(String string) {
        System.out.println(string);
    }
    private static ArrayList<ArrayList<Node>> createNodes(int RowCount) {
        RowCount--;
        ArrayList<ArrayList<Node>> EmptyNodes = new ArrayList<ArrayList<Node>>();
        for (int rowIndex=RowCount; rowIndex > -1; rowIndex--) {   
            ArrayList<Node> rowNodeArray = new ArrayList<Node>();
            for (int rowNodeIndex=0; rowNodeIndex < getRowNodeCount(rowIndex); rowNodeIndex++) {
                Node NodeForColumn = new Node();
                rowNodeArray.add(NodeForColumn);
                System.out.println("Created Node: " + NodeForColumn + " at row: " + String.valueOf(rowIndex)) ;
            }
            EmptyNodes.add(rowNodeArray);
        }
        Collections.reverse(EmptyNodes);

        for (int rowIndex=RowCount; rowIndex > -1; rowIndex--) {
            ArrayList<Node> rowNodeArray = new ArrayList<Node>();
            boolean parentRowExists = false;
            try {
                ArrayList<Node> ParentRow = EmptyNodes.get(rowIndex-1);
                parentRowExists = true;
            } catch (Exception E) {
                System.out.println("Already passed last row.");
            }
            int SubNodeCounter = 0; 
            int ParentCounter = 0;
            for (int NodeColumn=1; NodeColumn < getRowNodeCount(rowIndex-1)*2; NodeColumn = NodeColumn + 2) {
                SubNodeCounter++;
                int LeftColumnIndex = NodeColumn -1;
                int LeftRow = rowIndex; int RightRow = rowIndex;
                System.out.println("Left SubNode (" + String.valueOf(SubNodeCounter) + ") @ Column: " + String.valueOf(LeftColumnIndex) + " Row: " + String.valueOf(rowIndex));
                SubNodeCounter++;
                int RightColumnIndex = NodeColumn;
                System.out.println("Right SubNode (" + String.valueOf(SubNodeCounter) + ") @ Column: " + String.valueOf(RightColumnIndex) + " Row: " + String.valueOf(rowIndex));
                ArrayList<Node> SubNodeRow = EmptyNodes.get(rowIndex);
                if (parentRowExists) {
                    ParentCounter++;
                    int ParentColumn = NodeColumn/2;
                    int ParentRow = rowIndex-1;
                    System.out.println("Parent " + String.valueOf(ParentCounter) + " @ Column: " + String.valueOf(ParentColumn) + " Row: " + String.valueOf(ParentRow) + "\n");
                    Node Parent = EmptyNodes.get(ParentRow).get(ParentColumn);
                    Node LeftSubNode = EmptyNodes.get(rowIndex).get(LeftColumnIndex);
                    Node RightSubNode = EmptyNodes.get(rowIndex).get(LeftColumnIndex+1);
                    Parent.left = LeftSubNode;
                    Parent.right = RightSubNode;
                }
            }
        }
        ArrayList<ArrayList<Node>> FullNodes = EmptyNodes;
        ArrayList<String> RowStrings = new ArrayList<String>();
        String Space = " ";
        String  firstTreeString = ""; 
        for (int i=0; i < FullNodes.size(); i++) {
            //System.out.println("Row Size: " + String.valueOf(FullNodes.get(i).size()));
            print("");
            String RowString = "";
            RowString += getSpatialModifier(i);
            for (int j=0; j < FullNodes.get(i).size(); j++) {
                RowString += FullNodes.get(i).get(j).toString();
                if (j < FullNodes.get(i).size()-1) {
                    RowString += " - ";
                }

            }
            RowStrings.add(RowString);
            firstTreeString += RowString + "\n";
            print(RowString);
        }
        
        return FullNodes;
    }
    
    public static int scanTreeCount(Node head) {
        Queue<Node> node_queue = new LinkedList<>();
        node_queue.add(head);
        int nodeCount = 0;
        while (node_queue.size() > 0) {
            Node current = node_queue.remove();
            nodeCount++;
            node_queue.add(current.left);
            node_queue.add(current.right);
        }
        return nodeCount;
    }
    
    public static ArrayList<Node> scanTreeNodes(Node head) {
        Queue<Node> node_queue = new LinkedList<>();
        ArrayList<Node> node_array = new ArrayList<Node>();
        node_queue.add(head); // Initialize the Queue to scan subNodes
        while (node_queue.size() > 0) {
            Node current = node_queue.remove();
            node_array.add(current); // Add the head node to the array we return
            node_queue.add(current.left); // Ensure All subNodes are added
            node_queue.add(current.right);
        }
        return node_array;
    }
    
    public static int scanTreeRowCount(Node head) {
        int totalNodes = scanTreeCount(head);
        int accumulator = 0;
        int rowCount = 0;
        while (accumulator < totalNodes) {
            accumulator += Math.pow(2, rowCount);
            rowCount++;
        }
        return rowCount;
    }
    


    public static void main(String[] args) {
        createNodes(3);
    }
    
}
