/**
* interface for Electric type Pokemon.
* Fails checkstyle because no methods.
* @author Su Lao
* @since 02/18/2020
*/
public interface ElectricType {
   /** constants **/
   /** Type name String. */
   String ELECTRIC_TYPE = new String("Electric");
   /** Type color String. */ 
   String ELECTRIC_COLOR = new String("Yellow");
   /** Array of type fast attack names. */
   String[] ELECTRIC_FAST_ATTACKS = {"Spark", "Thunder Shock"};
   /** Array of type special attack names. */
   String[] ELECTRIC_SPECIAL_ATTACKS = {"Discharge", "Parabolic Charge", 
      "Thunder Punch", "Thunder", "Thunderbolt"};
   /** Array of fast attack powers, coincides with name array. */
   int[] ELECTRIC_FAST_ATK_POWER = {7, 5};
   /** Array of special attack powers, coincides with name array. */  
   int[] ELECTRIC_SPECIAL_ATK_POWER = {35, 15, 40, 100, 55};

}