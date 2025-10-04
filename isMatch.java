class Solution
{
    Integer dp[][];
    public boolean isMatch(String s,String p)
    {
        char str[]=s.toCharArray();
        char pat[]=p.toCharArray();
        dp=new Integer[pat.length+1][str.length+1];
        return isMatch(0,0,pat,str);
    }

    boolean isMatch(int i,int j,char[]pat,char[]str)
    {
        if(i==pat.length)
            return j==str.length;
        if(j==str.length)
            return canMatchEmpty(pat,i);
        if(dp[i][j]!=null)
            return dp[i][j]==1;
        
        boolean res;
        if(i+1<pat.length&&pat[i+1]=='*')
            res=isMatch(i+2,j,pat,str)||((str[j]==pat[i]||pat[i]=='.')&&isMatch(i,j+1,pat,str));
        else
            res=(str[j]==pat[i]||pat[i]=='.')&&isMatch(i+1,j+1,pat,str);
        
        dp[i][j]=res?1:0;
        return res;
    }

    boolean canMatchEmpty(char[]pat,int i)
    {
        while(i+1<pat.length&&pat[i+1]=='*')
            i+=2;
        
        return i==pat.length;
    }
}
