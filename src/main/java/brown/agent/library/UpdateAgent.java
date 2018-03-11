package brown.agent.library;

import brown.agent.AbsLab06Agent;
import brown.channels.library.CallMarketChannel;
import brown.exceptions.AgentCreationException;


// Calculates fair value and then updates in direction of trades it does
public class UpdateAgent extends AbsLab06Agent {

  private double fair_value = 0;
  private double update_epsilon = 5;
  private double spread_epsilon = 5;
  boolean updated = false;
  
  public UpdateAgent(String host, int port, String name)
      throws AgentCreationException {
    super(host, port, name);
    // TODO Auto-generated constructor stub
  }
  
  public UpdateAgent(String host, int port, String name, double update, double spread)
      throws AgentCreationException {
    super(host, port, name);
    update_epsilon = update;
    spread_epsilon = spread;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void onMarketStart() {

    // TODO Auto-generated method stub
    
    int decoys = this.getNumDecoys(); 
   
    if(this.getCoin()){
      fair_value = (double)(2+decoys)/(double)(2*decoys + 2) * 100;
    }
    else{   
      fair_value = (double)(decoys)/(double)(2*decoys + 2) * 100;
    }
    
  }

  @Override
  public void onMarketRequest(CallMarketChannel channel) {

    // TODO Auto-generated method stub
    
    if(updated) {
    this.cancel(0, true, channel);
    this.cancel(100, false, channel);
    updated = false;
    }
    
    System.out.println(fair_value);
    
    this.buy(Math.floor(fair_value-spread_epsilon), 1, channel);

    this.sell(Math.ceil(fair_value+spread_epsilon), 1, channel);
  }

  @Override
  public void onTransaction(int quantity, double price) {

    // TODO Auto-generated method stub
    if(price>0) {
      fair_value+=update_epsilon;
      fair_value = Math.min(fair_value, 94);
    }
    else{
      fair_value-=update_epsilon;
      fair_value = Math.max(fair_value, 06);

    }
    updated = true;
  }

}
