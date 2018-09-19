package core;
import java.util.*;
import java.io.*;
import java.net.*;

public class Game {
	String mode;
	Scanner sc = new Scanner(System.in);
	
	public void initialize(){
		System.out.println("******************Welcome to BlackJack Game!********************\n\n");
		System.out.print("Enter c for console mode  or i for fileInput mode:");
		mode = sc.next();
		while(mode.compareToIgnoreCase("c")!=0 && mode.compareToIgnoreCase("i")!=0){
			System.out.println("Invalid mode!");
			System.out.print("Enter c for console or I for file input:");
			mode = sc.next();
		}
	}
	
}
