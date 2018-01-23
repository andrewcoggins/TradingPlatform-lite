package brown.market.preset.library;

import brown.market.preset.AbsMarketPreset;
import brown.rules.library.LemonadeAllocation;
import brown.rules.library.LemonadeAnonymous;
import brown.rules.library.LemonadePayment;
import brown.rules.library.LemonadeQuery;
import brown.rules.library.LemonadeActivity;
import brown.rules.library.OneShotTermination;
import brown.rules.library.XRoundTermination;

public class LemonadeRules extends AbsMarketPreset {
  
  /**
   * some of these are guesses.
   * need to pass in the market internal state, 
   * or otherwise delete it from this constructor.
   */
  public LemonadeRules(int numSlots) {
    super(new LemonadeAllocation(numSlots),
        new LemonadePayment(), 
        new LemonadeQuery(),
        new LemonadeActivity(numSlots),
        new LemonadeAnonymous(numSlots), 
        new OneShotTermination(),
        new XRoundTermination());
  }
  
}
