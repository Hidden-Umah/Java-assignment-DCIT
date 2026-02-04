public class Grader {

    
    public void executeGradeReport( double score ) {

        if(validateScore(score)) {

            char grade = calculateLetterGrade(score) ;
            
            displayPerformanceMessage(grade) ;
            
        } else {
            System.out.println("Invalid Score");
            return ;
        }
        


    }
}
