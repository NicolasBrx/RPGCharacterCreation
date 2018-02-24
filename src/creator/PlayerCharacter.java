package creator;

/**
 * Quick class used a super class for all Player Character. This just handles
 the generic attributes of all characters (playerName of the player for instance).
 * 
 * @author Nicolas Brax
 */
public abstract class PlayerCharacter implements CreatorInterface {
  
  /**
   * 
   */
  protected String playerName;
  
  /**
   * 
   */
  protected String lastError;
  
  /**
   * 
   */
  protected boolean godMode;
  
  /**
   * 
   */
  protected CivilStatus civilian;
  
  /**
   * 
   */
  protected boolean stored;
  
  /**
   * 
   */
  protected boolean complete;
  
  /**
   * 
   * @param playerName 
   */
  public PlayerCharacter(String playerName){
    this.playerName = playerName;
    this.godMode = false;
    this.lastError = "";
    this.civilian = new CivilStatus();
    this.stored = false;
    this.complete = false;
  }
  
  /**
   * 
   * @return 
   */
  public String getName(){
    return this.playerName;
  }
  
  /**
   * 
   * @param playerName 
   */
  public void setName(String playerName){
    this.playerName = playerName;
  }

  /**
   * 
   * @return 
   */
  public boolean isGodMode() {
    return godMode;
  }

  /**
   * 
   * @param godMode 
   */
  public void setGodMode(boolean godMode) {
    this.godMode = godMode;
  }
  
  /**
   * 
   * @return 
   */
  public boolean isFemale() {
    return civilian.isFemale();
  }

  /**
   * 
   * @param female 
   */
  public void setFemale(boolean female) {
    civilian.setFemale(female);
  }

  /**
   * 
   * @return 
   */
  public String getFamilyname() {
    return civilian.getFamilyname();
  }

  /**
   * 
   * @param familyname 
   */
  public void setFamilyname(String familyname) {
    civilian.setFamilyname(familyname);
  }

  /**
   * 
   * @return 
   */
  public String getFirstname() {
    return civilian.getFirstname();
  }

  /**
   * 
   * @param firstname 
   */
  public void setFirstname(String firstname) {
    civilian.setFirstname(firstname);
  }
  
  /**
   * 
   * @return 
   */
  public String getSurname() {
    return civilian.getSurname();
  }

  /**
   * 
   * @param surname 
   */
  public void setSurname(String surname) {
    civilian.setSurname(surname);
  }

  /**
   * 
   * @return 
   */
  public int getAge() {
    return civilian.getAge();
  }

  /**
   * 
   * @param age 
   */
  public void setAge(int age) {
    civilian.setAge(age);
  }

  /**
   * 
   * @return 
   */
  public double getSize() {
    return civilian.getSize();
  }

  /**
   * 
   * @param size 
   */
  public void setSize(double size) {
    civilian.setSize(size);
  }

  /**
   * 
   * @return 
   */
  public double getWeigth() {
    return civilian.getWeigth();
  }

  /**
   * 
   * @param weigth 
   */
  public void setWeigth(double weigth) {
    civilian.setWeigth(weigth);
  }

  /**
   * 
   * @return 
   */
  public String getEyecolor() {
    return civilian.getEyecolor();
  }

  /**
   * 
   * @param eyecolor 
   */
  public void setEyecolor(String eyecolor) {
    civilian.setEyecolor(eyecolor);
  }

  /**
   * 
   * @return 
   */
  public String getPlayerName() {
    return playerName;
  }

  /**
   * 
   * @param playerName 
   */
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  /**
   * 
   * @return 
   */
  public boolean isStored() {
    return stored;
  }

  /**
   * 
   * @param stored 
   */
  public void setStored(boolean stored) {
    this.stored = stored;
  }

  /**
   * 
   * @return 
   */
  public boolean isComplete() {
    return complete;
  }

  /**
   * 
   */
  @Override
  public void setComplete() {
    this.complete = true;
  }
  
  /**
   * This methods is used to indicate to the user what was the last error in the 
   * creation process. This can be used by the user interface in order to inform
   * the user and guide him for the right thing to do.
   * 
   * Note that calling this method reset the last error to empty string.
   * 
   * @return A quick description of the last error that occured.
   */
  @Override
  public String lastError(){
    String toReturn = this.lastError;
    this.lastError = "";
    return toReturn;
  }
  
}
