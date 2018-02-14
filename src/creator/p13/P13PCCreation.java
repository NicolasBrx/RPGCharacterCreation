package creator.p13;

import creator.CreatorInterface;
import creator.PlayerCharacter;

/**
 *
 * @author Nicolas Brax
 */
public class P13PCCreation extends PlayerCharacter{
  
  /**
   * 
   */
  private int lucidity;
  
  /**
   * 
   */
  private int coldblood;
  
  /**
   * 
   */
  private int vitality;
  
  
  /**
   * 
   */
  public P13PCCreation(String playerName){
    super(playerName);
    
  }
  
  
  
  /**
   * This method is used to validate a created character. It is validated when
   * it complies with all the rules and specific scores according to the rules.
   * 
   * In Patient 13, this means:
   *  - 
   * 
   * @return True if the character is consistant with the rules, false otherwise.
   */
  @Override
  public boolean validateCharacter(){
    
    return false;
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
  @Override
  public boolean saveCharacter(){
    
    return false;
  }

  /**
   * 
   * @return 
   */
  public int getLucidity() {
    return lucidity;
  }

  /**
   * 
   * @param lucidity 
   */
  public void setLucidity(int lucidity) {
    this.lucidity = lucidity;
  }
  
  /**
   * 
   * @param modifier 
   */
  public void modifyLucidity(int modifier){
    
  }

  /**
   * 
   * @return 
   */
  public int getColdblood() {
    return coldblood;
  }

  /**
   * 
   * @param coldblood 
   */
  public void setColdblood(int coldblood) {
    this.coldblood = coldblood;
  }
  
  /**
   * 
   * @param modifier 
   */
  public void modifyColdblood(int modifier){
    
  }

  /**
   * 
   * @return 
   */
  public int getVitality() {
    return vitality;
  }

  /**
   * 
   * @param vitality 
   */
  public void setVitality(int vitality) {
    this.vitality = vitality;
  }
  
  /**
   * 
   * @param modifier 
   */
  public void modifyVitality(int modifier){
    
  }
  
}
