import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmrecomendationapp.data.FilmRepository
import com.example.filmrecomendationapp.dataTypes.Movie
import com.example.filmrecomendationapp.dataTypes.MoviePage
import com.example.filmrecomendationapp.ui.FilmRecomendationUIState
import com.example.filmrecomendationapp.ui.StepHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import com.example.filmrecomendationapp.network.getRequest
import com.google.gson.Gson

class FilmRecomendationViewModel(private val repository: FilmRepository) : ViewModel() {

    // Holds the app's UI state
    private val _uiState = MutableStateFlow(FilmRecomendationUIState())
    val uiState: StateFlow<FilmRecomendationUIState> = _uiState.asStateFlow()


    init {
        loadInitialData()
    }

    //Function to load initial data.
    private fun loadInitialData() {
        viewModelScope.launch {
            val watchedFilms = repository.getWatchedFilms()
            val ratings = repository.getFilmRatings()
            _uiState.update { currentState -> currentState.copy(watchedFilms = watchedFilms, ratings = ratings) }
        }

        getRequest {result ->
            val gson = Gson()
            val moviePage: MoviePage = gson.fromJson(result, MoviePage::class.java)
            _uiState.update {
                    currentState -> currentState.copy(movies = moviePage.results)
            }

        }
    }


    fun setCurrentMovies(movies: List<Movie>) {

        _uiState.update {
                currentState -> currentState.copy(movies = movies)
        }

    }
    fun setCurrentMovie(movie: Movie) {
        viewModelScope.launch {
            val watched: Boolean = repository.getWatchedFilm(movie.id)
            _uiState.update { currentState ->
                currentState.copy(currentMovie = movie, movieWatched = watched)
            }
        }
    }

    fun setMovieWatched(movieWatched : Boolean) {
        _uiState.update {
                currentState -> currentState.copy(movieWatched = movieWatched)
        }
        viewModelScope.launch {
            repository.setWatchedFilm(_uiState.value.currentMovie.id,movieWatched)
        }
    }


}