package brown.rules.library; 

import brown.market.marketstate.IMarketState;
import brown.rules.IInnerTC;

public class OneShotTermination implements IInnerTC {

  // If there are bids then a round has happened
  @Override
  public void innerTerminated(IMarketState state) {
    boolean over = state.getBids().size() > 0; 
    state.setInnerOver(over);
  }

  @Override
  public void reset() {
  }  
}