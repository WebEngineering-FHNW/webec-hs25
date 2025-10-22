package rooms

class Room {
    String  name
    Integer capacity
    String  typeOfRoom

    static constraints = {
        name       nullable:false, blank:false
        typeOfRoom inList:["meeting","seminar","office"]
        capacity   nullable:true
    }
}
