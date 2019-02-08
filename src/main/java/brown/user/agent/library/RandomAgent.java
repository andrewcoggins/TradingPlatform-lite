package brown.user.agent.library;

import brown.communication.channel.library.TwoSidedChannel;
import brown.logging.library.Logging;

// This agent buys or sells randomly with uniform distribution
public class RandomAgent extends AbsPredictionMarketAgent {

	public RandomAgent(String host, int port)  {
		super(host, port);
	}

	public RandomAgent(String host, int port, String name)  {
		super(host, port, name);
	}

	@Override
	public void onMarketRequest(TwoSidedChannel channel) {
		if (Math.random() < .5) {
			this.buy(Math.random() * 98 + 1, 1, channel);
		} else {
			this.sell(Math.random() * 98 + 1, 1, channel);
		}
	}

	@Override
	public void onTransaction(int quantity, double price) {
	  Logging.log("Price: " + price);
	}

	@Override
	public void onMarketStart() {}
	
	@Override
	public double getHighestBuy() {
		return 1;
	}

	@Override
	public double getLowestSell() {
		return 99;
	}

	public static void main(String[] args)  {

		new UpdateAgent("localhost", 2121, "Random1");
		new UpdateAgent("localhost", 2121, "Random2");
		new UpdateAgent("localhost", 2121, "Random3");
		new UpdateAgent("localhost", 2121, "Random4");

		while (true) {
		}
	}
}
