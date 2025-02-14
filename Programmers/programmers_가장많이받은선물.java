// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-2024-KAKAO-WINTER-INTERSHIP-%EA%B0%80%EC%9E%A5-%EB%A7%8E%EC%9D%B4-%EB%B0%9B%EC%9D%80-%EC%84%A0%EB%AC%BC

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friends_len = friends.length;
        int gifts_len = gifts.length;

        int[][] get_send_array = new int[friends_len][friends_len]; //주&받 표
        int[] presents_num = new int [friends_len]; //선물지수
        int[] get_presents = new int [friends_len]; //받은 선물

        for (int i = 0; i < gifts_len; i++){
            String[] gift_split = gifts[i].split(" ");
            String send = gift_split[0];
            String get = gift_split[1];

            int send_num = -1;
            int get_num = -1;
            for (int j=0; j < friends_len ; j++){
                if(friends[j].equals(send)){
                    send_num = j;
                    presents_num[j] += 1;
                }
                if(friends[j].equals(get)){
                    get_num = j;
                    presents_num[j] -= 1;
                }
            }
            if(send_num != -1 && get_num != -1){
                get_send_array[send_num][get_num] += 1;
            }

        }


        for(int a= 0; a < friends_len; a++){
            for (int b=a; b<friends_len; b++){
                if(a != b){
                    if(get_send_array[a][b] < get_send_array[b][a]){
                        get_presents[b] += 1;
                    }
                    else if(get_send_array[a][b] > get_send_array[b][a]){
                        get_presents[a] += 1;
                    }
                    else{
                        if(presents_num[a] > presents_num[b]){
                            get_presents[a] += 1;
                        }
                        else if(presents_num[a] < presents_num[b]){
                            get_presents[b] += 1;
                        }
                    }
                }
            }
        }


        for (int c =0; c < friends_len; c++){
            if(get_presents[c] > answer){
                answer = get_presents[c];
            }
        }

        return answer;
    }
}