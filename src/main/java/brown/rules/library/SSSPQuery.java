package brown.rules.library;

import brown.accounting.library.Ledger;
import brown.channels.agent.library.SSSPChannel;
import brown.market.marketstate.IMarketState;
import brown.messages.library.TradeRequestMessage;
import brown.rules.IQueryRule;

public class SSSPQuery implements IQueryRule {

	@Override
	public void makeChannel(IMarketState state, Ledger ledger) {	  
			state.setTRequest(new TradeRequestMessage(0, new SSSPChannel(state.getID())));
	}

  @Override
  public void reset() {    
  }	
}