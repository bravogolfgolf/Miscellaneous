package rover;

public interface Model {
	public abstract Point getPosition();
	public abstract String getHeading();
	public abstract void landOnPlanet(Grid planet);
	public abstract void move(String instruction);
}