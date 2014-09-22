package Poker;


public class Play {

	public static void main(String[] args) 
	{
		//NEW DECK
		Deck d = new Deck();
		
		//NEW HANDS FOR PLAYER 1 AND 2
		Hand h1 = new Hand(d);
		
		Hand h2 = new Hand(d);
		
		//EVALUATE HANDS 1 AND 2
		h1.EvalHand();
		h2.EvalHand();
		
		//PRINT VALUES FOR HANDS 1 AND 2
		System.out.print("Player 1 Hand: ");
		h1.printHand();
		
		System.out.print("Player 2 Hand: ");
		h2.printHand();
		
		System.out.println();
		
		//COMPARES HANDSTRENGTH
		if(h1.HandStrength > h2.HandStrength)
		{
			System.out.println("Player 1 won!");
		}
		
		else if (h1.HandStrength < h2.HandStrength)
		{
			System.out.println("Player 2 won!");
		}
		
		//COMPARES HIHAND
		else if (h1.HiHand > h2.HiHand)
		{
			System.out.println("Player 2 won!");
		}
		
		else if (h1.HiHand < h2.HiHand)
		{
			System.out.println("Player 2 won!");
		}
		
		//COMPARES LOHAND
		else if (h1.LoHand > h2.LoHand)
		{
			System.out.println("Player 2 won!");
		}
		
		else if (h1.LoHand < h2.LoHand)
		{
			System.out.println("Player 2 won!");
		}
		
		//COMPARES KICKER
		else if (h1.Kicker > h2.Kicker)
		{
			System.out.println("Player 2 won!");
		}
		
		else if (h1.Kicker < h2.Kicker)
		{
			System.out.println("Player 2 won!");
		}
		
		else
		{
			System.out.println("There is a tie!");
		}
	}

}
