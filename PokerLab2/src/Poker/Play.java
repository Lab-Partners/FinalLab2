package Poker;


public class Play {

	public static void main(String[] args) 
	{
		
		
		Deck d = new Deck();
		
		Hand h1 = new Hand(d);
		
		Hand h2 = new Hand(d);
		
		h1.EvalHand();
		h2.EvalHand();
		
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
	}

}
