package Poker;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {

		for (short suit = 1; suit <= 4; suit++) {
			for (short rank =  2; rank <= 14; rank++) {
				cards.add(new Card(rank, suit));
			}
		}
		Collections.shuffle(cards);
	}

	public Card draw() {
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}

	public int getNumberOfCards() {
		return cards.size();
	}
}
