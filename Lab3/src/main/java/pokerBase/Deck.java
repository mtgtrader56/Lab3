package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.DeckException;

public class Deck {

	public static ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if (eSuit != pokerEnums.eSuit.JOKER && eRank != pokerEnums.eRank.JOKER) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}
			 
		}
		Collections.shuffle(deckCards);
	}
	
	public Deck(int NbrOfJokers) {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if (eSuit != pokerEnums.eSuit.JOKER && eRank != pokerEnums.eRank.JOKER) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}
			 
		}
		for (int i=0; i<NbrOfJokers;i++){
			deckCards.add(new Card(eSuit.JOKER,eRank.JOKER,99));
		}
		Collections.shuffle(deckCards);
	}
	
	
	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {

		this(NbrOfJokers);
		for (Card c: Wilds){
			for (Card d: deckCards){
				if(c.geteSuit()==d.geteSuit()&&(c.geteRank()==d.geteRank())){
					c.seteSuit(eSuit.JOKER);
					c.seteRank(eRank.JOKER);
				}
			}
		}
	 
		
	}
	
	public static Card Draw(){
		if (deckCards.size()==0){
			try {
				throw new DeckException(deckCards,"Out of Cards");
			} catch (DeckException e) {
				e.printStackTrace();
			}
		}
		
		return deckCards.remove(0);}

	public Deck getDeck() {
		return this;
	
	}
	public static ArrayList<Card> getdeckCards() {
		return deckCards;
	}
}