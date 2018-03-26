package player_creator.games.shadowrun.builder;

import tools.RPGCCException;

/**
 *
 * @author Nicolas Brax
 */
public enum LifeStyle {
  Street,
  Squat,
  Low,
  Middle,
  High,
  Luxury;
  
  /**
   * 
   * @param lf
   * @return 
   * @throws tools.RPGCCException 
   */
  public int getCost(LifeStyle lf) throws RPGCCException{
    switch(lf){
      case Street: return 0;
      case Squat:  return 500;
      case Low:    return 2000;
      case Middle: return 5000;
      case High:   return 10000;
      case Luxury: return 100000;
      default: throw new RPGCCException("Cost is hard coded, this default case should not be reached.");
    }
  }
  
  /**
   * 
   * @param lf
   * @return
   * @throws RPGCCException 
   */
  public String getStartingNuyens(LifeStyle lf) throws RPGCCException{
    switch(lf){
      case Street: return "1D6+20";
      case Squat:  return "2D6+40";
      case Low:    return "3D6+60";
      case Middle: return "4D6+100";
      case High:   return "5D6+500";
      case Luxury: return "6D6+1000";
      default: throw new RPGCCException("Cost is hard coded, this default case should not be reached.");
    }
  }
}


