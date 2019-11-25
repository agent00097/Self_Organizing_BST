
public class Answer {
    public static void main(String[] args) {

        // Initializing all the cost counters

        int depthCostforSplay = 0;
        int rotatcostforSplay = 0;
        int depthCostforMTR = 0;
        int rotatCostforMTR = 0;
        int depthCostfordm = 0;
        int rotatCostfordm = 0;

        // Getting input keys, frequency and the access sequence

        randomPermutation random = new randomPermutation();
        rBST youknow = new rBST();
        random.randomizeInPlace(random.A);

        int inputCopy[] = random.A;

        int freq[] = new int[random.A.length + 1];

        int freqCopyForDynamicMontone[] = new int[1001];

        for (int i = 1; i <= 1000; i++) {
            freqCopyForDynamicMontone[i] = freq[i];
        }

        random.getFrequency(random.A, freq);

        // Optimal Binary Search tree function call

        double hereitis[] = new double[1001];

        for (int i = 1; i <= 1000; i++) {
            hereitis[i] = ((double) freq[i] / 10000);
        }
        OptimalBinarySearchTree opt = new OptimalBinarySearchTree(hereitis);

        double theAnswer[][] = opt.getCostArray();

        System.out.println("Optimal Binary search tree cost : " + theAnswer[1][999]);

        // Splay tree function call

        Node something = new Node();

        something = youknow.createNode(random.A[1]);

        for (int i = 2; i <= 1000; i++) {
            something = youknow.insertNode(something, random.A[i]);
        }

        Splay sp = new Splay();

        for (int i = 1; i <= 10000; i++) {
            something = sp.searchNode(something, random.accessSequence[i], i);
        }

        for (int i = 1; i <= 10000; i++) {
            depthCostforSplay = depthCostforSplay + sp.depthCounter[i];
            rotatcostforSplay = rotatcostforSplay + sp.rotationCost[i];
        }

        System.out.println("Splay tree cost:  " + "depth Cost = " + depthCostforSplay + "  rotationCost = " + rotatcostforSplay + " Total is: "
                + (depthCostforSplay + rotatcostforSplay));

        // Move to root function call

        Node somethingelse = new Node();

        somethingelse = youknow.createNode(random.A[1]);

        for (int i = 2; i <= 1000; i++) {
            somethingelse = youknow.insertNode(something, random.A[i]);
        }

        moveToRootBetter youknowthis = new moveToRootBetter();

        for (int i = 1; i <= 10000; i++) {
            youknowthis.getDepth(somethingelse, random.accessSequence[i], 0, i);
            somethingelse = youknowthis.searchMTRNode(somethingelse, random.accessSequence[i], i);
            while (somethingelse.data != random.accessSequence[i]) {
                somethingelse = youknowthis.searchMTRNode(somethingelse, random.accessSequence[i], i);
            }
        }

        for (int i = 1; i <= 10000; i++) {
            depthCostforMTR = depthCostforMTR + youknowthis.depthCountermtr[i];
            rotatCostforMTR = rotatCostforMTR + youknowthis.rotationCostmtr[i];
        }

        System.out.println("Move to root cost:  " + "Depth cost is:  " + depthCostforMTR + "  Rotation cost is:  " + rotatCostforMTR
                + "  Total is: " + (rotatCostforMTR + depthCostforMTR));

        // Dynamic Montone cost

        dmNode anything = null;

        dynamicMonotone sad = new dynamicMonotone();
        anything = sad.sortAndMakeATree(inputCopy, freqCopyForDynamicMontone, anything);

        for (int i = 1; i <= 10000; i++) {
            sad.getDepthdm(anything, random.accessSequence[i], 0, i);
            sad.accessTheElements(anything, random.accessSequence[i]);
            for (int j = 1; j <= 20; j++) {
                anything = sad.propertyChecker(anything, random.accessSequence[i], i);
            }
        }

        for (int i = 1; i <= 10000; i++) {
            depthCostfordm = depthCostfordm + sad.depthCounterdm[i];
            rotatCostfordm = rotatCostfordm + sad.rotationCostdm[i];
        }

        System.out.println("Dynamic montone cost is:  " + "Depth cost is: " + depthCostfordm + "  Rotation cost is :  " + rotatCostfordm
                + "  Total is:  " + (rotatCostfordm + depthCostfordm));

    }
}