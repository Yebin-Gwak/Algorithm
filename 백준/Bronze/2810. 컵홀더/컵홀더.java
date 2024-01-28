import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String sheet = sc.nextLine();
		
		boolean left = true;
		
		
		int count = 0;
		
		for(int i = 0; i < sheet.length()-1; i++) {
			char now = sheet.charAt(i);
			
			switch(now) {
			case 'S':
				count++;
				break;
				
			case 'L':
				if(left == true) {
					left = false;
					count += 2;
					i++;
					break;
				}
				else {
					count++;
					i++;
					break;
				}
			
			}
			
		}
		
		if(sheet.charAt(sheet.length()-1) == 'S')
			count++;
		
		System.out.println(count);
		
	}

}