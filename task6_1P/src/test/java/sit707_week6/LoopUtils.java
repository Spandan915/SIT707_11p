package sit707_week6;

public class LoopUtils {
	
	 public static int sumUpTo(int n) {
	        int sum = 0;
	        for (int i = 1; i <= n; i++) {
	            sum += i;
	        }
	        return sum;
	    }
	    
	    public static boolean isEven(int num) {
	        return num % 2 == 0;
	    }
}
