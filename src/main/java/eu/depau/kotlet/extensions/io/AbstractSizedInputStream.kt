package eu.depau.kotlet.extensions.io

import java.io.InputStream

abstract class AbstractSizedInputStream: InputStream() {
    abstract val size: Long
}