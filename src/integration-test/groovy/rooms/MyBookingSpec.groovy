package rooms

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration


/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class MyBookingSpec extends GebSpec {

    void "My Bookings with login"() {
        when:"We start at the publicly visible homepage"
            go '/?lang=de'
        then:"The default title is shown"
        	title == "Welcome to Grails"
        when: "click on link to booking controller"
            $("a", text: "rooms.BookingController").click()
        then: "we are redirected to login page"
            title == "Anmelden"

        when: "we log in as admin"
            $("form").username = "me"
            $("form").password = "bad"
            $("input", type: "submit").click()

        then: "we finally reach the booking page for all Bookings"
            title == "Booking Liste"
            $("h2").text().contains("user: me")
            $("h1").text() == "Booking Liste"
            $("a", text: "Albert Einstein")
            $("a", text: "Roger Federer")

        when: "we go to my bookings"
            go '/booking/myBookings'
        then: "we see only my bookings and no more Roger Federer bookings"
            $("h1").text() == "Booking Liste"
            $("a", text: "Albert Einstein")
            $("a", text: "Roger Federer").size() == 0
    }
}
