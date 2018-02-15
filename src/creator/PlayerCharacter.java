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
   * @param playerName 
   */
  public PlayerCharacter(String playerName){
    this.playerName = playerName;
    this.godMode = false;
    this.lastError = "";
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
