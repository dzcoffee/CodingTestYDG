// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-2023-KAKAO-BLIND-RECRUITMENT-%EA%B0%9C%EC%9D%B8%EC%A0%95%EB%B3%B4-%EC%88%98%EC%A7%91-%EC%9C%A0%ED%9A%A8%EA%B8%B0%EA%B0%84

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> termData = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        System.out.println(todayDate);

        for(int i=0; i<terms.length; i++){
            String[] str = terms[i].split(" ");
            termData.put(str[0], Integer.parseInt(str[1]));
        }

        for(int j=0; j<privacies.length; j++){
            String[] str2 = privacies[j].split(" ");
            LocalDate dateCheck = LocalDate.parse(str2[0], formatter);
            int termMonth = termData.get(str2[1]);
            System.out.println(termMonth);
            LocalDate plusDate = dateCheck.plusMonths(termMonth);
            LocalDate finalDate = plusDate.minusDays(1);
            System.out.println(finalDate);
            if(finalDate.isBefore(todayDate)){
                System.out.println("Check");
                answerList.add(j+1);
            }
        }
        int[] answer = new int[answerList.size()];
        int size = 0;
        for(int temp:answerList){
            answer[size] = temp;
            size++;
        }
        return answer;
    }
}