
/**
 * Write a description of interface Filter here.
 * 
 * @author (Shubhankar Vishwanath) 
 * @version (a version number or a date)
 */
public interface Filter
{
    public  boolean satisfies(QuakeEntry qe); 
    public String getName();
}
