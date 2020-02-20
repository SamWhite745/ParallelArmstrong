import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.*;

public class Runner {
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println("Armstrong numbers between 1 and 1000000:");
		System.out.println(Arrays.toString(armstrong(100000000).toArray()));
		System.out.println("time taken: " + watch.getTime() / 1000.0 + "s");
	}
	
	public static boolean isArmstrong(int num) {
		int numLen = String.valueOf(num).length();
		int r = Arrays.stream(String.valueOf(num).split("")).map(x -> (int) Math.pow(Integer.parseInt(x), numLen))
				.reduce((acc, next) -> (acc + next)).orElse(-1);

		return r == num;
	}

	public static List<Integer> armstrong(int max) {
		return IntStream.rangeClosed(1, max).parallel().filter(num -> isArmstrong(num)).boxed().collect(Collectors.toList());
	}
}
