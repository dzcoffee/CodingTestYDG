// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-PCCP-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-1%EB%B2%88-%EB%B6%95%EB%8C%80-%EA%B0%90%EA%B8%B0

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int last_attack_time = attacks[attacks.length-1][0];
        int now_HP = health; // 초마다 변화한 HP
        int heal_use_time = bandage[0];
        int monster_attack_count = 0;

        for (int t = 1; t <= last_attack_time ; t++){
            heal_use_time--;
            if(attacks[monster_attack_count][0] == t){ // 공격받으면 시전시간 초기화 및 HP 깎기
                heal_use_time = bandage[0];
                now_HP = now_HP - attacks[monster_attack_count][1];
                monster_attack_count++;
                if(now_HP <= 0){ //만약 HP가 0이하가 되면 종료 후 -1 return
                    answer = -1;
                    break;
                }
            }
            else if(heal_use_time == 0){ // 시전시간 완료 시 추가 heal
                if(bandage[1] + bandage[2] >= health - now_HP){
                    now_HP = health;
                }
                else{
                    now_HP = now_HP + bandage[1] + bandage[2];
                }
                heal_use_time = bandage[0];
            }
            else { //공격 X 일 시 그냥 넘어감
                if(bandage[1] >= health - now_HP ){
                    now_HP = health;
                }
                else{
                    now_HP = now_HP + bandage[1];

                }
            }
        }
        if(now_HP > 0){
            answer = now_HP;
        }

        return answer;
    }
}