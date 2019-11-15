import java.util.Random;

public class randomPermutation {

    int A[] = new int[1001];

    public void intrandomPermutation(){

    }

    public void randomizeInPlace(int A[]) {

        int newLength = A.length - 1;

        for(int i=1; i<=newLength; i++) {
            A[i] = i;
        }

        Random random = new Random();
        
        for (int i=1; i<=newLength; i++) {
            int randomPosition = random.nextInt(((newLength - 1) + 1) + 1);
            int temp = A[i];
            A[i] = A[randomPosition];
            A[randomPosition] = temp;
		}
    }

    public static void getFrequency(int A[]) {

    }
    public static void main(String[] args) {

        randomPermutation ra = new randomPermutation();
        ra.randomizeInPlace(ra.A);
        
        for(int i=1; i<=1000; i++){
        System.out.println(ra.A[i]);
    }
}
}