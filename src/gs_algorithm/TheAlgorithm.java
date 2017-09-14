/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs_algorithm;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class TheAlgorithm {
    public int n;
    public LinkedList<Integer> freemen;
    public int[][] men_preferences;
    public int[][] women_preferences;
    public int[] next;
    public int[] current;
    public PrepareData pd;
    public int steps=0;
    
    
    public TheAlgorithm(int number)
    {
        n=number;
        freemen = new LinkedList<Integer>();
        men_preferences=new int[n+1][n+1];
        women_preferences=new int[n+1][n+1];
        next = new int[n+1];
        current=new int[n+1];
        pd= new PrepareData();
        
        freemen=pd.InitializeFreeMen(freemen, n);
        men_preferences=pd.generate_preferences(men_preferences, n, true);
        women_preferences=pd.generate_preferences(women_preferences, n, false);
        next=pd.initialize_arrray(next,1);
        current=pd.initialize_arrray(current,-1);
        
        
        
        
    }
    
    public void run_algo()
    {
        
        while(!freemen.isEmpty())
        {
            steps++;
            int cur_man=freemen.removeFirst();
            boolean proposed=false;
            while(!proposed)
            {
                int cur_woman=men_preferences[cur_man][next[cur_man]];
                if(current[cur_woman]==-1)
                {
                    current[cur_woman]=cur_man;
                    next[cur_man]++;
                    proposed=true;
                }
                else
                {
                    int fia=current[cur_woman];
                    if(women_preferences[cur_woman][cur_man]<women_preferences[cur_woman][fia])
                    {
                        current[cur_woman]=cur_man;
                        next[cur_man]++;
                        proposed=true;
                        freemen.addFirst(fia);
                    }
                    else
                    {
                        next[cur_man]++;
                    }
                }
            }
        }
    }
    public void print_solution()
    {
        System.out.println("M   W");
        for(int i=1;i<=n;i++)
        {
            System.out.println(current[i]+"    "+i);
        }
            
    }
    public void print_pairs()
    {
        System.out.println("M      W");
    
        for(int i=1;i<=n;i++)
        {
            System.out.println(current[i]+"    "+i);
    }
    }
    
    
}
