public class PhraseFilter implements Filter 
{
    private String phrase;
    private String where;
    
    public PhraseFilter(String sentence, String place){
        phrase = sentence;
        where = place;
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(where.equals("start")){
            if (qe.getInfo().startsWith(phrase)){
                    return true;
            }
        }
        if(where.equals("end")){
            if (qe.getInfo().endsWith(phrase)){
                    return true;
            }
        }
        if(where.equals("any")){
            if (qe.getInfo().contains(phrase)){
                    return true;
            }
        }
        return false;
    }
    
    public String getName(){
        return "PhraseFilter";
    }
}