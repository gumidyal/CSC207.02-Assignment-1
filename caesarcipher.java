import java.io.PrintWriter;

// class to encode/decode a given message
public class caesarcipher {
  public static void main(String[] args) {

    int key;
    String message;

    PrintWriter pen = new PrintWriter(System.err, true);
    String command = args[0];
    // check for correct input
    if (args.length != 2) { 
      pen.println("Incorrect number of parameters");
      System.exit(2);
    }
    else if
    (command.contentEquals("encode")) {
      message = args[1];
      encode(message, message.length());
    }
    else if
    (command.contentEquals("decode")) {
      message = args[1];
      decode(message, message.length());
    }
    else {
      pen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(2);
    }
    
  } // main function

  // helper function to encode the original message
  public static void encode(String message, int len) {
    StringBuilder build = new StringBuilder(len);
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("26 Encoded possibilites: ");
    //loop to encode with every possible key
    for (int key = 0; key < 26; key++) {
      for (int i = 0; i < len; i++) {
        char ch = message.charAt(i); //index of given character
        int c = (int) ch - 97;
        c = ((c + key) % 26);
        ch = (char) (c + 97);
        build.append(ch);
      }
      pen.println("n = " + key + ": " + build);
      build.setLength(0); // clear for new message
    }
  }

  // helper function to decode the original message
  public static void decode(String message, int len) {
    StringBuilder build = new StringBuilder(len);
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("26 Decoded possibilites: ");
    for (int key = 0; key < 26; key++) {
      for (int i = 0; i < len; i++) {
        char ch = message.charAt(i);
        int c = (int) ch - 97;
        c = (((c - key) + 26) % 26);
        ch = (char) (c + 97);
        build.append(ch);
      }
      pen.println("n = " + key + ": " + build);
      build.setLength(0);
    }
  } 
} //class
