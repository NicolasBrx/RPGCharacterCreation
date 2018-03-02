package player_creator.games.shadowrun.gears;

/**
 *
 * @author Nicolas Brax
 */
public class Gear {
  
  private String gearName;
  private int gearRating;
  private int gearPrice;
  private String gearAvailability;

  public Gear() {
  }

  public Gear(String gearName, int gearRating, int gearPrice,String gearAvailability) {
    this.gearName = gearName;
    this.gearRating = gearRating;
    this.gearPrice = gearPrice;
    this.gearAvailability = gearAvailability;
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
}
