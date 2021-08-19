// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Maverick Berkland
// RESOURCES: No resources were
//            used in the making of this project.

////////////////////////////////////////////////////////////////
// ATTENTION: WebCAT will not deduct style points for your JUnit 
// test files.  Use of magic numbers is permitted in tests, and 
// javadoc for each method is optional.  However, it's good to 
// add comments that describe the purpose of each test if you 
// have time before the lab is due.
////////////////////////////////////////////////////////////////

import static org.junit.Assert.*;   // A Checkstyle error on this line is okay.

import org.junit.Test;

/**
 * This class provides a series of JUnit test cases corresponding
 * to the SavingsAccount.java functionality.
 * 
 * @author mberkland
 */
public class SavingsAccountTest
{
	///////////////////////////////////////////////////////////////
	// ATTENTION: Some sample tests are provided here to help you
	// get started.  Feel free to refer back to them as examples.
	// but we do not recommend editing them.
	///////////////////////////////////////////////////////////////
	
	
	//CONSTRUCTOR
	
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * This test verifies the behavior of the default constructor when 
	 * provided valid parameter values.  Getters are also exercised to
	 * verify that the object has been set up correctly.
	 */
	@Test
	public void testConstructorBasic()
	{
		//STEP 1: Setup prior state of the object
		//Since we're testing a constructor here, this step is not applicable.
		
		//STEP 2: Call the method being tested
		SavingsAccount a = new SavingsAccount("Herbie", "Durango", 9721, 10.52);
		a.setFirstName("Maverick");
		//STEP 3: Verify the post-state of the object
		assertEquals("Maverick", a.getFirstName());
		assertEquals("Durango", a.getLastName());
		assertEquals(9721, a.getAccountNumber());
		
		// When comparing double or float values, assertEquals takes a 
		// third parameter that specifies how close the two values need to
		// be to be considered equal.
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
		
		//STEP 4: Verify the return value of the method called
		//For constructors, verifying the "post-state" in step 3 and the return 
		//value are synonymous.  There's nothing more to do here.
	}

	
	//FIRST NAMES
	
	/**
	 * This test verifies that calling setFirstName with a valid string will
	 * cause the SavingsAccount to take on the new name.
	 */
	@Test
	public void testSetFirstNameValid()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName("Herbie");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Herbie", a.getFirstName());	//first name should have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with null values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValidNull()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName(null);
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with empty values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValidEmpty()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName("");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////
	// YOUR TESTS GO BELOW!  Try to write additional tests that exercise all of 
	// the code in SavingsAccount.java
	////////////////////////////////////////////////////////////////////////////
	
	
	//LAST NAMES
	
	/**
	 * This test verifies that calling setFirstName with a valid string will
	 * cause the SavingsAccount to take on the new name.
	 */
	@Test
	public void testSetLastNameValid()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setLastName("Herbie");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Herbie", a.getLastName());   //last name should have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with null values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetLastNameInValidNull()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setLastName(null);
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with empty values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetLastNameInValidEmpty()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setLastName("");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	
	
	//DEPOSITS
	
	/**
	 * This test verifies that calling deposit with valid
	 * values will properly change the amount.
	 */
	@Test
	public void testDepositValid()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(true, a.deposit(695.6)); //True
		assertEquals(1009.62, a.getBalance(), DOUBLE_TOLERANCE); //Changes
	}
	
	/**
	 * This test verifies that calling deposit with a
	 * negative value will not change the amount.
	 */
	@Test
	public void testDepositNegative()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(false, a.deposit(-300)); //False
		assertEquals(314.02, a.getBalance(), DOUBLE_TOLERANCE); //No Changes
	}
	
	/**
	 * This test verifies that calling deposit with a
	 * value of 0 will not change the amount.
	 */
	@Test
	public void testDepositZero()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(false, a.deposit(0)); //False
		assertEquals(314.02, a.getBalance(), DOUBLE_TOLERANCE); //No Changes
	}
	
	
	//WITHDRAWAL
	
	/**
	 * This test verifies that calling withdraw with a
	 * positive value will decrease the amount.
	 */
	@Test
	public void testWithdrawValid()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(true, a.withdraw(310.88)); //True
		assertEquals(3.14, a.getBalance(), DOUBLE_TOLERANCE); //Changes
	}
	
	/**
	 * This test verifies that calling withdraw with a
	 * negative value will not change the amount.
	 */
	@Test
	public void testWithdrawNegative()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(false, a.withdraw(-300)); //False
		assertEquals(314.02, a.getBalance(), DOUBLE_TOLERANCE); //No Changes
	}
	
	/**
	 * This test verifies that calling withdraw with a
	 * value of 0 will not change the amount.
	 */
	@Test
	public void testWithdrawZero()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(false, a.withdraw(0)); //False
		assertEquals(314.02, a.getBalance(), DOUBLE_TOLERANCE); //No Changes
	}
	
	
	//INTEREST RATE
	
	/**
	 * This test verifies that calling setInterestRate
	 * and applyInterestRate with a
	 * positive value will increase the amount.
	 */
	@Test
	public void testInterestRatePositive()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		a.setInterestRate(0.1); //0.00833% per month
		a.applyMonthlyInterest();
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(314.046168333, a.getBalance(), DOUBLE_TOLERANCE); //Changes
	}
	
	/**
	 * This test verifies that calling setInterestRate
	 * and applyInterestRate with a
	 * negative value will not change the amount.
	 */
	@Test
	public void testInterestRateNegative()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		a.setInterestRate(-203.88); //-16.99% interest rate monthly
		a.applyMonthlyInterest();
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(260.668002, a.getBalance(), DOUBLE_TOLERANCE); //No Changes
	}
	
	/**
	 * This test verifies that calling setInterestRate
	 * and applyInterestRate with a
	 * ZERO value will not change the amount.
	 */
	@Test
	public void testInterestRateZero()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		a.setInterestRate(0); //0% interest rate
		a.applyMonthlyInterest();
		
		assertEquals("Maverick", a.getFirstName()); //No Changes
		assertEquals("Berkland", a.getLastName()); //No Changes
		assertEquals(2002, a.getAccountNumber()); //No Changes
		assertEquals(314.02, a.getBalance(), DOUBLE_TOLERANCE); //No Changes
	}
	
	//TO STRING
	
	/**
	 * This test verifies that calling toString
	 * will correctly format the information.
	 */
	@Test
	public void testToString()
	{
		SavingsAccount a = new SavingsAccount("Maverick", "Berkland", 2002, 314.02);
		
		assertEquals("2002: $314.02", a.toString());
	}
}
