import java.util.Scanner; 

public class DCIT {
    
    // DCIT LECTURES ----------------------------------------------------------------------------------------------

    /*

    ====== BASICS =============
    - Java follows camel casing notation -> so naming something like 'is book available '
    - will look like -> IsBookAvailable 
    - Println prints and moves to a new line
    
    
    ====== MAIN METHOD ========
    the main method is where the program starts.
    its accepts an array of strings ' String[] ' that will be stored in a variable called args


    ====== COMPILING ==========
    - To complie compile use javac " Java Compiler "
    - To run the program - call java and add the name of the file 



    */ 






    public static void main(String[] args) {

        int num1, num2 , result = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter First number ");
        num1 = input.nextInt() ;

        System.out.println("Enter Second number ");
        num2 = input.nextInt() ;


        result = num1 + num2 ;
        System.out.println("Adding the two numbers will give us " + result);

        input.close();

    }
}
