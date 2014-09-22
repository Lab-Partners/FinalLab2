package Poker;

import java.util.Comparator;

public class Card {

	
	
	private short cvalue;
	private short suit;
	private String img;
	private boolean wild = false;

	public Card(short cvalue, short suit) {
		this.cvalue = cvalue;
		this.suit = suit;
	}

	public int getSuit() 
	{
		return suit;
	}

	public int getCvalue() 
	{
		return cvalue;
	}
	
	

	public static Comparator<Card> CardRank = new Comparator<Card>() {

		public int compare(Card c1, Card c2) {

		   int Cno1 = c1.getCvalue();
		   int Cno2 = c2.getCvalue();

		   /*For descending order*/
		   return Cno2 - Cno1;
		   

	   }};
	    
}
