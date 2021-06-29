package com.revature.models;

public class Account {
	
	private int savings;
	private int stocks;
	private int cryptos;
	private int bonds;
	private int total_balance;
	private String player_id_fk;
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Account(int savings, int stocks, int cryptos, int bonds, String player_id_fk) {//used for new account
		super();
		this.savings = savings;
		this.stocks = stocks;
		this.cryptos = cryptos;
		this.bonds = bonds;
		this.player_id_fk = player_id_fk;
	}

	public Account(int total_balance, String player_id_fk) {//used for leaderboard
		//super();
		this.total_balance = total_balance;
		this.player_id_fk = player_id_fk;
	}

	public Account(int savings, int stocks, int cryptos, int bonds, int total_balance, String player_id_fk) {//used for checkBalances
		super();
		this.savings = savings;
		this.stocks = stocks;
		this.cryptos = cryptos;
		this.bonds = bonds;
		this.total_balance = total_balance;
		this.player_id_fk = player_id_fk;
	}


	
	@Override
	public String toString() {
		return player_id_fk + "---> STATS: total balance = $" + total_balance + ", "
				+ "stocks = $" + stocks + ", cryptos = $" + cryptos + ", bonds = $" + bonds + ", savings = $" + savings;
	}

	public int getSavings() {
		return savings;
	}


	public void setSavings(int savings) {
		this.savings = savings;
	}


	public int getStocks() {
		return stocks;
	}


	public void setStocks(int stocks) {
		this.stocks = stocks;
	}


	public int getCryptos() {
		return cryptos;
	}


	public void setCryptos(int cryptos) {
		this.cryptos = cryptos;
	}


	public int getBonds() {
		return bonds;
	}


	public void setBonds(int bonds) {
		this.bonds = bonds;
	}


	public int getTotal_balance() {
		return total_balance;
	}


	public void setTotal_balance(int total_balance) {
		this.total_balance = total_balance;
	}


	public String getPlayer_id_fk() {
		return player_id_fk;
	}


	public void setPlayer_id_fk(String player_id_fk) {
		this.player_id_fk = player_id_fk;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bonds;
		result = prime * result + cryptos;
		result = prime * result + ((player_id_fk == null) ? 0 : player_id_fk.hashCode());
		result = prime * result + savings;
		result = prime * result + stocks;
		result = prime * result + total_balance;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (bonds != other.bonds)
			return false;
		if (cryptos != other.cryptos)
			return false;
		if (player_id_fk == null) {
			if (other.player_id_fk != null)
				return false;
		} else if (!player_id_fk.equals(other.player_id_fk))
			return false;
		if (savings != other.savings)
			return false;
		if (stocks != other.stocks)
			return false;
		if (total_balance != other.total_balance)
			return false;
		return true;
	}
	
	


}//class end
