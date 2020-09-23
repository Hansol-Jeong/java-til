package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {600, 600, 150, 800, 2500};
        for (int i = 0; i < genres.length; i++) {
            System.out.println(solution.solution(genres, plays)[i]);
        }
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        String [] kindsOfGenre = new String [genres.length];
        int [] howManyThatGenreTurnedOn = new int[genres.length];
        int count = 0;
     loop:   for(int i = 0; i<genres.length ;i++) {
           for(int j = 0; j<kindsOfGenre.length; j++) {
               if (kindsOfGenre[j] == genres[i]) {
                   howManyThatGenreTurnedOn[j] += plays[i];
                   continue loop;
               }
           }
           kindsOfGenre[count]=genres[i];
           howManyThatGenreTurnedOn[count]+=plays[i];
           count++;
        }//{classic, pop, null, null, null}
        int tempnum = 0;
        int maxNum = howManyThatGenreTurnedOn[0];
        int[] answer = new int[genres.length];
        while(tempnum!=5) {
            for (int i = 0; i < howManyThatGenreTurnedOn.length; i++) {
                maxNum = maxNum > howManyThatGenreTurnedOn[i] ? maxNum : howManyThatGenreTurnedOn[i];
            }//maxNum은 가장 많이 틀린 장르의 번호
            //해당 번호의 가장 많이 틀린 노래를 출력
            int maxTurnedOn = 0;
          loop:  for (int i = 0; i < genres.length; i++) {
                for(int j = 0; j<answer.length;j++) {
                    if(answer[j]==i);
                    continue loop;
                }
                if (genres[i].equals(kindsOfGenre[maxNum])) {
                    if (plays[i] > maxTurnedOn) {
                        maxTurnedOn = plays[i];
                        answer[tempnum] = i;
                    }
                }
            }
            tempnum++;
        }
        return answer;
    }
}