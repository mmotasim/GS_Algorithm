/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs_algorithm;

/**
 *
 * @author User
 */
public class driver {
    
    public int test_cases=20;
    public double[][] results;
    public TheAlgorithm a;
    
    public driver()
    {
      
        results=new double[test_cases][3];
    }
    public void execute()
    {
        int n=500;
        for(int i=0;i<test_cases;i++)
        {
            a=new TheAlgorithm(n);
            double start=System.nanoTime();
            a.run_algo();
            double stop=System.nanoTime();
            results[i][0]=n;
            results[i][1]=stop-start;
            results[i][2]=a.steps;
            n+=50;
        }
            
    }
    public void print_results()
    {
        System.out.println("N     Time  steps");
        for(int i=0;i<test_cases;i++)
        {
            System.out.println(results[i][0]+"   "+results[i][1]+"   "+results[i][2]);
        }
    }
}
