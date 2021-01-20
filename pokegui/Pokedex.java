import java.util.Scanner;
/**
* Driver program for the Pokemon tree.
* @author Su Lao
* @since 04/21/2020
*/

public class Pokedex {
   /** 
   * main method.
   * @param args not used
   */
   public static void main(String[] args) { 
      //declare variable
      PokeTree tree = new PokeTree();
      Pokemon p = null;
      Scanner scan = new Scanner(System.in);
      boolean exit = false;
      String choice = "";
      
      while (!exit) {
         //menu
         System.out.println("_______________________________________");
         System.out.println("What you want to do?");
         System.out.println("Please enter the number of your choice:");
         System.out.println("1. Catch Pokemon");
         System.out.println("2. Trade Pokemon");
         System.out.println("3. Print Pokedex");
         System.out.println("0. Quit");
         System.out.println("_______________________________________");
      
         //Get user's input
         choice = scan.nextLine();
         choice = choice.trim();
         
         switch(choice) {
            case "1":
               System.out.println("Gotta Catch 'Em All !");
               System.out.println("Which Pokemon do you want to catch?");
               tree.add(menuOfPoke()); //add pokemon
               break;
            case "2":
               System.out.println("Trade Pokemon");
               System.out.println("Which Pokemon do you want to trade?");
               p = menuOfPoke(); //get the userchoice
               try {
                  tree.get(p); //if not found should thorw error and catch
                  tree.remove(p); //remove
                  System.out.println("Which Pokemon do you want to add?");
                  tree.add(menuOfPoke()); //add pokemon
                  System.out.println("Successful traded Pokemon");
               } catch (PokemonException pe) {
                  System.out.println("This Pokemon not caught yet.");
               }
               break;
            case "3":
               System.out.println("Print Pokedex");
               String s = tree.printPokeTree(); //passed
               System.out.println(s);
               //input pokemon 4 2 1 3 6 5 7
               //output        1 2 3 4 5 6 7
               //tree.preorderPokeTree();
               break;
            case "0": //exit when user choose 0
               System.out.println("Good Bye");
               exit = true;
               break;
            default :
               System.out.println("Error:");
               System.out.println("Please enter a 0, 1, 2, or 3");
               break;
         } //close switch
      } //close while
   } // Close main
   
   /**
   * Choice a pokemon.
   * @param stage set name only happen when stage is 0
   * @return pokemon the Pokemon user choose
   */
   public static Pokemon menuOfPoke() {
      //Scanner for makePok method
      Scanner scan = new Scanner(System.in);
      //Instance variables for makePokemon methods.
      Pokemon p = null; //have to set to something first.
      String name = new String("");
      String choice = new String("");
      boolean exit = false;
      
      /* List of Pokemon 
      * 1 for Bulbasaur,  2 for Ivysaur,    3 for Venusaur
      * 4 for Charmander, 5 for Charmeleon, 6 for Charizard
      * 7 for Squirtle,   8 for Wartortle,  9 for Blastoise
      *10 for Eevee,     11 for Vaporeon,  12 for Jolteon,  13 for Flareon
      *  End of the list */
      System.out.println("Choose a Pokemon:");
      System.out.println("\t 1 for Bulbasaur \n\t 2 for Ivysaur   \n\t 3 for Venusaur");
      System.out.println("\t 4 for Charmander\n\t 5 for Charmeleon\n\t 6 for Charizard");
      System.out.println("\t 7 for Squirtle  \n\t 8 for Wartortle \n\t 9 for Blastoise"); 
      System.out.println("\t10 for Eevee");
      System.out.println("\t11 for Vaporeon  \n\t12 for Jolteon \n\t13 for Flareon");
      
      //only exit when user choosen a pokemon
      while (!exit) { //only exit when user choosen a pokemon.
         System.out.print("Enter the number of the Pokemon: ");
         //Get user's input
         choice = scan.nextLine();
         choice = choice.trim();
         //switch
         switch(choice) {
            case  "1":
               p = new Bulbasaur();
               exit = true;
               break;
            case  "2":
               p = new Ivysaur();
               exit = true;
               break;
            case  "3":
               p = new Venusaur();
               exit = true;
               break;
            case  "4":
               p = new Charmander();
               exit = true;
               break;
            case  "5":
               p = new Charmeleon();
               exit = true;
               break;
            case  "6":
               p = new Charizard();
               exit = true;
               break;
            case  "7":
               p = new Squirtle();
               exit = true;
               break;
            case  "8":
               p = new Wartortle();
               exit = true;
               break;
            case  "9":
               p = new Blastoise();
               exit = true;
               break;
            case  "10":
               p = new Eevee();
               exit = true;
               break;
            case  "11":
               p = new Vaporeon();
               exit = true;
               break;
            case  "12":
               p = new Jolteon();
               exit = true;
               break;
            case  "13":
               p = new Flareon();
               exit = true;
               break;
            default : //error message and not exit the loop.
               System.out.println("\n_________Invalid menu choice.___________");
               System.out.println("Please, enter a number that's 1 to 13");
               break;
         } //end switch
      } //end whlie
      
      /*
      if (stage == 0) { //only happen when stage is 0
      //get poekmon name
         System.out.println("What is the Pokemon's name? (if no just press enter.)");
         name = scan.nextLine().trim(); //get the name
         if (name.length() == 0) { //if name is space or empty, will not print name
            p.setName(p.getSpecies());
         } else {
            p.setName(name); //set the name.
         } 
      }
      */
      
      //System.out.println(p); //Testline.
      return p;
   }
      
} // Close class