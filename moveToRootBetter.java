public class moveToRootBetter {

    public int depthCountermtr[] = new int[10001];
    public int rotationCostmtr[] = new int[10001];


    Node searchMTRNode(Node node, int searchTerm, int index) {
        return moveToRootNode(node, searchTerm, index);
    }

    void getDepth(Node node, int searchTerm, int level, int index) {
        if (node == null) {
            return;
        }
        else if (node.data == searchTerm) {
            depthCountermtr[index] = level + 1;
            return;
        }
        else if(node.data < searchTerm)
        {
            getDepth(node.right, searchTerm, level + 1, index);
        }
        else 
        {
            getDepth(node.left, searchTerm, level + 1, index);
        }
    }


    

    Node moveToRootNode(Node node, int searchTerm, int index) {

        if(node.data == searchTerm)
        {
            return node;
        }
        else if(node.data < searchTerm)
        {
            if(node.right.data == searchTerm)
            {
                node = leftRotate(node, index);
            }
            else
            {
                node.right = moveToRootNode(node.right, searchTerm, index);
            }
        }
        else
        {
            if(node.left.data == searchTerm)
            {
                node = rightRotate(node, index);
            }
            else
            {
                node.left = moveToRootNode(node.left, searchTerm, index);
            }
        }
        return node;
    }

    public Node rightRotate(Node node, int index) {
        rotationCostmtr[index]++;
        Node n = node.left;
        node.left = n.right;
        n.right = node;
        return n;
    }

    public Node leftRotate(Node node, int index) {
        rotationCostmtr[index]++;
        Node n = node.right;
        node.right = n.left;
        n.left = node;
        return n;
    }
}