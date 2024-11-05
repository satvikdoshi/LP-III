import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int val;
    String symbol;
    Node left, right;

    public Node(int val, String symbol) {
        this.val = val;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node next) {
        return this.val - next.val;
    }
}

public class HuffmanCoding {

    public static void printNodes(Node node, String val) {
        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + " -> " + val);
            return;
        }
        if (node.left != null) {
            printNodes(node.left, val + "0");
        }
        if (node.right != null) {
            printNodes(node.right, val + "1");
        }
    }

    public static void main(String[] args) {
        String[] chars = { "a", "b", "c", "d", "e", "f" };
        int[] freqs = { 50, 10, 30, 5, 3, 2 };

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++) {
            nodes.add(new Node(freqs[i], chars[i]));
        }

        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            Node newNode = new Node(left.val + right.val, left.symbol + right.symbol);
            newNode.left = left;
            newNode.right = right;
            nodes.add(newNode);
        }

        printNodes(nodes.poll(), "");
    }
}
