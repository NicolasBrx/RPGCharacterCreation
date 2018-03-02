package player_creator;

/**
 *
 * @author Nicolas Brax
 */
public class CivilStatus {

  private boolean female;
  private String familyname;
  private String firstname;
  private String surname;
  private int age;
  private double size;
  private double weigth;
  private String eyecolor;
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

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public boolean isFemale() {
    return female;
  }

  public void setFemale(boolean female) {
    this.female = female;
  }

  public String getFamilyname() {
    return familyname;
  }

  public void setFamilyname(String familyname) {
    this.familyname = familyname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public double getWeigth() {
    return weigth;
  }

  public void setWeigth(double weigth) {
    this.weigth = weigth;
  }

  public String getEyecolor() {
    return eyecolor;
  }

  public void setEyecolor(String eyecolor) {
    this.eyecolor = eyecolor;
  }

  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }
}
