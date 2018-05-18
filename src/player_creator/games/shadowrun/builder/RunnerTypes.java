package player_creator.games.shadowrun.builder;

/**
 *
 * @author Nicolas Brax
 */
public enum RunnerTypes {
  
  streetLevelRunner("Street Level"),
  normalRunner("Normal Level"),
  primeRunner("Prime Runner");
  
  /**
   * 
   */
  private final String text;
  
  /**
   * 
   * @param text 
   */
  RunnerTypes(final String text){
    this.text = text;
  }
  
  /**
   * 
   * @param typeText
   * @return 
   */
  public RunnerTypes getRunnerType(String typeText){
    for(RunnerTypes type : RunnerTypes.values()){
      if(type.text.equalsIgnoreCase(typeText)){
        return type;
      }
    }
    return null;
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public String toString(){
    return text;
  }
}
