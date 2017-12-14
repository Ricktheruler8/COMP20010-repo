package com.comp20010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class WordCountHashMap {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("src\\com\\company\\textFile");
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader).useDelimiter("[^a-zA-Z]+");
        Map<String, Integer> frequency = new HashMap<>();

        while(scanner.hasNext()){
            String word = scanner.next().toLowerCase();
            Integer count = frequency.get(word);
            if(count == null){
                count = 0;
            }
            frequency.put(word, count + 1);
        }
        scanner.close();

        final int N = 10;

        List<Integer> list = new ArrayList<>(frequency.values());
        Collections.sort(list, Collections.reverseOrder());
        List<Integer> top10 = list.subList(0, 10);
        ArrayList<String> ten = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int j = 0; j < N; j++){
            for(Map.Entry<String, Integer> entry : frequency.entrySet()){

                if(entry.getValue() == top10.get(j)){
                    ten.add(j,entry.getValue() + " " + entry.getKey());
                }
            }
        }

        set.addAll(ten);
        ten.clear();
        ten.addAll(set);
        Collections.sort(ten, Collections.reverseOrder());
        int[] value = new int[ten.size()];
        String[] key = new String[ten.size()];


        for(int i = 0; i < ten.size(); ++i){
            Scanner sc = new Scanner(ten.get(i));
            value[i] = sc.nextInt();
            key[i] = sc.next();
            sc.close();
        }

        System.out.println("The word count for the document is: " + frequency.size() + " words");
        for(int j = 0; j < N; ++j){
            System.out.println("The No. " + (j + 1) + " most frequent word is " + "\"" + key[j] + "\"" + " with a frequency of " + value[j]);
        }
    }
}
