package it.michelepierri.patternrecognition.domain.dto;

public class PointDto {

	private double x;
	private double y;

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "PointDto [x=" + x + ", y=" + y + "]";
	}
}
