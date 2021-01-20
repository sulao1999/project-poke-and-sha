import javax.swing.JFrame;

/**
* PokemonFrame.
* Group 2
* @author Su Lao, Yeji Han
* @since 04/29/2020
*/

public class PokemonFrame {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("Pokemon");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add PokemonPanel object to Frame
      frm.getContentPane().add(new PokemonPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}