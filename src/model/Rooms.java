package model;

public class Rooms {

	private int roomNo;

	public Rooms(int roomNo) {
		super();
		this.roomNo = roomNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return  roomNo +"  ";
	}

}
