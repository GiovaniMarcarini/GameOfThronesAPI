package util

import model.Character

sealed interface Resource<out T> {
    data object Loading : Resource<Nothing>
    data class Error(val throwable: Throwable) : Resource<Nothing>
    data class Success<T>(val data: T) : Resource<T>
}

enum class ScreenState {
    LOADING,
    ERROR,
    SUCCESS
}

data class HomeUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val characters: List<Character> = listOf()
)