package atmInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmOperationImpl implements AtmInterface{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
    Scanner in=new Scanner(System.in);
///Method to ViewBalance 
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }
//Method To WithDrawAmount
    @Override
    public void withdrawAmount(double withdrawAmount) {
    	
        if(withdrawAmount%200==0) {
        	
                    if (withdrawAmount <= atm.getBalance()) {
            	System.out.println("confirm? Y/N");
            	String confirm=in.next();
            	if(confirm.equals("Y"))
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multipal of 200");
        }

    }
//Method To Deposit Amount
    @Override
    public void depositAmount(double depositAmount) {
    	System.out.println("confirm ? Y/N");
    	String confirm=in.next();
    	if(confirm.equals("y"));
        ministmt.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }
///Method to View Mini Statement
    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}