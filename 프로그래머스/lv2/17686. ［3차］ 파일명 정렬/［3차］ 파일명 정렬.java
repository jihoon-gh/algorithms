import java.util.*;

class Solution {
    
    static Map<String, Integer> m = new HashMap<>();
    public String[] solution(String[] files) {
        
        for(int i = 0; i < files.length; i++){
            m.put(files[i], i);
        }
        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String[] splits1 = splitFile(s1);
                String[] splits2 = splitFile(s2);
                if(splits1[0].equals(splits2[0])){
                    int a = Integer.parseInt(splits1[1]);
                    int b = Integer.parseInt(splits2[1]);
                    if(a == b){
                        return m.get(s1) - m.get(s2);
                    }
                    else{
                        return a - b;
                    }
                }
                else{
                    return splits1[0].compareTo(splits2[0]);
                }
            }
        });
        
        String[] answer = files;
        return answer;
    }
    public static String[] splitFile(String s){
        String head="";
        String number = "";
        String tail = "";
        int numberStartIndex = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isNumber(c) && numberStartIndex == -1){
                head = s.substring(0,i);
                numberStartIndex = i;
                continue;
            }
            if(!isNumber(c) && numberStartIndex != -1 ){
                number = s.substring(numberStartIndex, i);
                numberStartIndex = -1;
                tail = s.substring(i);
                break;
            }
        }
        if(numberStartIndex != -1){
            number = s.substring(numberStartIndex);
        }
        head = head.toLowerCase();
        String[] res = {head, number, tail};
        // System.out.println(head+" " + number + " " + tail);
        return res; 
    }
    public static boolean isNumber(char c){
        if(c < 48 || c > 57){
            return false;
        }
        return true;
    }

}