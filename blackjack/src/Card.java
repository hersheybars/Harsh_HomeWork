
public class Card {

	public enum Rank {
	    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;	    
	}
	
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS;
	}

	private Rank rank;
	private Suit suit;
	
	public Card(Rank face, Suit suit) {
		super();
		this.rank = face;
		this.suit = suit;
	}
	
	public Rank getRank() { return rank; }
	public Suit getSuit() { return suit; }

	@Override
	public String toString() {
		return rank.toString() + suit.toString() ;
	}

	public boolean equals(Rank rank, Suit suit) {
		return this.rank == rank && this.suit == suit;
	}
	

}
