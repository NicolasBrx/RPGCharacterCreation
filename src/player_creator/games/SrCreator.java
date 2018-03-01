package player_creator.games;

import ihm.games.tools.SR_Augmentation;
import ihm.games.tools.SR_Contact;
import ihm.games.tools.SR_Identity;
import ihm.games.tools.SR_Quality;
import ihm.games.tools.SR_Skill;
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
  private ArrayList<SR_Identity> identityList;
  private ArrayList<SR_Skill> skillList;
  private ArrayList<SR_Quality> qualityList;
  private ArrayList<SR_Contact> contactList;
  private ArrayList<SR_Augmentation> augmentationList;
  
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

  /**
   *
   * @return
   */
  public String getMetatype() {
    return metatype;
  }

  /**
   *
   * @param metatype
   */
  public void setMetatype(String metatype) {
    this.metatype = metatype;
  }

  /**
   *
   * @return
   */
  public int getStreetcred() {
    return streetcred;
  }

  /**
   *
   * @param streetcred
   */
  public void setStreetcred(int streetcred) {
    this.streetcred = streetcred;
  }

  /**
   *
   * @return
   */
  public int getNotoriety() {
    return notoriety;
  }

  /**
   *
   * @param notoriety
   */
  public void setNotoriety(int notoriety) {
    this.notoriety = notoriety;
  }

  /**
   *
   * @return
   */
  public int getPublicAwareness() {
    return publicAwareness;
  }

  /**
   *
   * @param publicAwareness
   */
  public void setPublicAwareness(int publicAwareness) {
    this.publicAwareness = publicAwareness;
  }

  /**
   *
   * @return
   */
  public int getKarma() {
    return karma;
  }

  /**
   *
   * @param karma
   */
  public void setKarma(int karma) {
    this.karma = karma;
  }

  /**
   *
   * @return
   */
  public int getTotalKarma() {
    return totalKarma;
  }

  /**
   *
   * @param totalKarma
   */
  public void setTotalKarma(int totalKarma) {
    this.totalKarma = totalKarma;
  }

  /**
   *
   * @return
   */
  public int getBody() {
    return body;
  }

  /**
   *
   * @param body
   */
  public void setBody(int body) {
    this.body = body;
  }

  /**
   *
   * @return
   */
  public int getAgility() {
    return agility;
  }

  /**
   *
   * @param agility
   */
  public void setAgility(int agility) {
    this.agility = agility;
  }

  /**
   *
   * @return
   */
  public int getReaction() {
    return reaction;
  }

  /**
   *
   * @param reaction
   */
  public void setReaction(int reaction) {
    this.reaction = reaction;
  }

  /**
   *
   * @return
   */
  public int getStrength() {
    return strength;
  }

  /**
   *
   * @param strength
   */
  public void setStrength(int strength) {
    this.strength = strength;
  }

  /**
   *
   * @return
   */
  public int getWillpower() {
    return willpower;
  }

  /**
   *
   * @param willpower
   */
  public void setWillpower(int willpower) {
    this.willpower = willpower;
  }

  /**
   *
   * @return
   */
  public int getLogic() {
    return logic;
  }

  /**
   *
   * @param logic
   */
  public void setLogic(int logic) {
    this.logic = logic;
  }

  /**
   *
   * @return
   */
  public int getIntuition() {
    return intuition;
  }

  /**
   *
   * @param intuition
   */
  public void setIntuition(int intuition) {
    this.intuition = intuition;
  }

  /**
   *
   * @return
   */
  public int getCharisma() {
    return charisma;
  }

  /**
   *
   * @param charisma
   */
  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  /**
   *
   * @return
   */
  public int getEdge() {
    return edge;
  }

  /**
   *
   * @param edge
   */
  public void setEdge(int edge) {
    this.edge = edge;
  }

  /**
   *
   * @return
   */
  public int getMagic() {
    return magic;
  }

  /**
   *
   * @param magic
   */
  public void setMagic(int magic) {
    this.magic = magic;
  }

  /**
   *
   * @return
   */
  public int getResonance() {
    return resonance;
  }

  /**
   *
   * @param resonance
   */
  public void setResonance(int resonance) {
    this.resonance = resonance;
  }

  /**
   *
   * @return
   */
  public int getInitiative() {
    return initiative;
  }

  /**
   *
   * @param initiative
   */
  public void setInitiative(int initiative) {
    this.initiative = initiative;
  }

  /**
   *
   * @return
   */
  public int getMatrixInitiative() {
    return matrixInitiative;
  }

  /**
   *
   * @param matrixInitiative
   */
  public void setMatrixInitiative(int matrixInitiative) {
    this.matrixInitiative = matrixInitiative;
  }

  /**
   *
   * @return
   */
  public int getAstralInitiative() {
    return astralInitiative;
  }

  /**
   *
   * @param astralInitiative
   */
  public void setAstralInitiative(int astralInitiative) {
    this.astralInitiative = astralInitiative;
  }

  /**
   *
   * @return
   */
  public int getComposure() {
    return composure;
  }

  /**
   *
   * @param composure
   */
  public void setComposure(int composure) {
    this.composure = composure;
  }

  /**
   *
   * @return
   */
  public int getJudgeIntention() {
    return judgeIntention;
  }

  /**
   *
   * @param judgeIntention
   */
  public void setJudgeIntention(int judgeIntention) {
    this.judgeIntention = judgeIntention;
  }

  /**
   *
   * @return
   */
  public int getMemory() {
    return memory;
  }

  /**
   *
   * @param memory
   */
  public void setMemory(int memory) {
    this.memory = memory;
  }

  /**
   *
   * @return
   */
  public int getLift() {
    return lift;
  }

  /**
   *
   * @param lift
   */
  public void setLift(int lift) {
    this.lift = lift;
  }

  /**
   *
   * @return
   */
  public int getMovement() {
    return movement;
  }

  /**
   *
   * @param movement
   */
  public void setMovement(int movement) {
    this.movement = movement;
  }

  /**
   *
   * @return
   */
  public int getPhysicalDamageTrack() {
    return physicalDamageTrack;
  }

  /**
   *
   * @param physicalDamageTrack
   */
  public void setPhysicalDamageTrack(int physicalDamageTrack) {
    this.physicalDamageTrack = physicalDamageTrack;
  }

  /**
   *
   * @return
   */
  public int getStunDamageTrack() {
    return stunDamageTrack;
  }

  /**
   *
   * @param stunDamageTrack
   */
  public void setStunDamageTrack(int stunDamageTrack) {
    this.stunDamageTrack = stunDamageTrack;
  }

  /**
   *
   * @return
   */
  public int getPhysicalLimit() {
    return physicalLimit;
  }

  /**
   *
   * @param physicalLimit
   */
  public void setPhysicalLimit(int physicalLimit) {
    this.physicalLimit = physicalLimit;
  }

  /**
   *
   * @return
   */
  public int getMentalLimit() {
    return mentalLimit;
  }

  /**
   *
   * @param mentalLimit
   */
  public void setMentalLimit(int mentalLimit) {
    this.mentalLimit = mentalLimit;
  }

  /**
   *
   * @return
   */
  public int getSocialLimit() {
    return socialLimit;
  }

  /**
   *
   * @param socialLimit
   */
  public void setSocialLimit(int socialLimit) {
    this.socialLimit = socialLimit;
  }

  /**
   *
   * @return
   */
  public ArrayList<SR_Identity> getIdentityList() {
    return identityList;
  }

  /**
   *
   * @param identityList
   */
  public void setIdentityList(ArrayList<SR_Identity> identityList) {
    this.identityList = identityList;
  }

  /**
   *
   * @return
   */
  public ArrayList<SR_Skill> getSkillList() {
    return skillList;
  }

  /**
   *
   * @param skillList
   */
  public void setSkillList(ArrayList<SR_Skill> skillList) {
    this.skillList = skillList;
  }

  /**
   *
   * @return
   */
  public ArrayList<SR_Quality> getQualityList() {
    return qualityList;
  }

  /**
   *
   * @param qualityList
   */
  public void setQualityList(ArrayList<SR_Quality> qualityList) {
    this.qualityList = qualityList;
  }

  /**
   *
   * @return
   */
  public ArrayList<SR_Contact> getContactList() {
    return contactList;
  }

  /**
   *
   * @param contactList
   */
  public void setContactList(ArrayList<SR_Contact> contactList) {
    this.contactList = contactList;
  }

  /**
   * 
   * @return 
   */
  public boolean isMagician() {
    return magician;
  }

  /**
   * 
   * @param magician 
   */
  public void setMagician(boolean magician) {
    this.magician = magician;
  }

  /**
   * 
   * @return 
   */
  public boolean isTechnomancer() {
    return technomancer;
  }

  /**
   * 
   * @param technomancer 
   */
  public void setTechnomancer(boolean technomancer) {
    this.technomancer = technomancer;
  }

  /**
   * 
   * @return 
   */
  public boolean isAdept() {
    return adept;
  }

  /**
   * 
   * @param adept 
   */
  public void setAdept(boolean adept) {
    this.adept = adept;
  }

  /**
   * 
   * @return 
   */
  public double getEssence() {
    return essence;
  }

  /**
   * 
   * @param essence 
   */
  public void setEssence(double essence) {
    this.essence = essence;
  }

  /**
   * 
   * @return 
   */
  public int getOverflow() {
    return overflow;
  }

  /**
   * 
   * @param overflow 
   */
  public void setOverflow(int overflow) {
    this.overflow = overflow;
  }

  /**
   * 
   * @return 
   */
  public ArrayList<SR_Augmentation> getAugmentationList() {
    return augmentationList;
  }

  /**
   * 
   * @param augmentationList 
   */
  public void setAugmentationList(ArrayList<SR_Augmentation> augmentationList) {
    this.augmentationList = augmentationList;
  }
  
  
}
