/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * @modifier Jingwei Sun, 2019
 */
public class Card 
{ 
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    public enum Suits {
        SPADES, HEART, CLUBS, DIAMOND
    }
        
    
    public enum Ranks {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13);
        
        private int value;
        
        Ranks(int value) {
            this.value = value;
        }
        
    }
    
    private Suits s;
    private Ranks r;
    
    public Card(Suits s, Ranks r) {
        this.s = s;
        this.r = r;
    }
    
    public int getCard() {
        return r.ordinal();
    }
       
    @Override
    public String toString() {
    return r + " of " + s + "\n";
    }
    
    
}
