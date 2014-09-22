package Poker;

public enum Suit {

	HEARTS(1), SPADES(2), CLUBS(3), DIAMONDS(4);
	
	private Suit(final int suit){
		this.suit = suit;
	}

	private int suit;
	
	public int getSuit(){
		return suit;
	}
	
	
}