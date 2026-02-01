public class Book extends GenericBook{
    
    //  the prefered visibility modifier for a public class is private 
    private String  title ;
    private String  author ; 
    private String  isbn ;
    




    // creating Getter methods 
    public String getTitle() {    // <- this method gets the title ( Getter )
        return title ;
    }

    public String getAuthor() {    // <- this method gets the author ( Getter )
        return author ; 
    }

    public String getIsbn() {    // <- this method gets the isbn ( Getter )
        return isbn ; 
    }

    




    // creating Getter methods 

    public void setTitle(String title) {   // <- this method sets the price ( Getter )
        this.title = title ; // the this makes reference the variable to the variable 
    }

    public void setAuthor(String author) {   // <- this method sets the price ( Getter )
        this.author = author ;
    }

    public void setIsbn(String isbn) {   // <- this method sets the price ( Getter )
        this.isbn = isbn;
    }

    



    // Creating Constructors 

    // pubilc Book () {}  this is the no argument constructor and it is the default 

    public Book (String title, String author , String isbn , int pageCount , double price  ) {
        this.title = title ;
        this.author = author ;
        this.isbn = isbn ;
        this.setPageContent( pageCount ) ;
        this.setPrice( price );
    }






    
}
