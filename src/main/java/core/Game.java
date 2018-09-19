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
						playerDone = !player.addCard(deck.dealNextCard());
						player.printHand(true);
					}else {
						playerDone = true;
					}
				}
				
				if(!dealerDone) {
					if(dealer.getHandTotal()<17) {
						System.out.println("Dealer hits\n");
						dealerDone = !dealer.addCard(deck.dealNextCard());
						dealer.printHand(false);
					}else {
						System.out.println("The dealer stays\n");
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
				System.out.println("You win!!!");
			}else {
				System.out.println("The house win!!!");
			}
		}
	}
}
