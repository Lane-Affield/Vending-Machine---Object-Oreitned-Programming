/* Name: Lane Affield
 * Date: 11/28
 * Description: GUI implementation of the vending machine created in assignment 7 
 * Sources: Emma Gerdeman helped me with the GridPane
 */

package Vending;

public class VendingMachine implements VendingMachineInterface{
	//Variables for vending machine
	private int[] option = new int [3];
	private int total_money = 0; 
	private int selection = 0; 
	private int profit = 0; 
	private static String[] candy = {"Snickers" , "Twix" , "reeses"};
	private static int[] prices = {100, 115, 130};

	
	public VendingMachine(int s, int t, int r) 
	{
		option[0] = s; 
		option[1] = t;
		option[2] = r;
	}
	@Override
	public void insertCents(int c) 
	{
		
		if(c % 5 == 0)
		{
			total_money += c; 		//adds to the total money
		}
		else
		{
			throw new ImproperCoinsException(); //throws exception if the amount of money is not a multiple of 5
		}
	}

	@Override
	public void makeSelection(int s) 
	{

		if(s < 0 || s > 2)
		{
			throw new ImproperSelectionException(); //throws exception if the amount of money is not between 0-2
		}
		else if (option[s] == 0)
		{
			throw new ImproperSelectionException(candy[s]); //throws exception if an item is out of stock
		}
		else 
		{
			selection = s;  //sets the selection to the s input
		}
	}

	@Override
	public int purchaseSelection() 
	{

		
		if (selection ==-1)
		{
			throw new ImproperPurchaseException();  // throws exception when there is not a correct input 
			
		}
		else if(total_money < prices[selection])
		{
			throw new ImproperPurchaseException(prices[selection] - total_money);
		}

		//returns the number of coins 
		profit += prices[selection]; //adds to profit 
		total_money = total_money - prices[selection];
			
		return total_money; // returns the coins back
	}

	@Override
	public int returnUnspentCents()
	{
		//returns the unspent money 
		int unspent = total_money;
		selection = -1;  //resets election 
		total_money = 0; //resets total money 
		return unspent; //returns the unspent amount of money
		

	}

	@Override
	public int getProfits() 
	{

		
	//gets the profits and returns the amount
		return profit;
		
	}

}
