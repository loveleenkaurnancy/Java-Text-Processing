
public class Quote
{
    private String quote;
    private int count;
    // 

    public Quote()
    {

    }

    public Quote(String q)
    {
        quote = q;
    }


    String getQuote()
    {
        return quote;
    }

    String getCredit(String author)
    {
        return author;
    }

    int getWordCount()
    {
        int count = quote.length();
        return count;
    }
    

    //...
}