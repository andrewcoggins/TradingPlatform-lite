package brown.agent.library;

import java.util.HashMap;
import java.util.Map;

import brown.agent.AbsSimpleSealedAgent;
import brown.bid.interim.BidType;
import brown.bidbundle.library.AuctionBidBundle;
import brown.channels.library.AuctionChannel;
import brown.exceptions.AgentCreationException;
import brown.logging.Logging;
import brown.messages.library.BankUpdateMessage;
import brown.messages.library.GameReportMessage;
import brown.setup.library.SSSPSetup;
import brown.tradeable.ITradeable;

public class SimpleSealedAgent extends AbsSimpleSealedAgent {
  
  public SimpleSealedAgent(String host, int port)
      throws AgentCreationException {
    super(host, port, new SSSPSetup());
  }
  
  @Override
  public void onSSSP(AuctionChannel simpleChannel) {
    Map<ITradeable, BidType> initial = new HashMap<ITradeable, BidType>();
    for (ITradeable t: this.tradeables) {
      initial.put(t, new BidType(this.valuation.getValuation(t).doubleValue(), 1));
    }
    // just bid valuation 
    simpleChannel.bid(this, new AuctionBidBundle(initial));
  }  

  @Override
  public void onBankUpdate(BankUpdateMessage bankUpdate) {
    Logging.log("BANKUPDATE: Agent: " + this.ID + ", " + bankUpdate.toString());
  }

  @Override
  public void onGameReport(GameReportMessage gameReport) {
    Logging.log("Game report received");
  } 
  
  public static void main(String[] args) throws AgentCreationException {
    new SimpleSealedAgent("localhost", 2121);
    new SimpleSealedAgent("localhost", 2121);
    new SimpleSealedAgent("localhost", 2121);
    new SimpleSealedAgent("localhost", 2121);
    new SimpleSealedAgent("localhost", 2121);
    new SimpleSealedAgent("localhost", 2121);
    new SimpleSealedAgent("localhost", 2121);    
    new SimpleSealedAgent("localhost", 2121);
//    new SimpleSealedAgent("localhost", 2121);    
    while(true){}
  }  
}