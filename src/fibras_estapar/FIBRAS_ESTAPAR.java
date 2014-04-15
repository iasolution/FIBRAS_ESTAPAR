

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FIBRAS_ESTAPAR extends ApplicationFrame implements ActionListener {

//VARIAIVEIS
    public TimeSeries series;
    public TimeSeries series2;
    public TimeSeries series3;
    public TimeSeries series4;
    public TimeSeries series5;
    
    public double lastValue = 540.0;
    public double lastValue2 = 540.0;
    public double lastValue3 = 540.0;
    public double lastValue4 = 540.0;
    public double lastValue5 = 540.0;
    
    int status = 10;
    
    public FIBRAS_ESTAPAR(String title) {

    super(title);
    
    this.series = new TimeSeries("L1", Millisecond.class);
    TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        
    this.series2 = new TimeSeries("L2", Millisecond.class);
    TimeSeriesCollection dataset2 = new TimeSeriesCollection(this.series2);
       
    this.series3 = new TimeSeries("L3", Millisecond.class);
    TimeSeriesCollection dataset3 = new TimeSeriesCollection(this.series3);
         
    this.series4 = new TimeSeries("L4", Millisecond.class);
    TimeSeriesCollection dataset4 = new TimeSeriesCollection(this.series4);
       
    this.series5 = new TimeSeries("L5", Millisecond.class);
    TimeSeriesCollection dataset5 = new TimeSeriesCollection(this.series5);
         
         
         
    JFreeChart chart = createChart(dataset, dataset2,dataset3,dataset4,dataset5);
        
    ChartPanel chartPanel = new ChartPanel(chart);
       
    JButton button = new JButton("VERIFICAR LINKS");
    
    button.addActionListener(this);
    
    JPanel content = new JPanel(new BorderLayout());
    content.add(chartPanel);
    content.add(button, BorderLayout.PAGE_END);
    chartPanel.setPreferredSize(new java.awt.Dimension(480, 320));
    setContentPane(content);
        
    }

    public JFreeChart createChart(XYDataset dataset,XYDataset dataset2,XYDataset dataset3,XYDataset dataset4,XYDataset dataset5) {
    JFreeChart result = ChartFactory.createTimeSeriesChart(
            "FIBRA HSJ",
            "TEMPO",
            "VALOR",
            dataset,
            true,
            true, 
            true
        );
      
      result.setBackgroundPaint(Color.white);
      XYPlot plot = (XYPlot) result.getPlot();  
      plot.setDataset(1, dataset2);
      plot.setDataset(2, dataset3);
      plot.setDataset(3, dataset4);
      plot.setDataset(4, dataset5);
      
      XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();  
      renderer.setShapesVisible(true);  
        
      XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer(true, true);  
      plot.setRenderer(1, renderer2);   
      
      XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer(true, true);  
      plot.setRenderer(2, renderer3); 
      
      XYLineAndShapeRenderer renderer4 = new XYLineAndShapeRenderer(true, true);  
      plot.setRenderer(3, renderer4);  
      
      XYLineAndShapeRenderer renderer5 = new XYLineAndShapeRenderer(true, true);  
      plot.setRenderer(4, renderer5);  
        
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setVisible(rootPaneCheckingEnabled);
        axis.setFixedAutoRange(15000.0);  // 15 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 900.0); 
        return result;
   
       
    }
    
    
   
    public void actionPerformed( ActionEvent ev) {
                 
           while (status>0){
                                     
            try {
                atualizar();
                Thread.sleep( 500 );
                } catch (InterruptedException ex) {
               Logger.getLogger(FIBRAS_ESTAPAR.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                inserir();
                Thread.sleep( 50 );
                } catch (InterruptedException ex) {
                Logger.getLogger(FIBRAS_ESTAPAR.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
            status--;
              }
                
               // atualizar();
               // inserir();
    }
    
    
    
    public void atualizar(){
          double factor = 0.90 + 0.2 * Math.random();
            this.lastValue = this.lastValue * factor;
            Millisecond now = new Millisecond();
            System.out.println("L1");
            System.out.println("Now = " + now.toString());
            System.err.println("ultimo valor ="+lastValue );
            System.err.println("fator ="+factor);
            System.err.println("status ="+status);
            
            double factor2 = 0.90 + 0.2 * Math.random();
            this.lastValue2 = this.lastValue2 * factor2;
            System.out.println("L2");
            System.out.println("Now = " + now.toString());
            System.err.println("ultimo valor ="+lastValue2 );
            System.err.println("fator ="+factor2);
            System.err.println("status ="+status);
           
            double factor3 = 0.90 + 0.2 * Math.random();
            this.lastValue3 = this.lastValue3 * factor3;
            System.out.println("L3");
            System.out.println("Now = " + now.toString());
            System.err.println("ultimo valor ="+lastValue3 );
            System.err.println("fator ="+factor3);
            System.err.println("status ="+status);
          
            double factor4 = 0.90 + 0.2 * Math.random();
            this.lastValue4 = this.lastValue4 * factor4;
            System.out.println("L4");
            System.out.println("Now = " + now.toString());
            System.err.println("ultimo valor ="+lastValue4 );
            System.err.println("fator ="+factor4);
            System.err.println("status ="+status);
                  
            double factor5 = 0.90 + 0.2 * Math.random();
            this.lastValue5 = this.lastValue5 * factor5;
            System.out.println("L5");
            System.out.println("Now = " + now.toString());
            System.err.println("ultimo valor ="+lastValue5 );
            System.err.println("fator ="+factor5);
            System.err.println("status ="+status);
                       
    }
   
    public void inserir(){
            this.series.add(new Millisecond(), this.lastValue);
            this.series2.add(new Millisecond(), this.lastValue2);
            this.series3.add(new Millisecond(), this.lastValue3);
            this.series4.add(new Millisecond(), this.lastValue4);
            this.series5.add(new Millisecond(), this.lastValue5);
    }
    
    public static void main (String[] args) {

        FIBRAS_ESTAPAR demo = new FIBRAS_ESTAPAR("FIBRAS HSJ");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        
                
       }
   

}