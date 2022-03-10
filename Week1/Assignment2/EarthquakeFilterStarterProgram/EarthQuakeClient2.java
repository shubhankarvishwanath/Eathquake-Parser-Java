import java.util.*;
//import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        int count = 0;

        //Filter f = new MinMagFilter(4.0); 
        //ArrayList<QuakeEntry> m7  = filter(list, f); 
        //for (QuakeEntry qe: m7) { 
        //    System.out.println(qe);
        
        Filter f1 = new MagnitudeFilter(4.0,5.0); 
        Filter f2 = new DepthFilter(-35000.0,-12000.0);
        ArrayList<QuakeEntry> appliedF1  = filter(list, f1);
        ArrayList<QuakeEntry> appliedF2  = filter(appliedF1, f2);
        for (QuakeEntry qe: appliedF2) { 
            System.out.println(qe);
            count++;
        } 
        System.out.println(count + " quakes in total");
    
        
        /*Filter f3 = new DistanceFilter(35.42,139.43,10000000);
        Filter f4 = new PhraseFilter("Japan", "end");
        ArrayList<QuakeEntry> appliedF3 = filter(list, f3);
        ArrayList<QuakeEntry> appliedF4 = filter(appliedF3, f4);
        
        for (QuakeEntry qe: appliedF4) { 
            System.out.println(qe);
            count++;
        }
        System.out.println(count + " quakes in total");
        }*/
    }
    
    
    /*public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        
        System.out.println("read data for "+list.size()+" quakes");
        int count =0;
        //Commented out as required:
        //for(QuakeEntry qe : list){
        //    System.out.println(qe);
        //}
        MatchAllFilter maf = new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(0.0,2.0);
        maf.addFilter(f1);
        Filter f2 = new DepthFilter(-100000.0,-10000.0);
        maf.addFilter(f2);
        Filter f3 = new PhraseFilter("a","any");
        maf.addFilter(f3);
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        for(QuakeEntry qe : quakes){
            System.out.println(qe);
            count++;
        }
        System.out.println("Filters used are: " + maf.getName() + " and count = " + count);
    }*/
    
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);   
        int count =0;
        
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilter maf = new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(0.0,3.0);
        maf.addFilter(f1);
        Filter f2 = new DistanceFilter(36.1314, -95.9372,10000000);
        maf.addFilter(f2);
        Filter f3 = new PhraseFilter("Ca","any");
        maf.addFilter(f3);
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        for(QuakeEntry qe : quakes){
            System.out.println(qe);
            count++;
        }
        System.out.println("Total count = " +count);
    }
    

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
