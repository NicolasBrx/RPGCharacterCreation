package ihm;

import ihm.games.P13Panel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Nicolas Brax
 */
public class PCGenericPanel extends javax.swing.JPanel {

  /**
   * 
   */
  private String game;
  
  /**
   * 
   */
  private CreationInterface creation;
  
  /**
   * Creates new form PCGenericPanel
   */
  public PCGenericPanel() {
    initComponents();
  }
  
  /**
   * 
   * @param message 
   */
  public void setInformation(String message){
    topPanel.setInformation(message);
  }
  
  public void reset(){
    topPanel.enable();
  }
  
  /**
   * 
   * @param game 
   */
  public void setGame(String game){
    this.game = game;
    switch(this.game){
      case "ADD":
        break;
      case "SR":
        break;
      case "AC":
        break;
      case "P13":
        creation = new P13Panel();
        add((P13Panel)creation);
        setInformation("Please enter a player name to start the creation process.");
        revalidate();
        repaint();
        break;
      case "FS":
        break;
      default:
        break;
    } //switch
  }
  
  /**
   * 
   * @return 
   */
  public boolean isSaveNeeded(){
    return creation.isSaveNeeded();
  }
  
  /**
   * 
   */
  public void saveCharacter(){
    creation.saveCharacter();
  }
  
  /**
   * 
   * @param playerName 
   */
  public void create(String playerName) {
    creation.create(playerName);
  }
  
  public void changeTitle(String toAdd){
    if(toAdd.equalsIgnoreCase("*")){
      ((JTabbedPane)this.getParent()).setTitleAt(0, 
                "*" + ((JTabbedPane)this.getParent()).getTitleAt(0));
    }
    else{
      ((JTabbedPane)this.getParent()).setTitleAt(0, 
                ((JTabbedPane)this.getParent()).getTitleAt(0).substring(1));
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    topPanel = new ihm.JpTopPanel();

    setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    setMaximumSize(new java.awt.Dimension(1000, 600));
    setMinimumSize(new java.awt.Dimension(1000, 600));
    add(topPanel);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private ihm.JpTopPanel topPanel;
  // End of variables declaration//GEN-END:variables
}
