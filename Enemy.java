public class Enemy extends Item {
	public Enemy() {
		super(0,500,50,50);
	}
	public void move(boolean[] keys){
		dx=5;
		super.move(keys);
	}
}
