package player_creator.games.shadowrun.builder;

/**
 *
 * @author Nicolas Brax
 */
public enum SpecialSkills {
  magician("Magician"),
  technomancer("Technomancer"),
  aspectedMagician("Aspected Magician"),
  adept("Adept");
  
  /**
   * 
   */
  private final String text;
  
  /**
   * 
   * @param text 
   */
  SpecialSkills(final String text){
    this.text = text;
  }
  
  /**
   * 
   * @param skillText
   * @return 
   */
  public SpecialSkills getSkill(String skillText){
    for(SpecialSkills special : SpecialSkills.values()){
      if(special.text.equalsIgnoreCase(skillText)){
        return special;
      }
    }
    return null;
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public String toString(){
    return text;
  }
}
