package player_creator.games.shadowrun.gears;

/**
 *
 * @author Nicolas Brax
 */
public class GearWeapon extends Gear{
  public enum weaponType {RANGED,MELEE};
  private int weaponDamage;
  private String weaponDamageType;
  private int weaponAccuracy;
  private int weaponArmorPiercing;
  
  /*** ranged weapon ***/
  private enum weaponMode {SS,SA,BF,FA};
  private int weaponAmmoCount;
  private enum weaponAmmoLoader {clip,barrel,belt};
  private int weaponRecoil;
  
  /*** melee weapon ***/
  private int weaponReach;

  public GearWeapon() {
  }

  public GearWeapon(int weaponDamage, String weaponDamageType, int weaponAccuracy, 
          int weaponArmorPiercing, int weaponAmmoCount, int weaponRecoil, 
          int weaponReach, String gearName, int gearRating, int gearPrice,
          String gearAvailability)
  {
    super(gearName, gearRating, gearPrice, gearAvailability, gearClass.weapon);
    this.weaponDamage = weaponDamage;
    this.weaponDamageType = weaponDamageType;
    this.weaponAccuracy = weaponAccuracy;
    this.weaponArmorPiercing = weaponArmorPiercing;
    this.weaponAmmoCount = weaponAmmoCount;
    this.weaponRecoil = weaponRecoil;
    this.weaponReach = weaponReach;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public int getWeaponDamage() {
    return weaponDamage;
  }
  
  public void setWeaponDamage(int weaponDamage) {
    this.weaponDamage = weaponDamage;
  }

  public String getWeaponDamageType() {
    return weaponDamageType;
  }

  public void setWeaponDamageType(String weaponDamageType) {
    this.weaponDamageType = weaponDamageType;
  }

  public int getWeaponAccuracy() {
    return weaponAccuracy;
  }

  public void setWeaponAccuracy(int weaponAccuracy) {
    this.weaponAccuracy = weaponAccuracy;
  }

  public int getWeaponArmorPiercing() {
    return weaponArmorPiercing;
  }

  public void setWeaponArmorPiercing(int weaponArmorPiercing) {
    this.weaponArmorPiercing = weaponArmorPiercing;
  }

  public int getWeaponAmmoCount() {
    return weaponAmmoCount;
  }

  public void setWeaponAmmoCount(int weaponAmmoCount) {
    this.weaponAmmoCount = weaponAmmoCount;
  }

  public int getWeaponRecoil() {
    return weaponRecoil;
  }

  public void setWeaponRecoil(int weaponRecoil) {
    this.weaponRecoil = weaponRecoil;
  }

  public int getWeaponReach() {
    return weaponReach;
  }

  public void setWeaponReach(int weaponReach) {
    this.weaponReach = weaponReach;
  }
  
  
  
}
