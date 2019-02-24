package brown.platform.market;

import java.util.List;
import java.util.Map;

import brown.platform.tradeable.ITradeable;

public interface IMarketBlock {

  public List<IMarketRules> getMarkets(); 
  
  public List<Map<String, List<ITradeable>>> getMarketTradeables(); 
  
}
