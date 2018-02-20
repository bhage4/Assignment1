package models;

public class Showroom {
	private int id;
	private int availableSeats;
	private int theaterId;

	public Showroom(int id, int availableSeats, int theaterId) {
		super();
		this.id = id;
		this.availableSeats = availableSeats;
		this.theaterId = theaterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
}
