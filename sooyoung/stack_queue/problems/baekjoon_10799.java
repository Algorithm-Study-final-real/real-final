package stack_queue.problems;

import java.util.*;
import java.io.*;

public class baekjoon_10799 {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 1. "()" : 열린 괄호 닫힌 괄호 두개가 붙어 있으면 모두 레이저
        // 2. "(....)" : 열린 괄호가 입력되고 닫힌 괄호가 바로 나오지 않는다면
        // 해당 괄호는 막대기를 의미한다.
        String input = in.readLine();
        int answer = 0;
        // 열린 괄호들의 값을 담을 stack 선언
        ArrayDeque<Character> s = new ArrayDeque<>();
        Character before = '(';

        for (int index = 0; index < input.length(); index++) {
            char element = input.charAt(index);

            if (element == '(') {
                s.push('(');
                before = '(';
            } else {
                // 레이저일 경우
                // 처음에는 peek 으로 검사할려고 했다가
                // 막대기일 경우도 걸리기 때문에 그냥 그 전의 값을 저장하자
                if (before == '(') {
                    answer += s.size() - 1;
                    s.pop();
                } else {
                    // 막대기의 오른쪽 끝점
                    // 각 쇠막대기를 자르는 레이저는 적어도 하나 존재하기 때문에
                    answer += 1;
                    s.pop();
                }

                before = ')';
            }
        }

        System.out.println(answer);

        in.close();
    }

}
