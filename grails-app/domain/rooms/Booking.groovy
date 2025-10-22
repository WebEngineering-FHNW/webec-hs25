package rooms

class Booking {
    Person booker
    Room   room
    Date   bookingDay
    String timeslot

    static constraints = {
        bookingDay    nullable: false
        timeslot      inList: ["08:15-11:00","12:15-15:00","15:15-18:00"]
        booker        nullable: false
        room          nullable: false
    }
}
