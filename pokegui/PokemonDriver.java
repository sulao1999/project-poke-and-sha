import java.util.*;
/**
* Using Queue and Stack.
* @author Su Lao
* @since 03/28/2020
*/

public class PokemonDriver {
   /** 
   * main method.
   * @param args not used
   */
   public static void main(String[] args) { 
   /* Use Deque for Stack */
      Deque<Pokemon> stack = new ArrayDeque<Pokemon>();
   /* Queue */
      PriorityQueue<Pokemon> queue = new PriorityQueue<>();
   /* declare variable */
      Pokemon pokemon = null;
   
      for (int i = 0; i < 5; i++) {
         pokemon = new Squirtle();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Venusaur();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Wartortle();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Blastoise();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Ivysaur();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Bulbasaur();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charmeleon();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charizard();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charmander();
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charmander("Hitokage");
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charmander("Alpha");
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charmander("Beta");
         queue.add(pokemon);
         stack.push(pokemon);
         pokemon = new Charmander("Gamma");
         queue.add(pokemon);
         stack.push(pokemon);
      }
      
      System.out.println("Queue List:\n");
      /* print the queue list */
      while (queue.size() > 0) {
         Pokemon current = queue.poll();
         System.out.println(current.toString() + "\n");
      }
   
      System.out.println("Stack List:\n");
      /* print the stack list*/
      while (stack.size() > 0) {
         Pokemon current = stack.pop();
         System.out.println(current.toString() + "\n");
      }
   
   
   
   
   
   
   
   } // Close main

} // Close class