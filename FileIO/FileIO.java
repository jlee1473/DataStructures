package FileIO;

import java.io.*;

public class FileIO {

  public static void main(String args[]) {
    InputStreamReader cin = null;
    FileOutputStream outfile = null;


    try {
      outfile = new FileOutputStream("output.txt");
      cin = new InputStreamReader(System.in);
      System.out.println("Enter characters to store to file or enter q to quit: ");
      char c;
      c = (char) cin.read();
      while (c != 'q') {
        outfile.write(c);
        c = (char) cin.read();
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
