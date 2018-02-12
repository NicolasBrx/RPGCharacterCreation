package tools;

/**
 * This class is designed to represent the exception specific to the project
 * RPG Character Creation.
 * 
 * As for now, it does nothing more than providing a specific class name. It is
 * dedicated to change in a more or less far future in order to provide more
 * useful information and so on.
 * 
 * @author Nicolas Brax
 */
public class RPGCCException extends Exception {

  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * The Constructor that just take the message and throw an exception with this
   * message.
   * 
   * @param message The exception message hard coded.
   */
  public RPGCCException(String message) {
    super("Error on Character Creation: " + message);
  }

  /**
   * The Constructor that just take the message and throw an exception with this
   * message if it is throwable.
   * 
   * @param message   The exception message hard coded.
   * @param throwable The hard coded fact that the message is throwable or not.
   */
  public RPGCCException(String message, Throwable throwable) {
    super("Error on Character Creation: " + message, throwable);
  }
}