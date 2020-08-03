package com.company;

public class Main {

    public static void main(String[] args) {
        String string = "www.google.com";
        int begin=0;
        int end=0;
        char [] c;
          c=string.toCharArray();
          for(int i=0;i<string.length();i++){

              if(c[i]=='.') {
                  end = i-1;
                  for(int j=end;j>=begin;j--)
                      System.out.print(string.charAt(j));
                  System.out.print(".");
                  begin=i+1;
              }
              if(i==(string.length()-1))
              {
                  end=string.length()-1;
                  for(int j=end;j>=begin;j--)
                      System.out.print(string.charAt(j));
              }

          }
    }
}
