package ihm.games.tools;

/**
 *
 * @author Nicolas Brax
 */
public class SR_Augmentation {
  
  /**
   * 
   */
  private String augmentationName;
  
  /**
   * 
   */
  private int augmentationRating;
  
  /**
   * 
   */
  private double augmentationEssenceCost;
  
  /**
   * 
   */
  private String augmentationNotes;

  /**
   * 
   */
  public SR_Augmentation() {
  }

  /**
   * 
   * @param augmentationName
   * @param augmentationRating
   * @param augmentationEssenceCost
   * @param augmentationNotes 
   */
  public SR_Augmentation(String augmentationName, int augmentationRating, double augmentationEssenceCost, String augmentationNotes) {
    this.augmentationName = augmentationName;
    this.augmentationRating = augmentationRating;
    this.augmentationEssenceCost = augmentationEssenceCost;
    this.augmentationNotes = augmentationNotes;
  }

  /**
   * 
   * @return 
   */
  public String getAugmentationName() {
    return augmentationName;
  }

  /**
   * 
   * @param augmentationName 
   */
  public void setAugmentationName(String augmentationName) {
    this.augmentationName = augmentationName;
  }

  /**
   * 
   * @return 
   */
  public int getAugmentationRating() {
    return augmentationRating;
  }

  /**
   * 
   * @param augmentationRating 
   */
  public void setAugmentationRating(int augmentationRating) {
    this.augmentationRating = augmentationRating;
  }

  /**
   * 
   * @return 
   */
  public double getAugmentationEssenceCost() {
    return augmentationEssenceCost;
  }

  /**
   * 
   * @param augmentationEssenceCost 
   */
  public void setAugmentationEssenceCost(double augmentationEssenceCost) {
    this.augmentationEssenceCost = augmentationEssenceCost;
  }

  /**
   * 
   * @return 
   */
  public String getAugmentationNotes() {
    return augmentationNotes;
  }

  /**
   * 
   * @param augmentationNotes 
   */
  public void setAugmentationNotes(String augmentationNotes) {
    this.augmentationNotes = augmentationNotes;
  }
  
  
}
