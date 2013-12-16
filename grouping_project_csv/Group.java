import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Group {

	public static void main(String args[]) {
		String names[];
		HashMap<Integer, String> groups = new HashMap<Integer, String>();
		try {
			File file = new File("class.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String data = br.readLine();
			names = data.split(",");
			int number=0;

				for (int i = 0; i < names.length; i++) {
					int mod = i%6;
					 String currentList=groups.get(mod);
					 if(currentList!=null)
						groups.put(mod, currentList+", "+names[i]);
					 else
						 groups.put(mod, names[i]);
						
					
				}

			Scanner scanner = new Scanner(System.in);
			System.out
					.println("The file has been read and the groups have been created.");
			while(number>=0&& number<6){
			System.out.println("Please enter a group number from 0 to 5 to view the list of students");
			number = scanner.nextInt();
			System.out.println("List of students : " + groups.get(number));
			}
			System.out.println("Incorrect Input. The system will exit");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
