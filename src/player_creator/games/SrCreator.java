package player_creator.games;

import player_creator.games.shadowrun.gears.GearAugmentation;
import player_creator.games.shadowrun.social.Contact;
import player_creator.games.shadowrun.social.Identity;
import player_creator.games.shadowrun.personal.Quality;
import player_creator.games.shadowrun.personal.Skil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import player_creator.PlayerCreator;
import player_creator.games.shadowrun.builder.Attribute;
import player_creator.games.shadowrun.gears.Gear;
import tools.RPGCCException;
import tools.XMLParser;

/**
 *
 * @author Nicolas Brax
 */
public class SrCreator extends PlayerCreator{
  
  // extension of civil state
  private String metatype;
  private int streetcred;
  private int publicAwareness;
  private int karma;
  private int totalKarma;
  
  // attributes
  private HashMap<String,Attribute> attributes;
  
  // special attributes
  private boolean magician;
  private boolean technomancer;
  private boolean adept;
  private int magic;
  private int resonance;
  private double essence;
  
  // computed attributes
  private int initiative;
  private int matrixInitiative;
  private int astralInitiative;
  private int physicalLimit;
  private int mentalLimit;
  private int socialLimit;
  private int physicalDamageTrack;
  private int stunDamageTrack;
  private int overflow;
  private int notoriety;
  private int composure;
  private int judgeIntention;
  private int memory;
  private int lift;
  private int movement;
  private int startingNuyens;
  
  // other information and data
  private ArrayList<String> raceAdvantages;
  private ArrayList<Identity> identityList;
  private ArrayList<Skil> skillList;
  private ArrayList<Quality> qualityList;
  private ArrayList<Contact> contactList;
  private ArrayList<GearAugmentation> augmentationList;
  
  // attributes for building TODO
  private int maxAttributePoints;
  private int maxSpecialAttributePoints;
  
  /**
   * 
   * @param playername 
   */
  public SrCreator(String playername){
    super(playername);
    this.streetcred = 0;
    this.publicAwareness = 0;
    this.attributes = new HashMap<>();
    this.raceAdvantages = new ArrayList<>();
    this.identityList = new ArrayList<>();
    this.skillList = new ArrayList<>();
    this.qualityList = new ArrayList<>();
    this.contactList = new ArrayList<>();
    this.augmentationList = new ArrayList<>();
  }
  
  /**
   * This method is used to validate a created character. It is validated when
   * it complies with all the rules and specific scores according to the rules.
   * 
   * In Shadowrun, this means:
   * - 
   * 
   * In case of error while validating, the method returns a sequence containing 
   * the following options (preceeded by '-'):
   * - 
   * 
   * It has to be noted that a character in God Mode will always be validated.
   * 
   * @return True if the character is consistant with the rules, false otherwise.
   */
  @Override
  public String validateCharacter(){
    return "";
  }
  
  /**
   * This method is used to save the current character for further uses. It 
   * returns an boolean value to indicate if the save has been correctly done
   * or if errors or corruptions occured.
   * 
   * It has to be noted that verification about the current character are to be
   * made before this call if wanted.
   * 
   * @return True if the character is saved, false otherwise.
   */
  @Override
  public boolean saveCharacter(){
    finalizeCharacter();
    boolean toReturn = true;
    try{
      XMLParser xml = new XMLParser();
      xml.saveCharacter(this);
    }
    catch(RPGCCException e){
      toReturn = false;
      this.lastError = "Error while saving: " + e.getMessage();
    }
    return toReturn;
  }

  /****************************************************************************/
  /*****                         Builder Methods                          *****/
  /****************************************************************************/
  
  public boolean setRace(String race){
    boolean toReturn = true;
    
    this.attributes.put("body", 
            new Attribute("body",(race.equalsIgnoreCase("dwarf") ? 3 :    // dwarf
                                  (race.equalsIgnoreCase("ork") ? 4 :    // ork
                                    (race.equalsIgnoreCase("troll") ? 5  // troll
                                    : 1) // other race
                                  ) // end ork
                                 ) // race check
                         )
                       ); // end dwarf
    
    this.attributes.put("strength", 
            new Attribute("strength",(race.equalsIgnoreCase("dwarf") ? 3 :    // dwarf
                                  (race.equalsIgnoreCase("ork") ? 3 :    // ork
                                    (race.equalsIgnoreCase("troll") ? 5  // troll
                                    : 1) // other race
                                  ) // end ork
                                 ) // race check
                         )
                       ); // end dwarf
    
    this.attributes.put("agility", new Attribute("agility",(race.equalsIgnoreCase("elf") ? 2 : 1)));
    this.attributes.put("reaction",new Attribute("reaction",1));
    this.attributes.put("agility", new Attribute("agility",(race.equalsIgnoreCase("dwarf") ? 2 : 1)));
    this.attributes.put("logic",new Attribute("logic",1));
    this.attributes.put("intuition",new Attribute("intuition",1));
    this.attributes.put("agility", new Attribute("agility",(race.equalsIgnoreCase("elf") ? 3 : 1)));
    this.attributes.put("edge",new Attribute("edge",(race.equalsIgnoreCase("human") ? 2 : 1)));

    if(race.equalsIgnoreCase("elf") || race.equalsIgnoreCase("ork")){
      this.raceAdvantages.add("night vision");
    }
    else if(race.equalsIgnoreCase("dwarf")){
      this.raceAdvantages.add("thermic vision");
      this.raceAdvantages.add("+2 against illness and poisons");
      this.raceAdvantages.add("+20% life costs");
    }
    else if(race.equalsIgnoreCase("elf")){
      this.raceAdvantages.add("thermic vision");
      this.raceAdvantages.add("+1 reach");
      this.raceAdvantages.add("+1 skin armor");
      this.raceAdvantages.add("+100% life costs");
    }
    
    return toReturn;
  }
  
  // TODO: modify special attributes (no rules except the number of points available)
  public boolean modifySpecialAttribute(String attribute, int modifier){
    boolean toReturn = true;
    return toReturn;
  }
  
  // TODO: modify attributes:  only one at the natural limit and points available
  public boolean modifyAttribute(String attribute, int modifier){
    boolean toReturn = true;
    return toReturn;
  }
  
  // TODO: choose qualities (spend and gain karma, warning for max gain/spend)
  public boolean spendKarma(int karmaModifier){
    boolean toReturn = true;
    // used for qualities
    return toReturn;
  }
  
  // TODO: purchase gears by spending resources
  public boolean addGear(Gear gear, boolean remove){
    boolean toReturn = true;
    return toReturn;
  }
  
  // TODO: set lifestyle (and add starting nuyens to finalization, random on lifestyle)
  public boolean setLifestyle(String lifestyle){
    boolean toReturn = true;
    return toReturn;
  }
  
  // TODO: leftover karma to spend : contacts
  public boolean addContact(Contact contact, boolean remove){
    boolean toReturn = true;
    return toReturn;
  }
  
  // TODO: finalization => add starting nuyens computation
  /**
   * Compute all attributes derivated from the ones set during the 
   * character creation process.
   */
  private void finalizeCharacter(){
    this.initiative = (getIntuition() + getReaction() 
                    + ThreadLocalRandom.current().nextInt(1, 7));
    this.matrixInitiative = (getIntuition() + getReaction()
                          + ThreadLocalRandom.current().nextInt(1, 7));;
    if(this.magician)
      this.astralInitiative = getIntuition() * 2
                            + ThreadLocalRandom.current().nextInt(1, 7)
                            + ThreadLocalRandom.current().nextInt(1, 7);  
    
    this.mentalLimit = Math.floorDiv((getLogic() * 2 + getBody() + getWillpower()),3);
    this.physicalLimit = Math.floorDiv((getStrength() * 2 + getBody() + getReaction()),3);
    this.socialLimit = Math.floorDiv((getCharisma() * 2 + getWillpower() + (int)Math.ceil(this.essence)),3);
    
    this.physicalDamageTrack = 8 + Math.floorDiv(getBody(), 2);
    this.stunDamageTrack = 8 + Math.floorDiv(getWillpower(), 2);
    this.overflow = getBody();
    
    this.notoriety = this.publicAwareness + this.streetcred;
    
    this.composure = getCharisma() + getWillpower();
    this.judgeIntention = getCharisma() + getIntuition();
    this.lift = getBody() + getStrength();
    this.memory = getLogic() + getWillpower();
    this.movement = getAgility() * 2;
    
    // TODO: compute starting nuyens (according to lifestyle)
    // TODO: compute new attribute values (according to gear and other bonuses/maluses)
  }
  
  // TODO: final touches => check what can be done
  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getMetatype() {
    return metatype;
  }

  public void setMetatype(String metatype) {
    this.metatype = metatype;
  }

  public int getStreetcred() {
    return streetcred;
  }

  public void setStreetcred(int streetcred) {
    this.streetcred = streetcred;
  }

  public int getNotoriety() {
    return notoriety;
  }

  public void setNotoriety(int notoriety) {
    this.notoriety = notoriety;
  }

  public int getPublicAwareness() {
    return publicAwareness;
  }

  public void setPublicAwareness(int publicAwareness) {
    this.publicAwareness = publicAwareness;
  }

  public int getKarma() {
    return karma;
  }

  public void setKarma(int karma) {
    this.karma = karma;
  }

  public int getTotalKarma() {
    return totalKarma;
  }

  public void setTotalKarma(int totalKarma) {
    this.totalKarma = totalKarma;
  }

  public int getBody() {
    return this.attributes.get("body").getCurrentValue();
  }

  public void setBody(int body) {
    this.attributes.get("body").setCurrentValue(body);
  }

  public int getAgility() {
    return this.attributes.get("agility").getCurrentValue();
  }

  public void setAgility(int agility) {
    this.attributes.get("agility").setCurrentValue(agility);
  }

  public int getReaction() {
    return this.attributes.get("reaction").getCurrentValue();
  }

  public void setReaction(int reaction) {
    this.attributes.get("reaction").setCurrentValue(reaction);
  }

  public int getStrength() {
    return this.attributes.get("strength").getCurrentValue();
  }

  public void setStrength(int strength) {
    this.attributes.get("strength").setCurrentValue(strength);
  }

  public int getWillpower() {
    return this.attributes.get("willpower").getCurrentValue();
  }

  public void setWillpower(int willpower) {
    this.attributes.get("willpower").setCurrentValue(willpower);
  }

  public int getLogic() {
    return this.attributes.get("logic").getCurrentValue();
  }

  public void setLogic(int logic) {
    this.attributes.get("logic").setCurrentValue(logic);
  }

  public int getIntuition() {
    return this.attributes.get("intuition").getCurrentValue();
  }

  public void setIntuition(int intuition) {
    this.attributes.get("intuition").setCurrentValue(intuition);
  }

  public int getCharisma() {
    return this.attributes.get("charisma").getCurrentValue();
  }

  public void setCharisma(int charisma) {
    this.attributes.get("charisma").setCurrentValue(charisma);
  }

  public int getEdge() {
    return this.attributes.get("edge").getCurrentValue();
  }

  public void setEdge(int edge) {
    this.attributes.get("edge").setCurrentValue(edge);
  }

  public int getMagic() {
    return magic;
  }

  public void setMagic(int magic) {
    this.magic = magic;
  }

  public int getResonance() {
    return resonance;
  }

  public void setResonance(int resonance) {
    this.resonance = resonance;
  }

  public int getInitiative() {
    return initiative;
  }

  public void setInitiative(int initiative) {
    this.initiative = initiative;
  }

  public int getMatrixInitiative() {
    return matrixInitiative;
  }

  public void setMatrixInitiative(int matrixInitiative) {
    this.matrixInitiative = matrixInitiative;
  }

  public int getAstralInitiative() {
    return astralInitiative;
  }

  public void setAstralInitiative(int astralInitiative) {
    this.astralInitiative = astralInitiative;
  }

  public int getComposure() {
    return composure;
  }

  public void setComposure(int composure) {
    this.composure = composure;
  }

  public int getJudgeIntention() {
    return judgeIntention;
  }

  public void setJudgeIntention(int judgeIntention) {
    this.judgeIntention = judgeIntention;
  }

  public int getMemory() {
    return memory;
  }

  public void setMemory(int memory) {
    this.memory = memory;
  }

  public int getLift() {
    return lift;
  }

  public void setLift(int lift) {
    this.lift = lift;
  }

  public int getMovement() {
    return movement;
  }

  public void setMovement(int movement) {
    this.movement = movement;
  }

  public int getPhysicalDamageTrack() {
    return physicalDamageTrack;
  }

  public void setPhysicalDamageTrack(int physicalDamageTrack) {
    this.physicalDamageTrack = physicalDamageTrack;
  }

  public int getStunDamageTrack() {
    return stunDamageTrack;
  }

  public void setStunDamageTrack(int stunDamageTrack) {
    this.stunDamageTrack = stunDamageTrack;
  }

  public int getPhysicalLimit() {
    return physicalLimit;
  }

  public void setPhysicalLimit(int physicalLimit) {
    this.physicalLimit = physicalLimit;
  }

  public int getMentalLimit() {
    return mentalLimit;
  }

  public void setMentalLimit(int mentalLimit) {
    this.mentalLimit = mentalLimit;
  }

  public int getSocialLimit() {
    return socialLimit;
  }

  public void setSocialLimit(int socialLimit) {
    this.socialLimit = socialLimit;
  }

  public ArrayList<Identity> getIdentityList() {
    return identityList;
  }

  public void setIdentityList(ArrayList<Identity> identityList) {
    this.identityList = identityList;
  }

  public ArrayList<Skil> getSkillList() {
    return skillList;
  }

  public void setSkillList(ArrayList<Skil> skillList) {
    this.skillList = skillList;
  }

  public ArrayList<Quality> getQualityList() {
    return qualityList;
  }

  public void setQualityList(ArrayList<Quality> qualityList) {
    this.qualityList = qualityList;
  }

  public ArrayList<Contact> getContactList() {
    return contactList;
  }

  public void setContactList(ArrayList<Contact> contactList) {
    this.contactList = contactList;
  }

  public boolean isMagician() {
    return magician;
  }

  public void setMagician(boolean magician) {
    this.magician = magician;
  }

  public boolean isTechnomancer() {
    return technomancer;
  }

  public void setTechnomancer(boolean technomancer) {
    this.technomancer = technomancer;
  }

  public boolean isAdept() {
    return adept;
  }

  public void setAdept(boolean adept) {
    this.adept = adept;
  }

  public double getEssence() {
    return essence;
  }

  public void setEssence(double essence) {
    this.essence = essence;
  }

  public int getOverflow() {
    return overflow;
  }

  public void setOverflow(int overflow) {
    this.overflow = overflow;
  }

  public ArrayList<GearAugmentation> getAugmentationList() {
    return augmentationList;
  }

  public void setAugmentationList(ArrayList<GearAugmentation> augmentationList) {
    this.augmentationList = augmentationList;
  }
}
