
/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author (Shubhankar Vishwanath) 
 * @version (10/MARCH/2022)
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);

}