import java.io.*;
import java.text.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Long a = Long.parseLong(br.readLine());
		Double b = Math.sqrt(a);
		DecimalFormat df = new DecimalFormat("0.0#######");
		System.out.println(df.format(b * 4D));
	}
}