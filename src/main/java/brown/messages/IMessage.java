package brown.messages;

import brown.agent.AbsAgent;

/**
 * a message is used to communicate between the agent and the server
 * @author lcamery
 */
public interface IMessage {
	
	/**
	 * Get message ID
	 * @return ID
	 */
	public Integer getID();
	
	/**
	 * Figures out what type of message this is, and acts accordingly
	 * @param agent
	 */
	public void dispatch(AbsAgent agent);
	
}
