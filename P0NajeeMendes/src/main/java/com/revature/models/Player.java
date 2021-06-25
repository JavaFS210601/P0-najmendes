package com.revature.models;

public class Player {
	
	private int player_id;
	private String first_name;
	private String last_name;
	private String user_name;
	
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Player(int player_id, String first_name, String last_name, String user_name) {
		super();
		this.player_id = player_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
	}//all-args


	public Player(int player_id, String user_name) {
		super();
		this.player_id = player_id;
		this.user_name = user_name;
	}//all args - id

	
	
//toString() for player id and user name only
	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", user_name=" + user_name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + player_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		Player other = (Player) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (player_id != other.player_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

//getters and setters
	public int getPlayer_id() {
		return player_id;
	}


	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
}//class
