package interfacesImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import interfaces.BaseInterface;
import model.Rooms;
import services.RoomsCRUD;

public class RoomsImpl implements BaseInterface {
	static List<Rooms> rooms = new ArrayList<Rooms>();
	RoomsCRUD roomsOperations = new RoomsCRUD();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// ADD Rooms
	@Override
	public void add() {

		int roomNo = 0;
		boolean flags = true;
		do {
			System.out.println("Enter Room No:");
			try {
				roomNo = Integer.parseInt(reader.readLine());
				if (!getAllRooms().isEmpty()) {
					for (Rooms rooms : getAllRooms()) {
						if (rooms.getRoomNo() == roomNo) {
							System.out.println("This Room No. already Existed");
							flags = true;
							break;
						} else {
							flags = false;
						}
					}
				} else {
					flags = false;
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("Enter Valid No.");
			}
		} while (flags);

		Rooms room = new Rooms(roomNo);
		rooms.add(room);
		System.out.println("Added Successfully");

	}

	// DISPLAY Rooms
	@Override
	public void display() {

		// Print the list objects in tabular format.
		System.out.println("-------------------------");
		System.out.printf("%10s", "ROOM ID");
		System.out.println();
		System.out.println("-------------------------");
		for (Rooms room : rooms) {
			System.out.format("%10d", room.getRoomNo());
			System.out.println();
		}
		System.out.println("-------------------------");

	}

	// UPDATE Rooms
	@Override
	public void update() {
		PrintStream out = System.out;

		System.out.println("Enter Room No. which you want to update:");
		int roomNo = 0;
		try {
			roomNo = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e1) {
			System.out.println("Wrongly Used Keys!!!");
		}
		int index = 0;
		boolean check = true;
		for (Rooms d : rooms) {
			int flag = 0;

			if (d.getRoomNo() == roomNo) {
				index = flag;
				System.out.println("Valid Room No.");
				check = false;
			}
			flag++;
		}
		if (check) {
			System.out.println("Invalid Number");
			try {
				roomsOperations.crud();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}

		int ch = 0;
		do {
			System.out.println("Which one you want to Update??\n1.Update RoomNo\n2.EXIT");
			out.println("Enter choice:");
			try {
				ch = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (ch) {
			case 1:
				int updateRoom = 0;
				boolean flag = true;
				while (flag)
					try {
						System.out.println("Enter Room No.:");
						updateRoom = Integer.parseInt(reader.readLine());
						flag = false;
					} catch (Exception e) {
						System.out.println("Invalid Number");
					}
				rooms.get(index).setRoomNo(updateRoom);
				System.out.println("Updated Successfully");
				break;
			case 2:
				try {
					roomsOperations.crud();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid Choice");
				try {
					roomsOperations.crud();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}

		} while (ch != 2);
		for (Rooms d : rooms) {
			System.out.println(d);
		}

	}

	// DELETE Rooms
	@Override
	public void delete() {
		System.out.println("Enter room no. to delete");
		int roomNo = 0;
		try {
			roomNo = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.out.println("Enter valid Number");
			try {
				roomsOperations.crud();
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		Iterator<Rooms> it = rooms.iterator();
		boolean flag = true;
		while (it.hasNext()) {
			Rooms d = it.next();
			if (d.getRoomNo() == roomNo) {
				it.remove();
				System.out.println("Deleted Successfully");
				flag = false;
			}
		}

		if (flag) {
			System.out.println("Invalid Key or No room Exist");
		}

	}

	public List<Rooms> getAllRooms() {
		return rooms;
	}
}
