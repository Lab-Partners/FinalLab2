package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Hand {

	int HandStrength;
	int HiHand;
	int LoHand;
	int Kicker;
	boolean bAce = false;
	boolean bFlush = false;
	boolean bStraight = false;
	boolean bStraightAceLow = false;


	private ArrayList<Card> HandCards = new ArrayList<Card>();

	public Hand(Deck myDeck) 
	{
		//DEALS 5 CARDS INTO HAND
		for (short h = 0; h <= 4; h++) 
		{
			HandCards.add(myDeck.draw());
		}

		//SORTS THE HAND FROM LEAST TO GREATEST
		Collections.sort(HandCards, Card.CardRank);
		Collections.reverseOrder();
		
		// CHECKS IF ACE IS IN HAND
		if (HandCards.get(4).getCvalue() == 14)
		{
			bAce = true;
		}
		
		//CHECKS FOR FLUSH
		if (HandCards.get(0).getSuit() == HandCards.get(1).getSuit()
			&&HandCards.get(1).getSuit() == HandCards.get(2).getSuit()
			&&HandCards.get(2).getSuit() == HandCards.get(3).getSuit()
			&&HandCards.get(3).getSuit() == HandCards.get(4).getSuit())
		{
			bFlush = true;
		}
		
		//CHECKS FOR STRAIGHT ACE HIGH
		if (HandCards.get(0).getCvalue() < 11
			&&HandCards.get(0).getCvalue() + 1 == HandCards.get(1).getCvalue()
			&&HandCards.get(1).getCvalue() + 1 == HandCards.get(2).getCvalue()
			&&HandCards.get(2).getCvalue() + 1 == HandCards.get(3).getCvalue()
			&&HandCards.get(3).getCvalue() + 1 == HandCards.get(4).getCvalue())
		{
			bStraight = true;
		}
		
		//CHECKS FOR STRAIGHT ACE LOW
		else if (HandCards.get(0).getCvalue() == 2
				&&HandCards.get(1).getCvalue() == 3
				&&HandCards.get(2).getCvalue() == 4
				&&HandCards.get(3).getCvalue() == 5
				&&HandCards.get(4).getCvalue() == 14)
			{
				bStraightAceLow = true;
			}
		
		
		
		
	}

	
	public void EvalHand() 
	{
		//CHECKS FOR ROYAL FLUSH AND EVALUATE
		if(bAce == true && bFlush == true && bStraight == true)
			{
				//ROYAL FLUSH IS PRESENT = 10 (HIGHEST SCORE AVAILABLE FOR HAND)
				HiHand = HandCards.get(4).getCvalue();
				LoHand = 0;
				Kicker = HiHand;
				ScoreHand(10, HiHand, LoHand, Kicker);
			}
			
		
		//CHECKS FOR STRAIGHT FLUSH AND EVALUATE
		else if(bStraight == true && bFlush == true)
			{
				HiHand = HandCards.get(4).getCvalue();
				LoHand = 0;
				Kicker = HiHand;
				ScoreHand(9, HiHand, LoHand , Kicker);
			}
		
		//CHECKS FOR FOUR OF A KIND AND EVALUATES
		else if(HandCards.get(0).getCvalue() == HandCards.get(3).getCvalue())
		{
			HiHand = HandCards.get(0).getCvalue();
			Kicker = HandCards.get(4).getCvalue();
			LoHand = 0;
			ScoreHand(8,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(1).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(1).getCvalue();
			Kicker = HandCards.get(0).getCvalue();
			LoHand = 0;
			ScoreHand(8,HiHand,LoHand,Kicker);
		}
		
		//CHECKS FOR FULL HOUSE AND EVALUATE
		else if(HandCards.get(0).getCvalue() == HandCards.get(1).getCvalue()
				&&HandCards.get(2).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(2).getCvalue();
			LoHand = HandCards.get(0).getCvalue();
			Kicker = 0;
			ScoreHand(7,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(0).getCvalue() == HandCards.get(2).getCvalue()
				&&HandCards.get(3).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(2).getCvalue();
			LoHand = HandCards.get(4).getCvalue();
			Kicker = 0;
			ScoreHand(7,HiHand,LoHand,Kicker);
		}
		
		//BOOLEAN FLUSH IS DONE SO EVALUATE 
		else if(bFlush == true)
		{
			HiHand = HandCards.get(4).getCvalue();
			LoHand = HandCards.get(0).getCvalue();
			Kicker = 0;
			ScoreHand(6,HiHand,LoHand,Kicker);
		}
		
		//BOOLEAN STRAIGHT IS DONE SO EVALUATE
		else if(bStraight == true)
		{
			HiHand = HandCards.get(4).getCvalue();
			LoHand = HandCards.get(0).getCvalue();
			Kicker = 0;
			ScoreHand(5,HiHand,LoHand,Kicker);
		}
		
		//
			
		//BOOLEAN ACE LOW STRAIGHT IS DONE SO EVALUATE
		else if(bStraightAceLow == true)
		{
			HiHand = HandCards.get(4).getCvalue();
			LoHand = 1;
			Kicker = 0;
			ScoreHand(5,HiHand,LoHand,Kicker);
		}
		
		//CHECKS FOR THREE OF A KIND AND EVALUATE
		else if(HandCards.get(0).getCvalue() == HandCards.get(2).getCvalue())
		{
			HiHand = HandCards.get(0).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(4).getCvalue();
			ScoreHand(4,HiHand,LoHand,Kicker);

		}
		
		else if(HandCards.get(1).getCvalue() == HandCards.get(3).getCvalue())
		{
			HiHand = HandCards.get(1).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(4).getCvalue();
			ScoreHand(4,HiHand,LoHand,Kicker);

		}
		
		else if(HandCards.get(2).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(2).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(1).getCvalue();
			ScoreHand(4,HiHand,LoHand,Kicker);

		}
			
		//CHECKS FOR TWO PAIR AND EVALUATES
		else if(HandCards.get(0).getCvalue() == HandCards.get(1).getCvalue()
				&&HandCards.get(2).getCvalue() == HandCards.get(3).getCvalue())
		{
			HiHand = HandCards.get(3).getCvalue();
			LoHand = HandCards.get(0).getCvalue();		
			Kicker = HandCards.get(4).getCvalue();
			ScoreHand(3,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(0).getCvalue() == HandCards.get(1).getCvalue()
				&&HandCards.get(3).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(3).getCvalue();
			LoHand = HandCards.get(0).getCvalue();		
			Kicker = HandCards.get(2).getCvalue();
			ScoreHand(3,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(1).getCvalue() == HandCards.get(2).getCvalue()
				&&HandCards.get(3).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(3).getCvalue();
			LoHand = HandCards.get(1).getCvalue();		
			Kicker = HandCards.get(0).getCvalue();
			ScoreHand(3,HiHand,LoHand,Kicker);
		}
			
		//CHECKS FOR ONE PAIR AND EVALUTES
		else if(HandCards.get(0).getCvalue() == HandCards.get(1).getCvalue())
		{
			HiHand = HandCards.get(1).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(4).getCvalue();
			ScoreHand(2,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(1).getCvalue() == HandCards.get(2).getCvalue())
		{
			HiHand = HandCards.get(2).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(4).getCvalue();
			ScoreHand(2,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(2).getCvalue() == HandCards.get(3).getCvalue())
		{
			HiHand = HandCards.get(3).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(4).getCvalue();
			ScoreHand(2,HiHand,LoHand,Kicker);
		}
		
		else if(HandCards.get(3).getCvalue() == HandCards.get(4).getCvalue())
		{
			HiHand = HandCards.get(4).getCvalue();
			LoHand = 0;		
			Kicker = HandCards.get(2).getCvalue();
			ScoreHand(2,HiHand,LoHand,Kicker);
		}
		//LOWEST HAND - RETURN THE HIGHEST CARD
		else
			{
				HiHand = HandCards.get(4).getCvalue();
				LoHand = 0;		
				Kicker = 0;
				ScoreHand(1,HiHand, LoHand, Kicker);
			}
		
		
		
		//ORIGINAL CODE FROM TEACHER
//		if ((bFlush) && (bStraight) && (bAce)) {
//			if (HandCards.get(0).getCvalue() == 10) {
//				ScoreHand((short) 100, (short) 0, (short) 0, (short) 0);
//			} else {
//				// Straight Flush
//				ScoreHand((short) 90, (short) HandCards.get(4).getCvalue(),
//						(short) 0, (short) 0);
//			}
//
//		}

	}

	private void ScoreHand(int HandStrength, int HiHand, int LoHand,
			int Kicker) {

		this.HandStrength = HandStrength;
		this.HiHand = HiHand;
		this.LoHand = LoHand;
		this.Kicker = Kicker;		
	}
	
	public void printHand()
	{
		for(int i = 0; i < 5;i++)
		{
			if(HandCards.get(i).getCvalue() == 14)
			{
				System.out.print("Ace ");
			}
			
			else if(HandCards.get(i).getCvalue() == 13)
			{
				System.out.print("King ");

			}
			
			else if(HandCards.get(i).getCvalue() == 12)
			{
				System.out.print("Queen ");

			}
			
			else if(HandCards.get(i).getCvalue() == 11)
			{
				System.out.print("Jack ");

			}
			else System.out.print(HandCards.get(i).getCvalue() + " ");
		}
		System.out.println();
	}
}


