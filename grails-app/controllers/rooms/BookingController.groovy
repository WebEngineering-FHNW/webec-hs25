package rooms

class BookingController {
    static scaffold = Booking

    def springSecurityService

    def myBookings() {
        if (!springSecurityService.isLoggedIn()) {
            redirect(controller: 'login', action: 'auth', params: params)
            return
        }
        SecUser secUser           = springSecurityService.currentUser
        Person person             = Person.findBySecUser(secUser)
        List<Booking> bookingList = Booking.findAllByBooker(person)
        render view:"index", model:[bookingList: bookingList, person: person]
    }

}
