public class GenericBook {
    
    private int  pageCount ;
    private double price ;

    public int get_pageCount() {    // <- this method gets the page count ( Getter )
        return pageCount ; 
    }

    public double getPrice() {    // <- this method gets the price ( Getter )
        return price ; 
    }

    public void setPageContent(int pageCount) {   // <- this method sets the price ( Getter )
        this.pageCount = pageCount;
    }

    public void setPrice(double price) {   // <- this method sets the price ( Getter )
        this.price = price;
    }

}
