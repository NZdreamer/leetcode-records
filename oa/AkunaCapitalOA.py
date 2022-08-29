import fileinput
from typing import List, Tuple
from datetime import datetime, timedelta

"""
trade_id, trade_date, time_of_trade, portfolio, exchange, product, product_type, expiry_dt, qty, strike_price, side
"""

class Trade:
    def __init__(self, raw_trade):
        self.raw_trade =raw_trade
    
    def process_raw(self):
        self.trade_id = self.raw_trade["trade_id"]
        trade_date_str = self.raw_trade["trade_date"]
        self.trade_date = datetime.strptime(self.raw_trade["trade_date"], "%Y-%m-%d")
        self.time_of_trade = datetime.strptime(self.raw_trade["time_of_trade"], "%H:%M:%S")
        self.date_time = datetime.strptime(self.raw_trade["trade_date"] + self.raw_trade["time_of_trade"], "%Y-%m-%d%H:%M:%S")
        self.portfolio = self.raw_trade["portfolio"]
        self.exchange = self.raw_trade["exchange"]
        self.product = self.raw_trade["product"]
        self.product_type = self.raw_trade["product_type"]
        self.expiry_dt = self.raw_trade["expiry_dt"]
        self.qty = self.raw_trade["qty"]
        self.strike_price = self.raw_trade["strike_price"]
        self.side = self.raw_trade["side"]
        if self.exchange == "CBOE":
            if self.qty[0] == '-':
                self.side = "BUY"
            else:
                self.side = "SELL"


class Solution:

    trades = []
    res = []
    def process_raw_trade(self, raw_trade: list):
        for rt in raw_trade:
            trade = Trade(rt)
            self.trades.append(trade)

    def run(self) -> List[Tuple[str, str]]:
        self.trades.sort(key=lambda x: x.date_time)
        for idx,trade in self.trades:
            if trade.portfolio == "Broker":
                self.check_trader(idx)
        return self.res

            
    def check_trader(self, idx):
        broker_trade = self.trades[idx]
        broker_time = broker_trade.date_time
        for i in range(idx - 1, -1, -1):
            cur_trade = self.trades[i]
            if cur_trade.portfolio != "Electronic":
                continue
            if cur_trade.date_time < broker_time - timedelta(minutes=1):
                continue
            if cur_trade.product != broker_trade.product:
                continue
            if cur_trade.product_type != broker_trade.product_type:
                continue
            if cur_trade.side != broker_trade.side:
                continue
            if cur_trade.expiry_dt != broker_trade.expiry_dt:
                continue
            if cur_trade.strike_price != broker_trade.strike_price:
                continue
            self.res.append(Tuple(broker_trade.trade_id, cur_trade.trade_id))



if __name__ == '__main__':
    solution = Solution()
    for row in fileinput.input():
        raw_trade = list(row.strip().replace(" ", "").split(","))
        solution.process_raw_trade(raw_trade)
    print(solution.run())