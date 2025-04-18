class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String say = countAndSay(n-1), ans="";
        int cnt=1;
        for(int i=0; i<say.length(); i++){
            while(i!=say.length()-1 && say.charAt(i) == say.charAt(i+1)){
                cnt++;
                i++;
            }
            ans += cnt +""+ say.charAt(i);
            cnt=1;
        }
        return ans;
    }
}