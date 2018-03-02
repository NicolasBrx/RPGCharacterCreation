package tools;

import player_creator.PlayerCreator;
import player_creator.games.P13Creator;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import player_creator.games.AcCreator;
import player_creator.games.AddCreator;
import player_creator.games.FsCreator;
import player_creator.games.SrCreator;

/**
 * An XML Parser made to save characters for several tabletop RPGs and used by
 * the RPG Software Suit.
 * 
 * @author Nicolas Brax
 */
public class XMLParser {
  
  /**
   * This method saves the character given in argument in an XML File. This
   * save is called only by the RPGCharacterCreation class and thus enforce
   * only the attributes and skills available for each creation and according
   * to the game played.
   * 
   * @param character
   * @throws tools.RPGCCException
   */
  public void saveCharacter(PlayerCreator character) throws RPGCCException{
    try{
      
      //TODO: chage according to type of the character...
      String path = System.getProperty("user.dir") + "/data/patient13/" 
                  + character.getPlayerName() + ".xml";
      
      File file = new File(path);
      if(file.exists()){
        // TODO: do something
      }
      file.createNewFile();
      DataOutputStream stream = new DataOutputStream(new FileOutputStream(file));
      
      Element player = new Element(character.getPlayerName());
      Document doc = new Document(player);
      
      Element person = new Element("character");
      
      /*** Generic Elements: Civilian Status ***/
      person.setAttribute(new Attribute("godmode",character.isGodMode() ? "yes":"no"));
      person.setAttribute(new Attribute("name",character.getFamilyname()));
      person.setAttribute(new Attribute("firstname",character.getFirstname()));
      Element sex = new Element("sex");
      sex.setText(character.isFemale() ? "woman" : "man");
      person.addContent(sex);
      Element surname = new Element("surname");
      surname.setText(String.valueOf(character.getSurname()));
      person.addContent(surname);
      Element age = new Element("age");
      age.setText(String.valueOf(character.getAge()));
      person.addContent(age);
      Element weight = new Element("weight");
      weight.setText(String.valueOf(character.getWeigth()));
      person.addContent(weight);
      Element size = new Element("size");
      size.setText(String.valueOf(character.getSize()));
      person.addContent(size);
      Element eye = new Element("eye");
      eye.setText(String.valueOf(character.getEyecolor()));
      person.addContent(eye);
      
      /*** Specific Elements ***/
      if(P13Creator.class.isInstance(character)){
        person = fillElementWithPatient13Specifics(person,(P13Creator)character);
      }
      else if(AcCreator.class.isInstance(character)){
        person = fillElementWithCthulhuSpecifics(person,(AcCreator)character);
      }
      else if(FsCreator.class.isInstance(character)){
        person = fillElementWithFengShuiSpecifics(person,(FsCreator)character);
      }
      else if(AddCreator.class.isInstance(character)){
        person = fillElementWithAddSpecifics(person,(AddCreator)character);
      }
      else if(SrCreator.class.isInstance(character)){
        person = fillElementWithShadowrunSpecifics(person,(SrCreator)character);
      }
      else{
        throw new RPGCCException("The creator is not recognized. The related "
                + "game might not be supported by the RPG Software Suit. Please "
                + "contact the creator for further information.");
      }

      /*** Finalize the document and close everything ***/
      doc.getRootElement().addContent(person);
      XMLOutputter xmlOut = new XMLOutputter();
      xmlOut.setFormat(Format.getPrettyFormat());
      xmlOut.output(doc, stream);
      stream.close();
    }
    catch(IOException e){
      throw new RPGCCException("Error while creating savegame file.");
    }
  }
  
  /**
   * 
   * @param person
   * @param character
   * @return 
   */
  private Element fillElementWithPatient13Specifics(Element person, P13Creator character){
    person.setAttribute(new Attribute("affected",character.isSane() ? "no" : "yes"));
    Element supervisor = new Element("supervisor");
    supervisor.setText(character.getSupervisor());
    person.addContent(supervisor);
    Element room = new Element("room");
    room.setText(character.getRoom());
    person.addContent(room);
    Element seniority = new Element("seniority");
    seniority.setText(String.valueOf(character.getSeniority()));
    person.addContent(seniority);
    Element attributes = new Element("attributes");
    Element vitality = new Element("vitality");
    vitality.setText(String.valueOf(character.getVitality()));
    attributes.addContent(vitality);
    Element coldblood = new Element("coldblood");
    coldblood.setText(String.valueOf(character.getColdblood()));
    attributes.addContent(coldblood);
    Element lucidity = new Element("lucidity");
    lucidity.setText(String.valueOf(character.getLucidity()));
    attributes.addContent(lucidity);
    person.addContent(attributes);
    Element lineaments = new Element("lineaments");
    for(String lineament : character.getLineaments().keySet()){
      Element tmpL = new Element(lineament);
      tmpL.setText(Integer.toString(character.getLineaments().get(lineament)));
      lineaments.addContent(tmpL);
    }
    person.addContent(lineaments);
    return person;
  }
  
  /**
   * 
   * @param person
   * @param character
   * @return 
   */
  private Element fillElementWithShadowrunSpecifics(Element person, SrCreator character){
    
    return person;
  }
  
  /**
   * 
   * @param person
   * @param character
   * @return 
   */
  private Element fillElementWithCthulhuSpecifics(Element person, AcCreator character){
    
    return person;
  }
  
  /**
   * 
   * @param person
   * @param character
   * @return 
   */
  private Element fillElementWithFengShuiSpecifics(Element person, FsCreator character){
    
    return person;
  }
  
  /**
   * 
   * @param person
   * @param character
   * @return 
   */
  private Element fillElementWithAddSpecifics(Element person, AddCreator character){
    
    return person;
  }
    
  
}
