package sk.sandeep.newsappcompose.presentation.news

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sk.sandeep.newsappcompose.common_or_util.Resource
import sk.sandeep.newsappcompose.domain.use_case.GetNewsItemUseCase
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsItemUseCase: GetNewsItemUseCase
) : ViewModel() {

    val news = mutableStateOf(NewsState())

    init {
        getNewsItems()
    }

    private fun getNewsItems() {
        getNewsItemUseCase().onEach { it ->
            when (it) {
                is Resource.Error -> {
                    news.value = NewsState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    news.value = NewsState(isLoading = true)
                }
                is Resource.Success -> {
                    news.value = NewsState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}