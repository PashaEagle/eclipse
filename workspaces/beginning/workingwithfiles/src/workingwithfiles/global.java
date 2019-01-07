package workingwithfiles;

import java.io.FileNotFoundException;

public class global {

	private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
	private static String fileName = "/home/pasha/Files/a.txt";
	
	public static void main(String[] args) {
		FileWorker.write(fileName, text);
		
		try {
			//Попытка прочитать несуществующий файл
			FileWorker.read("no_file.txt");
			
		}catch(FileNotFoundException e) {System.out.println("exception");}

		try {
		//Чтение файла
	    String textFromFile = FileWorker.read(fileName);
	    System.out.println(textFromFile);
		}catch(FileNotFoundException e) {System.out.println("exception");}
	}

}
