package rooms

class Booking {
    Person booker
    Room   room
    Date   bookingDay
    String timeslot

    static final AM  = "08:15-11:00"
    static final PM1 = "12:15-15:00"
    static final PM2 = "15:15-18:00"
    static final TIME_SLOTS = [AM, PM1, PM2]

    static constraints = {
        bookingDay    nullable: false
        timeslot      inList: TIME_SLOTS
        booker        nullable: false
        room          nullable: false
    }
}
