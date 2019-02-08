package brown.system.setup.library;

import com.esotericsoftware.kryo.Kryo;

import brown.communication.bid.library.GameBid;
import brown.communication.channel.library.GameChannel;
import brown.communication.messages.library.LemonadeReportMessage;
import brown.system.setup.ISetup;

/**
 * Additional setup for the Lemonade game.
 * @author andrew
 */
public class LemonadeSetup implements ISetup {

  @Override
  public void setup(Kryo kryo) {
    Startup.start(kryo);
    kryo.register(GameBid.class);    
    kryo.register(GameChannel.class);
    kryo.register(LemonadeReportMessage.class);
    kryo.register(java.util.List[].class);    
  } 
  
}