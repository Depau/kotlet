package eu.depau.kotlet.extensions.io

import java.io.OutputStream

abstract class AbstractSizedOutputStream: OutputStream() {
    abstract val size: Long
}