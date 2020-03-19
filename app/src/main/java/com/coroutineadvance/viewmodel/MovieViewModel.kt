package com.coroutineadvance.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coroutineadvance.model.ErrorResponse
import com.coroutineadvance.network.BaseModel
import com.coroutineadvance.model.MovieModel
import com.coroutineadvance.network.MovieRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MovieViewModel @Inject constructor(private val repository: MovieRepo) : ViewModel() {
    var response: MutableLiveData<BaseModel<Any>> = MutableLiveData()
        get() = field
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun getMoviesList() {
        scope.launch {
            response.postValue(BaseModel.LOADING("model?.data"))

            val model = repository.getMovieList()
            if (model?.data is MovieModel) {
                response.postValue(BaseModel.SUCCESS(model?.data))
            } else if (model?.data is ErrorResponse) {
                response.postValue(BaseModel.ERROR(model?.data))
            }

        }
    }
}