
import java.util.ArrayList;

public class MainClass {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		
		final boolean adminMode;
		final int initCards = 2; // cards per person on new hand
		final int BlackJack = 21;
		
		ArrayList<Hand> hands = new ArrayList<Hand>();
		
		Deck theDeck = null;
		String playerName = null;
		float playerBet = 0;
		Action currentAction = Action.NOTHING;
		
		IO.printWelcome();
		IO.hitEnter();		

		// GET PLAYER NAME
		playerName = IO.capitalCase(IO.getName());
		

		// GAME LOOP START
		while(true){
			
			
			// LOAD RANDOM DECK
			if(theDeck == null){
				theDeck = new Deck();
				theDeck.shuffle();
			}
			// CREATE HANDS
			Hand playerHand = new Hand(playerName);
			Hand dealerHand = new Hand(""); // if no name, DEALER (see code)
			hands.add(playerHand); // add hand to list of hands (for splitting)

			// GET/SET BET for first game
			playerBet = IO.getBet((int) playerHand.getPlayer().getWallet());
			if(playerHand.getPlayer().removeFunds(playerBet)){ // remove from player
				playerHand.setBet(playerBet); // add to hand
			}else{
				IO.warn("Something went wrong with your bet!");
				System.exit(0);
			}
			
			// DEAL FIRST 4 CARDS - PLAYER-DEALER-PLAYER-DEALER-etc
			for(int i = 0; i < initCards; i++){
				playerHand.dealCard(theDeck);
				dealerHand.dealCard(theDeck);
			}
			
			// PLAYER LOOP START
			do{
				IO.warn("==================================================");
				IO.warn("Now playing hand: " + playerHand.getPlayer().getName());
				IO.warn("--------------------------------------------------");
				
				// PRINT HANDS
				IO.printHand(playerHand);
				IO.printHandHidden(dealerHand);
				
				// ASK FOR ACTION (HIT - DOUBLE - STAND - etc)
				currentAction = IO.getAction(playerHand.availableActions());
				
				// PROCESS ACTIONS
				if(currentAction == Action.HIT){
					if(playerHand.performHit())
						playerHand.dealCard(theDeck);
				}
				if(currentAction == Action.STAND){
					// TODO stand
					// do nothing?
				}
				if(currentAction == Action.DOUBLE){
					float doubleAmt = 0;
					IO.warn("How much would you like to double down?");
					doubleAmt = IO.getBet((int) playerHand.getPlayer().getWallet());
					
					if(playerHand.performDouble(doubleAmt)){
						playerBet += doubleAmt; // add to bet tracking
						playerHand.dealCard(theDeck); // hit
					}
					
					currentAction = Action.STAND; // stand
				}
				if(currentAction == Action.SURRENDER){
					// TODO surrender
				}
				if(currentAction == Action.SPLIT){
					// FIXME split
					
					// verify funds
					if( playerHand.getBet() < playerHand.getPlayer().getWallet() ){
						// TODO split
					}
						
					IO.warn("Insufficient funds to split.");
					currentAction = Action.STAND; // stand
				}
				if(currentAction == Action.INSURANCE){
					// TODO insurance
				}
				if(currentAction == Action.NOTHING){
					break;
				}
			
			}
			while( playerHand.getScore() < 21 &&currentAction != Action.STAND );
			// PLAYER LOOP END
			
			// PRINT FINAL PLAYER HAND
			IO.warn("--------------------------------------------------");
			IO.warn(playerHand.getPlayer().getName()+"'s Final Hand");
			IO.printHand(playerHand);
			IO.hitEnter();
			
			// DEALER START
			IO.warn("==================================================");
			IO.warn("Now playing Dealer's hand");
			IO.warn("--------------------------------------------------");
			
			IO.printHand(dealerHand);
			
			while ( dealerHand.getScore() < 17 ){ // if less than 17, hit
				dealerHand.dealCard(theDeck);
				IO.printHand(dealerHand);
			}
			
			IO.warn("--------------------------------------------------");
			IO.warn("Dealer's Final Hand");
			IO.printHand(dealerHand);
			IO.hitEnter();
			
			// PROCESS SCORES
			boolean draw = false;
			boolean dealerBJ = false;
			boolean playerBJ = false;
			boolean dealerBust = false;
			boolean playerBust = false;
						
			if(dealerHand.getCards().size() <=2 && dealerHand.getScore() == 21)
				dealerBJ = true;
			
			if(playerHand.getCards().size() <=2 && playerHand.getScore() == 21)
				playerBJ = true;
			
			if(dealerHand.getScore() > 21)
				dealerBust = true;
			
			if(playerHand.getScore() > 21)
				playerBust = true;			
				
			// double blackjack
			if(dealerBJ == true && playerBJ == true)
				draw = true;
			
			// same score
			if (dealerHand.getScore() == playerHand.getScore())
				draw = true;

			// START SCORES OUTPUT	
			IO.warn("Results:");
			IO.warn(playerHand.getPlayer().getName() + " () : ");	
			
			if(draw == true && !playerBust && !dealerBust){
				IO.warn("draw");
				playerHand.getPlayer().addFunds(playerBet); // put funds back into wallet
			}else{
				
				// BLACKJACK!
				if(playerBJ == true){
					playerBet = (float) (playerBet * 2.5);
					playerHand.getPlayer().addFunds(playerBet);
					IO.warn("win $"+playerBet);
					
				// Player Wins!
				}else if (playerHand.getScore() > dealerHand.getScore() && !playerBust ){
					playerBet = (float) (playerBet * 2);
					playerHand.getPlayer().addFunds(playerBet);
					IO.warn("win $"+playerBet);
					
				// Dealer Wins!
				}else{
					IO.warn("lose $"+playerBet);
				}
				
			}
			
			IO.hitEnter();
			
			if(currentAction == Action.NOTHING){
				break;
			}
			
		}// while(true) GAME LOOP END
		
		IO.warn("You ran out of money! Thank you for playing. Come back next time.");
		
		System.exit(0);
	}
}
