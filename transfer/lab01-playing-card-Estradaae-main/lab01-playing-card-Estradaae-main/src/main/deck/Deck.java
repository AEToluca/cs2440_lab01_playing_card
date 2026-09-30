package deck;
import java.util.Random;
import java.util.ArrayList;
public class Deck
{
    public static final int NUM_CARDS = 52;
    private Random generator = new Random();
    private ArrayList<PlayingCard> deck;
    
    public Deck()
    {
        generator = new Random();
        initialize();
    }
    public Deck(int seed)
    {
        generator = new Random(seed);
        initialize();
    }
    public void initialize() 
    {
        deck = new ArrayList<PlayingCard>();
        Rank[] ranks = Rank.values(); 
        Suit[] suits = Suit.values(); 
        for (int i = 0; i < ranks.length; i++)
         {
            for (int j = 0; j < suits.length; j++) 
            {
                PlayingCard card = new PlayingCard(ranks[i], suits[j]);
                deck.add(card);
            }
        }
    }
        public void shuffleDeck() 
    {
        int deckSize = deck.size();
        for (int i = deckSize - 1; i >= 1; i--)
        {
            int randomIndex = generator.nextInt(i + 1);
            PlayingCard temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }
    }
    public PlayingCard getCard(int index) {
        if (index >= 0 && index < deck.size())
        {
            return deck.get(index);
        } 
        else
        {
            return null; 
        }
    }
        public String toString()
         {
            String result = "";
        
            for (int i = 0; i < deck.size(); i++) 
            {
                result += deck.get(i).toString();
        
                if (i < deck.size() - 1)
                 {
                    result += "\n";
                }
            }
        
            return result;
    }
    public static void main(String[] args)
    {
        System.out.print("Hello World~!");
    }
}

