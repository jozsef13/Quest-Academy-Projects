package player;

public interface InvincibilityRole {

	void set(boolean otherInvincibility);

	boolean isNotActive();

	void setPlayerStatus(String otherInvincibilityStatus);

	String getStatus();

}
