package player_creator.games;

import player_creator.games.shadowrun.gears.GearAugmentation;
import player_creator.games.shadowrun.social.Contact;
import player_creator.games.shadowrun.social.Identity;
import player_creator.games.shadowrun.personal.Quality;
import player_creator.games.shadowrun.personal.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import player_creator.PlayerCreator;
import player_creator.games.shadowrun.builder.Attribute;
import player_creator.games.shadowrun.builder.LifeStyle;
import player_creator.games.shadowrun.builder.RunnerType;
import player_creator.games.shadowrun.builder.SpecialSkill;
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
  private int initialKarma;       
  private int karma;
  
  // attributes
  private HashMap<String,Attribute> attributes;
  
  // special knowledge
  private SpecialSkill specialSkill;
  private RunnerType runnerType;
  private LifeStyle lifeStyle;
  
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
  private int lifeCostAdjustment;
  private double essence;
  
  // other information and data
  private ArrayList<String> raceAdvantages;
  private ArrayList<Identity> identityList;
  private ArrayList<Skill> skillList;
  private ArrayList<Quality> qualityList;
  private ArrayList<Contact> contactList;
  private ArrayList<GearAugmentation> augmentationList;
  private ArrayList<Gear> gearList;
  
  /**
   * 
   * @param playername 
   * @param initialKarma 
   */
  public SrCreator(String playername, int initialKarma){
    super(playername);
    this.initialKarma = initialKarma;
    this.karma = initialKarma;
    this.streetcred = 0;
    this.publicAwareness = 0;
    this.attributes = new HashMap<>();
    this.raceAdvantages = new ArrayList<>();
    this.identityList = new ArrayList<>();
    this.skillList = new ArrayList<>();
    this.qualityList = new ArrayList<>();
    this.contactList = new ArrayList<>();
    this.augmentationList = new ArrayList<>();
    this.gearList = new ArrayList<>();
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
    String toReturn = "OK";
    if(!godMode){
      
    }
    return toReturn;
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
    try{finalizeCharacter();}
    catch(RPGCCException e){System.exit(9);} // better ?
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
  
  /**
   * 
   * @param race
   * @return 
   */
  public boolean setRace(String race){
    boolean toReturn = true;
    
    this.attributes.put("body", 
            new Attribute("body",(race.equalsIgnoreCase("dwarf") ? 3 :   // dwarf
                                  (race.equalsIgnoreCase("ork") ? 4 :    // ork
                                    (race.equalsIgnoreCase("troll") ? 5  // troll
                                    : 1) // other race
                                  ) // end ork
                                ) // race check
                        )
                      ); // end dwarf
    
    this.attributes.put("strength", 
            new Attribute("strength",(race.equalsIgnoreCase("dwarf") ? 3 : // dwarf
                                  (race.equalsIgnoreCase("ork") ? 3 :      // ork
                                    (race.equalsIgnoreCase("troll") ? 5    // troll
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
    
    if(race.equalsIgnoreCase("elf") || race.equalsIgnoreCase("ork")){
      this.raceAdvantages.add("night vision");
    }
    else if(race.equalsIgnoreCase("dwarf")){
      this.raceAdvantages.add("thermic vision");
      this.raceAdvantages.add("+2 against illness and poisons");
      this.raceAdvantages.add("+20% life costs");
      this.lifeCostAdjustment = 20;
    }
    else if(race.equalsIgnoreCase("elf")){
      this.raceAdvantages.add("thermic vision");
      this.raceAdvantages.add("+1 reach");
      this.raceAdvantages.add("+1 skin armor");
      this.raceAdvantages.add("+100% life costs");
      this.lifeCostAdjustment = 100;
    }
    
    // special attributes
    this.attributes.put("edge",new Attribute("edge",(race.equalsIgnoreCase("human") ? 2 : 1)));
    this.attributes.put("magic",new Attribute("magic", (specialSkill == SpecialSkill.magician ? 1 : 0)));
    this.attributes.put("resonance",new Attribute("resonance", (specialSkill == SpecialSkill.technomancer ? 1 : 0)));
    
    return toReturn;
  }
  
  /**
   * 
   * @param attribute
   * @param modifier
   * @param special
   * @return 
   */
  public boolean modifyAttribute(String attribute, int modifier, boolean special){
    boolean toReturn = true;
    if(((this.attributes.get(attribute).getCurrentValue() + modifier) > this.attributes.get(attribute).getMaxValue())
    || ((this.attributes.get(attribute).getCurrentValue() + modifier) < 0)
    && !godMode
    ){
      lastError = "Attribute value must be between " + this.attributes.get(attribute).getMinValue()  
                + "and " + this.attributes.get(attribute).getMaxValue() + ".";
      toReturn = false;
    }
    else{
      if(!special 
      && ((this.attributes.get(attribute).getCurrentValue() + modifier) == this.attributes.get(attribute).getMaxValue())
      ){
        toReturn = checkLimits();
      }
      if(toReturn){
        this.attributes.get(attribute).setCurrentValue(this.attributes.get(attribute).getCurrentValue() + modifier);
      }
    }
    return toReturn;
  }

  /**
   * 
   * @return 
   */
  private boolean checkLimits(){
    boolean toReturn = true;
    if(!godMode){
      for(Attribute a : this.attributes.values()){
        if(a.getCurrentValue() == a.getMaxValue()){
          lastError = "There must be only one attribute up to its natural limit. As for now, "
                    + a.getAttributeName() + " is at its limit.";
          toReturn = false;
        }
      }
    }
    return toReturn;
  }
  
  /**
   * Beware that the cost of the fear has to be managed by the UI...
   * 
   * @param gear
   * @param remove
   * @return 
   */
  public boolean addGear(Gear gear, boolean remove){
    boolean toReturn = true;
    if(!remove){
      this.gearList.add(gear);
    }
    else{
      toReturn = false;
      lastError = "The item has not been found in the gear list of the current character.";
      for(int i = 0 ; i < gearList.size() ; ++i){
        if(gearList.get(i).getGearName().equals(gear.getGearName())){
          this.gearList.remove(i);
          toReturn = true;
          lastError = "";
        }
      }
    }
    return toReturn;
  }
  
  /**
   * Beware that the cost of the augmentation has to be managed by the UI in the
   * creation process 
   * 
   * @param augmentation
   * @param remove
   * @return 
   */
  public boolean addAugmentation(GearAugmentation augmentation, boolean remove){
    boolean toReturn = true;
    if(!godMode && (essence - augmentation.getAugmentationEssenceCost() < 0) && !remove){
      toReturn = false;
      lastError = "With this augmentation, the essence of the current character would drop"
                + " below 0, which is not possible in the normal creation rules.";
    }
    else{
      if(!remove){
        this.augmentationList.add(augmentation);
        this.essence -= augmentation.getAugmentationEssenceCost();
      }
      else{
        toReturn = false;
        lastError = "The augmentation has not been found in the augmentation list of the current character.";
        for(int i = 0 ; i < augmentationList.size() ; ++i){
          if(augmentationList.get(i).getGearName().equals(augmentation.getGearName())){
            this.essence += augmentation.getAugmentationEssenceCost();
            this.augmentationList.remove(i);
            toReturn = true;
            lastError = "";
          }
        }
      }
    }
    return toReturn;
  }
  
  private boolean checkKarma(int karmaModifier){
    boolean toReturn = true;
    if(karmaModifier < 0){
      if((this.karma + karmaModifier) < 0){
        lastError = "Too much karma has been spent for contacts, qualities or "
                  + "credits. There is no karma left.";
      }
    }
    else{
      if((this.karma + karmaModifier) >= (2 * this.initialKarma)){
        lastError = "You cannot remove this contact, qualities or nuyens without "
                  + "exceeding the total amount of allowed karma (" 
                  + (2 * this.initialKarma) + ") with  the regained karma.";
      }
    }
    return toReturn;
  }
  
  /**
   * 
   * @param contact
   * @param add
   * @return 
   */
  public boolean addContact(Contact contact, boolean add){
    boolean toReturn;
    if(add){
      int karmaCost = contact.getContactConnection() + contact.getContactLoyalty();
      toReturn = checkKarma(karmaCost * -1);
      if(toReturn){
        this.karma -= karmaCost;
        this.contactList.add(contact);  
      }
    }
    else{
      toReturn = false;
      lastError = "The contact has not been found in the gear list of the current character.";
      for(int i = 0 ; i < contactList.size() ; ++i){
        if(contactList.get(i).getContactName().equals(contact.getContactName())){
          int karmaCost = contactList.get(i).getContactConnection() + contactList.get(i).getContactLoyalty();
          toReturn = checkKarma(karmaCost);
          if(toReturn){
            this.contactList.remove(i);
            lastError = "";
          }
        }
      }
    }
    return toReturn;
  }
  
  /**
   * 
   * @param quality
   * @param add
   * @return 
   */
  public boolean addQuality(Quality quality, boolean add){
    boolean toReturn;
    if(add){
      int karmaCost = quality.getKarmaCost();
      toReturn = checkKarma(karmaCost * -1);
      if(toReturn){
        this.karma -= karmaCost;
        this.qualityList.add(quality);  
      }
    }
    else{
      toReturn = false;
      lastError = "The contact has not been found in the gear list of the current character.";
      for(int i = 0 ; i < contactList.size() ; ++i){
        if(contactList.get(i).getContactName().equals(quality.getQualityName())){
          int karmaCost = qualityList.get(i).getKarmaCost();
          toReturn = checkKarma(karmaCost);
          if(toReturn){
            this.contactList.remove(i);
            lastError = "";
          }
        }
      }
    }
    return toReturn;
  }
  
  /**
   * Beware that this is only for karma tracking, the money gained or spent is 
   * used to create the character and then has to be managed by the UI.
   * 
   * @param karmaCost
   * @param add
   * @return 
   */
  public boolean addNuyens(int karmaCost, boolean add){
    boolean toReturn;
    toReturn = checkKarma((add ? -1 : 1) * karmaCost);
    if(toReturn){
      this.karma += karmaCost  * (add ? -1 : 1);
    }
    return toReturn;
  }
  
  /**
   * 
   * @param skill
   * @param add
   * @return 
   */
  public boolean modifySkill(Skill skill, boolean add){
    boolean toReturn = false;
    boolean found = false;
    lastError = "The Skill has not been found in the skill list of this character.";
    
    for(Skill s : this.skillList){
      if(s.getSkillName().equals(skill.getSkillName())){
        found = true;
        if(s.getSkillRating() == (add ? 6 : 0)){
          lastError = "This skill rating must be between 0 and 6.";
        }
        else{
          s.setSkillRating(s.getSkillRating() + (add ? 1 : -1));
          toReturn = true;
          lastError = "";
        }
      }
    }
    
    if(!found){
      skill.setSkillRating(1);
      this.skillList.add(skill);
    }
    
    return toReturn;
  }
  public boolean addSpecialisation(String skillName, String specialisation){
    boolean toReturn = false;
    lastError = "The Skill has not been found in the skill list of this character.";
    for(Skill s : this.skillList){
      if(s.getSkillName().equals(skillName)){
        toReturn = true;
        lastError = "";
        s.addSpecialisation(specialisation);
      }
    }
    return toReturn;
  }
  
  /**
   * Compute all attributes derivated from the ones set during the 
   * character creation process.
   */
  private void finalizeCharacter() throws RPGCCException{
    this.initiative = (getIntuition() + getReaction() 
                    + ThreadLocalRandom.current().nextInt(1, 7));
    this.matrixInitiative = (getIntuition() + getReaction()
                          + ThreadLocalRandom.current().nextInt(1, 7));;
    if(specialSkill == SpecialSkill.magician)
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
    
    this.startingNuyens = (Integer.parseInt(lifeStyle.getStartingNuyens(this.lifeStyle).split("D")[0]) 
                        * ThreadLocalRandom.current().nextInt(1, 7))
                        + Integer.parseInt(lifeStyle.getStartingNuyens(this.lifeStyle).split("\\+")[1]);
    
    // TODO: compute new attribute values (according to gear and other bonuses/maluses)... when we have the intel
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
    return initialKarma;
  }

  public void setKarma(int karma) {
    this.initialKarma = karma;
  }

  public int getTotalKarma() {
    return karma;
  }

  public void setTotalKarma(int totalKarma) {
    this.karma = totalKarma;
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
  
  public int getMagic(){
    return this.attributes.get("magic").getCurrentValue();
  }
  
  public void setMagic(int magic){
    this.attributes.get("magic").setCurrentValue(magic);
  }
  
  public int getResonance(){
    return this.attributes.get("resonance").getCurrentValue();
  }
  
  public void setResonance(int resonance){
    this.attributes.get("resonance").setCurrentValue(resonance);
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

  public ArrayList<Skill> getSkillList() {
    return skillList;
  }

  public void setSkillList(ArrayList<Skill> skillList) {
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
  
  public SpecialSkill getSpecialSkill(){
    return this.specialSkill;
  }
  
  public RunnerType getRunnerType(){
    return this.runnerType;
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

  public int getStartingNuyens() {
    return startingNuyens;
  }

  public void setStartingNuyens(int startingNuyens) {
    this.startingNuyens = startingNuyens;
  }

  public int getLifeCostAdjustment() {
    return lifeCostAdjustment;
  }

  public void setLifeCostAdjustment(int lifeCostAdjustment) {
    this.lifeCostAdjustment = lifeCostAdjustment;
  }

  public LifeStyle getLifeStyle() {
    return lifeStyle;
  }

  public void setLifeStyle(LifeStyle lifeStyle) {
    this.lifeStyle = lifeStyle;
  }

  public ArrayList<String> getRaceAdvantages() {
    return raceAdvantages;
  }

  public void setRaceAdvantages(ArrayList<String> raceAdvantages) {
    this.raceAdvantages = raceAdvantages;
  }

  public ArrayList<Gear> getGearList() {
    return gearList;
  }

  public void setGearList(ArrayList<Gear> gearList) {
    this.gearList = gearList;
  }
  
  
}
