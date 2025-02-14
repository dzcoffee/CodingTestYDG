// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.1-%EB%B0%94%ED%83%95%ED%99%94%EB%A9%B4-%EC%A0%95%EB%A6%AC

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux =wallpaper.length;
        int luy =wallpaper[0].length();
        int rdx=-1;
        int rdy = -1;
        for(int i =0; i<wallpaper.length; i++){
            for(int j = 0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(luy > j){
                        luy = j;
                    }
                    if(lux > i){
                        lux = i;
                    }
                    if(rdy < j){
                        rdy = j;
                    }
                    if(rdx < i){
                        rdx = i;
                    }
                    System.out.println(lux +""+ luy +""+ rdx+1 +""+ rdy+1);
                }
            }
        }

        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}