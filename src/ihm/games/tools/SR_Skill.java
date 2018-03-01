package ihm.games.tools;

/**
 *
 * @author Nicolas Brax
 */
public class SR_Skill {
  
  private String skillName;
  private int skillRating;
  private String skillType;
  
  /**
   * 
   */
  public SR_Skill(){
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
  public SR_Skill(String name, int rating, String type){
    this.skillName = name;
    this.skillRating = rating;
    this.skillType = type;
  }

  /**
   * 
   * @return 
   */
  public String getSkillName() {
    return skillName;
  }

  /**
   * 
   * @param skillName 
   */
  public void setSkillName(String skillName) {
    this.skillName = skillName;
  }

  /**
   * 
   * @return 
   */
  public int getSkillRating() {
    return skillRating;
  }

  /**
   * 
   * @param skillRating 
   */
  public void setSkillRating(int skillRating) {
    this.skillRating = skillRating;
  }

  /**
   * 
   * @return 
   */
  public String getSkillType() {
    return skillType;
  }

  /**
   * 
   * @param skillType 
   */
  public void setSkillType(String skillType) {
    this.skillType = skillType;
  }
  
  
  
}
