package StrategyPattern;

public abstract class Robot {
	private String name;
	private Moving moving;
	private Attacking attacking;

	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void move() {
		moving.move();
	}
	
	public void attack() {
		attacking.attack();
	}
	
	public void setMovingStrategy(Moving moving) {
		this.moving = moving;
	}
	
	public void setAttackingStrategy(Attacking attackcing) {
		this.attacking = attackcing;
	}
}
