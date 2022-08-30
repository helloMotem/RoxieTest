package com.hellomotem.roxietest.data

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class DeleteWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParameters: WorkerParameters,
    private val repository: OrdersRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CoroutineWorker(appContext, workerParameters) {

    override suspend fun doWork(): Result {
        val imageName = inputData.getString("imageName") ?: return Result.failure()
        val result = withContext(dispatcher) { repository.deleteCarImage(imageName) }

        val output: Data = workDataOf("result" to result)
        return Result.success(output)
    }
}