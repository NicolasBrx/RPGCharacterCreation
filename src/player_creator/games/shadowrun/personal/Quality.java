package player_creator.games.shadowrun.personal;

/**
 *
 * @author Nicolas Brax
 */
public class Quality {
  
  private String qualityName;
  private String qualityDescription;
  private String qualityType;
  private String relatedSkillOrAttribute;

  /**
   * 
   */
  public Quality() {
  }

  /**
   * 
   * @param qualityName
   * @param qualityDescription
   * @param qualityType 
   * @param relatedSkillOrAttribute 
   */
  public Quality(String qualityName, String qualityDescription, 
          String qualityType,String relatedSkillOrAttribute){
    this.qualityName = qualityName;
    this.qualityDescription = qualityDescription;
    this.qualityType = qualityType;
    this.relatedSkillOrAttribute = relatedSkillOrAttribute;
  }

  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getQualityName() {
    return qualityName;
  }

  public void setQualityName(String qualityName) {
    this.qualityName = qualityName;
  }

  public String getQualityDescription() {
    return qualityDescription;
  }

  public void setQualityDescription(String qualityDescription) {
    this.qualityDescription = qualityDescription;
  }

  public String getQualityType() {
    return qualityType;
  }

  public void setQualityType(String qualityType) {
    this.qualityType = qualityType;
  }

  public String getRelatedSkillOrAttribute() {
    return relatedSkillOrAttribute;
  }

  public void setRelatedSkillOrAttribute(String relatedSkillOrAttribute) {
    this.relatedSkillOrAttribute = relatedSkillOrAttribute;
  }
}
