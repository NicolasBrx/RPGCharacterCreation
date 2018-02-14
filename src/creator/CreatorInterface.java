package creator;

import java.util.HashMap;

/**
 * This interface ensures that every class used for character (playable or non
 * playable) using the RPG Character Creation follows a good designed and is
 * usable in the RPG Software Suit.
 * 
 * To be compliant with the user interface, all the methods  and attributes that 
 * are not defined in this interface MUST use the following guidelines:
 *  - the setter methods should return a int value equals to 0 when an 
 *    error occurs;
 *  - when an error is possible, the method should check and store indication
 *    if one occurs;
 *  - internal information should be user transparent and specified if it not
 *    possible to do otherwise;
 *  - a method should be set for "God Mode", i.e. the ability to go through
 *    the normal player limitations;
 *  - each attribute of importance might see setter and getter methods as well
 *    as modification methods in order to be used by other plugins;
 *  - as the user interface is fully independant, design will be based onto
 *    the methods in the creation class so plan well.
 * 
 * @author Nicolas Brax
 */
public interface CreatorInterface {
  
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
  
  /**
   * This method is used to save the current character for further uses. It 
   * returns an boolean value to indicate if the save has been correctly done
   * or if errors or corruptions occured.
   * 
   * It has to be noted that verification about the current character are to be
   * made before this call if wanted.
   * 
   * @return True if the charachter is save, false otherwise.
   */
  public boolean saveCharacter();
  
}
