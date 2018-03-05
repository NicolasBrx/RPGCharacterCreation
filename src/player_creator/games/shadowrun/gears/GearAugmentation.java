package player_creator.games.shadowrun.gears;

/**
 *
 * @author Nicolas Brax
 */
public class GearAugmentation extends Gear{
  
  private double augmentationEssenceCost;
  private String augmentationNotes;
  
  /**
   * Constructor
   */
  public GearAugmentation() {
  }

  /**
   * Constructor
   * @param augmentationName
   * @param augmentationRating
   * @param augmentationEssenceCost
   * @param augmentationNotes 
   * @param augmentationAvailability 
   * @param augmentationPrice 
   */
  public GearAugmentation(String augmentationName, int augmentationRating, 
          double augmentationEssenceCost, String augmentationNotes,
          String augmentationAvailability, int augmentationPrice)
  {
    super(augmentationName, augmentationRating, augmentationPrice,
                                augmentationAvailability, gearClass.augmentation);
    this.augmentationEssenceCost = augmentationEssenceCost;
    this.augmentationNotes = augmentationNotes;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public double getAugmentationEssenceCost() {
    return augmentationEssenceCost;
  }

  public void setAugmentationEssenceCost(double augmentationEssenceCost) {
    this.augmentationEssenceCost = augmentationEssenceCost;
  }

  public String getAugmentationNotes() {
    return augmentationNotes;
  }

  public void setAugmentationNotes(String augmentationNotes) {
    this.augmentationNotes = augmentationNotes;
  }
}
