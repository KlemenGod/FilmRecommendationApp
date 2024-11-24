import androidx.lifecycle.ViewModel
import com.example.filmrecomendationapp.data.stepHistory
import com.example.filmrecomendationapp.ui.FilmRecomendationUIState
import com.example.filmrecomendationapp.ui.StepHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.*

class FilmRecomendationViewModel : ViewModel() {

    // Holds the app's UI state
    private val _uiState = MutableStateFlow(FilmRecomendationUIState())
    val uiState: StateFlow<FilmRecomendationUIState> = _uiState.asStateFlow()


    init {
        resetStepCounter()
    }

    fun resetStepCounter() {
        _uiState.value = FilmRecomendationUIState()
    }

    // Function to update the step count (e.g., called when steps are detected)
    fun updateStepCount(newSteps: Int) {
        _uiState.update {
                currentState -> currentState.copy(stepCount = newSteps)
        }
    }

    // Function to set a new daily goal
    fun setStepGoal(goal: Int) {
        _uiState.update {
                currentState -> currentState.copy(stepGoal = goal)
        }
    }

    // Function to add a new history entry (e.g., at the end of the day)
    fun addStepHistoryEntry() {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val newHistory = stepHistory + StepHistory(date = today, steps = _uiState.value.stepCount)

        //update the history

        // Reset the step count at the end of the day and update history
        resetStepCounter()
    }


}