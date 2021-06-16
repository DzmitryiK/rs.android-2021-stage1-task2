package subtask3

import java.lang.Math.abs
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockA.isEmpty()) { return "Empty array"}
        else {
            when(blockB) {
                String::class -> {
                    return blockA.filterIsInstance<String>().joinToString("")
                }
                Int::class -> {
                    return blockA.filterIsInstance<Int>().sum()
                }
                LocalDate::class -> {
                    val dateArr = blockA.filterIsInstance<LocalDate>()
                    if (dateArr.isEmpty()){ return "No data"}
                    else {
                        var daysBetw = abs(dateArr[0].until(LocalDate.now(), ChronoUnit.DAYS))
                        var resDate = dateArr[0]
                        for (e in dateArr) {
                            if (abs(e.until(LocalDate.now(), ChronoUnit.DAYS)) < daysBetw) {
                                daysBetw = abs(e.until(LocalDate.now(), ChronoUnit.DAYS))
                                resDate = e
                            }
                        }
                        return resDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                    }
                }
                else -> return "Unsupportable array"
            }
        }
    }
}
