package creator.p13;

import creator.CreatorInterface;

/**
 *
 * @author Nicolas Brax
 */
public class P13PCCreation implements CreatorInterface{
  
  public P13PCCreation(){
    
  }
  
  
  
  /**
   * This method is used to validate a created character. It is validated when
   * it complies with all the rules and specific scores according to the rules.
   * 
   * @return True if the character is consistant with the rules, false otherwise.
   */
  public boolean validateCharacter(){
    
    return false;
  }
  
  /**
   * This methods is used to indicate to the user what was the last error in the 
   * creation process. This can be used by the user interface in order to inform
   * the user and guide him for the right thing to do.
   * 
   * @return A quick description of the last error that occured.
   */
  public String lastError(){
    
    return "";
  }
  
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
  public boolean saveCharacter(){
    
    return false;
  }
  
}
