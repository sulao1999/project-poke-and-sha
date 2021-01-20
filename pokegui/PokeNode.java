/**
* PokeNode for the tree of each pokemon.
* @author Su Lao
* @since 04/21/2020
*/

public class PokeNode {
   /** Pokemon data. */
   private Pokemon poke;
   /** Number of pokemon. */
   private int number;
   /** Linked to left child of Pokemon. */
   private PokeNode left;
   /** Linked to right child of Poekmon. */
   private PokeNode right;
   
   /**
   * Constructor.
   * @param p The Pokemon object
   * @param numCaught number of the Pokemon catch
   * @param lChild The address of the left child
   * @param rChild The address of the right child
   * @throws PokemonException if numCaught is less than 1
   */
   public PokeNode(Pokemon p, int numCaught, 
       PokeNode lChild, PokeNode rChild) 
      throws PokemonException {
      if (p != null) {
         poke = p;
      } else {
         PokemonException pe = new PokemonException("Pokemon cannot be null object.");
         throw pe;
      }
      if (numCaught >= 1) {
         number = numCaught;
      } else {
         PokemonException pe = new PokemonException("The number of catch cannot less than 1");
         throw pe;
      }
      left = lChild;
      right = rChild;
   } //close Constructor
      
   /** 
   * Gets the Pokemon inside the node.
   * @return p the Pokemon
   */      
   public Pokemon getPokemon() {
      return poke;
   }
   
   /** 
   * Gets the Pokemon species' number.
   * @return Pokemon species number
   */      
   public int getKey() {
      return poke.getNumber();
   }
      
   /** 
   * Gets the Pokemon number of Caught.
   * @return Pokemon number of Caught
   */        
   public int getNumCaught() {
      return number;
   }
   
   /** 
   * Gets the left child of the Pokemon.
   * @return left child of the Pokemon
   */  
   public PokeNode getLChild() {
      return left;
   }
     
   /** 
   * Gets the right child of the Pokemon.
   * @return right child of the Pokemon
   */     
   public PokeNode getRChild() {
      return right;
   }
   
   /**
   * increase the NumCaught by one.
   */
   public void increaseNumCaught() {
      number++;
   }
   
   /**
   * increase the NumCaught by one.
   * @throws PokemonException if numCaught is less than 1
   */   
   public void decreaseNumCaught() throws PokemonException {
      number--;
      if (number < 1) { //throw exception if numCaught less than 1
         PokemonException pe = new PokemonException("The number of catch cannot less than 1");
         throw pe;
      }
   }
   
   /**
   * set newLChild to the left child of the node.
   * @param newLChild the new left child to beset.
   */
   public void setLChild(PokeNode newLChild) {
      left = newLChild;
   }
      
   /**
   * set newRChild to the right child of the node.
   * @param newRChild the new right child to beset.
   */
   public void setRChild(PokeNode newRChild) {
      right = newRChild;
   }   
   
   /**
   * access private setPokemon
   * helper method should be private.
   * @param newPokeNode replace the node
   */
   protected void setPoke(PokeNode newPokeNode) {
      setPokemon(poke, newPokeNode); //set the newPokemon to node Pokemon
   }
   
   /** 
   * private setPokemon method.
   * @param p the pokemon
   * @param newPokeNode the node hold the new pokemon
   */
   private void setPokemon(Pokemon p, PokeNode newPokeNode) {
      poke = newPokeNode.getPokemon();
   }
} // Close class