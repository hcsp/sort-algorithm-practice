package com.github.hcsp.algorithm;

import com.github.hcsp.test.helper.ProjectSourceFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortTest {
    @Test
    public void sortTest() {
        String sortJava = ProjectSourceFileReader.readAsString(Sort.class);
        String methodRegex = "sort[0-9]*\\(int\\[\\]";
        // 保存所有的 sort 方法
        List<String> sortMethodList = new ArrayList<>();
        Matcher matcher =
                Pattern.compile(methodRegex).matcher(sortJava);
        while (matcher.find()) {

            String method = matcher.group().split("\\(")[0];
            sortMethodList.add(method);
        }

        for (int c = 0; c < sortMethodList.size(); c++) {
            // 生成随机数组
            int[] randomArray = new int[10];
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                randomArray[i] = r.nextInt(10);
            }

            int[] copy = Arrays.copyOf(randomArray, 10);
            Arrays.sort(copy);

            System.out.println("Before: " + Arrays.toString(randomArray));
            // 遍历执行每个 sort 方法
            String methodName = sortMethodList.get(c);

            try {
                Class sortClass = Class.forName("com.github.hcsp.algorithm.Sort");
                Method sortC = sortClass.getDeclaredMethod(methodName, int[].class);
                sortC.invoke(sortClass, randomArray);

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("After: " + Arrays.toString(randomArray) + "\n");
            Assertions.assertArrayEquals(copy, randomArray);
        }
    }
}
