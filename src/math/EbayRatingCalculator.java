package math;
import java.math.BigDecimal;
import java.math.MathContext;

/*
 *  If a seller get x good ratings and y bad ratings, what will the possibility be that this is a bad seller.
 *  
 *  Suppose a buyer has no idea whether a seller is good (G) or bad (B), and models this by assuming that there 
 *  is a 50% chance the seller is bad. Suppose a bad seller cheats buyers 30% of the time. A good seller never 
 *  cheats buyers, but buyers might still have a bad experience with the seller 1% of the time due to circumstances 
 *  outside the seller’s control—the package really was lost in the post, for example. (We’ll assume that no such 
 *  additional causes occur with the bad seller, so that you have a bad experience with the bad seller only if he 
 *  is cheating you.)
 * 
 */

public class EbayRatingCalculator
{

	public static final double G = 0.5;           //possibility that the seller is good
	public static final double RIG = 0.99;        //possibility that a good seller gets a good rating
	public static final double RInG = 0.7;        //possibility that a bad seller gets a good rating
	
	
	public static BigDecimal getBadPossibility(int goodRatings, int badRatings)
	{
		BigDecimal up1 = new BigDecimal((1-RInG)).pow(goodRatings);
		BigDecimal up2 = new BigDecimal(RInG).pow(badRatings);
		
		BigDecimal do1 = new BigDecimal(RIG).pow(goodRatings);
		BigDecimal do2 = new BigDecimal(1-RIG).pow(badRatings);
		
		//MathContext mc = new MathContext(400);
		BigDecimal up =  up1.multiply(up2).multiply(new BigDecimal(G));
		BigDecimal down = up1.multiply(up2).multiply(new BigDecimal(G)).add( do1.multiply(do2).multiply(new BigDecimal(G)));
		return down;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(getBadPossibility(1000,50));
	}

}
