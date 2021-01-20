/**
* Pokemon Tree.
* @author Su Lao
* @since 04/21/2020
*/

public class PokeTree {

   /** private PokeTree root. */
   private PokeNode root;
   /** private String. */
   String s = "";
    
    /**
    * Constructor.
    * Empty PokeTree constructor
    */
   public PokeTree() {
   }
    
    /**
    * Add Pokemon.
    * @param p Pokemon object
    */
   public void add(Pokemon p) {
      root = add(root, p); //call the private add method
   }
         
    /**
    * Recursive add method.
    * @param node The root of the Poketree
    * @param p The Pokemon object
    * @return PokeNode the node or incearse number
    */
   private PokeNode add(PokeNode node, Pokemon p) {
      if (node == null) { //if not exist
         node = new PokeNode(p, 1, null, null);
      } else if (node.getKey() == p.getNumber()) { //if pokemon exist increase the count
         node.increaseNumCaught();
      } else if (node.getKey() < p.getNumber()) { //if key less than the node key move to left 
         node.setRChild(this.add(node.getRChild(), p));
      } else if (node.getKey() > p.getNumber()) { //if key more than the node key move to right 
         node.setLChild(this.add(node.getLChild(), p));
      }
      //System.out.println(node.getPokemon()); //testline
      return node;
   } 

    /**
    * Add Pokemon.
    * @param searchKey The key to search
    * @return pokemon if in the tree, if return null
    */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }
      
      /** 
      * Private recursive get method.
      * @param node The root of the Poketree
      * @param searchKey the key for the pokemon
      * @return pokemon if found or throws exception
      */
   private Pokemon get(PokeNode node, Pokemon searchKey) {
      if (node == null) {
         PokemonException pe = new PokemonException("Pokemon not found");
         throw pe;
      } else if (searchKey.getNumber() == node.getKey()) {
         return node.getPokemon();
      } else if (searchKey.getNumber() < node.getKey()) {
         return this.get(node.getLChild(), searchKey); //if key less than node key move to left
      } else if (searchKey.getNumber() > node.getKey()) {
         return this.get(node.getRChild(), searchKey); //if key more than node key move to right
      }
      return node.getPokemon();
   }
   
   /**
   * Removes node from the tree.
   * Using the example code from BinarySearchTree.java
   * @param searchKey An object key to find the remove object
   */
   public void remove(Pokemon searchKey) {
      root = this.remove(root, searchKey);
   }
   
   /**
   * Recursively removes an item from the tree.   
   * Using the example code from BinarySearchTree.java
   * @param node The root of the tree/subtree
   * @param searchKey find the Pokemon to remove.
   * @return root of current subtree.
   * @throws PokemonException if item not found in tree.
   */
   private PokeNode remove(PokeNode node, Pokemon searchKey) {
   // if item not found, throw exception
      if (node == null) {
         PokemonException pe = new PokemonException("Pokemon not found");
         throw pe;
      }
      // if search key is less than node's search key,
      // continue to left subtree
      else if (searchKey.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), searchKey));
         return node;
      }
      // if search key is greater than node's search key,
      // continue to right subtree
      else if (searchKey.getNumber() > node.getKey()) {
         node.setRChild(this.remove(node.getRChild(), searchKey));
         return node;
      }
      // found node containing object with same search key,
      // so delete it
      else {
         // call private method remove
         try { //if exception show remove the pokemon
            node.decreaseNumCaught();
         } catch (PokemonException pe) {
            node = this.remove(node);
            if (node != null && node.getNumCaught() == 0) {
            node.increaseNumCaught(); //for some bug this will go to 0 without any ec
            }
            return node;
         }
      }
      return node;
   }
   
   /**
   * Helper method that takes a node out of tree.
   * Using the example code from BinarySearchTree.java
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode remove(PokeNode node) {
      // if node is a leaf,return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes
      else {
         // get next Smaller Item, which is Largest Item in Left Subtree
         // The next Smaller Item is stored at the rightmost node in the left
         // subtree.
         PokeNode largestItemInLeftSubtree = this.getItemWithLargestSearchKey(node
             .getLChild());
         // replace the node's item with this item
         node.setPoke(largestItemInLeftSubtree);
         // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }
   
   /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * A example from the BinarySearchTree.java
   * @param node The root of the tree/subtree
   * @return The pokemon with largest key
   */
   private PokeNode getItemWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node;
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   }
   
   /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * A example from the BinarySearchTree.java
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
   
   /**
   * access private print method.
   */
   public String printPokeTree() {
      s = "";
      return this.printPokeTree(root);
   }
      
   /**
   * @param root2 The rot of the tree
   * change to root2 for fixing checkstyle
   * inorder
   */
   private String printPokeTree(PokeNode root2) {
      if (root2 != null) {
         printPokeTree(root2.getLChild());
         s = s + "\n\n " + root2.getPokemon().toString() + "\nCaught: " 
             + root2.getNumCaught(); //copy from the example
         printPokeTree(root2.getRChild());      
      }
      return s;
   }
         
   /** 
   * access private print method.
   * for debugging
   */
   public void preorderPokeTree() {
      preorderPokeTree(root);
   }
   
   /** 
   * @param root2 The root of the tree
   * change to root2 for fixing checkstyle
   */   
   private void preorderPokeTree(PokeNode root2) {
      if (root2 != null) {
         System.out.println("  " + root2.getPokemon().toString() + "\nCaught: " 
             + root2.getNumCaught());
         preorderPokeTree(root2.getLChild());
         preorderPokeTree(root2.getRChild());
      }
   }
} // Close class
