import java.util.*;

class Solution {
    static class Ticket{
        public String next;
        public boolean isAvailable = true;
        public Ticket(String s){
            next = s;
        }
    }
    static ArrayDeque<String> ad = new ArrayDeque<>();
    static HashMap<String, ArrayList<Ticket>> hm = new HashMap<>();
    static ArrayList<ArrayList<String>> alist = new ArrayList<>();
    static int totalTickets;
    public String[] solution(String[][] tickets) {
        
        for(String[] t : tickets){
            String from = t[0];
            String to = t[1];
            if(hm.get(from) == null){
                ArrayList<Ticket> temp = new ArrayList<>();
                hm.put(from,temp);
            }
            if(hm.get(to) == null){
                ArrayList<Ticket> temp = new ArrayList<>();
                hm.put(to,temp);
            }
            hm.get(from).add(new Ticket(to));
        }
        totalTickets = tickets.length;
        
        ad.addLast("ICN");
        dfs("ICN");
        Collections.sort(alist, new Comparator<ArrayList<String>>(){
            @Override
            public int compare(ArrayList<String> l1, ArrayList<String> l2){
                for(int i = 0; i < l1.size(); i++){
                    if(l1.get(i) != l2.get(i)){
                        return l1.get(i).compareTo(l2.get(i));
                    }
                    else continue;
                }
                return -1;
            }
        });
        String[] answer = new String[totalTickets + 1];
        int k  = 0;
        for(String s : alist.get(0)){
            answer[k++] = s;
        }
        return answer;
    }
    public static void dfs(String now){
        if(ad.size() == totalTickets + 1){
            ArrayList<String> temp = new ArrayList<>();
            for(String s : ad){
                temp.add(s);
            }
            alist.add(temp);
            return ;
        }
        
        for(Ticket t : hm.get(now)){
            if(!t.isAvailable) continue;
            t.isAvailable = false;
            ad.addLast(t.next);
            dfs(t.next);
            ad.pollLast();
            t.isAvailable = true;
        }
    }
}