package player_creator.games.shadowrun.builder;

/**
 *
 * @author Nicolas Brax
 */
public class Attribute {

  private String attributeName;
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
    this.currentValue = this.minValue;
    this.maxValue = this.minValue + 5;
    this.augmentedValue = this.minValue;
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
