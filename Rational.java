
/**
 * Rational Class.
 *
 * @author Dr. McNallly
 * @version (a version number or a date)
 */
public class Rational
{
  // instance data.  clearly described in the question as only 
  // three variables.  the concept of ALSO STARING A DECIMAL
  // would go against the idea of an objecto 100% as then 
  //the numbers could theoretically disagree
  private int numerator;
  private int denominator;
  private boolean positive;
  
 
  // first construcor:  bring in two numbers (numerator and denominator) 
  // which could be negative or positive
  public Rational(int a, int b)
  {
      // First the question clearly says the instance 
      // data numerator and denominator must be positive value
      // so we absolute value them
      numerator = Math.abs(a);
      denominator = Math.abs(b);

      // next we must find the sign of this rational number
      // there are 4 cases, but easier ti multiply them together.
      // if the product is negative, 1 and only 1 of the numbers is negative
      // and thus the result is negative
      if (a*b < 0)
          positive = false;
      else
          positive = true;
     
      // finally, apply reduce to THIS object which needs no parameters
      reduce();
  }
  
 
  // Second construcor:  bring in one decimal number
  // which could be negative or positive 
  public Rational(double x)
  {
      // first i assign the sign parameter appropriately 
      if (x < 0)
          positive = false;
      else
          positive = true;
          
      // as teh question says, we multiply numerator and denominator by 10 
      // over and over until we get the numerator is an integer
      // i choose a while loop as  numbers like 2.0 woudl already be integers
      //  the denominator  would initialy be 1 as 2.0 = 2.0 / 1
      denominator = 1;
      while( x%1 != 0)
      {
         denominator = denominator * 10;
         x = x * 10;
        }
       
      // now i store the numerator (it has ot lose its decimal oplace so a casting)
      // but remember the denominator has already been stored
      numerator = (int) x;
     
      // i then call reduce (at this point, just assume it works until we program it later
      reduce();
  }
  


  // a toString method converts the object to a string represenation
  // it does not print, it does not have a user.........
  // to get the sign right, use our sign vairable. 
  // using just one of numerator or denominator does not work and they should only be positive
  public String toString()
  {
      String result;
      if (positive) 
           result = "+" + numerator + "/" + denominator;
      else
           result = "-" + numerator + "/" + denominator;
      
      return result;
  }
  

    
  public double convertToDecimal()
  {
      //the fisrt and most important part of this method is to remember that
      // in java  3/4 is 0... integers math.. so convert the numerator to double first
      //         or we could do 1.0*numerator/denominator
      double x = (double) numerator/denominator;

      // then we apply the sign from the sign variable.
      if (!positive)
          x = -x;
          
      return x;
  }
      
  

  // compareTo methods in java are therefore objects to compare themselves
  // to another object of the same type.   so it brings in as  a parametee
  // a rational number
  public int compareTo(Rational x)
  {
      // since i have a method to change rationals to decimals, i use it
      // both on this method and on the one being compared to
      double thisone = convertToDecimal();
      double thatone = x.convertToDecimal();
      

      // compareTo should always return -1, 0 or 1 as below (less than, same or greater than)
      //  from the perspective of what THIS object could say.
      int result = 0;
      if ( thisone < thatone)
          result = -1;
      else if( thisone > thatone)
          result = +1;
     
     return result;
    }
  


  // This method reduced THIS rational number so no input parameter and no output
  //  since this gets called by each constructor i made it private as a method
  // other users of this class should never need to use.
  private void reduce()
  {
   
      // first I found the smaller of the numerator and denominator
      // this is the largest common factor they could have
      int min  = numerator;
      if (denominator < numerator)
         min = denominator;
        
      // now i want to see and reduce the fraction each time there is a common factor
      // first don't check 1.. as all integers divide by 1, this would change or fraction to 
      //   0/0
      
      //  so if i start at 2 and go to the min, when i see a number divided by 2, if it was for example divisible
      // by 4 i would factor out the 2, but never check reduce thte other 2
      // to solve this i scan it from minimum down, so i woudl chek the 4 and factor it out before the 2.
      for (int i = min; i >1; i--)
      {
          if ( (numerator%i == 0) && (denominator%i == 0) )
          {
              // if i is a factor of both num and denom, then divide each by both
              numerator = numerator/i;
              denominator = denominator/i;
            }
      }
              
          
      }
      
      
  }
    
