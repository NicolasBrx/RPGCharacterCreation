package ihm;

/**
 *
 * @author Nicolas Brax
 */
public interface CreationInterface {
  
  /**
   * 
   * @return 
   */
  public boolean isSaveNeeded();
  
  /**
   * 
   */
  public void saveCharacter();
  
  /**
   * 
   * @param playerName 
   */
  public void create(String playerName);
  
}
