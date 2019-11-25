
class dmNode
{
    int data;
    int accessCount;
    dmNode left;
    dmNode right;
}

public class dynamicMonotone
{

    public int depthCounterdm[] = new int[10001];
    public int rotationCostdm[] = new int[10001];
    
    dmNode sortAndMakeATree(int input[], int probabilities[], dmNode whatever)
    {
        sort(input, probabilities);

        whatever = createDMNode(input[1], 0);

        for(int i=2; i<=1000; i++)
        {
            whatever = insertDMNode(whatever, input[i], probabilities[i]);
        }

        return whatever;
    }

    dmNode propertyChecker(dmNode node, int searchTerm, int index)
    {
        //System.out.println("I hope this works");
        if(node.data == searchTerm)
        {
            return node;
        }
        else if(node.data < searchTerm)
        {
            if((node.right.data == searchTerm) && (node.right.accessCount > node.accessCount))
            {
                
                node = leftRotate(node, index);
            }
            else
            {
                node.right = propertyChecker(node.right, searchTerm, index);
            }
        }
        else
        {
            if((node.left.data == searchTerm) && (node.left.accessCount > node.accessCount))
            {
                node = rightRotate(node, index);
            }
            else
            {
                node.left = propertyChecker(node.left, searchTerm, index);
            }
        }
        return node;
    }

    void getDepthdm(dmNode node, int searchTerm, int level, int index)
    {
        if (node == null) {
            return;
        }
        else if (node.data == searchTerm) {
            depthCounterdm[index] = level + 1;
            return;
        }
        else if(node.data < searchTerm)
        {
            getDepthdm(node.right, searchTerm, level + 1, index);
        }
        else 
        {
            getDepthdm(node.left, searchTerm, level + 1, index);
        }
    }

    void accessTheElements(dmNode node, int searchTerm)
    {
        if(node == null)
        {
            return;
        }
        if (node.data == searchTerm){
            node.accessCount++;
            return;
        }
        if(node.data < searchTerm)
        {
            accessTheElements(node.right, searchTerm);
        }
        if(node.data > searchTerm){
            accessTheElements(node.left, searchTerm);
        }
        return;
    }

    void sort(int arr[], int probabilities[]) 
    { 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 1; i <= 1000; i++) 
        { 
            // Find the minimum element in unsorted array 
            int max_idx = i; 
            for (int j = i+1; j <= 1000; j++) 
                if (probabilities[j] >= probabilities[max_idx]) 
                    max_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp1 = arr[max_idx]; 
            arr[max_idx] = arr[i]; 
            arr[i] = temp1;
            int temp2 = probabilities[max_idx];
            probabilities[max_idx] = probabilities[i];
            probabilities[i] = temp2;
        } 
    }

    public dmNode createDMNode(int data, int access)
    {
        dmNode rushabh = new dmNode();
        rushabh.data = data;
        rushabh.accessCount = access;
        rushabh.left = null;
        rushabh.right = null;
        return rushabh;
    }

    public dmNode insertDMNode(dmNode node, int val, int freq)
    {
        if(node == null) {
            return createDMNode(val, 0);
        }

        if(val < node.data)
        {
            node.left = insertDMNode(node.left, val, 0);
        }
        else if(val > node.data)
        {
            node.right = insertDMNode(node.right, val, 0);
        }

        return node;
    }

    public dmNode rightRotate(dmNode node, int index) {
        rotationCostdm[index]++;
        dmNode n = node.left;
        node.left = n.right;
        n.right = node;
        return n;
    }

    public dmNode leftRotate(dmNode node, int index) {
        rotationCostdm[index]++;
        dmNode n = node.right;
        node.right = n.left;
        n.left = node;
        return n;
    }
   

}