package com.blandinf.calculatrice

import android.content.res.Resources
import java.lang.Exception

class CalculLogic {
    companion object {
        var a: Double? = null
        var b: Double? = null
        var operator: String? = null

        fun addValue(value: Double) {
            if (operator != null) {
                b = OffsetManager.applyOffset(b, value)
            } else {
                a = OffsetManager.applyOffset(a, value)
            }
        }

        fun clear() {
            a = null
            b = null
            operator = null
        }

        fun compute (): Double {
            if (a != null && b != null && operator != null) {
                if (operator == "/" && b == 0.0) {
                    throw Exception(Resources.getSystem().getString(R.string.divide_by_zero))
                } else {
                    var result = 0.0
                    // a and b cannot be empty here
                    when (operator) {
                        "+" -> result = a!! + b!!
                        "-" -> result = a!! - b!!
                        "/" -> result = a!! / b!!
                        "*" -> result = a!! * b!!
                    }
                    return result
                }
            } else {
                throw Exception(Resources.getSystem().getString(R.string.result_error))
            }
        }
    }
}