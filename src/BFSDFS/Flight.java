package BFSDFS;

import java.util.ArrayList;
import java.util.Collections;

public class Flight {
    static ArrayList<String> arr = new ArrayList();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visit = new boolean[tickets.length];
        arr.add("ICN");
        dfs(tickets, "ICN", visit);
        answer = new String[arr.size()];
        for(int i =0; i< arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }

    private void dfs(String[][] tickets ,String destination, boolean[] visit){
        ArrayList<String> list = new ArrayList<>();
        if(arr.size()== visit.length){  //재귀 종료
            return;
        }
        else{
            for(int i =0; i < tickets.length; i++){
                if(tickets[i][0].equals(destination) && visit[i]==false){//출발지가 같은지 찾기
                    for(int j = 0; j< tickets.length; j++){
                        if(tickets[i][1].equals(tickets[j][0])){
                            list.add(tickets[i][1]);
                        }else if(arr.size() == tickets.length-1){
                            list.add(tickets[i][1]);
                        }
                    }
                }
            }
        }
        String target="";
        if(list.size()>0){  //list정렬해서 더 먼저 가야하는곳 정하기
            Collections.sort(list);
            target = (String) list.get(0);
            arr.add(target);
        }
        for (int j = 0; j < tickets.length; j++) {   //visit에 표시
            if (tickets[j][0].equals(destination) && tickets[j][1].equals(target)) {
                visit[j]=true;
                dfs(tickets, target, visit);
            }
        }
    }

//    private void dfs(String[][] tickets ,String destination, boolean[] visit){
//        ArrayList<String> list = new ArrayList<>();
//        for (int j = 0; j < tickets.length; j++) {   //출발지가 같은게 있는지 확인해서 list에 추가
//            for(int i=0; i < tickets.length; i++) {
//                if (tickets[j][0].equals(destination) && visit[j] == false ) {
//                    if(tickets[i][0].equals(tickets[j][1])){
//                        list.add(tickets[j][1]);
//                    }
//                    else if(arr.size() == tickets.length-1) {
//                        list.add(tickets[j][1]);
//                    }
//                }
//            }
//        }
//        String target="";
//        if(list.size()>0){  //list정렬해서 더 먼저 가야하는곳 정하기
//            Collections.sort(list);
//            target = (String) list.get(0);
//            arr.add(target);
//        }
//        for (int j = 0; j < tickets.length; j++) {   //visit에 표시
//            if (tickets[j][0].equals(destination) && tickets[j][1].equals(target)) {
//                visit[j]=true;
//                dfs(tickets, target, visit);
//            }
//        }
////        if(visit[j] == false) {
////            dfs(tickets, target, visit);
////        }
//    }

    public static void main(String[] args){
        Flight fly = new Flight();
        String[][] ticket ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},{"ATL","SFO"}};
        String[][] ticket2 ={{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
        fly.solution(ticket2);
        for(String i : arr){
            System.out.println(i);
        }

    }
}
/*문제 설명
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
입출력 예
tickets	return
[[ICN, JFK], [HND, IAD], [JFK, HND]]	|   [ICN, JFK, HND, IAD]
[[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]] 	|  [ICN, ATL, ICN, SFO, ATL, SFO]
입출력 예 설명
예제 #1

[ICN, JFK, HND, IAD] 순으로 방문할 수 있습니다.

예제 #2

[ICN, SFO, ATL, ICN, ATL, SFO] 순으로 방문할 수도 있지만 [ICN, ATL, ICN, SFO, ATL, SFO] 가 알파벳 순으로 앞섭니다.

알파벳 순으로 가되 경로 없는 경우?
입력 : [[ICN, A], [ICN, B], [B, ICN]]
답 : [ICN, B, ICN, A]
*/
