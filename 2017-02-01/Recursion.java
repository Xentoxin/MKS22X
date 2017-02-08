
public class Recursion {
	public static String name() {
		return "Chen,HaoYu";
	}

	public static void main(String[] args) {
		System.out.println(sqrt(1234567890));
	}

	public static double sqrt(double n) {
		if(n < 0){
			try{
			throw new IllegalArgumentException("Illegal Arugment");
			}
			catch(Exception e){
				System.out.println("Exception caught");
			}
			return 0;
		}
		else{
return helper(n,1);}
	}
	public static boolean isCloseEnough(double n, double g) {
		if (n == 0 && g == 0) {
			return true;
		}
		return ((n - g) / n) <= 1e-12 && ((n - g) / n) >= 0;
	}

	public static double helper(double n, double g) {
		double better = ((n / g) + g) / 2;
		if (isCloseEnough(better, g)) {
			return better;
		}
		return helper(n, better);
	}
}
