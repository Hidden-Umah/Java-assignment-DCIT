public class Assignment2Average {

    

    public double CalculateClassAverage (double num1,double num2){
            double sum = num1 + num2 ;
            double average = sum /2.0;
            return average ;
    }

    public double CalculateClassAverage( double input1,double input2, double input3){
        double sum = input1 + input2 + input3 ;
        double average = sum /3.0;
        return average ;

    }


    public double CalculateClassAverage( double[] scores){
        double sum = 0;
            
        for (double s: scores){
            sum += s;

        }
        return sum/scores.length;

    }

}