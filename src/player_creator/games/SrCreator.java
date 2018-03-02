package player_creator.games;

import player_creator.games.shadowrun.gears.GearAugmentation;
import player_creator.games.shadowrun.social.Contact;
import player_creator.games.shadowrun.social.Identity;
import player_creator.games.shadowrun.personal.Quality;
import player_creator.games.shadowrun.personal.Skil;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import player_creator.PlayerCreator;
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
  private int body;
  private int agility;
  private int reaction;
  private int strength;
  private int willpower;
  private int logic;
  private int intuition;
  private int charisma;
  
  // special attributes
  private boolean magician;
  private boolean technomancer;
  private boolean adept;
  private int edge;
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
  
  // other information and data
  private ArrayList<Identity> identityList;
  private ArrayList<Skil> skillList;
  private ArrayList<Quality> qualityList;
  private ArrayList<Contact> contactList;
  private ArrayList<GearAugmentation> augmentationList;
  
  /**
   * 
   * @param playername 
   */
  public SrCreator(String playername){
    super(playername);
    this.streetcred = 0;
    this.publicAwareness = 0;
    this.identityList = new ArrayList<>();
    this.skillList = new ArrayList<>();
    this.qualityList = new ArrayList<>();
    this.contactList = new ArrayList<>();
    this.augmentationList = new ArrayList<>();
  }
  
  /**
   * Compute all attributes derivated from the ones set during the 
   * character creation process.
   */
  private void finalizeCharacter(){
    this.initiative = (this.intuition + this.reaction 
                    + ThreadLocalRandom.current().nextInt(1, 7));
    this.matrixInitiative = (this.intuition + this.reaction 
                          + ThreadLocalRandom.current().nextInt(1, 7));;
    if(this.magician)
      this.astralInitiative = this.intuition * 2
                            + ThreadLocalRandom.current().nextInt(1, 7)
                            + ThreadLocalRandom.current().nextInt(1, 7);  
    
    this.mentalLimit = Math.floorDiv((this.logic * 2 + this.body + this.willpower),3);
    this.physicalLimit = Math.floorDiv((this.strength * 2 + this.body + this.reaction),3);
    this.socialLimit = Math.floorDiv((this.charisma * 2 + this.willpower + (int)Math.ceil(this.essence)),3);
    
    this.physicalDamageTrack = 8 + Math.floorDiv(this.body, 2);
    this.stunDamageTrack = 8 + Math.floorDiv(this.willpower, 2);
    this.overflow = this.body;
    
    this.notoriety = this.publicAwareness + this.streetcred;
    
    this.composure = this.charisma + this.willpower;
    this.judgeIntention = this.charisma + this.intuition;
    this.lift = this.body + this.strength;
    this.memory = this.logic + this.willpower;
    this.movement = this.agility * 2;
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
   * @return True if the charachter is saved, false otherwise.
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
    return body;
  }

  public void setBody(int body) {
    this.body = body;
  }

  public int getAgility() {
    return agility;
  }

  public void setAgility(int agility) {
    this.agility = agility;
  }

  public int getReaction() {
    return reaction;
  }

  public void setReaction(int reaction) {
    this.reaction = reaction;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getWillpower() {
    return willpower;
  }

  public void setWillpower(int willpower) {
    this.willpower = willpower;
  }

  public int getLogic() {
    return logic;
  }

  public void setLogic(int logic) {
    this.logic = logic;
  }

  public int getIntuition() {
    return intuition;
  }

  public void setIntuition(int intuition) {
    this.intuition = intuition;
  }

  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  public int getEdge() {
    return edge;
  }

  public void setEdge(int edge) {
    this.edge = edge;
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
