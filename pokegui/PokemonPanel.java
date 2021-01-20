import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
/**
* Panel for PokemonFrame GUI.
* @author Yeji Han, Su Lao
* @since 05/05/2020
*/

public class PokemonPanel extends JPanel {
   
   /** Context. */
   private Component mContext;
   /** PokedexButton with image. */
   private ImageIcon image = new ImageIcon("Pokedex.png");
   /** CatchIconButton with image. */
   private ImageIcon catchIcon = new ImageIcon("pokeball.png");
   /** BackPackButton with image. */
   private ImageIcon backpack = new ImageIcon("backpack.png");
   
   /** sub-panel. */
   private JPanel topSubPanel = new JPanel();
   /** sub-panel. */
   private JPanel centerSubPanel = new JPanel();
   /** sub-panel. */
   private JPanel bottomSubPanel = new JPanel();
   /** Tabbed-panel. */
   private JTabbedPane bottomTabPane = new JTabbedPane();
   /** pokedexTextArea. */
   private JTextArea pokedexTextArea = new JTextArea();
   /** backpackTextArea. */
   private JTextArea backpackTextArea = new JTextArea();
   
   /** declare and initialize ActionListener obj. */
   private GUIListener listener = new GUIListener();
   
   /** Hunt button. */
   private JButton huntbutton = new JButton("Hunt");
   /** Catch button. */
   private JButton catchbutton = new JButton("Catch");
   /** Pokedex button. */
   private JButton pokedexbutton = new JButton("", image);
   /** Backpack button. */
   private JButton backpackbutton = new JButton("", backpack);
   /** Choice drop down menu for Number/Recent. */
   private Choice choiceofbackpack = new Choice();
   
   
   /** textarea1. */
   private JTextArea textArea1 = new JTextArea(15, 50);
   /** text field. */
   private JTextField textField1 = new JTextField(25);
   /** TextArea1 Scoller. **/
   private JScrollPane scroll1 = new JScrollPane(textArea1,
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   /** textarea2. */
   private JTextArea textArea2 = new JTextArea(15, 50);
   /** TextArea Scoller. **/
   private JScrollPane scroll2 = new JScrollPane(textArea2,
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         
   /** Pokemon. */
   private Pokemon p = new Bulbasaur();
   /** PokeTree. */
   private PokeTree tree = new PokeTree();
   /** Use Deque for Stack. */
   private Deque<Pokemon> stack = new ArrayDeque<Pokemon>();
   /** Queue. */
   private PriorityQueue<Pokemon> queue = new PriorityQueue<>();
   
   /** Bulbasaur image. */
   private ImageIcon bulbasaur = new ImageIcon("Bulbasaur.png");
   /** Ivysaur image. */
   private ImageIcon ivysaur = new ImageIcon("Ivysaur.png");
   /** Venusaur image. */
   private ImageIcon venusaur = new ImageIcon("Venusaur.png");
   /** Charmander image. */
   private ImageIcon charmander = new ImageIcon("Charmander.png");
   /** Charmeleon image. */
   private ImageIcon charmeleon = new ImageIcon("Charmeleon.png");
   /** Charizard image. */
   private ImageIcon charizard = new ImageIcon("Charizard.png");
   /** Squirtle image. */
   private ImageIcon squirtle = new ImageIcon("Squirtle.png");
   /** Wartortle image. */
   private ImageIcon wartortle = new ImageIcon("Wartortle.png");
   /** Blastoise image. */
   private ImageIcon blastoise = new ImageIcon("Blastoise.png");  
   
   /** Label. */
   private JLabel pImage = new JLabel(image);
   
   /** String. */
   private String s = "";
   /** a empty string. */
   private String empty = "";
   
   /** appearLabel. */
   private JLabel appearLabel = new JLabel("");
   /** speciesLabel. */
   private JLabel speciesLabel = new JLabel("");
   /** numberLabel. */
   private JLabel numberLabel = new JLabel("");
   /** type1Label. */
   private JLabel type1Label = new JLabel("");
   /** heightLabel. */
   private JLabel heightLabel = new JLabel("");
   /** weightLabel. */
   private JLabel weightLabel = new JLabel("");
   /** hpLabel. */
   private JLabel hpLabel = new JLabel("");
   /** cpLabel. */
   private JLabel cpLabel = new JLabel("");
   /** catchLabel. */
   private JLabel catchLabel = new JLabel("");
   
   /**
   * constructor.
   */
   public PokemonPanel() {
      
      /** setting textArea color. */
      mContext = this;
      textArea2.setBackground(Color.white); //set textArea2 color in center panel
      
      /** set panel color. */
      topSubPanel.setBackground(Color.white); //north area color
      centerSubPanel.setBackground(Color.white); //center area color
      
      /** set the panel size. */
      GridLayout gl = new GridLayout(1, 2); //GridLayout setting
      this.setLayout(new BorderLayout()); //Border panel layout
      this.setPreferredSize(new Dimension(500, 900)); //set size
      topSubPanel.setPreferredSize(new Dimension(500, 400));
      topSubPanel.setBorder(BorderFactory.createTitledBorder("To Catch a Pokemon"));
      centerSubPanel.setPreferredSize(new Dimension(500, 100));
      centerSubPanel.setLayout(gl);
      
      /** set the sub panel. */
      this.add("North", topSubPanel); //adding top sub-panel to North
      this.add("Center", centerSubPanel); //adding center sub-panel to center
      this.add("South", bottomSubPanel);
      
      /** top panel. */
      topSubPanel.setLayout(null);
      appearLabel.setBounds(30, 40, 250, 40);
      speciesLabel.setBounds(30, 100, 150, 40);
      numberLabel.setBounds(30, 170, 150, 40);
      heightLabel.setBounds(30, 220, 150, 40);
      weightLabel.setBounds(30, 270, 150, 40);
      type1Label.setBounds(300, 170, 150, 40);
      hpLabel.setBounds(300, 220, 150, 40);
      cpLabel.setBounds(300, 270, 150, 40);
      pImage.setBounds(300, 40, 100, 100);
      huntbutton.setBounds(170, 320, 70, 25);
      catchbutton.setBounds(260, 320, 70, 25);
      catchLabel.setBounds(150, 360, 200, 25);
      catchLabel.setHorizontalAlignment(JLabel.CENTER);
      topSubPanel.add(appearLabel); 
      topSubPanel.add(speciesLabel); 
      topSubPanel.add(numberLabel);
      topSubPanel.add(heightLabel);
      topSubPanel.add(weightLabel);
      topSubPanel.add(type1Label);
      topSubPanel.add(hpLabel);
      topSubPanel.add(cpLabel);
      topSubPanel.add(pImage); //add pokemon image.
      topSubPanel.add(huntbutton); //add hunt button
      topSubPanel.add(catchLabel);
      huntbutton.addActionListener(listener);  //link to listener
      topSubPanel.add(catchbutton); //add catch button
      catchbutton.addActionListener(listener);  //link to listener
      catchbutton.setEnabled(false); //can't press util user press at least hunt.
      topSubPanel.add(textField1); //add text Field
      textField1.setEditable(false); //text field set to not editable
   
      /** center panel. */
      centerSubPanel.add(pokedexbutton); //add pokedex button
      pokedexbutton.addActionListener(listener);  //link to listener
      centerSubPanel.add(backpackbutton); //add backpack button
      backpackbutton.addActionListener(listener);  //link to listener
      textArea2.setEditable(false); //text Area set to not editable
      
      /** Bottom panel. */
      bottomSubPanel.setPreferredSize(new Dimension(500, 300));
      bottomTabPane.setPreferredSize(new Dimension(400, 290));
      bottomTabPane.addTab("PokeDex", new JScrollPane(pokedexTextArea));
      bottomTabPane.addTab("Backpack", new JScrollPane(backpackTextArea));
      
      pokedexTextArea.setEditable(false);
      backpackTextArea.setEditable(false);
      bottomSubPanel.add(bottomTabPane);
     
   } //close PokemonPanel()

/**
* Private ActionListener class.
*/
   private class GUIListener implements ActionListener {
        
      /**
      * ActionPerformed method.
      * @param event what button is clicked.
      */ 
      public void actionPerformed(ActionEvent event) {
         s = empty; //set string back to empty.
         
         // when event equal to click huntbutton  
         if (event.getSource() == huntbutton) {
            p = menuOfPoke(); //random pick a pick a pokemon
            appearLabel.setText("A Wild " + p.getSpecies() + " appeared!");
            speciesLabel.setText("Species: " + p.getSpecies());
            numberLabel.setText("Number: " + p.getNumber());
            heightLabel.setText("Height: " + p.getHeight());
            weightLabel.setText("Weight: " + p.getWeight());
            if (p.getType2().length() == 0) {
            type1Label.setText("Type: " + p.getType1()); 
            } else { 
            type1Label.setText("Type: " + p.getType1() + " | " + p.getType2()); 
            }
            hpLabel.setText("HP: " + p.getHP());
            cpLabel.setText("CP: " + p.getCP());
            catchbutton.setEnabled(true); //after the user press huntbutton
            catchLabel.setText("");
         }
         
         // when event equal to click catchbutton  
         if (event.getSource() == catchbutton) {
            catchPokemon(); //call the catch method
            catchbutton.setEnabled(false); //after user press catch disable
         }
         
         // when event equal to click pokedexbutton  
         if (event.getSource() == pokedexbutton) {
            bottomTabPane.setSelectedIndex(0);
            s = tree.printPokeTree();
            pokedexTextArea.setText(s); //call the tree print inorder
         }
      
         // when event equal to click backpackbutton  
         if (event.getSource() == backpackbutton) {
            String[] choices = {"Recent", "Number"};
            int order = JOptionPane.showOptionDialog(mContext, 
                        "Would you like to sort the pokemons by Recent or Number?", "OrderCheck",
                         JOptionPane.YES_NO_CANCEL_OPTION, 
                         JOptionPane.INFORMATION_MESSAGE, 
                         null, choices, null);
            bottomTabPane.setSelectedIndex(1);
         
            Deque<Pokemon> tempStack = new ArrayDeque<Pokemon>(); //temp stack
            PriorityQueue<Pokemon> tempQueue = new PriorityQueue<>(); //temp qeue
            
            if (order == 0) {
               tempStack.addAll(stack); //get all stack into tempStack
               while (tempStack.size() > 0) {
                  p = tempStack.pop(); //pop everything stack
                  s = s + p.toString() + "\n\n"; //and get into string.
               }
            } else if (order == 1) {
               tempQueue.addAll(queue);
               while (tempQueue.size() > 0) {
                  p = tempQueue.poll();
                  s = s + p.toString() + "\n\n";
               }
            }
            
            backpackTextArea.setText(s);
         
         }                 
      
      } //actionEvent method
   
      /**
      * Choice a pokemon.
      * @return pokemon the Pokemon user choose
      */
      private Pokemon menuOfPoke() {
         //Instance variables for makePokemon methods.
         p = null;
         //create a random variable
         Random rand = new Random();
         int i = rand.nextInt(9) + 1; //change the 9 to 13 for more pokemon:D
      
         /* List of Pokemon 
         * 1 for Bulbasaur,  2 for Ivysaur,    3 for Venusaur
         * 4 for Charmander, 5 for Charmeleon, 6 for Charizard
         * 7 for Squirtle,   8 for Wartortle,  9 for Blastoise
         *10 for Eevee,     11 for Vaporeon,  12 for Jolteon,  13 for Flareon
         *  End of the list */
         switch(i) {
            case  1:
               p = new Bulbasaur();
               pImage.setIcon(bulbasaur);
               break;
            case  2:
               p = new Ivysaur();
               pImage.setIcon(ivysaur);
               break;
            case  3:
               p = new Venusaur();
               pImage.setIcon(venusaur);
               break;
            case  4:
               p = new Charmander();
               pImage.setIcon(charmander);
               break;
            case  5:
               p = new Charmeleon();
               pImage.setIcon(charmeleon);
               break;
            case  6:
               p = new Charizard();
               pImage.setIcon(charizard);
               break;
            case  7:
               p = new Squirtle();
               pImage.setIcon(squirtle);
               break;
            case  8:
               p = new Wartortle();
               pImage.setIcon(wartortle);
               break;
            case  9:
               p = new Blastoise();
               pImage.setIcon(blastoise);
               break;
            case  10:
               p = new Eevee();
               break;
            case  11:
               p = new Vaporeon();
               break;
            case  12:
               p = new Jolteon();
               break;
            case  13:
               p = new Flareon();
               break;
            default : //error message and not exit the loop.
               System.out.println("Error: on menuOfPoke()"); //this line should not show.
               break;
         } //end switch
         
         return p;
      } //end menuOfPoke
      
      /**
      * helper method for ActionListener.
      * randomly choose the Pokemon is caught or not.
      */
      private void catchPokemon() {
         Random rand = new Random();
         //set boolean
         boolean caught = rand.nextBoolean();
      
         if (caught) {
            catchLabel.setText("You Caught " + p.getSpecies() + " !");
         //             textArea1.setText(p.toString() + "\n");
            tree.add(p);
            queue.add(p);
            stack.push(p);
         
         } else { //not caught
            catchLabel.setText(p.getSpecies() + " escaped! ");
            textArea1.setText("");
         }
      
      } //end catchPokemon method
   
   } //close class GUIListener

} //close class PokemonPanel