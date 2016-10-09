package pokerEnums;

public enum eHandExceptionType {

	TieHand {
		@Override
		public String toString() {
			return ("Tie Hand.");
		}
	},
	ShortHand {
		public String toString() {
			return ("Not enough cards in hand.");
		}
	}
}