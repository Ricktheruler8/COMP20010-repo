package com.comp20010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

public class HashCodeCollision {

    // polynomial hasCode
    public static int hashCode(String s, int p) {
        int h = 0;

        for (int i = 0; i < s.length(); i++) {
            h = p * h + s.charAt(i);
        }
        return h;
    }
    // old java hashCode
    static int hashCodeOld(String s){
        int hash = 0;

        int skip = Math.max(1, s.length() / 8);

        for (int i = 0; i < s.length(); i += skip) {
            hash = (hash * 37) + s.charAt(i);
        }
        return hash;
    }
    // cyclic shift hashcode
    static int hashCodeCyclicShift(String s) {
        int h = 0;
        for(int i = 0; i < s.length(); ++i) {
            h = (h << 7) | (h >>> 25);
            h += (int) s.charAt(i);
        }
        return h;
    }

    public static void Collision() throws FileNotFoundException {

        Map<Integer, List<String>> hashMap = new HashMap<>();
        File file = new File("src\\com\\company\\collision");
        FileReader reader = new FileReader(file);
        Scanner sc = new Scanner(reader).useDelimiter("[^a-zA-Z]+");

        int i = 0;
        while (sc.hasNext()) {
            String word = sc.next();

//            part a Q 5
            int code = hashCode(word, 41);
//            part b Q 5
//            int code = hashCode(word, 17);
//            part c Q 5
//            int code = hashCodeCyclicShift(word);
//            part d Q 5
//            int code = hashCodeOld(word);

            if (!hashMap.containsKey(code)) {
                hashMap.put(code, new ArrayList<>());
            }

            hashMap.get(code).add(word);
        }
        sc.close();

        int collisions = 0;
        int max = 0;
        List<String> maxList = null;
        for (Entry<Integer, List<String>> listEntry : hashMap.entrySet()) {
            List<String> l = listEntry.getValue();
            if (l.size() > max) {
                max = l.size();
                maxList = l;
            }

            if (l.size() > 1) {
                System.out.println("Collision: " + l);
                ++collisions;
            }
        }

        System.out.println("collisions found: " + collisions);
        System.out.println("biggest collision: " + maxList);
    }

    public static void main(String[] args) throws FileNotFoundException {

        Collision();
    }
}

