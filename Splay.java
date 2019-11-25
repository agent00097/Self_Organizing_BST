public class Splay {

    public int depthCounter[] = new int[10001];
    public int rotationCost[] = new int[10001];
    private int rotationCounter = 0;

    Node searchNode(Node node, int searchTerm, int index) {
        rotationCounter = 0;
        depthCounter[index] = (getDepth(node, searchTerm, 0) + 1);
        return splayNode(node, searchTerm, index);
    }

    int getDepth(Node node, int searchTerm, int level) {
        if (node == null) {
            return 0;
        }
        if (node.data == searchTerm) {
            return level;
        }
        if(node.data < searchTerm)
        {
            return getDepth(node.right, searchTerm, level + 1);
        }
        if(node.data > searchTerm) 
        {
            return getDepth(node.left, searchTerm, level + 1);
        }
        return level;
    }

    Node splayNode(Node node, int searchTerm, int index) {


        if (node == null || node.data == searchTerm) {
            rotationCost[index] = rotationCounter;
            return node;
        }

        if (node.data > searchTerm) {
            if (node.left == null) {
                rotationCost[index] = rotationCounter;
                return node;
            }

            if (node.left.data > searchTerm) {
                node.left.left = splayNode(node.left.left, searchTerm, index);

                node = rightRotate(node);
            } else if (node.left.data < searchTerm) {
                node.left.right = splayNode(node.left.right, searchTerm, index);

                if (node.left.right != null) {
                    node.left = leftRotate(node.left);
                }
            }
            rotationCost[index] = rotationCounter + 1;
            return (node.left == null) ? node : rightRotate(node);
        }

        else {
            if (node.right == null) {
                return node;
            }

            if (node.right.data > searchTerm) {
                node.right.left = splayNode(node.right.left, searchTerm, index);

                if (node.right.left != null) {
                    node.right = rightRotate(node.right);
                }
            } else if (node.right.data < searchTerm) {
                node.right.right = splayNode(node.right.right, searchTerm, index);
                node = leftRotate(node);
            }
            //Need to change my counter here
            rotationCost[index] = rotationCounter + 1;
            return (node.right == null) ? node : leftRotate(node);
        }
    }

    public Node rightRotate(Node node) {
        rotationCounter++;
        Node n = node.left;
        node.left = n.right;
        n.right = node;
        return n;
    }

    public Node leftRotate(Node node) {
        rotationCounter++;
        Node n = node.right;
        node.right = n.left;
        n.left = node;
        return n;
    }
}