// C# = 1, D# = 2, F# = 3, G# =4 , A# = 5;


class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int playTime = 0;
        m = m.replaceAll("C#", "1");
        m = m.replaceAll("D#", "2");
        m = m.replaceAll("F#", "3");
        m = m.replaceAll("G#", "4");
        m = m.replaceAll("A#", "5");
        for(String s : musicinfos){
            s = s.replaceAll("C#", "1");
            s = s.replaceAll("D#", "2");
            s = s.replaceAll("F#", "3");
            s = s.replaceAll("G#", "4");
            s = s.replaceAll("A#", "5");
            String[] splits = s.split(",");
            String[] startTime = splits[0].split(":");
            String[] endTime = splits[1].split(":");
            
            Integer startHour = Integer.parseInt(startTime[0]) * 60;
            Integer startMin = Integer.parseInt(startTime[1]);
            int start = startHour + startMin;
            
            Integer endHour = Integer.parseInt(endTime[0]) * 60;
            Integer endMin = Integer.parseInt(endTime[1]);
            int end = endHour + endMin;
            
            int time = end - start;
            
            String songTitle = splits[2];
            
            String tones = splits[3];
            
            int x = time / tones.length();
            int y = time % tones.length();
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < x; i++){
                sb.append(tones);
            }
            sb.append(tones.substring(0, y));
            String res = sb.toString();
            if(res.length() > m.length()){
                if(res.contains(m) && playTime < time){
                    answer = songTitle;
                    playTime = time;
                }
            }
            else{
                if(m.contains(res) && playTime < time){
                    answer = songTitle;
                    playTime = time;
                }
            }
        }
        if(answer.equals("")){
            answer = "(None)";
        }
        return answer;
    }
}