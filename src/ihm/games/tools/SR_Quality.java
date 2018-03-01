package ihm.games.tools;

/**
 *
 * @author Nicolas Brax
 */
public class SR_Quality {
  
  /**
   * 
   */
  private String qualityName;
  
  /**
   * 
   */
  private String qualityDescription;
  
  /**
   * 
   */
  private String qualityType;

  /**
   * 
   */
  public SR_Quality() {
  }

  /**
   * 
   * @param qualityName
   * @param qualityDescription
   * @param qualityType 
   */
  public SR_Quality(String qualityName, String qualityDescription, String qualityType) {
    this.qualityName = qualityName;
    this.qualityDescription = qualityDescription;
    this.qualityType = qualityType;
  }

  /**
   *
   * @return
   */
  public String getQualityName() {
    return qualityName;
  }

  /**
   *
   * @param qualityName
   */
  public void setQualityName(String qualityName) {
    this.qualityName = qualityName;
  }

  /**
   *
   * @return
   */
  public String getQualityDescription() {
    return qualityDescription;
  }

  /**
   *
   * @param qualityDescription
   */
  public void setQualityDescription(String qualityDescription) {
    this.qualityDescription = qualityDescription;
  }

  /**
   *
   * @return
   */
  public String getQualityType() {
    return qualityType;
  }

  /**
   *
   * @param qualityType
   */
  public void setQualityType(String qualityType) {
    this.qualityType = qualityType;
  }
}
