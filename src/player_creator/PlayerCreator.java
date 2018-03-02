package player_creator;

/**
 * Quick class used a super class for all Player Character. This just handles
 the generic attributes of all characters (playerName of the player for instance).
 * 
 * @author Nicolas Brax
 */
public abstract class PlayerCreator implements CreatorInterface {
  
  protected String playerName;
  protected String lastError;
  protected boolean godMode;
  protected CivilStatus civilian;
  protected boolean stored;
  protected boolean complete;
  
  /**
   * Constructor
   * @param playerName 
   */
  public PlayerCreator(String playerName){
    this.playerName = playerName;
    this.godMode = false;
    this.lastError = "";
    this.civilian = new CivilStatus();
    this.stored = false;
    this.complete = false;
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
  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getName(){
    return this.playerName;
  }
  
  public void setName(String playerName){
    this.playerName = playerName;
  }

  public boolean isGodMode() {
    return godMode;
  }

  public void setGodMode(boolean godMode) {
    this.godMode = godMode;
  }
  
  public boolean isFemale() {
    return civilian.isFemale();
  }

  public void setFemale(boolean female) {
    civilian.setFemale(female);
  }

  public String getFamilyname() {
    return civilian.getFamilyname();
  }

  public void setFamilyname(String familyname) {
    civilian.setFamilyname(familyname);
  }

  public String getFirstname() {
    return civilian.getFirstname();
  }

  public void setFirstname(String firstname) {
    civilian.setFirstname(firstname);
  }
  
  public String getSurname() {
    return civilian.getSurname();
  }

  public void setSurname(String surname) {
    civilian.setSurname(surname);
  }

  public int getAge() {
    return civilian.getAge();
  }

  public void setAge(int age) {
    civilian.setAge(age);
  }

  public double getSize() {
    return civilian.getSize();
  }

  public void setSize(double size) {
    civilian.setSize(size);
  }

  public double getWeigth() {
    return civilian.getWeigth();
  }

  public void setWeigth(double weigth) {
    civilian.setWeigth(weigth);
  }

  public String getEyecolor() {
    return civilian.getEyecolor();
  }

  public void setEyecolor(String eyecolor) {
    civilian.setEyecolor(eyecolor);
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public boolean isStored() {
    return stored;
  }

  public void setStored(boolean stored) {
    this.stored = stored;
  }

  public boolean isComplete() {
    return complete;
  }

  @Override
  public void setComplete() {
    this.complete = true;
  }
}
