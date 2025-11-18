package rooms

import grails.util.Environment

import java.time.LocalDate

class BootStrap {


    static Date today      = toUtilDate(LocalDate.now())
    static Date tomorrow   = toUtilDate(LocalDate.now().plusDays(1))
    static Date yesterday  = toUtilDate(LocalDate.now().minusDays(1))

    def init = { servletContext ->

        if (Environment.current == Environment.PRODUCTION) { // guard clause
            return
        }

        // in production or test, this might already be in the DB
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.GUEST))

        SecUser testUser  = save(new SecUser(username: 'me',    password: 'bad'))
        SecUser guest     = save(new SecUser(username: 'guest', password: 'guest'))

        testUser.withTransaction { tx ->
            SecUserSecRole.create(testUser, adminRole, true) //flush
            SecUserSecRole.create(guest,    guestRole, true)
        }

        // plausibility check
        assert SecRole.count()          == 2
        assert SecUser.count()          == 2
        assert SecUserSecRole.count()   == 2


        Person einstein = save(new Person(firstName: "Albert", lastName: "Einstein", yearOfBirth: 1870, secUser: testUser))
        Person roger    = save(new Person(firstName: "Roger",  lastName: "Federer",  yearOfBirth: 1975))

        Room b51 = save(new Room(name: "5.2B51", capacity: 42, typeOfRoom: Room.MEETING))
        Room yyy = save(new Room(name: "5.2B53", capacity: 38, typeOfRoom: Room.SEMINAR))

        100.times { n ->
            save(new Room(name: "5.2B"+n, capacity: n, typeOfRoom: Room.OFFICE))
        }

        save(new Booking(bookingDay: today, timeslot: Booking.AM,  booker: einstein, room: b51))
        save(new Booking(bookingDay: today, timeslot: Booking.PM1, booker: roger,    room: b51))
        save(new Booking(bookingDay: today, timeslot: Booking.PM2, booker: roger,    room: yyy))
    }

    def destroy = {
    }


    /**
     * Convenience method to save a domain object and throw an exception if validation fails.
     * @param domainObject
     * @return Object - the saved domain object
     */
    static <T> T save(T domainObject) {
        domainObject.save(failOnError: true) // will throw an exception if validation fails
        return domainObject
    }

    /**
     * Convenience method to convert a LocalDate to a java.util.Date
     * @param localDate
     * @return Date - a java.util.Date
     */
    static Date toUtilDate(LocalDate localDate) {
        // this is not the best way to do it in general but it works for our purposes
        return new Date(localDate.toEpochDay() * 24 * 60 * 60 * 1000)
    }
}
