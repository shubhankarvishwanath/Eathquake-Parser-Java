public class DistanceFilter implements Filter 
{
    private Location loc;
    private double disMax;
    
    public DistanceFilter(double lat, double lon, double max){
        loc = new Location(lat,lon);
        disMax = max;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(loc) <= disMax;
    }
    
    public String getName(){
        return "DistanceFilter";
    }
}