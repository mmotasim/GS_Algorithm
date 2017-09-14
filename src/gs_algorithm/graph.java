/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs_algorithm;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author User
 */
public class graph extends ApplicationFrame{
     public graph(final String title, double[][] results) {

        super(title);

        final XYDataset dataset = createDataset(results);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    
    public XYDataset createDataset(double[][] results) {
        
        final XYSeries steps = new XYSeries("Actual Steps");
        final XYSeries nsq= new XYSeries("N Square");
        for(int i=0;i<results.length;i++)
        {
            steps.add(results[i][0],results[i][2]);
            nsq.add(results[i][0],results[i][0]*results[i][0]);
        }
            

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(steps);
       //dataset.addSeries(nsq);      
        return dataset;
        
    }
    
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "GS-algorithm against varying n",      // chart title
            "N",                      // x axis label
            "steps",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );


        chart.setBackgroundPaint(Color.white);
        return chart;
        
    }
}
