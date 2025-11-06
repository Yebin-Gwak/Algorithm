import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double w = Double.parseDouble(br.readLine());
		Double h = Double.parseDouble(br.readLine());
		h *= h;
		Double bmi = w / h;
		if(bmi > 25.0)
			System.out.println("Overweight");
		else if(bmi < 18.50)
			System.out.println("Underweight");
		else
			System.out.println("Normal weight");
	}
}