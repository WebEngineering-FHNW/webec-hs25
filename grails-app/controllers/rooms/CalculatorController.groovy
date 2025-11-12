package rooms

class CalculatorController {

    def index() {
        render view: "GradeCalculator"
    }

    def calc(double tec, double own) {
        double result = tec * own / 100
        render view: "CalculatorOutput", model: [result: result]
    }
}
