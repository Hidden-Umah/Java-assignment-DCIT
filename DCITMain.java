import java.util.Scanner ; 

public class DCITMain {
    static int num1 ;
    static int num2 ;
    static int result ;

    Scanner input = new Scanner(System.in);

    
    
// <visibility modifier>    <return type>   <nethod name>      <parameters>
        public                 static void       main       (String[] args) {
        
    }

    // Scan First Number 
    public void ScanFirstNum() {
        System.out.println("Enter first Number ");
        num1 = input.nextInt() ;
    }

    // Scan second Number 
    public void ScanSecondNum() {
        System.out.println("Enter second Number ");
        num2 = input.nextInt() ;
    }

    // Add 
    public static int Sum(int num1 , int num2 ) {
        return num1  + num2 ;
    }
}
