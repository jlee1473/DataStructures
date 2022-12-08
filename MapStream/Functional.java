package MapStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functional {

  public static List<Integer> addOne (List<Integer> list) {
    // TODO: Make an addOne function using map
    List<Integer> addOneList = list.stream().map(x -> x + 1).toList();
    return addOneList;
  }

  public static int add(int a, int b) {
    return a + b;
  }

  public static List<Integer> filterEven (List<Integer> list) {
    // TODO: Make an filterEven function using filter
    List<Integer> evenList = list.stream().filter(x -> x%2 == 0).toList();
    return evenList;
  }

  public static List<Integer> filterAndAdd (List<Integer> list) {
    // TODO: Make an filterandAdd function using map and filter
    List<Integer> modifiedList = list.stream().filter(x -> x%2 ==0).map(x -> x + 1).toList();
    return modifiedList;
  }

  public static List<Integer> filterAddMultiplyFilter(List<Integer> list) {
    List<Integer> modifiedList = list.stream().filter(x -> x%2 == 1).map(x -> x + 1).map(x -> x*3).filter(x -> x%2 == 0).toList();
    return modifiedList;
  }



  public static void main(String[] args) throws Exception {
    System.out.println("\nSquares: int -> int");
    List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4);
    List<Integer> list2 = list1.stream().map((n) -> n * n).toList();
    System.out.println(list1);
    System.out.println(list2);

    System.out.println("\nChars from string: int -> string");
    List<Integer> list3 = Arrays.asList(0, 1, 2, 3, 4);
    List<Character> list4 = list3.stream().map((n) -> {
      String s = "Hello!";
      return s.charAt(n);
    }).toList();
    System.out.println(list3);
    System.out.println(list4);

    System.out.println("\nOdds only: int -> int");
    List<Integer> list5 = Arrays.asList(0, 1, 2, 3, 4);
    List<Integer> list6 = list1.stream().filter((n) -> n % 2 > 0).toList();
    System.out.println(list5);
    System.out.println(list6);

    System.out.println("\nFilter then map: int -> int");
    List<Integer> list7 = Arrays.asList(0, 1, 2, 3, 4);
    List<Integer> list8 = list1.stream()
      .filter((n) -> n % 2 > 0)
      .map((n) -> n * n)
      .collect(Collectors.toList());
    System.out.println(list7);
    System.out.println(list8);

    System.out.println("\nDictionary operations: {Dict} -> {Dict}");
    List<Dictionary> data = new ArrayList<>();
    Dictionary p1 = new Hashtable();
    p1.put("name", "paul");
    p1.put("age", 34);
    p1.put("bday", "1988-06-26");

    Dictionary p2 = new Hashtable();
    p2.put("name", "aman");
    p2.put("age", 22);
    p2.put("bday", "2022-11-16");

    data.add(p1);
    data.add(p2);

    Date today = new Date();

    // Find all that match todays date and increment their age by 1
    List<Dictionary> data_out = data.stream()
      .filter((d) -> {
        String s =  (String) d.get("bday");
        Date bday = null;
        try {
          bday = new SimpleDateFormat("yyyy-mm-dd").parse(s); // edit parse Date
          System.out.println("bday: " + bday);
          System.out.println("today: " + today);
        } catch (ParseException e) {
          throw new RuntimeException(e);
        }
        return today.compareTo(bday) == 0; })
      .map((d) -> {
        d.put("age", (int) d.get("age") + 1);
        return d;
      }).toList();
    System.out.println(data_out);

    //Reduction with identity value of 0 for addition
    int result = list1.stream().reduce(0, Functional::add);
    System.out.println("Reduction result: " + result);

    System.out.println("\nAdd with function reference");
    System.out.println(list1.stream().reduce(0, Functional::add));

    /**
     * Reduce Identity :
     * Any Math operations + -  * / is 0;
     * Max and Min is 0;
     * Join String is "" (empty line);
     */

  }
}