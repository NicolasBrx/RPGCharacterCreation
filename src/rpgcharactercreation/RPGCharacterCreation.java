package rpgcharactercreation;

import ihm.RPGCharacterCreationIHM;

/**
 *
 * @author Nicolas Brax
 */
public class RPGCharacterCreation {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }catch(Exception ex){}
    new RPGCharacterCreationIHM().setVisible(true);
  }
  
}
