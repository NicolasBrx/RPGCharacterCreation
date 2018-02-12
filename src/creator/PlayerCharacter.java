package creator;

/**
 * Quick class used a super class for all Player Character. This just handles
 the generic attributes of all characters (playerName of the player for instance).
 * 
 * @author Nicolas Brax
 */
public class PlayerCharacter {
  
  /**
   * 
   */
  private String playerName;
  
  /**
   * 
   * @param playerName 
   */
  PlayerCharacter(String playerName){
    this.playerName = playerName;
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
  
}
