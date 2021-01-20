/**
* PokemonClassTester test A3.
* @author Lisa Miller
* @since 10/27/2017
*/

public class PokemonClassTester{

  /** main method.
  * @param args not used.
  */
   public static void main(String [] args){
   
      Pokemon[] pArray = {new Bulbasaur(), new Bulbasaur("Bob"), new Ivysaur(), new Ivysaur("Ivy"),
         new Venusaur(), new Venusaur("Vinny"), new Squirtle(),
         new Squirtle("Sam"), new Wartortle(), new Wartortle("Wally"), new Blastoise(),
         new Blastoise("Bluto"), new Charmander(), new Charmander("Charlie"), new Charmeleon(),
         new Charmeleon("Chuck"), new Charizard(), new Charizard("Chaz"), 
         new Eevee(), new Eevee("Eve"), new Vaporeon(), new Vaporeon("Vap"), new Jolteon(),
         new Jolteon("Joe"), new Flareon(), new Flareon("Flame")};
      
      
      for(int i = 0; i < pArray.length; i++){
         System.out.println(pArray[i]);
      
      }
    
    //attack pokemons before in array
      for(int i = 0; i < pArray.length; i++){
         for(int j = 0; j < i;  j++){
            System.out.println(pArray[i].performFastAttack(pArray[j]));
            System.out.println(pArray[i].performSpecialAttack(pArray[j]));
         
         }
      
      }
   //attack pokemons after in array
      for(int i = pArray.length-1; i >= 0; i--){
         for(int j = i-1; j >= 0;  j--){
            System.out.println(pArray[i].performFastAttack(pArray[j]));
            System.out.println(pArray[i].performSpecialAttack(pArray[j]));
         
         }
      
      }
   
   
   } 


}