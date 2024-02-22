package com.zs25.programs;

public class BooksTest {
    public static void main(String[] args) {
        Books[] books = new Books[3];
//        books[0] = new Books("Do Epic Shit", "Ankur Warikoo");
//        books[1] = new Books("The Power of Habit", "Charles Duhigg");
//        books[2] = new Books("Atomic Habits", "James Clear");
        for(int i =0; i<books.length; i++){
            System.out.println(books[i]);
        }
    }
}
class Books{
    String title;
    String author;
    Books(){

    }
    Books(String title, String author){
        this.title = title;
        this.author = author;
    }
    public String toString(){
        return this.title + " by " + this.author;
    }
}