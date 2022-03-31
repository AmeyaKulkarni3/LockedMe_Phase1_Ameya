import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JavaProject {

	static String path = "D:\\Test_Files\\";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println("****************************************");
			System.out.println("       Developer : Ameya Kulkarni       ");
			System.out.println("              LockedMe.com              ");
			System.out.println("****************************************");
			System.out.println("Choose the Option from below to proceed");
			System.out.println("");
			System.out.println("	1. Get all the file names");
			System.out.println("	2. Add, Delete or Search the Files");
			System.out.println("	3. Exit");
			System.out.println("");
			int choice = sc.nextInt();
			System.out.println("");
			switch (choice) {
			case 1:
				getFiles();
				break;

			case 2:
				fileOperations();
				break;

			case 3:
				System.out.println("Thank You for using LockedMe.com!");
				System.exit(0);
				break;
			default:
				System.out.println("Check the option and retry!");
				break;
			}
		}
	}

	private static void fileOperations() throws IOException {

		while (true) {
			System.out.println("****************************************");
			System.out.println("              File Operations           ");
			System.out.println("****************************************");
			System.out.println("Choose the Option from below to proceed.");
			System.out.println("");
			System.out.println("	1. Add File");
			System.out.println("	2. Delete File");
			System.out.println("	3. Search File");
			System.out.println("	4. Exit");
			System.out.println("");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addFile();
				break;
			case 2:
				deleteFile();
				break;
			case 3:
				System.out.println("Enter the file name to be searched.");
				String input = sc.next();
				if (searchFile(input)) {
					System.out.println("The File exists in " + path);
				} else {
					System.out.println("The File doesn't exist in " + path);
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Check the option and retry!");
				break;
			}
		}

	}

	private static boolean searchFile(String input) {

		String fileName = "";
		if (fileName.contains(".")) {
			String[] s = input.split(".");
			fileName = s[0];
		} else {
			fileName = input;
		}
		File fileDir = new File(path);
		File[] files = fileDir.listFiles();
		boolean flag = false;
		for (File f : files) {
			if (f.getName().toLowerCase().equals(input.toLowerCase())) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;

	}

	private static void deleteFile() {
		while (true) {
			System.out.println("Enter the file name to be deleted.");
			String input = sc.next();
			if (searchFile(input)) {
				File f = new File(path + input);
				if (f.delete()) {
					System.out.println("The file successfully deleted.");
				} else {
					System.out.println("Error deleting the file! Please try again");
				}
			} else {
				System.out.println("The file doesn't exist! Please check the name and retry!");
			}
			System.out.println("Press 1 to retry or to delete another file. Press 2 to exit.");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				continue;
			case 2:
				return;
			default:
				continue;
			}
		}

	}

	private static void addFile() throws IOException {
		System.out.println("File will be saved at " + path);
		while (true) {
			System.out.println("Please Enter The File Name:");
			String fileName = sc.next();
			File file = new File(path + fileName);
			boolean result = file.createNewFile();
			if (!result) {
				System.out.println("Error in creating file.");
			} else {
				System.out.println("The file is created!");
			}
			System.out.println("Press 1 to retry or to create new file. Press 2 to exit.");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				continue;
			case 2:
				return;
			default:
				continue;
			}
		}
	}

	private static void getFiles() {
		File file = new File(path);
		File[] files = file.listFiles();
		if(files.length == 0) {
			System.out.println("There are no files in " + path + " directory");
			return;
		}
		System.out.println("****************************************");
		System.out.println("           Files in Directory           ");
		System.out.println("****************************************");
		for (File f : files) {
			String[] fileName = f.getName().split("\\\\");
			System.out.println("	" + fileName[fileName.length - 1]);
		}
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("");

	}

}
