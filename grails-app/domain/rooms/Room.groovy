package rooms

class Room {
    String  name
    /** how many people fit into that room */
    Integer capacity
    String  typeOfRoom

    String toString() {
        return name + "(" + capacity + ") - "+ typeOfRoom
    }

    static final MEETING = "meeting"
    static final SEMINAR = "seminar"
    static final OFFICE  = "office"
    static final ROOM_TYPES = [MEETING, SEMINAR, OFFICE]

    static constraints = {
        name       nullable:false, blank:false
        typeOfRoom inList: ROOM_TYPES
        capacity   nullable: true
    }
}
