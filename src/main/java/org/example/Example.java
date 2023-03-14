package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setName("Egor");
        user1.setOnline(true);
        user1.setAge(10);
        users.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Max");
        user2.setOnline(false);
        user2.setAge(20);
        users.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Petr");
        user3.setOnline(true);
        user3.setAge(20);
        users.add(user3);

        User user4 = new User();
        user4.setId(4);
        user4.setName("Henry");
        user4.setOnline(true);
        user4.setAge(50);
        users.add(user4);

        User user5 = new User();
        user5.setId(5);
        user5.setName("Robert");
        user5.setOnline(false);
        user5.setAge(17);
        users.add(user5);

        List<Map<String, String>> users2 = List.of(
                Map.of("name", "Bronn", "gender", "male", "birthday", "1973-03-23"),
                Map.of("name", "Reigar", "gender", "male", "birthday", "1973-11-03"),
                Map.of("name", "Eiegon", "gender", "male", "birthday", "1963-11-03"),
                Map.of("name", "Sansa", "gender", "female", "birthday", "2012-11-03"),
                Map.of("name", "Jon", "gender", "male", "birthday", "1980-11-03"),
                Map.of("name", "Robb", "gender", "male", "birthday", "1980-05-14"),
                Map.of("name", "Tisha", "gender", "female", "birthday", "2012-11-03"),
                Map.of("name", "Rick", "gender", "male", "birthday", "2012-11-03"),
                Map.of("name", "Joffrey", "gender", "male", "birthday", "1999-11-03"),
                Map.of("name", "Edd", "gender", "male", "birthday", "1973-11-03")
        );


        var signal1 = "_|¯|____|¯|__|¯¯¯";
        var signal2 = "_|-|____|-|__|---";

        List<Integer> coll1 = List.of(15, 10, 3, 4);
        List<Integer> coll2 = List.of(7, 5, 3, 2);
        List<Integer> coll3 = List.of(7, 5, 4, 4, 3);
        /*Collection<Integer> example = new ArrayCollection<>();
        example.add(1);
        example.add(23);
        example.add(2);
        example.remove(2);
        System.out.println("размер: " + example.size());
        System.out.println("пустой: " + example.isEmpty());
        System.out.println(example);*/



       /* Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        Integer[] input = new Integer[1];

        Integer[] result = testInstance.toArray(input);
        System.out.println(Arrays.toString(result));*/

//        System.out.println(testInstance);
//        Integer[] arr1 = {1, 2, 3};
        /*Integer[] iii =  new Integer[2];
        Object[] object = iii;
        Object[] arr2 = new Object[2];
        arr2[0] = 22;
        arr2[1] = 24;
        Integer[] arr1 = Arrays.copyOf(arr2, arr2.length, iii.getClass());
        System.out.println(Arrays.toString(arr1));
        System.out.println(iii.getClass());
        System.out.println(object.getClass());
        System.out.println(arr1.getClass());
        System.out.println(arr2.getClass());*/

        /*List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ListIterator<Integer> listItr = list.listIterator();
        System.out.println(".next: " + listItr.next());
        System.out.println(".nextIndex: " + listItr.nextIndex());
        System.out.println(".previousIndex: " + listItr.previousIndex());
        System.out.println(".next: " + listItr.next());
        System.out.println(".previous: " + listItr.previous());
        System.out.println(".next: " + listItr.next());*/



        /*List<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);
        System.out.println(list.lastIndexOf(1));*/

/*
        List<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("Лист вначале: " + list);
        System.out.println("Размер листа вначале: " + list.size());
        list.remove("1");
        list.remove("3");
        list.remove("5");
        System.out.println("Лист после удаления: " + list);
        System.out.println("Размер листа после удаления: " + list.size());*/


        /*List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        list.add(set1);
        set1.add(9);
        list.get(0).add(12);
        System.out.println(list.get(0));
        Set<Integer> set2 = new HashSet<>();
        set2.add(11);
        set2.add(212);
        set2.add(32);
        list.add(set2);
        list.get(1).remove(11);
        System.out.println(list.get(1));*/

        List<Integer> zzz = new ArrayList<>(Arrays.asList(1, 2, 3));
        zzz.set(10, 15);


        System.out.println(zzz);









//        System.out.println(solution(new ArrayList<>(List.of(0, 1, 2, 3, 4))));
    }


    //выявить анграммы
    public static List<String> filterAnagram(String word, List<String> anagrams) {
        if (anagrams.isEmpty()) {
            return new ArrayList<>();
        }
        return anagrams.stream()
                .filter(anagram -> isAnagram(word, anagram))
                .toList();
    }

    public static boolean isAnagram(String word, String anagram) {
        List<String> sortedWord = Stream.of(word.split(""))
                .sorted()
                .toList();

        List<String> sortedAnagram = Stream.of(anagram.split(""))
                .sorted()
                .toList();
        return sortedWord.equals(sortedAnagram);
    }

    //счётчик одногодок
    public static Map<Integer, Long> getMenCountByYear(List<Map<String, String>> users) {
        Map<Integer, Long> result = users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .map(user -> LocalDate.parse(user.get("birthday")).getYear())
                .collect(Collectors.groupingBy(user -> user, Collectors.counting()));
        return result;
//        for (int birthday : birthdaysOfMens) {
//            if (result.containsKey(birthday)) {
//                result.put(birthday, result.get(birthday) + 1);
//            } else {
//                result.put(birthday, (long) 1);
//            }
//        }
//        return result;
    }

    //NRZI код
    public static String nrzi(String diagram) {
        StringBuilder result = new StringBuilder();
        String[] diagramAsArr = diagram.split("");
//        System.out.println(Arrays.toString(diagramAsArr));
        for (int i = 0; i < diagramAsArr.length; i++) {
            if (diagramAsArr[i].equals("|")) {
                result.append("1");
                i += 1;
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }


    //поиск ближайшего соседа
    /*public static int findIndexOfNearest(List<Integer> coll, int num) {
        if (coll.isEmpty()) {
            return -1;
        }
        int answer = 0;
        int diff1 = Math.abs(coll.get(0) - num);
        int diff2 = 0;
        for (int i = 1; i < coll.size(); i++) {
            diff2 = Math.abs(coll.get(i) - num);
            if (diff2 < diff1) {
                answer = i;
                diff1 = diff2;
            }
            if (diff1 == diff2 && i < answer) {
                answer = 1;
            }
        }
        return answer;
    }*/

    public static int findIndexOfNearest(List<Integer> coll, int num) {
        List<Integer> diffs = coll.stream()
                .map(x -> Math.abs(x - num))
                .toList();
        int minDiff = diffs.stream()
                .min(Comparator.comparingInt(x -> x))
                .orElse(0);
        return diffs.indexOf(minDiff);
    }


    public static Integer solution(List<Integer> numbers) {
        int biggest = numbers.stream()
                .max((x, y) -> Integer.compare(x, y))
                .orElse(0);
        numbers.remove(biggest);
        return numbers.stream()
                .max(Comparator.comparingInt(x -> x))
                .orElse(0);
    }


    //Создайте функцию, которая извлекает из хеша имя и фамилию и собирает их в одну строку.
    public List<String> solution2(List<Map<String, String>> names) {
        return names.stream()
                .map(pair -> pair.get("first") + " " + pair.get("last"))
                .collect(Collectors.toList());
    }


    // Реализуйте функцию genDiff(), которая сравнивает два словаря и возвращает результат сравнения в виде словаря.
    // Ключами результирующего словаря будут все ключи из двух входящих, а значением - строка с описанием отличий:
    // added, deleted, changed или unchanged.
    //
    //Возможные значения:
    //
    //added — ключ отсутствовал в первом словаре, но был добавлен во второй
    //deleted — ключ был в первом словаре, но отсутствует во втором
    //changed — ключ присутствовал и в первом и во втором словаре, но значения отличаются
    //unchanged — ключ присутствовал и в первом и во втором словаре с одинаковыми значениями
    public static Map<String, String> genDiff(Map<String, String> data1, Map<String, String> data2) {
        Map<String, String> resultMap = new HashMap<>();
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());
        for (String key : allKeys) {
            if (!data1.containsKey(key)) {
                resultMap.put(key, "added");
            } else if (!data2.containsKey(key)) {
                resultMap.put(key, "deleted");
            } else if (data1.get(key).equals(data2.get(key))) {
                resultMap.put(key, "unchanged");
            } else {
                resultMap.put(key, "changed");
            }
        }
        return resultMap;
    }


    // Преобразование DNA в RNA
    public static String dnaToRna(String dna) {
        /*if (dna.equals("")) {
            return "";
        }
        List<String> dnaChain = new ArrayList<>(List.of("G", "C", "T", "A"));
        List<String> dnaList = new ArrayList<>(Arrays.asList(dna.split("")));
        if (!dnaChain.containsAll(dnaList)) {
            return null;
        }
        return dnaList.stream()
                .map(item -> switch (item) {
                    case "G" -> "C";
                    case "C" -> "G";
                    case "T" -> "A";
                    default -> "U";
                })
                .collect(Collectors.joining(""));
    }*/

        // Альтернативное решение
        if (dna.equals("")) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Map<String, String> mapping = new HashMap<>(
                Map.of("G", "C", "C", "G", "T", "A", "A", "U")
        );
        for (String item : dna.split("")) {
            if (!mapping.containsKey(item)) {
                return null;
            }
            result.append(mapping.get(item));
        }
        return result.toString();
    }


    // Реализуйте функцию merged(), которая объединяет несколько словарей в один общий словарь. Функция принимает
    // любое количество аргументов и возвращает результат в виде словаря, в котором каждый ключ содержит множество
    // (set) уникальных значений.
    public static Map<Character, Set<Integer>> merged(Map<Character, Integer>... forMerged) {
        Map<Character, Set<Integer>> resultMap = new HashMap<>();
        for (Map<Character, Integer> oneMapForMerged : forMerged) {
            for (Map.Entry<Character, Integer> pair : oneMapForMerged.entrySet()) {
                if (resultMap.containsKey(pair.getKey())) {
                    resultMap.get(pair.getKey()).add(pair.getValue());
                } else {
                    Set<Integer> newValue = new HashSet<>();
                    newValue.add(pair.getValue());
                    resultMap.put(pair.getKey(), newValue);
                }
            }
        }
        return resultMap;
    }



}


















