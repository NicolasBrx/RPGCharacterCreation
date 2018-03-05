package player_creator.games.shadowrun.gears;

/**
 *
 * @author Nicolas Brax
 */
public class GearArmor extends Gear{
  
  private String armorNotes;
  
  public GearArmor() {
  }

  public GearArmor(String armorName, int armorRating, String armorNotes, int armorPrice,
          String armorAvailability)
  {
    super(armorName, armorRating, armorPrice, armorAvailability, gearClass.armor);
    this.armorNotes = armorNotes;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getArmorNotes() {
    return armorNotes;
  }

  public void setArmorNotes(String armorNotes) {
    this.armorNotes = armorNotes;
  }
}
