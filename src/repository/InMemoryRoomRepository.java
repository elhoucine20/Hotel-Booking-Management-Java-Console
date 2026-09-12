package repository;

import domain.Room;
import enums.RoomStatus;
import enums.RoomType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRoomRepository {

    //HashMap<String, Room>
    static Map<UUID, Room> rooms = new HashMap<>();

    {
        rooms.put(UUID.randomUUID(),
                new Room(
                        "101",
                        RoomType.SINGLE,
                        1,
                        new BigDecimal("350.00"),
                        RoomStatus.AVAILABLE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "102",
                        RoomType.DOUBLE,
                        2,
                        new BigDecimal("550.00"),
                        RoomStatus.AVAILABLE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "103",
                        RoomType.SUITE,
                        4,
                        new BigDecimal("1200.00"),
                        RoomStatus.MAINTENANCE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "104",
                        RoomType.SINGLE,
                        1,
                        new BigDecimal("400.00"),
                        RoomStatus.AVAILABLE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "105",
                        RoomType.DOUBLE,
                        2,
                        new BigDecimal("650.00"),
                        RoomStatus.AVAILABLE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "106",
                        RoomType.SUITE,
                        5,
                        new BigDecimal("1500.00"),
                        RoomStatus.MAINTENANCE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "107",
                        RoomType.DOUBLE,
                        2,
                        new BigDecimal("700.00"),
                        RoomStatus.AVAILABLE
                )
        );

        rooms.put(UUID.randomUUID(),
                new Room(
                        "108",
                        RoomType.SUITE,
                        4,
                        new BigDecimal("1200.00"),
                        RoomStatus.AVAILABLE
                )
        );

    }

    public void afichierRooms(){
        System.out.println("========================================");
        System.out.println("============ View All Rooms ============");
        System.out.println("========================================");

        for (Map.Entry<UUID,Room> room : rooms.entrySet()){
            System.out.println("RoomNumber:"+room.getValue().getRoomNumber()+" , Capacity:"+room.getValue().getCapacity()+
                    " , Type:"+room.getValue().getType()+" , PriceByNight:"+room.getValue().getPricePerNight()+" , Statu:"+room.getValue().getStatus());
        }
        System.out.print("\n");
    }

    public void afichierRoomsAvailable(){
        System.out.println("========================================");
        System.out.println("========= View Rooms Available =========");
        System.out.println("========================================");

        for (Map.Entry<UUID,Room> room : rooms.entrySet()){
            if (room.getValue().getStatus().equals(RoomStatus.AVAILABLE)){
                System.out.println("RoomNumber:"+room.getValue().getRoomNumber()+" , Capacity:"+room.getValue().getCapacity()+
                        " , Type:"+room.getValue().getType()+" , PriceByNight:"+room.getValue().getPricePerNight()+" , Statu:"+room.getValue().getStatus());
            }
        }
        System.out.print("\n");
    }

    public  Room getroomByNumber(String NRoom){
          Room room = rooms.entrySet().stream().filter(ro->ro.getValue().getRoomNumber().equals(NRoom))
                .map(Map.Entry::getValue).findFirst().orElseThrow();
          if (room == null)
              throw new IllegalArgumentException("room introvable");
          return room;
    }

    public static Map<UUID,Room> getRooms(){
        return rooms;
    }
}
