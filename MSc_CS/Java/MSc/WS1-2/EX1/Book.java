
/** Book is a class for a program that will give user information about  
 *  a book, the title, year and isbn
 *
 *  @author Frances Adriana Laureano De Leon
 *  @version 22/10/18
 */


public class Book{

    private String title;
    private int year;
    private String isbn;

    /** 
     *  This is my Book constructor which takes in three arguments and takes in 
     *  some information about a book. 
     *
     *  @param title takes in book title as a string
     *  @param year takes in the year book was published as interger
     *  @param isbn takes in the isbn number as a string
     */

    public Book(String title, int year, String isbn){
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }
    

    /** 
     *  Allows me to set the value of title
     *  @param title for changed title 
     */

    public void setTitle(String newTitle){
        title = newTitle;    
    }

    /** 
     *  returns title as string
     */

    public String getTitle(){
        return title;
    }

    /** 
     *  Allows me to set the value for year
     *  @param year for the changed year
     */

    public void setYear(int newYear){
        year = newYear;
    }


    /** 
     *  returns year as integer 
     */

    public int getYear(){
        return year;
    }

    /** 
     *  Allows me to set the value for isbn
     *  @param isbn for the changed isbn
     */

    public void setIsbn(String newIsbn){
        isbn = newIsbn;
    }

    /** 
     *  returns isbn as string
     */

    public String getIsbn(){
        return isbn;
    }

    /** 
     *  Sets the format for how Book will print
     */

    public String toString(){
        return "The book you are searching for is " + "" + title + "" + " from year "+ "" + year + "" + " with isbn: " + isbn + ".";
    }
    
    //  the main method is there just for me to run from terminal.

    public static void main(String[] args){
        Book b = new Book("Crime and Punishment", 2003, "09090909");
        System.out.println(b);
    }
}

/**
 * Passed 7/7 of my Junit tests and passed Manfred's Junit tests. My Junit tests were closely based on what Manfred provided because I am unsure of what else to test for in my code.
 */
