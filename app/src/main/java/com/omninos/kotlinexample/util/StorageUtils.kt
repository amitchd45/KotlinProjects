package com.omninos.kotlinexample.util

import android.os.Environment

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object StorageUtils {

    val appExternalDataDirectoryPath: String
        get() {
            val sb = StringBuilder()
            sb.append(Environment.getExternalStorageDirectory())
                .append(File.separator)
                .append("Android")
                .append(File.separator)
                .append("data")
                .append(File.separator)
                .append("com.omninos.kotlinexample")
                .append(File.separator)

            return sb.toString()
        }

    val appExternalDataDirectoryFile: File
        get() {
            val dataDirectoryFile = File(appExternalDataDirectoryPath)
            dataDirectoryFile.mkdirs()

            return dataDirectoryFile
        }

    fun writeStringToFile(string: String, file: File) {
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            fos.write(string.toByteArray())
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (fos != null) {
                try {
                    fos.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun writeObjectToFile(`object`: Any, file: File) {
        var oos: ObjectOutputStream? = null
        try {
            val fos = FileOutputStream(file)
            oos = ObjectOutputStream(fos)
            oos.writeObject(`object`)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                oos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    fun <T> readObjectFromFile(file: File): T? {
        var ois: ObjectInputStream? = null
        var `object`: T? = null
        try {
            val fis = FileInputStream(file)
            ois = ObjectInputStream(fis)
            `object` = ois.readObject() as T
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (ois != null) {
                try {
                    ois.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }

        return `object`
    }
}
