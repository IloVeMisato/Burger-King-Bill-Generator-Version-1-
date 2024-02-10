package Objorient;

class Burger{
    private int price;
    private Boolean veg;
    private int extraCheese = 35;
    private int extraFries = 49;
    private int extraCoke = 79;
    private int Deserts = 99;
    private int homeDelivary = 49;
    private int regularBurger ;
    private boolean isExtraCheeseAdded = false;
    private boolean isExtraFriesAdded = false;
    private boolean isExtraCokeTaken = false;
    private boolean isDesertTaken = false;
    private boolean parcelOrderedHome = false;

    public Burger(Boolean veg){  // Non veg ke liye ye wala tha - Boolean true matlab veg and false matlab Non veg --Binary
        this.veg = veg;
        if(this.veg){
            this.price = 129;
        }else {
            this.price = 169;
        }
        regularBurger = this.price;
    }
    public void addExtraCheese(){
        isExtraCheeseAdded =true;
        this.price += extraCheese;
    }
    public void addExtraFries(){
        isExtraFriesAdded = true;
        this.price += extraFries;
    }
    public void addExtraCoke(){
        isExtraCokeTaken = true;
        this.price += extraCoke;
    }
    public void addDeserts(){
        isDesertTaken =true;
        this.price += Deserts;
    }
    public void addParceltoHome(){
       parcelOrderedHome = true;
       this.price += homeDelivary;
    }
    public void totalBill(){
        String bill = "";
        System.out.println("Regular Mc Burger is : " + regularBurger);
        if(isExtraCheeseAdded){
            bill += "Extra Cheese added : " + extraCheese + "\n Ammount is : ";
        }
        if(isExtraFriesAdded){
            bill += "Extra packet of Fries are added : "+ extraFries + "\n Ammount is : ";
        }
        if(isExtraCokeTaken){
            bill += "Extra glass of Coke : " + extraCoke + "\n Ammount is : ";
        }
        if(isDesertTaken){
            bill+="Desert Taken" + Deserts + "\n Ammount is : ";
        }
        if (parcelOrderedHome){
            bill +="Home Delievary - " + homeDelivary + "\n Ammount is : ";
        }
        bill += "Total Ammount is :" + this.price +  "\n";
        System.out.println(bill);
    }
}

class JumboOffer extends Burger{
    public JumboOffer(Boolean veg) {
        super(veg);
        super.addExtraCheese();
        addExtraCoke();
        addExtraFries();
    }
}

class MegaOffer extends JumboOffer{

    public MegaOffer(Boolean veg) {
        super(veg);
        super.addExtraCheese();
        super.addDeserts();
        super.addExtraCoke();
    }
}

public class BurgerKingBillGenerator {
    public static void main(String[] args) {
        Burger burger = new Burger(true);
        burger.addExtraCoke();
        burger.totalBill();

        JumboOffer jumbo = new JumboOffer(true);
        jumbo.addParceltoHome();
        jumbo.totalBill();


        //Already has Constructors of Burgers
        MegaOffer offer = new MegaOffer(false);
        offer.totalBill();

    }
}
