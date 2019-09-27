package player;

import java.io.Serializable;

public class Invincibility implements InvincibilityRole, Serializable {

	private boolean state;
	private String playerStatus;

	public Invincibility(boolean state, String playerStatus) {
		super();
		this.state = state;
		this.playerStatus = playerStatus;
	}

	@Override
	public void set(boolean otherInvincibility) {
		state = otherInvincibility;
	}

	@Override
	public boolean isNotActive() {
		return !state;
	}

	@Override
	public void setPlayerStatus(String otherInvincibilityStatus) {
		playerStatus = otherInvincibilityStatus;
	}

	@Override
	public String getStatus() {
		return playerStatus;
	}

}
