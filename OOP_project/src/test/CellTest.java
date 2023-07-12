package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;

public class CellTest {
	public static void main(String[] args) throws IOException  {
		
		Path namePath = Paths.get("src/Resource/Covid/Capsid/name.txt");
		File file = new File("src/Resource/Covid/Capsid"); 
		if (file.exists()) {
			System.out.println("hello bitch");
		}
		//String name = new String(Files.readAllBytes(namePath));
		String name = Files.exists(namePath) ? new String(Files.readAllBytes(namePath)) : null;	
		System.out.println(name);

	}
}
