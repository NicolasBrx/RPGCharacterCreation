package ihm.games.tools;

/**
 *
 * @author Nicolas Brax
 */
public class SR_Contact {
  
  /**
   * 
   */
  private String contactName;
  
  /**
   * 
   */
  private int contactLoyalty;
  
  /**
   * 
   */
  private int contactConnection;
  
  /**
   * 
   */
  private String contactJob;

  /**
   * 
   */
  public SR_Contact() {
  }

  /**
   * 
   * @param contactName
   * @param contactLoyalty
   * @param contactConnection
   * @param contactJob 
   */
  public SR_Contact(String contactName, int contactLoyalty, int contactConnection, String contactJob) {
    this.contactName = contactName;
    this.contactLoyalty = contactLoyalty;
    this.contactConnection = contactConnection;
    this.contactJob = contactJob;
  }

  /**
   * 
   * @return 
   */
  public String getContactName() {
    return contactName;
  }

  /**
   * 
   * @param contactName 
   */
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  /**
   * 
   * @return 
   */
  public int getContactLoyalty() {
    return contactLoyalty;
  }

  /**
   * 
   * @param contactLoyalty 
   */
  public void setContactLoyalty(int contactLoyalty) {
    this.contactLoyalty = contactLoyalty;
  }

  /**
   * 
   * @return 
   */
  public int getContactConnection() {
    return contactConnection;
  }

  /**
   * 
   * @param contactConnection 
   */
  public void setContactConnection(int contactConnection) {
    this.contactConnection = contactConnection;
  }

  /**
   * 
   * @return 
   */
  public String getContactJob() {
    return contactJob;
  }

  /**
   * 
   * @param contactJob 
   */
  public void setContactJob(String contactJob) {
    this.contactJob = contactJob;
  }
  
}
