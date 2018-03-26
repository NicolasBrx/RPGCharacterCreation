package player_creator.games.shadowrun.personal;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class Skill {
  
  private String skillName;
  private int skillRating;
  private String skillType;
  private ArrayList<String> specialisations;
  
  /**
   * 
   */
  public Skill(){
    this.skillName = "";
    this.skillRating = -1;
    this.skillType = "";
    this.specialisations = new ArrayList<>();
  }
  
  /**
   * 
   * @param name
   * @param rating
   * @param type 
   */
  public Skill(String name, int rating, String type){
    this.skillName = name;
    this.skillRating = rating;
    this.skillType = type;
    this.specialisations = new ArrayList<>();
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
  
  public void addSpecialisation(String specialisation){
    this.specialisations.add(specialisation);
  }
}
