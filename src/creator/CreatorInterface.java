package creator;

import java.util.HashMap;

/**
 * This interface ensures that every class used for character (playable or non
 * playable) using the RPG Character Creation follows a good designed and is
 * usable in the RPG Software Suit.
 * 
 * To be compliant with the user interface, all the methods that are not defined
 * in this interface MUST use the following guidelines:
 *  - the setter methods should return a int value equals to 0 when an 
 *    error occurs;
 *  - when an error is possible, the method should check and store indication
 *    if one occurs;
 *  - internal information should be user transparent and specified if it not
 *    possible to do otherwise.
 * 
 * @author Nicolas Brax
 */
public interface CreatorInterface {
  
  
  /**
   * 
   * @return 
   */
  public HashMap<String,Integer> getAttributes();
  
  /**
   * This method is used to validate a created character. It is validated when
   * it complies with all the rules and specific scores according to the rules.
   * 
   * @return True if the character is consistant with the rules, false otherwise.
   */
  public boolean validateCharacter();
  
  /**
   * This methods is used to indicate to the user what was the last error in the 
   * creation process. This can be used by the user interface in order to inform
   * the user and guide him for the right thing to do.
   * 
   * @return A quick description of the last error that occured.
   */
  public String lastError();
  
}
