package calendar

class Params(val year: Int, val fileName: String)

fun parseArguments(args: Array<String>): Params
{
    var year: Int? = null
    var fileName: String? = null
    var index = 0

    while (index < args.size) {
        when (args[index]) {
            "-y" -> {
                if (index + 1 < args.size) {
                    year = args[index+1].toInt()
                    index += 2
                } else {
                    throw RuntimeException("No year specified")
                }
            }

            "-o" -> {
                if (index + 1 < args.size) {
                    fileName = args[index+1]
                    index += 2
                } else {
                    throw RuntimeException("No output file specified")
                }
            }

            else -> throw IllegalArgumentException("Invalid argument ${args[index]}")
        }
    }

    if (year == null) {
        throw RuntimeException("No year specified")
    }

    if (fileName == null) {
        throw RuntimeException("No output file specified")
    }

    return Params(year, fileName)
}

fun main(args: Array<String>) {
    val params = parseArguments(args)

    println("year=${params.year} fileName=${params.fileName}")
}
