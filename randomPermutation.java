import java.util.Random;

public class randomPermutation {

    public int A[] = new int[1001];

    public int accessSequence[] = new int[10001];

    public void intrandomPermutation() {

    }

    public void randomizeInPlace(int A[]) {

        int newLength = A.length - 1;

        for (int i = 1; i <= newLength; i++) {
            A[i] = i;
        }

        Random random = new Random();

        for (int i = 1; i <= newLength; i++) {
            int randomPosition = random.nextInt(newLength) + 1;
            int temp = A[i];
            A[i] = A[randomPosition];
            A[randomPosition] = temp;
        }
    }

    public void getFrequency(int permutation[], int freq[]) {
        // First computing a[i] for n integers
        // Initializing a[i] array

        int a[] = new int[permutation.length];

        for (int i = 1; i <= (a.length - 1); i++) {
            Random random = new Random();
            a[i] = random.nextInt(100) + 1;
        }
        // Creating a c[i] array

        int c[] = new int[permutation.length];
        c[0] = a[0];

        // Filling values for c array

        for (int j = 1; j <= (permutation.length - 1); j++) {
            c[j] = c[j - 1] + a[j];
        }

        // Running loop for 10000 times
        for (int i = 1; i <= 10000; i++) {
            Random random = new Random();
            int j = random.nextInt(c[1000]) + 1;

            for (int k = 1; k < c.length; k++) {
                if (j > c[k - 1] && j <= c[k]) {
                    freq[k] = freq[k] + 1;
                    accessSequence[i] = A[k];
                }
            }
        }
    }
}