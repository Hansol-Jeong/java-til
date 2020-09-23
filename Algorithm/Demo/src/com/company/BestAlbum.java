package com.company;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        Solution_BestAlbum solution_bestAlbum = new Solution_BestAlbum();
        System.out.println(Arrays.toString(solution_bestAlbum.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        Map<Integer, String> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(i, genres[i]);
        }
        for (int s: genreMap.keySet()) {
            System.out.print(s);
        }
        System.out.println();
        Iterator iteraotr = genreMap.keySet().iterator();
        while(iteraotr.hasNext()) {
            int key = (int) iteraotr.next();
            System.out.print(key);
        }
    }
}

class Solution_BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[genres.length - 1];
        int count = 0;

        Map<Integer, String> genreMap = new HashMap<>();
        Map<Integer, Integer> playMap = new HashMap<>();
        Map<String, Integer> totalSum = new TreeMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(i, genres[i]);
            playMap.put(i, plays[i]);
            if (!totalSum.containsKey(genres[i])) {
                totalSum.put(genres[i], plays[i]);
            } else {
                int tempValue = totalSum.get(genres[i]);
                totalSum.put(genres[i], tempValue + plays[i]);
            }
        }
        loop: while (genreMap.size()>0) {
            int sum = 0;
            String nextSong = "";
            Iterator iterator = totalSum.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                if (totalSum.get(key) >= sum) {
                    sum = totalSum.get(key);
                    nextSong = key;//장르를 정했다.
                }
            }
            iterator = genreMap.keySet().iterator();
            List<Integer> list = new ArrayList<>();

            while (iterator.hasNext()) {
                int key = (int) iterator.next();
                if (genreMap.get(key) == nextSong)
                    list.add(key);
            }


            int loopNum = list.size();

            for(int i = 0; i<loopNum; i++) {
                int key = 0;
                int play = 0;
                int index = 0;
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    key = (int) iterator.next();
                    if (playMap.get(key) >= play) {
                        play = playMap.get(key);
                        index = key;
                    }
                }
                int tempValue = totalSum.get(genreMap.get(index));
                genreMap.remove(index);
                playMap.remove(index);
                list.remove(list.indexOf(index));

                totalSum.put(nextSong, tempValue - play);
                answer[count++]=index;
                if(genreMap.size()==1)
                    break loop;
            }
        }
        return answer;
    }

}


