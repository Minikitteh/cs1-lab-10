
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class lab10 {
    
    /*************************** METHOD FOR STEP 2 ********************************/
    /* Create a method. You must create a method that:
      •	receives a string indicating the destination of the credit, for instance "home", and 
      •	returns a Boolean value indicating if the credit is denied (false) or not (true). If 
       / the loan is denied, the "denied" message should be displayed by the main method and 
       / the program should end. If the loan is granted, then the program should proceed to the next step.
     ******************************************************************************/
    // Start with its signature and check with your TA
    // Then set to write its body in pseudocode in your word file
    // Finally, translate the body into java right here
	
	String loant;
	public static boolean rloan(String loant){ //test if user input is valid and equal to the loan types available
		
		if (loant.equals("home") || loant.equals("car") || loant.equals("land")){
			return true;
		}
		System.out.println("Loan denied, type of loan is not valid");
			System.exit(0); //exits prigram
		return false;
	} 
	

    
    
    /*************************** METHOD 1 FOR STEP 4 ******************************/
    /* Create a method that takes as parameters the values of r, A, and P (as described 
     * in lab10.docx) and returns N, the number of monthly payments needed. 
     ******************************************************************************/
    // Start with its signature and check with your TA
    // Then set to write its body in pseudocode in your word file
    // Finally, translate the body into java right here
	//public static double N;
	//public static double I;

	public static double moNeeded(double r, double A, double P){
		double N = (Math.log(1/(1-((r*A)/P)))) / Math.log(1+r); //formula given to us, calculates the monthly payments needed
		return N;
	}  
    
    
    /*************************** METHOD 2 FOR STEP 4 ******************************/
    /* Create a method that takes as parameters the values of P, N, and A, and 
     * returns I, the total amount of interest the customer will pay.
     ******************************************************************************/
    // Start with its signature and check with your TA
    // Then set to write its body in pseudocode in your word file
    // Finally, translate the body into java right here

    public static double moI(double P, double N, double A){ //calculates the user's total interest rate with the given formula
		double I = ((P*N)-A);
		return I;
    }
    
    
    /**************************** MAIN METHOD *************************************/
    /* In this method, you will write the relevant set of instructions to
     * make sure that you Loan Tool works accoording to the description provided in
     * the lab word file and as shown in the test cases provided to you
     ******************************************************************************/
    public static void main(String[] args) {
        
        /***** STEP 1: GET CUSTOMER INFORMATION ***********************************/
        /* In this part, you need to get the customer's:
          •	Full name, 
          •	Age, 
          • Occupation, 
          •	Work place/company, 
          •	Social Security Number (SSN), and 
          •	Monthly income. 
         * The social security number is valid only if it is composed of 6 characters: 
         * three consonants and 3 digits. The first character should be a capital letter 
         * consonant, e.g., PW46y3 and T12tV9. 
         * After getting personal information of customer, display "Welcome to our Bank 
         * John Doe", assuming the name of the customer in this case is John Doe. 
         * 
         * Note: you need to validate the customer’s SSN. Here is how:
         * If a customer has a valid SSN, the program will keep running. 
         * However, a customer has three attempts to input a valid SSN. 
         * After three unsuccessful attempts, the program should display  
         * "Loan denied - invalid Social Security Number!" and end.
         ***************************************************************************/
        
		Scanner user = new Scanner(System.in); //getting use's info and storing it to determine if they are applicable to a loan
		System.out.println("Welcome to the Wells Fargo Bank Loan Evaluator!");
		System.out.println("This Loan Evaluator will let you know if you qualify for a loan with our bank.");
		System.out.println("Please make sure you fill in all your information accurately, if not, the program will close.");
        System.out.println("Enter your full name: ");
		String name = user.nextLine();       
        System.out.println("Enter your age: ");
		int age = user.nextInt();
		System.out.println("Enter your occupation: ");
		String occupation = user.next();
		System.out.println("Enter your workplace: ");
		String workp = user.next();
		System.out.println("Enter your monthly income (without the $): ");
		double moin = user.nextDouble();
		System.out.println("Enter your Social Security Number: (don't include the dashes)");
		String ssn = user.next();
		
		int digits = 0, consonants = 0;
		boolean SSNvalid = true;
		int i = 0; //index
		
		System.out.print(ssn.length());
		
			if (ssn.length() == 6) { // checks if string given by user has 6 characters
				if(Character.isUpperCase(ssn.charAt(i)) == true){
					//i++; // increment index
					//consonants++;
					
						while(i < ssn.length()) { // checks if SSN is valid by comparing digits and if it is not a digit, it is a constant
							if(ssn.charAt(i) != 'a' && ssn.charAt(i) != 'e' && ssn.charAt(i) != 'i' &&ssn.charAt(i) != 'o' && ssn.charAt(i) != 'u') {
								if(Character.isDigit(ssn.charAt(i)) == true) {
									digits++;
								}
								else {
									consonants++;
								}
							}
							else {
								SSNvalid = false;
									System.out.println("Loan denied, invalid Social Security Number");
									System.exit(0); //Exits program							
							}
							i++;// increment the index
							if(digits == 3 && consonants == 3) {
								System.out.println("Welcome to our bank, " + name + ".");
							}
						}
				}	
			}
			else{
				System.out.println("Loan denied, invalid Social Security Number");
			}        
        /***** STEP 2: REQUEST THE TYPE OF THE LOAN FROM THE USER ******************/
        /* In this part, you need to get this information from the user and validate 
        // * that the type of loan is "home", "car", or "land". *
		// •	If the type is different from these three options, the loan will be denied. 
          //•	If the loan is denied, the message "Loan denied – type of loan is not valid. 
            should be displayed on the screen and the program should end. 
         *
         * Note: You have already Created a method that:
          //•	receives a string indicating the destination of the credit, for instance "home", and 
          //•	returns a Boolean value indicating if the credit is denied (false) or not (true). If 
           // the loan is denied, the "denied" message should be displayed by the main method and 
            //the program should end. If the loan is granted, then the program should proceed 
           // to the next step.
         //* So in this part, you need to use your method (see above where prompted to write it)
         *****************************************************************************/
		System.out.println("Which type of loan are you applying for, home, car, or land?");
		String loant = user.next();
		rloan(loant);
        /***** STEP 3: EVALUATE CUSTOMER'S ABILITY TO PAY LOAN ***********************/
        /* In this part, the program will ask the user for his or her monthly expenses. 
          •	If customer’s monthly expenses are less than or equal to 35% of the customer’s 
            monthly income, the loan will be approved with a maximum amount of 10 times the 
            customer’s monthly income. 
          •	If customer’s monthly expenses are more than 35% and less than or equal to 50% 
            of the customer’s monthly income, the loan will be approved with a maximum 
            amount of 5 times the customer’s monthly income. 
          •	If the loan is approved, a message should be displayed on the screen congratulating 
            the customer, indicating the loan was approved and the amount. For more details, 
            please refer to the test cases.
          •	If the customer’s monthly expenses are more than 50% of the customer’s monthly 
            income, the loan is denied. If the loan is denied, the following message should 
            be displayed on the screen: "Loan denied – customer has high monthly expenses."  
            See example below in lab10.docx.
         *******************************************************************************/ 
			
		System.out.println("What are your monthly expenses, " + name + " ?");
		double moex = user.nextInt();
		double A = 0;
		if (moex <= (moin*0.35)) {
			System.out.println("Congrats! Max loan available is $" + moin*10);
			A=moin*10;
		}
		else if ((moex >= (moin*0.35)) && (moex <= (moin*0.50))) {
			System.out.println("Congrats! Max loan available is $" + moin*5);
			A=moin*5;
		}else{
			System.out.println("Loan denied, " + name + " has high monthly expenses");
			
		}
        
        
        /***** STEP 4: CALCULATE THE LOAN'S DURATION and THE TOTAL INTEREST ************/
        /* In this part, you have to ask the customer for the annual percentage rate (APR) 
         * and the monthly amount the customer will pay monthly towards the loan.
         * Note: You have already created a method for each of the following:  
           • to compute the number of payments; and
           • to compute the total amount of interest the customer will pay
         * So in this part, you need to use these two methods (see above where prompted to write them)
         *****************************************************************************/
		 double APR =0;
		 System.out.println("What is your annaul percentage rate?");
		 APR = user.nextDouble();
		 double r = APR/12;
		 double P =0;
		 System.out.println("What is your monthly payment?");
		 P = user.nextDouble();
		 double N = 0;
		 double I  = 0;
		 N = moNeeded(r, A, P);
		 System.out.println("Monthly payments needed: " + N);
		 I = moI(P, N, A);
		 System.out.println("Total interest you will pay:  " + I);

        
    }
}