package com.posuoren.structure.list;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 11:42
 */
public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(4);
        testList.add(6);
        testList.add(9);
        testList.add(2);
        testList.add(3);
        printList(testList);
        printSize(testList);
        System.out.println("--------");
        testList.add(2);
        System.out.println("after insert 2");
        printList(testList);
        printSize(testList);
        System.out.println("--------");
        System.out.println("after insert 3 at index 1");
        testList.insert(1, 3);
        printList(testList);
        printSize(testList);
        System.out.println("--------");
        System.out.println("after insert 3 at index 10");
        testList.insert(10, 3);
        printList(testList);
        printSize(testList);
        System.out.println("--------");
        System.out.println("after insert 999 at index 0");
        testList.insert(0, 999);
        printList(testList);
        printSize(testList);
        System.out.println("--------");
        testList.remove(0);
        System.out.println("after remove index 0");
        printList(testList);
        printSize(testList);
        System.out.println("--------");
        System.out.println("tyr remove index 100");
        try{
            testList.remove(100);
        }catch (Exception e){
            System.out.println(e);
        }
        printList(testList);
        printSize(testList);

        System.out.println("--------");
        testList.pop(9);
        System.out.println("after remove value 9");
        printList(testList);
        printSize(testList);

        System.out.println("--------");
        testList.pop(9);
        System.out.println("after remove value 1");
        printList(testList);
        printSize(testList);

        System.out.println("--------");
        testList.removeTail();
        System.out.println("after remove tail");
        printList(testList);
        printSize(testList);

        System.out.println("--------");
        for(Integer value: testList){
            System.out.println("for each print:  " + value);
        }
        System.out.println("--------");
        testList.clear();
        printSize(testList);;
    }

    public static <T> void printList(LinkedList<T> tLinkedList){
        StringBuilder stringBuilder = new StringBuilder();
        for(T value: tLinkedList){
            stringBuilder.append(":" + value.toString());
        }
        System.out.println(stringBuilder.toString());
    }

    public static <T> void printSize(LinkedList<T> tLinkedList){
        System.out.println("size: " + tLinkedList.size());
    }
}
