package sk.train_memory;

public class Sum {
	
   public static void main(String[] args) {
        Long sum = 0L;
        long longsum = sum;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            longsum += i;
        }
        sum = longsum;
        System.out.println(sum);
    }
}
