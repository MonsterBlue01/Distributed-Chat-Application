import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Please enter your date of birth in the following format: YYYY MM DD")
    val yearOfBirth = scanner.nextInt()
    val monthOfBirth = scanner.nextInt()
    val dayOfBirth = scanner.nextInt()
    println("Please enter today's date in the following format: YYYY MM DD")
    val yearToday = scanner.nextInt()
    val monthToday = scanner.nextInt()
    val dayToday = scanner.nextInt()
    var year = yearToday - yearOfBirth
    var month = monthToday - monthOfBirth
    var day = dayToday - dayOfBirth
    if (day < 0) {
        month -= 1
        day += 30
    }
    if (month < 0) {
        year -= 1
        month += 12
    }
    println("You have been in this world for $year years, $month months, and $day days.")
}
