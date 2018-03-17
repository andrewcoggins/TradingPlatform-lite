package brown.agent.library; // TODO: change this to your package

import brown.agent.AbsPredictionMarketAgent;
import brown.channels.library.CallMarketChannel;
import brown.exceptions.AgentCreationException;

public class PredictionMarketAgent extends AbsPredictionMarketAgent{
  
  public PredictionMarketAgent(String host, int port, String name) throws AgentCreationException {
    super(host, port, name);
  }

  @Override
  public void onMarketStart() {
    // TODO anything you want to compute before trading begins
  }

  @Override
  public void onMarketRequest(CallMarketChannel channel) {
    // TODO decide if you want to bid/offer or not
  }

  @Override
  public void onTransaction(int quantity, double price) {
    // TODO anything your bot should do after a trade it's involved
    // in is completed
  }
  
  @Override
  public double getHighestBuy() {
    // TODO upper bound you would buy at
    return 0;
  }

  @Override
  public double getLowestSell() {
    // TODO lower bound they 
    return 0;
  }
  
  public static void main(String[] args) throws AgentCreationException {
    new PredictionMarketAgent("localhost", 2121, "bot name goes here"); // TODO: name your bot
    while(true){}      
  }
}
