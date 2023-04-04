
/*
 * Name: Lane Affield
 * Date: 11/11/22
 * Description: This program creates a virutal vending machine that can take coins and 
 * 				lets a user buy a candybar if there is enough money it buys a candy bar
 * 				and also returns the unused change. the program can also return the profits
 * 	SOURCES: 	Morgan helped me with turning variables into arrays and Sam Basala helped with 
 * 				getting my test 8 to work. 		
 */


package Vending;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class VendingMachineTester 
{
	@Test 
	//Test 1
	//Test if an ImproperCoinsException is thrown when a customer inserts a number of centsthat is not a multiple of 5.
	(expected = ImproperCoinsException.class)
	public void ImproperCoinTest() 
	{
		VendingMachine  vendTest1 = new VendingMachine (9,9,9);
		vendTest1.insertCents(12);
				
	}
	
	@Test
	//Test 2
	//2. Test if an ImproperSelectionException is thrown when a customer selects an item numberthat isn’t 0, 1, or 2.
	(expected = ImproperSelectionException.class)
	public void ImproperSelectionTest1() 
	{
		VendingMachine vendTest2 = new VendingMachine(9,9,9);
		vendTest2.makeSelection(9);
	}
	
	@Test
	//Test 3
	//Test if an ImproperSelectionException is thrown when a customer selects an item that is sold out.
	(expected = ImproperSelectionException.class)
	public void ImproperSelectionTest2()
	{
		VendingMachine vendTest3 = new VendingMachine(7,0,11);
				vendTest3.insertCents(110);
				vendTest3.makeSelection(1);
				vendTest3.purchaseSelection();
	}
	@Test
	//Test04
	//Test if an ImproperPurchaseException is thrown when a customer attempts to make a purchase before selecting an item
	(expected = ImproperPurchaseException.class)
	public void ImproperPurchaseTest1()
	{
		VendingMachine vendTest4 = new VendingMachine (7,8,3);
		vendTest4.purchaseSelection();
	}
	@Test 
	//Test 05 
	// Test if an ImproperPurchaseException is thrown when a customer attempts to make apurchase before he/she has inserted enough cents into the machine.
	(expected = ImproperPurchaseException.class)
	public void ImproperPurchaseTest2()
	{
		VendingMachine vendTest5 = new VendingMachine(9,9,9);
				vendTest5.insertCents(40);
				vendTest5.makeSelection(2);
				vendTest5.purchaseSelection();	
	}
	
	@Test
	// Test 06 
	//Test if the correct amount of cents is returned to the customer after he/she has purchased anitem.
	public void CoinsBackTest1()
	{
		VendingMachine vendTest6 = new VendingMachine(3,3,3);
		vendTest6.insertCents(175);
		vendTest6.makeSelection(2);
		assertEquals(45, vendTest6.purchaseSelection());
	}
	
	@Test 
	// Test 7 
	// Test if the correct amount of cents is returned to the customer after he/she has decided notto make a purchase press the button to return unspent cents
	public void CoinsBackTest2() 
	{
		VendingMachine vendTest7 = new VendingMachine(3,3,3);
		vendTest7.insertCents(50);
		assertEquals(50, vendTest7.returnUnspentCents());
	}
	
	@Test
	//Test 8 
	// Test if the getProfits method returns the correct amount of cents after several purchaseshave been made
	public void profitsTest()
	{
		VendingMachine vendTest8 = new VendingMachine(3,3,3);
		vendTest8.insertCents(425);
		vendTest8.makeSelection(1);
		vendTest8.purchaseSelection();
		vendTest8.makeSelection(1);
		vendTest8.purchaseSelection();		
		vendTest8.returnUnspentCents();
		assertEquals(230, vendTest8.getProfits());
	}


}

