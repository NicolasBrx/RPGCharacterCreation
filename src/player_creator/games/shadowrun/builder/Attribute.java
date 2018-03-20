package player_creator.games.shadowrun.builder;

/**
 *
 * @author Nicolas Brax
 */
public class Attribute {

  private final String attributeName;
  private int minValue;
  private int maxValue;
  private int currentValue;
  private int augmentedValue;
  
  /**
   * 
   * @param attributeName 
   */
  public Attribute(String attributeName){
    this.attributeName = attributeName;
  }
  
  /**
   * 
   * @param attributeName
   * @param minValue 
   */
  public Attribute(String attributeName, int minValue){
    this.attributeName = attributeName;
    this.minValue = minValue;
    if(minValue != 0){
      this.currentValue = this.minValue;
      this.maxValue = this.minValue + 5;
      this.augmentedValue = this.minValue;
    }
    else{ // this magic or resonance and should be 0 if not magician or technomancer
      this.currentValue = 0;
      this.maxValue = 0;
      this.augmentedValue = 0;
    }
  }

  public int getMinValue() {
    return minValue;
  }

  public int getMaxValue() {
    return maxValue;
  }

  public int getCurrentValue() {
    return currentValue;
  }

  public int getAugmentedValue() {
    return augmentedValue;
  }

  public String getAttributeName() {
    return attributeName;
  }
  
  public void setCurrentValue(int currentValue) {
    this.currentValue = currentValue;
  }

  public void setAugmentedValue(int augmentedValue) {
    this.augmentedValue = augmentedValue;
  }
}
