import java.util.Scanner;

public class Income
{
    double grossIncome;
    
    
    public Income(double input)
    {
        grossIncome = input;
    }
    
    
    
    
    
    public void doTaxes()
    {
            double taxableIncome = calcTaxableIncome();
            double fedTax = calcFedTax(taxableIncome);
            double provTax = calcProvTax(taxableIncome);
            
            System.out.printf("\n\n\nYour gross income is: $%.2f \n", grossIncome);
            System.out.printf("Your taxable Income is: $%.2f \n", taxableIncome);
            System.out.printf("Your federal tax bill is: $%.2f \n", fedTax);
            System.out.printf("Your provincial tax bill is: $%.2f \n", provTax);
            System.out.printf("Your total tax bill is income is: $%.2f \n", fedTax + provTax);
            System.out.printf("Your net income (after taxes) is: $%.2f \n", grossIncome - (fedTax + provTax));
            
            return;
    }

    
    
    

    private double calcTaxableIncome()
    {
        Scanner input = new Scanner(System.in);
        
        int married, numChildren;
        double taxableIncome;
        double spouseIncome;  
        double spouseDeduction, childDeduction;
        String response;
        
        System.out.println("Welcome to the tax deduction part of the process: ");
        System.out.printf("Let me ask: are you married? enter Yes or No ==>");
        response = input.nextLine();
        response = response.toUpperCase();
        if (response.equals("YES") )
        {
            System.out.printf("Thanks: please enter the gross income of your spouse ==>");
            spouseIncome = input.nextDouble();
            spouseDeduction = calcSpouseDeduction(spouseIncome);
        }
        else
            spouseDeduction = 0;
        
        System.out.printf("Also Let me ask: How many children under 16 do you have==>");
        numChildren = input.nextInt();
        childDeduction = calcChildDeduction(numChildren);
        
        taxableIncome = grossIncome - 12069   - childDeduction - spouseDeduction;
        if (taxableIncome < 0)
            taxableIncome = 0;
            
        return taxableIncome;
    }
 
    
    
    
    
    private double  calcChildDeduction( int numChildren)
    {
        return numChildren * 2000;
    }
    
    
    
    
    
     private double  calcSpouseDeduction( double spouseIncome)
    {
        double spouseDeduction = 0;
        if (spouseIncome < 12069)
                 spouseDeduction = 12069 - spouseIncome;
                 
        return spouseDeduction;
    }
    
    
    
    
    
    private double calcFedTax(double taxableIncome)
    {
        double fedTax = 0;
        if (taxableIncome  < 47630)
            fedTax = taxableIncome * 0.15;
        else if(taxableIncome  < 95259) 
            fedTax = 47630*0.15 + (taxableIncome  - 47630)* 0.205;
        else if(taxableIncome  < 147667) 
            fedTax = 47630*0.15 + (95259 - 47630)* 0.205 + (taxableIncome  - 95259)* 0.26;
        else if(taxableIncome  < 210371) 
            fedTax = 47630*0.15 + (95259 - 47630)* 0.205 + (147667  - 95259)* 0.26 + (taxableIncome  - 147667)* 0.29;
        else
            fedTax = 47630*0.15 + (95259 - 47630)* 0.205 + (147667  - 95259)* 0.26 + (210371  - 147667)* 0.29 + (taxableIncome  - 210371)* 0.33;          
          
        return fedTax;
    }
    
    
    
    
    
    
    private double calcProvTax(double taxableIncome)
    {
        double provTax = 0;
        if (taxableIncome  < 42592)
            provTax = taxableIncome * 0.0968;
        else if(taxableIncome  < (42592 + 42592)) 
            provTax = 42592*0.0968 + (taxableIncome - 42592)*0.1482;
        else if(taxableIncome  < (42592 + 42592 + 53307)) 
            provTax = 42592*0.0968 + 42592*0.1482 + (taxableIncome  - (42592 + 42592))* 0.1652;
        else if(taxableIncome  < (42592 + 42592 + 53307 + 19287)) 
            provTax = 42592*0.0968 + 42592*0.1482 + 53307* 0.1652 + (taxableIncome  - (42592 + 42592 + 53307))* 0.1784;
        else
            provTax = 42592*0.0968 + 42592*0.1482 + 53307*0.1652 + 19287*0.1784 + (taxableIncome  - (42592 + 42592 + 53307 + 19287))* 0.203;          
          
        return provTax;
    }



}      