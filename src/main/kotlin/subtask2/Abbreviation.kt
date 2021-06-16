package subtask2

import java.lang.StringBuilder

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var rg:StringBuilder = StringBuilder()
        rg.append(".*?")
        for (i in 0..b.length-1) {
            rg.append("("+b[i].toUpperCase()+").*?")
        }

        if (a.toUpperCase().matches(rg.toString().toRegex()))
            return "YES"
        else
            return "NO"
    }
}
