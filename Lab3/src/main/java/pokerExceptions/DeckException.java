package pokerExceptions;

import java.util.ArrayList;

import pokerBase.Card;
import pokerBase.Deck;

public class DeckException extends Exception {
	
	private ArrayList<Card> deckCards;
	public DeckException(ArrayList<Card> deckCards, String Message) {
			super(Message);
			this.deckCards=deckCards;
			}
}