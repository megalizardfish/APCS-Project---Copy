import java.util.*;
import java.io.*;

public class Store{
   
   
   private String name = "";
   private int cost = 0;
   private boolean purchase = false;
   Weapon w;
  
    //ArrayList for the weapons
   private ArrayList<Weapon> weapon =new ArrayList<Weapon>();
      //Store Name ArrayList
   private ArrayList<String> storeName= new ArrayList<String>(Arrays.asList("Merek","Carac","Ulric","Tybalt","Borin","Sadon","Rowan","Forthwind","Althalos","Fendrel", "Brom", "Hadrian","Jarin","Cassius","Leo","Cedric","Gavin","Peyton","Josef","Janshai","Doran","Asher","Quinn","Zane","Xalvador","Favian","Destrian","Dain","Letholdus"));
    //ArrayList for the second half of the store name.
   private  ArrayList<String>  storeName2=new ArrayList<String>(Arrays.asList("Emporium", "Caravan", "Bazaar", "Trade Depot", "House of Wonders", "Market", "Stand", "Marketplace"));
   private Scanner s = new Scanner(System.in);
   private int randomnum = ((int) Math.random()*11);
   private boolean finish;
   int cash=0;

   
   public void Store(int money) throws IOException{
      purchase = false;
      cash = money;
   
      for(int i = 0; i<= randomnum;i++)
      {
         Weapon x = new Weapon((((int)(Math.random()*21)*10)+11));
         weapon.add(x);
      }
      
      //getting random number for both name arrays and making a name string from the values that they generate
      int rand = (int)(Math.random()*storeName.size());
      int rand2= (int)(Math.random()*storeName2.size());  
      name = storeName.get(rand)+"'s "+storeName2.get(rand2);    
      System.out.println("Hello, and welcome to "+name+"!\nMy wares are better than any other's!\nThese are my items!");
     
     
      for(int i = 0; i<weapon.size();i++)
      {
         System.out.println(weapon.get(i).getName());
      }
    
      System.out.println("Do any of these interest you?");
      
      
      if(s.nextLine().toUpperCase().equals("YES"))
      {
         boolean finish = false;
         
         printIt();
              
      }
      else
      {
         finish = true;
      }
   }
   

   public void printIt()
   {    
      for(int i = 0; i<weapon.size();i++)
      {
         System.out.println((i+1)+". "+weapon.get(i)+" $ "+weapon.get(i).getPrice());
      }
      System.out.println("Please enter the numerical value of item you want, or press 0 to cancel");
      int val = s.nextInt();
         
      purchase(val);
   }
       
   public void purchase(int val)
   {      
      if(val<=0)
      {
         System.out.println("You canceled your transaction");
         finish = true;           
      }
      
      else if(cash < weapon.get(val-1).getPrice())
      {
         System.out.println("I think its out of your price range, would you like to buy something else?");
         if(s.nextLine().toUpperCase().equals("YES"))
         {
            printIt();
         }
         else
         {
            val = 0;
            purchase(val);
         }
      }
                
      else
      {
         System.out.println("It costs this much: "+weapon.get(val-1).getPrice()+"\nIs that acceptable?");
         if(s.nextLine().toUpperCase().equals("YES"))
         {
            cost = weapon.get(val-1).getPrice();
            System.out.println("Thank you for your purchase");
            w=weapon.get(val-1);
            purchase = true;
            finish = true;
         }           
      }
   }
}
    
    /*
   public Weapon getWeapon()
   {
   return w;
   }
 */
