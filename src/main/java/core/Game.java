package core;
import java.util.*;
import java.io.*;
import java.net.*;

public class Game {
	protected String mode;
	Scanner sc = new Scanner(System.in);
	protected Player player;
	protected Player dealer;
	
	public Game(Player player,Player dealer){
		this.player = player;
		this.dealer = dealer;
	}
	
	public void initialize(){
		System.out.println("******************Welcome to BlackJack Game!********************\n\n");
		System.out.print("Enter c for console mode  or i for fileInput mode: ");
		mode = sc.next();
		while(mode.compareToIgnoreCase("c")!=0 && mode.compareToIgnoreCase("i")!=0){
			System.out.println("Invalid mode!");
			System.out.print("Enter c for console or I for file input:");
			mode = sc.next();
		}
	}
	
	public void start() {
		if(mode.compareToIgnoreCase("c")==0){		
			
			Deck deck = new Deck();		
			
			player.addCard(deck.dealNextCard());		
			player.addCard(deck.dealNextCard());
			
			dealer.addCard(deck.dealNextCard());
			dealer.addCard(deck.dealNextCard());
			
			System.out.println("Cards are dealt\n");
			player.printHand(true);
			dealer.printHand(false);
			System.out.println("\n");
			
			boolean playerDone = false;
			boolean dealerDone = false;
			String ans;
		
			while(!playerDone || !dealerDone ) {
				
				if(!playerDone) {
					
					System.out.println("Hit or stay? (Enter H or S): ");
					ans = sc.next();
					System.out.println();
					
					if(ans.compareToIgnoreCase("H")==0) {
						playerDone = !player.hit(deck);
						player.printHand(true);
					}else {
						playerDone = true;
					}
				}
				
				if(!dealerDone) {
					if(dealer.getHandTotal()<17) {
						System.out.println("[Dealer hits]\n");
						dealerDone = !dealer.hit(deck);
						dealer.printHand(true);
					}else {
						System.out.println("[The dealer stays]\n");
						dealer.printHand(true);
						dealerDone = true;
						}
				}
				System.out.println();
				
			}
		
			sc.close();
	
			player.printHand(true);
			dealer.printHand(true);
			
			int playerTotal = player.getHandTotal();
			int dealerTotal = dealer.getHandTotal();
			
			if(playerTotal > dealerTotal && playerTotal<=21 || dealerTotal >21) {
				System.out.println("--Your Hand total: "+player.getHandTotal());
				System.out.println("--Dealer's Hand total: "+dealer.getHandTotal());
				System.out.println("--You win!!!--");
			}else if(playerTotal ==21 && dealerTotal == 21) {
				System.out.println("--Dealer's Hand total: "+dealer.getHandTotal());
				System.out.println("--Your Hand total: "+player.getHandTotal());
				System.out.println("--The house win!!!--");
			}else {
				System.out.println("--Dealer's Hand total: "+dealer.getHandTotal());
				System.out.println("--Your Hand total: "+player.getHandTotal());
				System.out.println("--The house win!!!--");
			}
		}
		
		else if(mode.compareToIgnoreCase("i")==0){
					
			String[] arr = this.promptUser();
			int i=0;
			Player player = new Player("Player");
			Player dealer = new Player("Dealer");
			
			//Turn array of string into a deck of cards
			Deck deck = new Deck(this.arrToDeck(arr));
			
			//Array of commands
			char commands[] = this.getCommands(arr);

			player.addCard(deck.dealNextCard());		
			player.addCard(deck.dealNextCard());
			
			dealer.addCard(deck.dealNextCard());
			dealer.addCard(deck.dealNextCard());
			
			System.out.println("Cards are dealt\n");
			player.printHand(true);
			dealer.printHand(false);
			System.out.println("\n");
			
			boolean playerDone = false;
			boolean dealerDone = false;
			String ans;
			
			while(!playerDone || !dealerDone ) {
				int turn = 0;
				if(!playerDone) {
					
					ans = Character.toString(commands[turn]);
					if(ans.compareToIgnoreCase("H")==0) {
						System.out.println("--Player Hits!--\n");
						playerDone = !player.addCard(deck.dealNextCard());
						player.printHand(true);
					}else {
						playerDone = true;
					}
					turn++;
				}
				
				if(!dealerDone) {
					if(dealer.getHandTotal()<17) {
						System.out.println(dealer.getHandTotal());
						System.out.println("--Dealer hits--\n");
						dealerDone = !dealer.addCard(deck.dealNextCard());
						dealer.printHand(true);
					}else {
						System.out.println("--The dealer stays--\n");
						dealer.printHand(true);
						dealerDone = true;
						}
				}
				
				if(dealer.getHandTotal() == 21 && player.getHandTotal()==21){
					dealerDone = true;
					playerDone = true;
				}
				System.out.println();
				
			}
			player.printHand(true);
			dealer.printHand(true);
			
			int playerTotal = player.getHandTotal();
			int dealerTotal = dealer.getHandTotal();
			
			if(playerTotal > dealerTotal && playerTotal<=21 || dealerTotal >21) {
				System.out.println("--Your Hand total: "+player.getHandTotal());
				System.out.println("--Dealer's Hand total: "+dealer.getHandTotal());
				System.out.println("--You win!!!--");
			}else if(playerTotal ==21 && dealerTotal == 21) {
				System.out.println("--Dealer's Hand total: "+dealer.getHandTotal());
				System.out.println("--Your Hand total: "+player.getHandTotal());
				System.out.println("--The house win!!!--");
			}else {
				System.out.println("--Dealer's Hand total: "+dealer.getHandTotal());
				System.out.println("--Your Hand total: "+player.getHandTotal());
				System.out.println("--The house win!!!--");
			}
		}
	}
	
	
//Prompt user for file input
	public String[] promptUser(){
		System.out.println("Please enter file name with .txt extension");
		Scanner x = new Scanner (System.in);
		String fileName = x.nextLine();
		String arr[] = new String[52];
		int c = 0;
		try{
			URL path = Game.class.getResource(fileName);
			File f = new File(path.getFile());
			Scanner sc = new Scanner(f);
			while(sc.hasNext()){
			arr[c] = sc.next().replaceAll("\\s+","");
			c++;
			}
			sc.close();
		}catch(Exception e){
			System.out.println("/!\\File not found");
			System.exit(1);
		}
		x.close();
		return arr;
			
	}
	
	//Convert 2 characters of a string int0 a card
	public Card toCard(String in){
		
		char s = in.charAt(0);

		Suit suit = null;
		switch(s){
			case 'C':
				suit = Suit.values()[0];
				break;
			case 'D':
				suit = Suit.values()[1];
				break;
			case 'H':
				suit = Suit.values()[3];
				break;
			case 'S':
				suit = Suit.values()[2];
				break;
			
		}

		String value = Character.toString(in.charAt(1));
		Card card = new Card(suit,value);
		
		return card;
	}
	
	//Convert a string array to an array of decks
	public Card[] arrToDeck(String[] arr){
		int i=0;
		int j=0;
		Card deck[] = new Card[52];
		while(arr[i]!=null){
			if(arr[i].length()==2){
				deck[j] = this.toCard(arr[i]);
				j++;
			}
			i++;			
		}
		return deck;
	}
	
	//Get commands from the file input
	public char[] getCommands(String[] arr){
		int i=0;
		int j=0;
		char commands[] = new char[52];
		while(arr[i]!=(null)){
			if(arr[i].length()==1){
				commands[j] = arr[i].charAt(0);
				j++;
			}
			i++;			
		}
		return commands;
	}
}
