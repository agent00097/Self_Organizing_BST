class Node{
    int data;
    Node left;
    Node right;
}

public class rBST {

    public Node createNode(int value)
    {
        Node rus = new Node();
        rus.data = value;
        rus.left = null;
        rus.right = null;
        return rus;
    }

    public Node insertNode(Node node, int val)
    {
        if(node == null) {
            return createNode(val);
        }

        if(val < node.data)
        {
            node.left = insertNode(node.left, val);
        }
        else if(val > node.data)
        {
            node.right = insertNode(node.right, val);
        }

        return node;
    } 

}