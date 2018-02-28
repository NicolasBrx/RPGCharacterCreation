package creator.p13;

import creator.PlayerCharacter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import tools.RPGCCException;
import tools.XMLParser;

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
  private int seniority;
  
  /**
   * 
   */
  private String room;
  
  /**
   * 
   */
  private String supervisor;
  
  /**
   * 
   */
  private HashMap<String,Integer> lineaments;
  
  /**
   * 
   * @param playerName
   * @param sane
   */
  public P13PCCreation(String playerName,boolean sane){
    super(playerName);
    this.sane = sane;
    this.lucidity = 5;
    this.coldblood = 5;
    this.vitality = 5;
    this.lineaments = new HashMap<>();
  }
  
  
  
  /**
   * This method is used to validate a created character. It is validated when
   * it complies with all the rules and specific scores according to the rules.
   * 
   * In Patient 13, this means:
   *  - 26 or 29 points for the attributes according to the sane or affected 
   *    state of the patient;
   *  - each attribute score must be between 5 and 13 included;
   *  - {+2;+1;-1;-2} or {+3;+2+2;+1;-1;-2} for the lineaments scores according
   *    to the sane or affected status of the patient;
   *  - some information: name, age, surname.
   * 
   * In case of error while validating, the method returns a sequence containing 
   * the following options (preceeded by '-'):
   *  - "name": the name is not given;
   *  - "surname": the surname is not given and the character is affected;
   *  - "age": the age is not given
   *  - "attribute": attribute points are not correct
   *  - "remaining": it remains at least one attribute point to spend
   *  - "lineaments": lineaments are not correct (number, names, ...)
   * 
   * It has to be noted that a character in God Mode will always be validated.
   * 
   * @return True if the character is consistant with the rules, false otherwise.
   */
  @Override
  public String validateCharacter(){
    String toReturn = "OK";
    if(!isGodMode()){
      // check attributes
      if((this.vitality < 5) || (this.vitality > 13)
      || (this.coldblood < 5) || (this.coldblood > 13)
      || (this.lucidity < 5) || (this.lucidity > 13)
      ){
        toReturn = toReturn.replace("OK","");
        toReturn +="-attribute";
      }
      
      if(remainingPoints() != 0){
        toReturn = toReturn.replace("OK","");
        toReturn +="-remaining";
      }
      
      // check lineaments
      boolean ok = true;
      Iterator it = this.lineaments.entrySet().iterator();
      while(ok && it.hasNext()){
        HashMap.Entry pair = (HashMap.Entry)it.next();
        if(((String)pair.getKey()).equalsIgnoreCase("")){
          ok = false;
          toReturn = toReturn.replace("OK","");
          toReturn +="-lineaments"; 
        }
        //System.out.println(pair.getKey() + " = " + pair.getValue());
        //it.remove(); // avoids a ConcurrentModificationException
      }
      
      // check name
      if(civilian.getFamilyname().equalsIgnoreCase("")
      || civilian.getFirstname().equalsIgnoreCase("")
      ){
        toReturn = toReturn.replace("OK","");
        toReturn +="-name"; 
      }
      
      // check surname
      if(civilian.getSurname().equalsIgnoreCase("") && !sane){
        toReturn = toReturn.replace("OK","");
        toReturn +="-surname";
      }
      
      // check age
      if(civilian.getAge() <= 0){
        toReturn = toReturn.replace("OK","");
        toReturn +="-age";
      }
    }
    return toReturn;
  }
  
  /**
   * This method is used to save the current character for further uses. It 
   * returns an boolean value to indicate if the save has been correctly done
   * or if errors or corruptions occured.
   * 
   * It has to be noted that verification about the current character are to be
   * made before this call if wanted.
   * 
   * @return True if the charachter is saved, false otherwise.
   */
  @Override
  public boolean saveCharacter(){
    finalizeCharacter();
    boolean toReturn = true;
    try{
      XMLParser xml = new XMLParser();
      xml.saveCharacter(this);
    }
    catch(RPGCCException e){
      toReturn = false;
    }
    
    return toReturn;
  }
  
  /**
   * 
   */
  private void finalizeCharacter(){
    room = ((ThreadLocalRandom.current().nextInt(1, 3) == 1) ? "A" : "B")
         + (ThreadLocalRandom.current().nextInt(1, 21));
    String[] supervisors = {"Kemper","Marche","Vigorsen","Stein"};   //TODO: change to load...
    supervisor = supervisors[ThreadLocalRandom.current().nextInt(0, supervisors.length)];
    seniority = (sane ? 0 : ThreadLocalRandom.current().nextInt(1, 11));
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
   * @return 
   */
  public int getSeniority() {
    return seniority;
  }

  /**
   * 
   * @return 
   */
  public String getRoom() {
    return room;
  }

  /**
   * 
   * @return 
   */
  public String getSupervisor() {
    return supervisor;
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
  
  /**
   * 
   * @return 
   */
  public boolean isSane(){
    return this.sane;
  }
  
  /**
   * 
   * @param lineament
   * @param score 
   */
  public void addLineament(String lineament, int score){
    this.lineaments.put(lineament, score);
  }
  
  /**
   * 
   * @return 
   */
  public HashMap<String,Integer> getLineaments(){
    return this.lineaments;
  }
  
  /**
   * 
   * @return 
   */
  public int remainingPoints(){
    return ((sane ? 26 : 29) - this.lucidity - this.coldblood - this.vitality);
  }

}
