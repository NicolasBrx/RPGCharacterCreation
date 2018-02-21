package creator.p13;

import creator.PlayerCharacter;
import java.util.HashMap;

/**
 *
 * @author Nicolas Brax
 */
public class P13PCCreation extends PlayerCharacter{
  
  /**
   * 
   */
  private boolean sane;
  
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
  private HashMap<String,Integer> lineaments;
  
  /**
   * 
   */
  public P13PCCreation(String playerName){
    super(playerName);
    lineaments = new HashMap<>();
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
   * @return  
   */
  public boolean modifyLucidity(int modifier){
    boolean toReturn = true;
    if(!godMode){
      if(remainingPoints() == 0 && modifier > 0){
        lastError = "There are no points left.";
        toReturn = false;
      }
      else if((this.lucidity + modifier < 5) || (this.lucidity + modifier > 13)){
        lastError = "Attribute value should be between 5 and 13.";
        toReturn = false;
      }
      else if((this.lucidity + this.coldblood + this.vitality) > (sane ? 26 : 29)){
        lastError = "The sum of the attributes values can not exceed " 
                  + (sane ? 26 : 29)
                  + ".";
        toReturn = false;
      }
      else{
        this.lucidity += modifier;
      }
    }//if godMode
    else{
      this.lucidity += modifier;
    }
    return toReturn;
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
   * @return  
   */
  public boolean modifyColdblood(int modifier){
    boolean toReturn = true;
    if(!godMode){
      if(remainingPoints() == 0 && modifier > 0){
        lastError = "There are no points left.";
        toReturn = false;
      }
      else if((this.coldblood + modifier < 5) || (this.coldblood + modifier > 13)){
        lastError = "Attribute value should be between 5 and 13.";
        toReturn = false;
      }
      else if((this.lucidity + this.coldblood + this.vitality) > (sane ? 26 : 29)){
        lastError = "The sum of the attributes values can not exceed " 
                  + (sane ? 26 : 29)
                  + ".";
        toReturn = false;
      }
      else{
        this.coldblood += modifier;
      }
    }//if godMode
    else{
      this.coldblood += modifier;
    }
    return toReturn;
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
   * @return  
   */
  public boolean modifyVitality(int modifier){
    boolean toReturn = true;
    if(!godMode){
      if(remainingPoints() == 0 && modifier > 0){
        lastError = "There are no points left.";
        toReturn = false;
      }
      else if((this.vitality + modifier < 5) || (this.vitality + modifier > 13)){
        lastError = "Attribute value should be between 5 and 13.";
        toReturn = false;
      }
      else if((this.lucidity + this.coldblood + this.vitality) > (sane ? 26 : 29)){
        lastError = "The sum of the attributes values can not exceed " 
                  + (sane ? 26 : 29)
                  + ".";
        toReturn = false;
      }
      else{
        this.vitality += modifier;
      }
    }//if godMode
    else{
      this.vitality += modifier;
    }
    return toReturn;
  }
  
  /**
   * 
   * @param sane 
   */
  public void setSane(boolean sane){
    this.sane = sane;
  }
  
  public boolean isSane(){
    return this.sane;
  }
  
  /**
   * 
   * @return 
   */
  public int remainingPoints(){
    return ((sane ? 26 : 29) - this.lucidity - this.coldblood - this.vitality);
  }
  
}
