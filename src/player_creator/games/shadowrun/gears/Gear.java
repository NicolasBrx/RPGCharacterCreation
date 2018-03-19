package player_creator.games.shadowrun.gears;

/**
 *
 * @author Nicolas Brax
 */
public class Gear {
  
  public enum gearClass {item, vehicle, weapon, armor, augmentation};
  
  private String gearName;
  private int gearRating;
  private int gearPrice;
  private String gearAvailability;
  private gearClass gearType;
  private String bonusAttribute;
  private int bonusValue;
  
  public Gear() {
    this.gearType = gearClass.item;
  }

  public Gear(String gearName, int gearRating, int gearPrice,String gearAvailability) {
    this.gearName = gearName;
    this.gearRating = gearRating;
    this.gearPrice = gearPrice;
    this.gearAvailability = gearAvailability;
    this.gearType = gearClass.item;
  }
  
  public Gear(String gearName, int gearRating, int gearPrice, 
          String gearAvailability, gearClass gearType) {
    this.gearName = gearName;
    this.gearRating = gearRating;
    this.gearPrice = gearPrice;
    this.gearAvailability = gearAvailability;
    this.gearType = gearType;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getGearName() {
    return gearName;
  }

  public void setGearName(String gearName) {
    this.gearName = gearName;
  }

  public int getGearRating() {
    return gearRating;
  }

  public void setGearRating(int gearRating) {
    this.gearRating = gearRating;
  }

  public int getGearPrice() {
    return gearPrice;
  }

  public void setGearPrice(int gearPrice) {
    this.gearPrice = gearPrice;
  }
  
  public String getGearAvailability(){
    return this.gearAvailability;
  }
  
  public void setGearAvailability(String gearAvailability){
    this.gearAvailability = gearAvailability;
  }

  public gearClass getGearType() {
    return gearType;
  }

  public void setGearType(gearClass gearType) {
    this.gearType = gearType;
  }

  public void setBonusAttribute(String bonusAttribute) {
    this.bonusAttribute = bonusAttribute;
  }

  public void setBonusValue(int bonusValue) {
    this.bonusValue = bonusValue;
  }

  public String getBonusAttribute() {
    return bonusAttribute;
  }

  public int getBonusValue() {
    return bonusValue;
  }
}
