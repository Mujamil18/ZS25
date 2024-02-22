package special.programs;

public class BookItem {
    protected String name;
    protected double listedPrice;
    BookItem(String name, double listedPrice){
        this.name = name;
        this.listedPrice = listedPrice;
    }
    public double getSellingPrice(){
        return listedPrice;
    }
    public double getListedPrice(){
        return listedPrice;
    }
    public String name(){
        return name;
    }
    public String toString(){
        return "Book Item -> "+ this.name;
    }
}
class UsedBook extends BookItem{
    protected double discountFactor;
    UsedBook(String name, double listedPrice, double discountFactor){
        super(name, listedPrice);
        this.discountFactor = discountFactor;
    }
    public double getSellingPrice(){
        return (1-discountFactor) * listedPrice;
    }
    public String toString(){
        return "Used Book -> "+name;
    }
}
class RareBook extends BookItem{
    protected double premiumFactor;
    RareBook(String name, double listedPrice, double premiumFactor){
        super(name, listedPrice);
        this.premiumFactor = premiumFactor;
    }
    public double getSellingPrice(){
        return (1+premiumFactor) * listedPrice;
    }
    public String toString(){
        return "Rare Book -> "+ name;
    }
}
