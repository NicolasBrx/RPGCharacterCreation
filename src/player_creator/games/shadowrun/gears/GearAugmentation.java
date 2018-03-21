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
   * @param legality 
   */
  public GearAugmentation(String augmentationName, int augmentationRating, 
          double augmentationEssenceCost, String augmentationNotes,
          int augmentationAvailability, int augmentationPrice,String legality)
  {
    super(augmentationName, augmentationRating, augmentationPrice,
                                augmentationAvailability, gearClass.augmentation,legality);
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
