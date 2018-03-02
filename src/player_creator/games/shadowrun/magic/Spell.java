package player_creator.games.shadowrun.magic;

/**
 *
 * @author Nicolas Brax
 */
public class Spell {
  
  private String spellName;
  private String spellType;
  private int spellRange;
  private int spellDuration;
  private int spellDrain;

  public Spell() {
  }

  public Spell(String spellName, String spellType, int spellRange, int spellDuration, int spellDrain) {
    this.spellName = spellName;
    this.spellType = spellType;
    this.spellRange = spellRange;
    this.spellDuration = spellDuration;
    this.spellDrain = spellDrain;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getSpellName() {
    return spellName;
  }

  public void setSpellName(String spellName) {
    this.spellName = spellName;
  }

  public String getSpellType() {
    return spellType;
  }

  public void setSpellType(String spellType) {
    this.spellType = spellType;
  }

  public int getSpellRange() {
    return spellRange;
  }

  public void setSpellRange(int spellRange) {
    this.spellRange = spellRange;
  }

  public int getSpellDuration() {
    return spellDuration;
  }

  public void setSpellDuration(int spellDuration) {
    this.spellDuration = spellDuration;
  }

  public int getSpellDrain() {
    return spellDrain;
  }

  public void setSpellDrain(int spellDrain) {
    this.spellDrain = spellDrain;
  }
  
  
  
}
