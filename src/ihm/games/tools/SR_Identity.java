package ihm.games.tools;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class SR_Identity {
  
  /**
   * 
   */
  private boolean trueIdentity;
  
  /**
   * 
   */
  private boolean sinLess;
  
  /**
   * 
   */
  private String identity;
  
  /**
   * 
   */
  private String lifestyle;
  
  /**
   * 
   */
  private int nuyens;
  
  /**
   * 
   */
  private ArrayList<String> licences;

  /**
   *
   */
  public SR_Identity() {
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
  public SR_Identity(boolean trueIdentity, boolean sinLess, String identity, String lifestyle, int nuyens, ArrayList<String> licences) {
    this.trueIdentity = trueIdentity;
    this.sinLess = sinLess;
    this.identity = identity;
    this.lifestyle = lifestyle;
    this.nuyens = nuyens;
    this.licences = licences;
  }

  /**
   *
   * @return
   */
  public boolean isTrueIdentity() {
    return trueIdentity;
  }

  /**
   *
   * @param trueIdentity
   */
  public void setTrueIdentity(boolean trueIdentity) {
    this.trueIdentity = trueIdentity;
  }

  /**
   *
   * @return
   */
  public boolean isSinLess() {
    return sinLess;
  }

  /**
   *
   * @param sinLess
   */
  public void setSinLess(boolean sinLess) {
    this.sinLess = sinLess;
  }

  /**
   *
   * @return
   */
  public String getIdentity() {
    return identity;
  }

  /**
   *
   * @param identity
   */
  public void setIdentity(String identity) {
    this.identity = identity;
  }

  /**
   *
   * @return
   */
  public String getLifestyle() {
    return lifestyle;
  }

  /**
   *
   * @param lifestyle
   */
  public void setLifestyle(String lifestyle) {
    this.lifestyle = lifestyle;
  }

  /**
   *
   * @return
   */
  public int getNuyens() {
    return nuyens;
  }

  /**
   *
   * @param nuyens
   */
  public void setNuyens(int nuyens) {
    this.nuyens = nuyens;
  }

  /**
   *
   * @return
   */
  public ArrayList<String> getLicences() {
    return licences;
  }

  /**
   *
   * @param licences
   */
  public void setLicences(ArrayList<String> licences) {
    this.licences = licences;
  }
  
}
