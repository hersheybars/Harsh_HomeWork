
import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private final int defaultHandSize = 2;
	private final int BlackJack = 21;
	private int score;
	private float bet;
	private Player player;
	private boolean isSurrender = false;

	public Hand(String name) {
		this.setPlayer(new Player(name));
	}
	
	public String getScoreString() {		
		ArrayList<Integer> score = new ArrayList<Integer>();
		int total = 0;
		int aceCount = 0;
		
		// go through all cards and add values
		for ( Card card : cards ) {			
			switch(card.getRank()) {
				case ACE: 
					score.add(11);
					aceCount++;
					break;
				case TWO: 
					score.add(2); break;
				case THREE: 
					score.add(3); break;
				case FOUR: 
					score.add(4); break;
				case FIVE: 
					score.add(5); break;
				case SIX:
					score.add(6); break;
				case SEVEN:
					score.add(7); break;
				case EIGHT:
					score.add(8); break;
				case NINE:
					score.add(9); break;
				case TEN: 
				case JACK: 
				case QUEEN: 
				case KING:
					score.add(10); break;
				default:
					score.add(0); break;
			}
		}
		
		// add (sum) the values from the score array into var total
		for(int i = 0; i < score.size(); i++)
			total += score.get(i);
		
		// ace calculations - remove 10 points every time there is an ace and total is a bust
		while ( total > this.BlackJack && aceCount > 0)
			total -= 10;
		
		// set score for later use
		this.setScore(total);
		
		// return ( blackjack | surrender | bust | size )
		if( total == this.BlackJack && this.cards.size() == this.defaultHandSize)
			return "Black Jack!";
		
		else if (isSurrender)
			return "Surrendered!";
		
		else if (total > this.BlackJack)
			return "Bust! ("+total+")";
		
		else
			return ""+total;
	}
	
	private boolean canDo(Action a){		
		List<Action> actions = availableActions();
		if(actions.contains(a)) 
			return true;
		
		return false;
	}
	
	public List<Action> availableActions(){
		List<Action> available = new ArrayList<Action>();
		
		available.add(Action.HIT);
		available.add(Action.STAND);
		
		// if 2 cards (first hand, or after split)
		if (this.cards.size() == this.defaultHandSize){
			available.add(Action.DOUBLE);
			available.add(Action.SURRENDER);
			
			// if the 2 cards are the same
			if(this.cards.get(0).getRank().equals(this.cards.get(1).getRank())){
				available.add(Action.SPLIT);				
			}			
		}
		return available;
	}
	
	public boolean performHit(){		
		if(canDo(Action.HIT)){
			return true;
		}		
		return false;
	}
	
	public boolean performStand(){
		if(canDo(Action.STAND)){
			return true;
		}		
		return false;
	}
	
	public boolean performDouble(float amt){
		if(canDo(Action.DOUBLE)){
			 // remove funds from dude
			if(player.removeFunds(amt)){
				setBet( getBet()+amt ); // add funds to current bet
				return true;
			}
			return false;
		}		
		return false;
	}
	
	public boolean performSurrender(){
		if(canDo(Action.SURRENDER)){
			return true;
		}		
		return false;
	}
	
	public boolean performSplit(){
		if(canDo(Action.SPLIT)){
			return true;
		}		
		return false;
	}


	public String getDescription() {
		return "";
	}
	
	public boolean dealCard(Deck deck){
		Card card = deck.draw();
		if(card != null){
			this.cards.add(card);
			return true;
		}
		return false;		
	}	

	public ArrayList<Card> getCards() {
		return this.cards;
	}

	public float getBet() {
		return bet;
	}

	public void setBet(float bet) {
		this.bet = bet;
	}

	public Player getPlayer() {
		return player;
	}

	private void setPlayer(Player player) {
		this.player = player;
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}
}
