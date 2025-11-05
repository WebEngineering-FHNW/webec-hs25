package rooms

class PersonController {
    static scaffold = Person

    def probe() {

        // gib die Personen aus, die den Raum 5.2B51 gebucht haben
//        Room xxx = Room.findByName("5.2B51")
//        String result = Booking.findAllByRoom(xxx).booker

        // Gib die Räume aus, die Roger gebucht hat
        Person roger  = Person.findByFirstName("Roger")
        String result = Booking.findAllByBooker(roger)

        render text:result
    }
}
