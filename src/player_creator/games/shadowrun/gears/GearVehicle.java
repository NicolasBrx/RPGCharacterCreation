package player_creator.games.shadowrun.gears;

/**
 *
 * @author Nicolas Brax
 */
public class GearVehicle extends Gear{
  
  private int vehicleAcceleration;
  private int vehicleHandling;
  private int vehiclePilot;
  private int vehicleSpeed;
  private int vehicleArmor;
  private int vehicleBody;
  private int vehicleSensor;
  private String vehicleNotes;
  
  public GearVehicle() {
  }

  public GearVehicle(String vehicleName, int vehicleAcceleration, int vehicleHandling, 
          int vehiclePilot, int vehicleSpeed, int vehicleArmor, int vehicleBody, 
          int vehicleSensor, String vehicleNotes, int vehiclePrice, String vehicleAvailability)
  {
    super(vehicleName, 0, vehiclePrice, vehicleAvailability, gearClass.vehicle);
    this.vehicleAcceleration = vehicleAcceleration;
    this.vehicleHandling = vehicleHandling;
    this.vehiclePilot = vehiclePilot;
    this.vehicleSpeed = vehicleSpeed;
    this.vehicleArmor = vehicleArmor;
    this.vehicleBody = vehicleBody;
    this.vehicleSensor = vehicleSensor;
    this.vehicleNotes = vehicleNotes;
  }

  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public int getVehicleAcceleration() {
    return vehicleAcceleration;
  }

  public void setVehicleAcceleration(int vehicleAcceleration) {
    this.vehicleAcceleration = vehicleAcceleration;
  }

  public int getVehicleHandling() {
    return vehicleHandling;
  }

  public void setVehicleHandling(int vehicleHandling) {
    this.vehicleHandling = vehicleHandling;
  }

  public int getVehiclePilot() {
    return vehiclePilot;
  }

  public void setVehiclePilot(int vehiclePilot) {
    this.vehiclePilot = vehiclePilot;
  }

  public int getVehicleSpeed() {
    return vehicleSpeed;
  }

  public void setVehicleSpeed(int vehicleSpeed) {
    this.vehicleSpeed = vehicleSpeed;
  }

  public int getVehicleArmor() {
    return vehicleArmor;
  }

  public void setVehicleArmor(int vehicleArmor) {
    this.vehicleArmor = vehicleArmor;
  }

  public int getVehicleBody() {
    return vehicleBody;
  }

  public void setVehicleBody(int vehicleBody) {
    this.vehicleBody = vehicleBody;
  }

  public int getVehicleSensor() {
    return vehicleSensor;
  }

  public void setVehicleSensor(int vehicleSensor) {
    this.vehicleSensor = vehicleSensor;
  }

  public String getVehicleNotes() {
    return vehicleNotes;
  }

  public void setVehicleNotes(String vehicleNotes) {
    this.vehicleNotes = vehicleNotes;
  }
}
