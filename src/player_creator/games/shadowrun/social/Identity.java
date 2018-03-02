package player_creator.games.shadowrun.social;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class Identity {
  
  private boolean trueIdentity;
  private boolean sinLess;
  private String identity;
  private String lifestyle;
  private int nuyens;
  private ArrayList<String> licences;

  /**
   *
   */
  public Identity() {
  }

  /**
   *
   * @param trueIdentity
   * @param sinLess
   * @param identity
   * @param lifestyle
   * @param nuyens
   * @param licences
   */
  public Identity(boolean trueIdentity, boolean sinLess, String identity, String lifestyle, int nuyens, ArrayList<String> licences) {
    this.trueIdentity = trueIdentity;
    this.sinLess = sinLess;
    this.identity = identity;
    this.lifestyle = lifestyle;
    this.nuyens = nuyens;
    this.licences = licences;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public boolean isTrueIdentity() {
    return trueIdentity;
  }

  public void setTrueIdentity(boolean trueIdentity) {
    this.trueIdentity = trueIdentity;
  }

  public boolean isSinLess() {
    return sinLess;
  }

  public void setSinLess(boolean sinLess) {
    this.sinLess = sinLess;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }

  public String getLifestyle() {
    return lifestyle;
  }

  public void setLifestyle(String lifestyle) {
    this.lifestyle = lifestyle;
  }

  public int getNuyens() {
    return nuyens;
  }

  public void setNuyens(int nuyens) {
    this.nuyens = nuyens;
  }

  public ArrayList<String> getLicences() {
    return licences;
  }

  public void setLicences(ArrayList<String> licences) {
    this.licences = licences;
  }
  
}
