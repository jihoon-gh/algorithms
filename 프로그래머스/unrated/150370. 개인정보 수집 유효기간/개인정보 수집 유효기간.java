import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
      int[] answer = {};
        List<Integer> ans = new ArrayList<>();

        String[] todayInfo = today.split("\\.");

        String temp = todayInfo[0] + todayInfo[1] + todayInfo[2];
        Integer todayInt = Integer.parseInt(temp);

        Map<String, Integer> m = new HashMap<>();
        for(String s : terms){
            String[] splits = s.split(" ");
            m.put(splits[0], Integer.parseInt(splits[1]));
        }

        for(int i = 0; i < privacies.length; i++){
            String[] splits = privacies[i].split(" ");
            String priv = splits[1];
            String[] dayInfo = splits[0].split("\\.");
            Integer privYear = Integer.parseInt(dayInfo[0]);
            Integer privMon = Integer.parseInt(dayInfo[1]);
            Integer privDay = Integer.parseInt(dayInfo[2]);
            privYear += m.get(priv) / 12;
            privMon += m.get(priv) % 12;
            if(privMon >=13){
                privYear++;
                privMon -= 12;
            }
            String tempYear = privYear.toString();
            String tempMon;
            String tempDay;
            if(privMon < 10){
                tempMon = "0"+privMon;
            }
            else{
                tempMon = privMon.toString();
            }
            if(privDay < 10){
                tempDay = "0"+privDay;
            }
            else{
                tempDay = privDay.toString();
            }
            Integer privInt = Integer.parseInt(tempYear+tempMon+tempDay);
            if(privInt<=todayInt){
                ans.add(i+1);
            }
        }
        answer = Arrays.stream(ans.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}