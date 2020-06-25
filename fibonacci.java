package homework;

public class fibonacci {
		
	public static class Fibonacci{
		public static int of(int n) {
			if (n == 1 || n == 2) {
				return 1;
			}
			else {
				return of(n-1) + of(n-2);
			}
		}
	}
	
	public static void main(String[] args) {
		int i = 1;
		while(Fibonacci.of(i) <= 200) {
			String str = String.format("Fibonacci.of(%d) = %d", i, Fibonacci.of(i));
			System.out.println(str);
			i++;
		}
	}
}