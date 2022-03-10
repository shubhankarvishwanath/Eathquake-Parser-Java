
/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author Shubhankar Vishwanath

 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public String getRandomText(int numChars);

    public void setRandom(int seed);
}