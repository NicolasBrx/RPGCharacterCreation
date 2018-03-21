package player_creator.games.shadowrun.builder;

import java.util.ArrayList;
import java.util.HashMap;
import tools.RPGCCException;

/**
 * TODO: load priority values from some config file?
 * @author Nicolas Brax
 */
public class Prioritizer {
  
  // intel on the specificity of the character
  private final SpecialSkill specialSkill;
  private final RunnerType runnerType;
  
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
   * @param runnerLevel
   * @param runnerType
   * @param specialSkill
   * @param metatypePriority
   * @param attributesPriority
   * @param magicOrResonancePriority
   * @param skillsPriority
   * @param resourcePriority
   * @throws RPGCCException 
   */
  public Prioritizer(String runnerLevel, RunnerType runnerType, SpecialSkill specialSkill,
          int metatypePriority, int attributesPriority, int magicOrResonancePriority, 
          int skillsPriority, int resourcePriority) throws RPGCCException
  {
    //TODO: test if priorities are OK (not the same numbers)
    //TODO: no contradiction (techno/adept/magician/...)
    
    //intel on the specificity of the character
    this.runnerType = runnerType;
    this.specialSkill = specialSkill;
    
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
      case 2: return (specialSkill == SpecialSkill.adept ? 6 : (specialSkill == SpecialSkill.aspectedMagician ? 5 : 4));
      case 3: return (specialSkill == SpecialSkill.adept ? 4 : 3);
      case 4: return ((specialSkill == SpecialSkill.adept||specialSkill == SpecialSkill.aspectedMagician) ? 2 : 0);
      case 5: return 0;
      default: throw new RPGCCException("Invalid magic/resonance priority.");
    }
  }
  
  private ArrayList<Integer> determineMagicOrResonanceSkill(int priority) throws RPGCCException{
    switch(priority){
      case 1: return new ArrayList<Integer>(){{add(2);add(5);}};
      case 2: return new ArrayList<Integer>(){{add((specialSkill == SpecialSkill.adept||specialSkill == SpecialSkill.aspectedMagician) ? 1 : 2);add(4);}};
      case 3: return (specialSkill == SpecialSkill.adept||specialSkill == SpecialSkill.aspectedMagician) ? new ArrayList<Integer>(){{add(1);add(2);}} : null;
      case 4: case 5: return null;
      default: throw new RPGCCException("Invalid magic/resonance priority.");
    }
  }
  
  private int determineSpellOrComplexForms(int priority) throws RPGCCException{
    switch(priority){
      case 1: return (specialSkill == SpecialSkill.magician ? 10 : (specialSkill == SpecialSkill.technomancer ? 5 : 0));
      case 2: return (specialSkill == SpecialSkill.magician ? 7 : (specialSkill == SpecialSkill.technomancer ? 2 : 0));
      case 3: return (specialSkill == SpecialSkill.magician ? 5 : (specialSkill == SpecialSkill.technomancer ? 1 : 0));
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
      case 1: return (runnerType == RunnerType.streetLevelRunner ? 75000 : (runnerType == RunnerType.primeRunner ? 500000 : 450000));
      case 2: return (runnerType == RunnerType.streetLevelRunner ? 50000 : (runnerType == RunnerType.primeRunner ? 325000 : 275000));
      case 3: return (runnerType == RunnerType.streetLevelRunner ? 25000 : (runnerType == RunnerType.primeRunner ? 210000 : 140000));
      case 4: return (runnerType == RunnerType.streetLevelRunner ? 15000 : (runnerType == RunnerType.primeRunner ? 150000 : 50000));
      case 5: return (runnerType == RunnerType.streetLevelRunner ? 6000 : (runnerType == RunnerType.primeRunner ? 100000 : 6000));
      default: throw new RPGCCException("Invalid skills priority.");
    }
  }
  
  private int determineKarma() {
    return (runnerType == RunnerType.streetLevelRunner ? 13 : (runnerType == RunnerType.primeRunner ? 35 : 25));
  }

  private int determineGearRatingRestriction() {
    return (runnerType == RunnerType.streetLevelRunner ? 4 : (runnerType == RunnerType.primeRunner ? 6 : 5));
  }

  private int determineGearAvailabilityRestriction() {
    return (runnerType == RunnerType.streetLevelRunner ? 10 : (runnerType == RunnerType.primeRunner ? 15 : 12));
  }

  private int determineNuyenRestriction() {
    return (runnerType == RunnerType.streetLevelRunner ? 5 : (runnerType == RunnerType.primeRunner ? 25 : 15));
  }

  private int determineKarmaRestriction() { // for the contact... => multiplication  by charisma
    return (runnerType == RunnerType.streetLevelRunner ? 0 : (runnerType == RunnerType.primeRunner ? 6 : 3));
  }

  /****************************************************************************/
  /*****                         Getter Methods                           *****/
  /****************************************************************************/
  public RunnerType getRunnerType(){
    return this.runnerType;
  }

  public SpecialSkill getSpecialSkill(){
    return this.specialSkill;
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

  public int getGearRatingRestriction() {
    return gearRatingRestriction;
  }

  public int getGearAvailabilityRestriction() {
    return gearAvailabilityRestriction;
  }
}
