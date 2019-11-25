public class OptimalBinarySearchTree
{

    public int n;

	public int[][] root;
	
	public double[][] e;

	public int q = 25;


    public OptimalBinarySearchTree(double[] p)
    {
	n = p.length - 1;
	root = new int[n+1][n+1];
	optimalBST(p, n);
    }

    public void optimalBST(double[] p, int n)
    {
	
	e = new double[n+2][n+1];

	
	double[][] w = new double[n+2][n+1];

	for (int l = 1; l <= n; l++) {
	    for (int i = 1; i <= n-l+1; i++) {
		int j = i + l - 1;	
		
		e[i][j] = Double.MAX_VALUE;
		w[i][j] = w[i][j-1] + p[j];

		for (int r = i; r <= j; r++) {
		    double t = e[i][r-1] + e[r+1][j] + w[i][j];
		    if (t < e[i][j]) {
			e[i][j] = t;
			root[i][j] = r;
		    }
		}
	    }
	}

	}
	
	public double[][] getCostArray()
	{
		return e;
	}

    public int getNumberOfKeys()
    {
	return q;
    }

    public int[][] getRootTable()
    {
	return root;
    }
}

