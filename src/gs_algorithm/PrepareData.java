/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs_algorithm;

import java.util.LinkedList;
import java.util.Random;

public class PrepareData {
    public LinkedList<Integer> InitializeFreeMen(LinkedList<Integer> freemen,int n)
    {
        for(int i=1;i<=n;i++)
        {
            freemen.addFirst(i);
            
        }
        return freemen;
    }
    public int[][] generate_preferences(int[][] p,int n,boolean for_men)
            
    {
        
        for(int i=1;i<=n;i++)
        {
            
            int[] temp=new int[n+1];
            Random r = new Random();
            int done_count=0;
            while(done_count<n)
            {
               int num=r.nextInt(n)+1;
               if(temp[num]==0)
               {
                   done_count++;
                   temp[num]=1;
                   if(for_men)
                   {
                       p[i][done_count]=num;
                   }
                   else
                   {
                       p[i][num]=done_count;
                   }
                   
               }
               else
               {
                   continue;
               }
               
            }
           
        }
         return p;
    }
    public int[] initialize_arrray(int[] array, int value)
    {
        for(int i=1;i<array.length;i++)
        {
            array[i]=value;
        }
        return array;
        
        
    }
    
        
}
    
    
    
    
    
    
   
