package player_creator;

/**
 *
 * @author Nicolas Brax
 */
public class CivilStatus {

  /**
   * 
   */  
  private boolean female;
  
  /**
   * 
   */
  private String familyname;
  
  /**
   * 
   */
  private String firstname;
  
  /**
   * 
   */
  private String surname;
  
  /**
   * 
   */
  private int age;
  
  /**
   * 
   */
  private double size;
  
  /**
   * 
   */
  private double weigth;
  
  /**
   * 
   */
  private String eyecolor;
  
  /**
   * 
   */
  private String ethnicity;

  /**
   * 
   */
  public CivilStatus() {
    female = true;
    familyname = "";
    firstname = "";
    surname = "";
    age = 0;
    size = 0.0;
    weigth = 0.0;
    eyecolor = "";
    ethnicity = "";
  }

  /**
   * 
   * @return 
   */
  public boolean isFemale() {
    return female;
  }

  /**
   * 
   * @param female 
   */
  public void setFemale(boolean female) {
    this.female = female;
  }

  /**
   * 
   * @return 
   */
  public String getFamilyname() {
    return familyname;
  }

  /**
   * 
   * @param familyname 
   */
  public void setFamilyname(String familyname) {
    this.familyname = familyname;
  }

  /**
   * 
   * @return 
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * 
   * @param firstname 
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  /**
   * 
   * @return 
   */
  public String getSurname() {
    return surname;
  }

  /**
   * 
   * @param surname 
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * 
   * @return 
   */
  public int getAge() {
    return age;
  }

  /**
   * 
   * @param age 
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * 
   * @return 
   */
  public double getSize() {
    return size;
  }

  /**
   * 
   * @param size 
   */
  public void setSize(double size) {
    this.size = size;
  }

  /**
   * 
   * @return 
   */
  public double getWeigth() {
    return weigth;
  }

  /**
   * 
   * @param weigth 
   */
  public void setWeigth(double weigth) {
    this.weigth = weigth;
  }

  /**
   * 
   * @return 
   */
  public String getEyecolor() {
    return eyecolor;
  }

  /**
   * 
   * @param eyecolor 
   */
  public void setEyecolor(String eyecolor) {
    this.eyecolor = eyecolor;
  }

  /**
   * 
   * @return 
   */
  public String getEthnicity() {
    return ethnicity;
  }

  /**
   * 
   * @param ethnicity 
   */
  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }
}
