package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.HandException;

public class Hand_Test {

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
	public void TestFiveOfAKind() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.ACE, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE, 1));

		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(h.getHs().getHandStrength()+"five of a kind test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.JOKER.getiRankNbr());

	}

	@Test
	public void Test1Joker() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(h.getHs().getHandStrength()+ "jokertest");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());

	}

	@Test
	public void TestStraightFlush() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
			
		try {
			Hand.EvaluateHand(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(h.getHs().getHandStrength()+ "straight flush test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());

	}

	@Test
	public void TestFourOfAKind() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE, 1));

		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(h.getHs().getHandStrength()+ "four of a kind test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());

	}

	@Test
	public void TestFullHouse() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength()+ "full house test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());

	}

	@Test
	public void TestFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength()+ "flush test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Flush.getHandStrength());

	}

	@Test
	public void TestStraight() throws Exception {
		Hand h = new Hand(); 
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK, 1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.QUEEN, 1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength() + "straight test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
	}

	@Test
	public void TestThreeOfAKind() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength()+ "three of a kind test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
	}

	@Test
	public void TestTwoPair() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength()+ "two pair test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
	}

	@Test
	public void TestPair() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER, 1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength()+ "pair test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
	}

	@Test
	public void HighCard() throws Exception {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING, 1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.FIVE, 1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO, 1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE, 1));

		try {
			h.EvaluateHand(h);
		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength()+ "high hand test");
		assertTrue(h.getHs().getHandStrength() == eHandStrength.HighCard.getHandStrength());
	}
}