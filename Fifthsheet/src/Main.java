//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Collections;   // <- plural
import java.util.Comparator;
public class Main {




    public static String giveMeNoVowelsInMiddle(String input) {
        StringBuilder X = new StringBuilder();
        char[] arr = input.toCharArray();

        X.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            char ch = Character.toLowerCase(arr[i]);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                X.append(arr[i]);
            }
        }

        return X.toString();
    }





/*
    public static boolean comparing(String name,String compressed){
        boolean flag=false;
        char[]comp=compressed.toCharArray();
        char[]nam=name.toCharArray();
        if(comp[0]!=nam[0])
        {flag=false;

        return flag;}




        for(int i=1;i<comp.length;i++){

            for(int j=1;j<nam.length;j++){

                if(comp[i]==nam[j]){}



            }



        }



        return flag;

    }
*/

  public static String findClosestMatch(String [] arr,String compressedname){
      String noVowels = "";
      String [] arr2=new String[arr.length];


      for(int i=0;i<arr.length;i++){


          noVowels=giveMeNoVowelsInMiddle(arr[i]);

          arr2[i]=noVowels;

      }

      int numberSaver=0;
      for(int i=0;i<arr2.length;i++)
      {


          if(compressedname.equals(arr2[i]))
          {


              numberSaver=i;
          }



      }





      return arr[numberSaver];
  }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            String[] originalNames = {"Alice", "Alicia", "Alfred", "Albert"};
            String compressedName = "Alfrd";
            System.out.println(findClosestMatch(originalNames, compressedName));
            String[] names2 = {"Emma", "Emily", "Emanuel"};
            String compressed2 = "Eml";
            System.out.println(findClosestMatch(names2, compressed2));
            String[] names3 = {"Brian", "Brenda", "Brock"};
            String compressed3 = "Bz";
            System.out.println(findClosestMatch(names3, compressed3));

    }
}