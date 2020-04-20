package com.blandinf.calculatrice

class OffsetManager {
    companion object {
        fun applyOffset(original: Double?, newValue: Double, offset: Double = 10.0): Double {
            return if (original != null) {
                original * offset + newValue
            } else {
                newValue
            }
        }
    }
}