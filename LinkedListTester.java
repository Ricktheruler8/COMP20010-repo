package com.comp20010;

import java.util.Random;

/*Test class to test all methods of the linked list implementation and List ADT*/
public class LinkedListTester {
    public static Random random = new Random(System.currentTimeMillis());

    public static void test1(){


        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        String[] data = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        for(int i = 0; i < 50; ++i){
            dll.addLast(data[random.nextInt(data.length)]);
        }

        int N = 100;

        String[] procs = {"addFirst", "addLast", "removeFirst", "removeLast", "add", "removeNode"};

        for (int i = 0; i < N; ++i) {
            String s = data[random.nextInt(data.length)];
            switch (procs[random.nextInt(procs.length)]) {
                case "addFirst":
                    dll.addFirst(s);
                    break;
                case "addLast":
                    dll.addLast(s);
                    break;
                case "removeFirst":
                    if (!dll.isEmpty()) {
                        dll.removeFirst();
                    }
                    break;
                case "removeLast":
                    if (!dll.isEmpty()) {
                        dll.removeLast();
                    }
                    break;
                case "removeNode":
                    dll.removeNode(random.nextInt(dll.size()));
                    break;
                case "add":
                    dll.add(s, random.nextInt(dll.size()));
                    break;
                default:
                    System.out.println("unknown");
                    break;
            }
        }

        // print out the size of the list and the elements...
        System.out.println("size(dll): " + dll.size());
        for (Object s : dll) {
            System.out.println("dll -> " + s);
        }

    }
}
