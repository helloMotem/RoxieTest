package com.hellomotem.roxietest.data.repository

import android.content.Context
import com.hellomotem.roxietest.domain.entity.CarImage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context
) : LocalDataSource {

    override suspend fun getCarImage(name: String): CarImage? {
        return withContext(dispatcher) {
            val data = runCatching {
                context.openFileInput(name).use {
                    it.readBytes()
                }
            }.getOrNull()

            if (data != null)
                CarImage.LocalCarImage(data.inputStream())
            else {
                null
            }
        }
    }

    override suspend fun saveCarImage(name: String, content: CarImage) {
        return withContext(dispatcher) {
            runCatching {
                if (content is CarImage.ApiCarImage) {
                    context.openFileOutput(name, Context.MODE_PRIVATE).use {
                        it.write(content.image.bytes())
                    }
                }
            }
        }
    }

    override suspend fun deleteCarImage(name: String): Boolean =
        File(context.cacheDir, name).delete()
}