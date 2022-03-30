import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class CreatingFile {
	public void createfile() throws IOException {
		String path = "D:\\Mphasis\\i\\";
		Scanner sc = new Scanner(System.in);

		ArrayList<String> al = new ArrayList<>();
		while (true) {
			System.out.println("Enter the file name which you want to create: ");
			String filename = sc.next();
			String finalname = path + filename;
			System.out.println(finalname);

			// create a file

			File f = new File(finalname);
			boolean b = f.createNewFile();
			if (b != true) {
				System.out.println("File not created");
			} else {
				al.add(filename);
				System.out.println("File created");

			}

			System.out.println("the collection of files is " + al);
			break;
		}
	}
}

class DeletingFile {
	public void deletefile() throws IOException {
		String path = "D:\\Mphasis\\i\\";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name which you want to delete: ");
		String filname = sc.next();
		String finalfile = path + filname;
		File file = new File(finalfile);
		file.delete();
		System.out.println("file deleted");

	}
}

class DisplayFile {
	public void displayfile() throws IOException {
		String path = "D:\\Mphasis\\i\\";
		File f = new File(path);
		File filename[] = f.listFiles();
		for (File ff : filename) {
			System.out.println(ff.getName());
		}
	}
}

class SearchFile {
	public void searchfil() throws IOException {
		String path = "D:\\Mphasis\\i\\";
		File f = new File(path);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name to search: ");
		String filsearchname = sc.next();
		File filename[] = f.listFiles();
		int flag = 0;
		for (File ff : filename) {
			if (ff.getName().equals(filsearchname)) {
				flag = 1;
				break;
			} else {
				flag = 0;
			}

		}

		if (flag == 1) {
			System.out.println("found the file");
		} else {
			System.out.println("file is not found");
		}
	}
}

public class AssessmentProject {
	public static void main(String[] args) throws IOException {

		boolean e = true;
		while (e) {

			System.out.println("Press 1 : Retrive Files\nPress 2 : To BL Operations\nPress 3 : Exit the App");
			Scanner ee = new Scanner(System.in);
			System.out.print("Enter the option: ");
			int option = ee.nextInt();
			switch (option) {

				case 1:
					DisplayFile ds = new DisplayFile();
					ds.displayfile();
					break;

				case 2:
					boolean f = true;
					while (f) {
						System.out.println(
								"Press 1 : To Add File\nPress 2 : To delete File\nPress 3 : To search File\nPress 4 : Go to main menu");
						Scanner sc = new Scanner(System.in);
						System.out.print("Enter the choice: ");
						int choice = sc.nextInt();
						switch (choice) {
							case 1:
								CreatingFile c = new CreatingFile();
								c.createfile();
								break;
							case 2:
								DeletingFile d = new DeletingFile();
								d.deletefile();
								break;

							case 3:
								SearchFile sf = new SearchFile();
								sf.searchfil();
								break;

							case 4:
								f = false;
								break;
						}
					}
					break;

				case 3:
					e = false;
					System.out.println("Exiting the Application...");
					break;

			}

		}
	}
}
