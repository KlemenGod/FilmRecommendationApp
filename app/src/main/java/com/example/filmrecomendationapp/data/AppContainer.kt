import android.content.Context
import com.example.filmrecomendationapp.data.FilmRepository
import com.example.filmrecomendationapp.data.FilmRecommendationDatabase

//dependency injection
interface AppContainer {
    val filmRepository: FilmRepository
}

//...implementation...
//provides instance of StepRepositoryImpl
class AppDataContainer (private val context: Context) : AppContainer{

    override val filmRepository: FilmRepository by lazy {
        FilmRepositoryImpl(FilmRecommendationDatabase.getDatabase(context).watchedFilmsDao(),
            FilmRecommendationDatabase.getDatabase(context).filmRatingsDao())
    }

}

