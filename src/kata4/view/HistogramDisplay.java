/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Usuario
 */
public class HistogramDisplay extends ApplicationFrame{
    private final Histogram <String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    

    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", 
                "Dominios email",
                "Nº de emails", dataSet, PlotOrientation.VERTICAL, false, false,
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : histogram.keySet()){
            dataset.addValue(histogram.get(key), "", key);
        }
        return dataset;
    }
    
    public void execute() {
        setVisible(true);
    }
    
    
        
    
    
    
}
