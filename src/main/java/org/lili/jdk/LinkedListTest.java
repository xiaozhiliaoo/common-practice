package org.lili.jdk;

import java.util.LinkedList;

/**
 * @author lili
 * @date 2020/5/4 9:43
 * @description
 * @notes
 */

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("11");
        linkedList.addFirst("22");
        linkedList.addFirst("33");
        System.out.println(linkedList);
    }
}
