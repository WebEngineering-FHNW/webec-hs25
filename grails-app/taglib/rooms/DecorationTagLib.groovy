package rooms

class DecorationTagLib {
    static defaultEncodeAs = 'raw'
    static namespace = "rooms"

    def decorate = { attributes, body ->
        String grade = attributes.grade
        def decor = "<img src='http://2.bp.blogspot.com/"
        if (grade.toDouble() < 3.8) {
            decor += "-rnfZUujszZI/UZEFYJ269-I/AAAAAAAADnw/BbB-v_QWo1w/s1600/facebook-frown-emoticon.png'>"
        } else {
            decor += "-qODY1kxipZ0/Tv5dwDFFntI/AAAAAAAAAjM/cLXT6KEp-bE/s400/sunglasses%2Bemoticon.png'>"
        }
        out << decor
        out << body()
        out << decor
    }
}
