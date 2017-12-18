package brown.setup.library;

import com.esotericsoftware.kryo.Kryo;

import brown.channels.agent.library.LemonadeChannel;
import brown.messages.library.GameReport;
import brown.messages.library.LemonadeReport;
import brown.setup.ISetup;
import brown.setup.Startup;

/**
 * additional setup for the lemonade game.
 * @author andrew
 *
 */
public class SimpleSetup implements ISetup {

  @Override
  public void setup(Kryo kryo) {
    // TODO Auto-generated method stub
    Startup.start(kryo);
    kryo.register(GameReport.class);
    kryo.register(LemonadeChannel.class);
    kryo.register(LemonadeReport.class);
  } 
  
}