package brown.auction.marketstate.library;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import brown.auction.marketstate.IMarketState;
import brown.communication.messages.IInformationMessage;
import brown.communication.messages.ITradeMessage;
import brown.communication.messages.library.TradeRequestMessage;
import brown.platform.accounting.library.AccountUpdate;
import brown.platform.tradeable.ITradeable;

/**
 * Standard MarketState stores the internal information of a market.
 * 
 * @author acoggins
 */
public class MarketState implements IMarketState {
 
  private boolean isOpen; 
  private int ticks;  
  private long time;
  
  // Allocation rule
  private Map<Integer, List<ITradeable>> allocation;
  
  // Payment rule
  private List<AccountUpdate> payments;
  
  // Query rule
  private TradeRequestMessage tRequest;
  
  // TODO: move to IMarket!
  private Map<ITradeable, Double> increment;
  private double flatIncrement;
  
  // Activity rule
  private Boolean isAcceptable; 
  private Map<ITradeable, Double> reserve;
  // for Revealed Preference rule
  private Map<ITradeable, List<Integer>> altAlloc;
  
  // IR policy
  private Map<Integer, List<IInformationMessage>> gameReports;
  
  // Termination condition
  private Boolean terminated; 
  
  public MarketState() {
    this.increment = new HashMap<ITradeable, Double>();
    this.ticks = 0; 
    this.terminated = false;
    this.allocation = new HashMap<Integer, List<ITradeable>>();
    this.altAlloc = new HashMap<ITradeable, List<Integer>>();
    this.payments = new LinkedList<AccountUpdate>();
    this.time = System.currentTimeMillis();
    this.isOpen = true; 
    this.reserve = new HashMap<ITradeable, Double>();
//    for (ITradeable t : this.TRADEABLES) {
//      this.reserve.put(t,0.);
//      this.altAlloc.put(t,  new LinkedList<Integer>());
//    }
  }

  
  @Override
  public void tick() {
    this.ticks++;
  }

  @Override
  public int getTicks() {
    return this.ticks; 
  }
  
  @Override
  public long getTime() {
    return this.time;
  }
  
  @Override
  public void close() { 
    this.isOpen = false; 
  }
  
  @Override
  public boolean isOpen() {
    return this.isOpen; 
  }

  // TODO: clearAllocation()
  // Maybe rename this method clearPayments:
  @Override
  public void clearOrders() {
    this.setPayments(new LinkedList<AccountUpdate>());
  }

  @Override
  public TradeRequestMessage getTRequest() {
    return this.tRequest;
  }

  @Override
  public void setTRequest(TradeRequestMessage t) {
    this.tRequest = t;
  }
  
  @Override
  public Map<ITradeable, Double> getIncrement() {
    return this.increment;
  }

  // TODO: move increment to Market -- for OpenOutcry markets only
  // it is not part of the state (since it is constant)
  @Override
  public void setIncrement(Map<ITradeable, Double> increment) {
//   for (ITradeable t : this.TRADEABLES) {
//     if (!increment.containsKey(t)) {
//       increment.put(t, 0.0); 
//     }
//   }
   this.increment = increment;
  }
  
  public Double getFlatIncrement() {
    return this.flatIncrement;
  }
  
  public void setFlatIncrement(Double increment) {
    this.flatIncrement = increment;
  }

  @Override
  public boolean getAcceptable() {
    return isAcceptable; 
  }

  @Override
  public void setAcceptable(boolean acceptable) {
    this.isAcceptable = acceptable; 
  }

  @Override
  public Map<ITradeable,Double> getReserve() {
    return this.reserve;
  }

  @Override
  public void setReserve(Map<ITradeable,Double> reserve) {
     this.reserve = reserve;
  }
  
  @Override 
  public Map<ITradeable, List<Integer>> getAltAlloc() { 
    return this.altAlloc;
  }
  
  @Override
  public void setAltAlloc(Map<ITradeable, List<Integer>> altAlloc) {
    this.altAlloc = altAlloc;
  }

  @Override
  public boolean getOver() {
    return this.terminated; 
  }

  @Override
  public void setOver(boolean over) {
    this.terminated = over; 
  }
  
  @Override
  public Map<Integer, List<IInformationMessage>>  getReport() {
    return this.gameReports; 
  }

  @Override
  public void setReport(Map<Integer, List<IInformationMessage>> gameReport) {
    this.gameReports = gameReport;
  }

  @Override
  public Map<Integer, List<ITradeable>> getAllocation() {
    return this.allocation;
  }

  @Override
  public List<AccountUpdate> getPayments() {
    return this.payments;
  }

  @Override
  public void setAllocation(Map<Integer, List<ITradeable>> allocation) {
    this.allocation = allocation;
  }

  @Override
  public void setPayments(List<AccountUpdate> payments) {
    this.payments = payments;
  }

}
