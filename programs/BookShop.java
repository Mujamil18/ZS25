package special.programs;

import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        BookShop bShop = new BookShop();
        BookItem[] b = bShop.generateBooks();
        bShop.displayBooks(b);

    }
    public BookItem[] generateBooks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books: ");
        int numberOfBooks = sc.nextInt();
        BookItem[] books = new BookItem[numberOfBooks];
        for(int i=0; i<books.length; i++){
            books[i] = getBook();
        }
        return books;
    }
    public BookItem getBook(){
        BookItem b = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Type: 1-Regular 2-Used 3-Rare");
        int bookType = sc.nextInt();
        sc.nextLine();
        if(bookType == 1 || bookType == 2 || bookType ==3){
            System.out.println("Book Name: ");
            String name = sc.nextLine();
            System.out.println("Book Price: ");
            double price = sc.nextDouble();
            switch(bookType){
                case 1:
                    b = new BookItem(name,price);
                    break;
                case 2:
                    System.out.println("Enter Discount Factor: ");
                    double disc = sc.nextDouble();
                    b = new UsedBook(name, price,disc);
                    break;
                case 3:
                    System.out.println("Enter Premium Factor: ");
                    double premium = sc.nextDouble();
                    b = new RareBook(name, price, premium);
                    break;
                default:
                    b = null;
            }
        }
        else{
            System.out.println("Invalid Option");
        }
        return b;
    }
    public void displayBooks(BookItem[] b){
        for(int i=0; i<b.length; i++){
            System.out.println(b[i] + " " + b[i].getSellingPrice() + " "+ b[i].getListedPrice());
        }
    }
}
