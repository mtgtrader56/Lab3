package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;
import pokerExceptions.DeckException;

import java.util.Collections;

public class Deck_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before 
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void DeckBuildTest()
	{
		Deck newDeck = new Deck(4);
		Collections.sort(newDeck.deckCards);
		Card topcard = newDeck.deckCards.remove(0);
		assertTrue(topcard.geteRank() == eRank.JOKER);
		Card secondcard = newDeck.deckCards.remove(0);
		assertTrue(secondcard.geteRank() == eRank.JOKER);
		Card thirdcard = newDeck.deckCards.remove(0);
		assertTrue(thirdcard.geteRank() == eRank.JOKER);
		Card fourthcard = newDeck.deckCards.remove(0);
		assertTrue(fourthcard.geteRank() == eRank.JOKER);
		System.out.println("DeckBuild 4 jokers complete");
	}
	@Test
	public void DeckBuildTestOverDraw() throws DeckException {
		Deck NewDeck = new Deck();
		for (int count = 0; count < 53; count++) {
			NewDeck.Draw();
		}
	}
	
	


}
