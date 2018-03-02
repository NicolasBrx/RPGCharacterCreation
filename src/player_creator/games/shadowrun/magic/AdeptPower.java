package player_creator.games.shadowrun.magic;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class AdeptPower {
  
  private String powerName;
  private int powerRating;
  private String powerNote;
  private ArrayList<AdeptPower> requirements;

  public AdeptPower() {
  }

  public AdeptPower(String powerName, int powerRating, String powerNote, ArrayList<AdeptPower> requirements) {
    this.powerName = powerName;
    this.powerRating = powerRating;
    this.powerNote = powerNote;
    this.requirements = requirements;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }

  public int getPowerRating() {
    return powerRating;
  }

  public void setPowerRating(int powerRating) {
    this.powerRating = powerRating;
  }

  public String getPowerNote() {
    return powerNote;
  }

  public void setPowerNote(String powerNote) {
    this.powerNote = powerNote;
  }

  public ArrayList<AdeptPower> getRequirements() {
    return requirements;
  }

  public void setRequirements(ArrayList<AdeptPower> requirements) {
    this.requirements = requirements;
  }
  
  
  
}
