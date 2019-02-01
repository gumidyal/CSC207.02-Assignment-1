import java.io.PrintWriter;

public class vigenerecipher {

//class to encode/decode a given message
  public static void main(String[] args) {

    int key;
    String message;

    PrintWriter pen = new PrintWriter(System.err, true);
    String command = args[0];
 // check for correct input
    if (args.length != 3) {
      pen.println("Incorrect number of parameters");
      System.exit(2);
    }
    else if
    (command.contentEquals("encode")) {
      message = args[1];
      encode(message, message.length(), args[2]);
    }
    else if
    (command.contentEquals("decode")) {
      message = args[1];
      decode(message, message.length(), args[2]);
    }
    else {
      pen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(2);
    }

  } // main

//helper function to encode the original message
  public static void encode(String message, int len, String key) {
    StringBuilder build = new StringBuilder(len);
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < len; i++) {
      char ch = message.charAt(i);
      int k = (int) key.charAt((i%key.length())) - 97;
      int c = (int) ch - 97;
      c = ((c + k) % 26);
      ch = (char) (c + 97);
      build.append(ch);
    }
    pen.println(build);
   
  }

//helper function to decode the original message
  public static void decode(String message, int len, String key) {
    StringBuilder build = new StringBuilder(len);
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < len; i++) {
      char ch = message.charAt(i);
      int k = (int) key.charAt(i%key.length()) - 97;
      int c = (int) ch - 97;
      c = (((c - k) + 26) % 26);
      ch = (char) (c + 97);
      build.append(ch);
    }
    pen.println(build);
   
  }
} //class


