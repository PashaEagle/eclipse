package com.app.InOut.output;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.app.model.User;

@Component
public class OutputUser {
	public void writeToFile(User user) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true))) 
		{
			bw.write(user.toString() + "\n");
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		} catch (IOException e) 
		{
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}
	}
}