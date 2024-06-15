import java.util.*;

class Solution {
    static class Car implements Comparable<Car> {
        int num, cost;
        Car(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Car o) {
            return this.num - o.num;
        }
    }

    static PriorityQueue<Car> pq = new PriorityQueue<>();
    static Map<Integer, Integer> carMap = new HashMap<>();
    static Map<Integer, Integer> inTimes = new HashMap<>();
    static int defaultTime, defaultCost, perTime, perCost;
    static int carCount = 0;
    
    static int[] allTimes = new int[10001];
    static int[] allCosts = new int[100001];
    static boolean[] visited = new boolean[10001];
    
    static int[] answer;
    
    public int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0];
        defaultCost = fees[1];
        perTime = fees[2];
        perCost = fees[3];

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String[] rawTime = st.nextToken().split(":");
            int hour = Integer.parseInt(rawTime[0]);
            int min = Integer.parseInt(rawTime[1]);
            int carNum = Integer.parseInt(st.nextToken());
            String check = st.nextToken();

            int time = hour * 60 + min;

            if (check.equals("IN")) {
                inTimes.put(carNum, time);
                if(!visited[carNum]){
                    visited[carNum] = true;
                    carCount++;
                }
            } else {
                out(carNum, time);
                inTimes.remove(carNum); // 안전한 위치로 이동
            }
        }

        // 모든 차량을 23:59에 출차로 간주
        Iterator<Map.Entry<Integer, Integer>> iterator = inTimes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            out(entry.getKey(), 1439);
            iterator.remove(); // 안전하게 삭제
        }
        
        calc();

        return answer;
    }
    
    private static void calc(){
        
        answer = new int[carCount];
        int count = 0;
        
        for(int i = 0; i <= 9999; i++){
            if(visited[i]){
                int totalCost = defaultCost;
                int totalTime = allTimes[i];
                
                if (totalTime > defaultTime) {
                    totalTime -= defaultTime;
                    totalCost += (totalTime / perTime) * perCost;
                    if (totalTime % perTime != 0) {
                        totalCost += perCost;
                    }
                }
                
                allCosts[i] = totalCost;
                answer[count++] = totalCost;
            }
                
        }
        
    }

    private static void out(int carNum, int outTime) {
        int inTime = inTimes.get(carNum);
        int totalTime = outTime - inTime;
 
        allTimes[carNum] += totalTime;
    }
}
