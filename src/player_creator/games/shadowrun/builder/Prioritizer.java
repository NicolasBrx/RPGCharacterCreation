package player_creator.games.shadowrun.builder;

import java.util.ArrayList;
import java.util.HashMap;
import tools.RPGCCException;

/**
 * TODO: load priority values from some config file?
 * @author Nicolas Brax
 */
public class Prioritizer {
  
  //intel on the specificity of the character
  private final boolean streetLevel; // cf p.64
  private final boolean primeRunner;
  private final boolean technomancer;
  private final boolean magician;
  private final boolean aspectedMagician;
  private final boolean adept;
  
  // computed according to global level (streetlevel, primeRunner or normal one)
  private final int karma;
  private final int gearRatingRestriction;
  private final int gearAvailabilityRestriction;
  private final int nuyenRestrictions;
  private final int karmaRestrictions;
  
  // computed according to priority table
  private final HashMap<String,Integer> specialAttributesAndMetatype; // {metatype,attributes}
  private final int attributes;
  private final int magicOrResonance;
  private final ArrayList<Integer> magicOrResonanceSkill;             // {number,rating}
  private final int spellsOrComplexForms;
  private final int skills;
  private final int groupSkills;
  private final int resources;
  
  /**
   * Constructor 
   * @param streetLevel
   * @param primeRunner
   * @param magician
   * @param adept
   * @param aspectedMagician
   * @param technomancer
   * @param metatypePriority
   * @param attributesPriority
   * @param magicOrResonancePriority
   * @param skillsPriority
   * @param resourcePriority
   * @throws RPGCCException 
   */
  public Prioritizer(boolean streetLevel, boolean primeRunner, boolean magician,
          boolean adept, boolean aspectedMagician, boolean technomancer,
          int metatypePriority, int attributesPriority, int magicOrResonancePriority, 
          int skillsPriority, int resourcePriority) throws RPGCCException
  {
    //TODO: test if priorities are OK (not the same numbers)
    //TODO: no contradiction (techno/adept/magician/...)
    
    //intel on the specificity of the character
    this.streetLevel = streetLevel;
    this.primeRunner = primeRunner;
    this.technomancer = technomancer;
    this.magician = magician;
    this.aspectedMagician = aspectedMagician;
    this.adept = adept;
    
    // computed according to global level (streetlevel, primeRunner or normal one)
    this.karma = determineKarma();
    this.gearRatingRestriction = determineGearRatingRestriction();
    this.gearAvailabilityRestriction = determineGearAvailabilityRestriction();
    this.nuyenRestrictions = determineNuyenRestriction();
    this.karmaRestrictions = determineKarmaRestriction();
    
    // according to priority table
    this.specialAttributesAndMetatype = determineSpecialAttributes(metatypePriority);
    this.attributes = determineAttributes(attributesPriority);
    this.magicOrResonance = determineMagicOrResonance(magicOrResonancePriority);
    this.magicOrResonanceSkill = determineMagicOrResonanceSkill(magicOrResonancePriority);
    this.spellsOrComplexForms = determineSpellOrComplexForms(magicOrResonancePriority);
    this.skills = determineSkills(skillsPriority);
    this.groupSkills = determineGroupSkills(skillsPriority);
    this.resources = determineResources(resourcePriority);
  }
  
  /****************************************************************************/
  /*****  Methods for value settings according to priorities (cF. ctor)   *****/
  /****************************************************************************/
  private int determineAttributes(int priority) throws RPGCCException{
    switch(priority){
      case 1: return 24;
      case 2: return 20;
      case 3: return 16;
      case 4: return 14;
      case 5: return 12;
      default: throw new RPGCCException("Invalid attribute priority.");
    }
  }
  
  private HashMap<String,Integer> determineSpecialAttributes(int priority) throws RPGCCException{
    switch(priority){
      case 1: return new HashMap<String,Integer>(){{put("Human",9);put("Elf",8);put("Dwarf",7);put("Ork",7);put("Troll",5);}};
      case 2: return new HashMap<String,Integer>(){{put("Human",7);put("Elf",6);put("Dwarf",4);put("Ork",4);put("Troll",0);}};
      case 3: return new HashMap<String,Integer>(){{put("Human",5);put("Elf",3);put("Dwarf",1);put("Ork",0);}};
      case 4: return new HashMap<String,Integer>(){{put("Human",3);put("Elf",0);}};
      case 5: return new HashMap<String,Integer>(){{put("Human",1);}};
      default: throw new RPGCCException("Invalid metatype priority.");
    }
  }
  
  private int determineMagicOrResonance(int priority) throws RPGCCException{
    switch(priority){
      case 1: return 6;
      case 2: return (adept ? 6 : (aspectedMagician ? 5 : 4));
      case 3: return (adept ? 4 : 3);
      case 4: return ((adept||aspectedMagician) ? 2 : 0);
      case 5: return 0;
      default: throw new RPGCCException("Invalid magic/resonance priority.");
    }
  }
  
  private ArrayList<Integer> determineMagicOrResonanceSkill(int priority) throws RPGCCException{
    switch(priority){
      case 1: return new ArrayList<Integer>(){{add(2);add(5);}};
      case 2: return new ArrayList<Integer>(){{add((adept||aspectedMagician) ? 1 : 2);add(4);}};
      case 3: return (adept||aspectedMagician) ? new ArrayList<Integer>(){{add(1);add(2);}} : null;
      case 4: case 5: return null;
      default: throw new RPGCCException("Invalid magic/resonance priority.");
    }
  }
  
  private int determineSpellOrComplexForms(int priority) throws RPGCCException{
    switch(priority){
      case 1: return (magician ? 10 : (technomancer ? 5 : 0));
      case 2: return (magician ? 7 : (technomancer ? 2 : 0));
      case 3: return (magician ? 5 : (technomancer ? 1 : 0));
      case 4: case 5: return 0;
      default: throw new RPGCCException("Invalid magic/resonance priority.");
    }
  }
  
  /****************************************************************************/
  /*****  Methods for value settings according to runner global levels    *****/
  /****************************************************************************/
  private int determineSkills(int priority) throws RPGCCException{
    switch(priority){
      case 1: return 46;
      case 2: return 36;
      case 3: return 28;
      case 4: return 22;
      case 5: return 18;
      default: throw new RPGCCException("Invalid skills priority.");
    }
  }
  
  private int determineGroupSkills(int priority) throws RPGCCException{
    switch(priority){
      case 1: return 10;
      case 2: return 5;
      case 3: return 2;
      case 4: case 5: return 0;
      default: throw new RPGCCException("Invalid skills priority.");
    }
  }
  
  private int determineResources(int priority) throws RPGCCException{
    switch(priority){
      case 1: return (streetLevel ? 75000 : (primeRunner ? 500000 : 450000));
      case 2: return (streetLevel ? 50000 : (primeRunner ? 325000 : 275000));
      case 3: return (streetLevel ? 25000 : (primeRunner ? 210000 : 140000));
      case 4: return (streetLevel ? 15000 : (primeRunner ? 150000 : 50000));
      case 5: return (streetLevel ? 6000 : (primeRunner ? 100000 : 6000));
      default: throw new RPGCCException("Invalid skills priority.");
    }
  }
  
  private int determineKarma() {
    return (streetLevel ? 13 : (primeRunner ? 35 : 25));
  }

  private int determineGearRatingRestriction() {
    return (streetLevel ? 4 : (primeRunner ? 6 : 5));
  }

  private int determineGearAvailabilityRestriction() {
    return (streetLevel ? 10 : (primeRunner ? 15 : 12));
  }

  private int determineNuyenRestriction() {
    return (streetLevel ? 5 : (primeRunner ? 25 : 15));
  }

  private int determineKarmaRestriction() { // for the contact... => multiplication  by charisma
    return (streetLevel ? 0 : (primeRunner ? 6 : 3));
  }

  /****************************************************************************/
  /*****                         Getter Methods                           *****/
  /****************************************************************************/
  public boolean isStreetLevel() {
    return streetLevel;
  }

  public boolean isTechnomancer() {
    return technomancer;
  }

  public boolean isMagician() {
    return magician;
  }

  public boolean isAspectedMagician() {
    return aspectedMagician;
  }

  public boolean isAdept() {
    return adept;
  }

  public int getKarma() {
    return karma;
  }

  public int getNuyenRestrictions() {
    return nuyenRestrictions;
  }

  public int getKarmaRestrictions() {
    return karmaRestrictions;
  }

  public HashMap<String, Integer> getSpecialAttributesAndMetatype() {
    return specialAttributesAndMetatype;
  }

  public int getAttributes() {
    return attributes;
  }

  public int getMagicOrResonance() {
    return magicOrResonance;
  }

  public ArrayList<Integer> getMagicOrResonanceSkill() {
    return magicOrResonanceSkill;
  }

  public int getSpellsOrComplexForms() {
    return spellsOrComplexForms;
  }

  public int getSkills() {
    return skills;
  }

  public int getGroupSkills() {
    return groupSkills;
  }

  public int getResources() {
    return resources;
  }

  public boolean isPrimeRunner() {
    return primeRunner;
  }

  public int getGearRatingRestriction() {
    return gearRatingRestriction;
  }

  public int getGearAvailabilityRestriction() {
    return gearAvailabilityRestriction;
  }
}
