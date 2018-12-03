package brown.mechanism.bid.library;

import brown.mechanism.bid.IGameAction;

/**
 * A bid that is used in games like the lemonade game.
 * @author acoggins
 *
 */
public class ContinuousGameBid implements IGameAction {
  
	// integer or double? 
	public final Double action; 
	
	public ContinuousGameBid(Double action) {
		this.action = action; 
	}

	
	@Override
	public String toString() {
		return "ContinuousGameBid [action=" + action + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContinuousGameBid other = (ContinuousGameBid) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		return true;
	}

	
}