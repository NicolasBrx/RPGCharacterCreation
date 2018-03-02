package player_creator.games.shadowrun.personal;

/**
 *
 * @author Nicolas Brax
 */
public class Skil {
  
  private String skillName;
  private int skillRating;
  private String skillType;
  
  /**
   * 
   */
  public Skil(){
    this.skillName = "";
    this.skillRating = -1;
    this.skillType = "";
  }
  
  /**
   * 
   * @param name
   * @param rating
   * @param type 
   */
  public Skil(String name, int rating, String type){
    this.skillName = name;
    this.skillRating = rating;
    this.skillType = type;
  }

  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getSkillName() {
    return skillName;
  }

  public void setSkillName(String skillName) {
    this.skillName = skillName;
  }

  public int getSkillRating() {
    return skillRating;
  }

  public void setSkillRating(int skillRating) {
    this.skillRating = skillRating;
  }

  public String getSkillType() {
    return skillType;
  }

  public void setSkillType(String skillType) {
    this.skillType = skillType;
  }
}
