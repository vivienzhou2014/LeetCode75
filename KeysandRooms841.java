import java.util.*;

public class KeysandRooms841 {

        public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
            //use set to store all visited rooms
            //use container(queue, stack, set, list, does not matter) to loop through keys in next available room
            //put the first room key[0] into the container, while container is not empty
            //put keys in the room we are visiting into the container
            //loop each key, if there is a key for a room not visited yet, add it to the visited room set(pretend we visited it)
            //and add this key to the container, go back to check if container is empty
            //last check if number of visited room has the same number of rooms
            HashSet<Integer> visited = new HashSet<>();
            visited.add(0);
            Queue<Integer> container = new LinkedList<>();
            container.offer(0);
            while(!container.isEmpty()){
                List<Integer> keys = rooms.get(container.poll());
                for(int key : keys){
                    if(!visited.contains(key)) {
                        visited.add(key);
                        container.offer(key);
                    }
                }
            }
            return rooms.size() == visited.size();
        }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
            //we can also solve it recursively
        Set<Integer> visited = new HashSet<>();
        process(0, visited, rooms);
        return rooms.size() == visited.size();
    }

    private static void process(int key, Set<Integer> visited, List<List<Integer>> rooms) {
            List<Integer> room = rooms.get(key);
            visited.add(key);
            for(int keys : room){
                if(!visited.contains(keys)) {
                    process(keys, visited, rooms);
                }
            }
    }

    public static void main(String[] args) {
        KeysandRooms841 keysandRooms841 = new KeysandRooms841();

        // Create a list of rooms with keys
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1,3));
        rooms.add(List.of(3,0,1));
        rooms.add(List.of(2));
        rooms.add(List.of(0,2));
        //rooms.add(new ArrayList<>()); // Room 3 has no keys, it's empty

        if (canVisitAllRooms(rooms)) {
            System.out.println("You can visit all rooms.");
        } else {
            System.out.println("You cannot visit all rooms.");
        }
    }
}
