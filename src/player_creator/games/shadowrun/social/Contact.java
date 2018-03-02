package player_creator.games.shadowrun.social;

/**
 *
 * @author Nicolas Brax
 */
public class Contact {
  
  private String contactName;
  private int contactLoyalty;
  private int contactConnection;
  private String contactJob;

  /**
   * 
   */
  public Contact() {
  }

  /**
   * 
   * @param contactName
   * @param contactLoyalty
   * @param contactConnection
   * @param contactJob 
   */
  public Contact(String contactName, int contactLoyalty, int contactConnection, String contactJob) {
    this.contactName = contactName;
    this.contactLoyalty = contactLoyalty;
    this.contactConnection = contactConnection;
    this.contactJob = contactJob;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public int getContactLoyalty() {
    return contactLoyalty;
  }

  public void setContactLoyalty(int contactLoyalty) {
    this.contactLoyalty = contactLoyalty;
  }

  public int getContactConnection() {
    return contactConnection;
  }

  public void setContactConnection(int contactConnection) {
    this.contactConnection = contactConnection;
  }

  public String getContactJob() {
    return contactJob;
  }

  public void setContactJob(String contactJob) {
    this.contactJob = contactJob;
  }
}
