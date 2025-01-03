
import com.example.filmrecomendationapp.data.FilmRatingsDao
import com.example.filmrecomendationapp.data.FilmRatingsEntity
import com.example.filmrecomendationapp.data.FilmRepository
import com.example.filmrecomendationapp.data.WatchedFilmsDao
import com.example.filmrecomendationapp.data.WatchedFilmsEntity
import com.example.filmrecomendationapp.dataTypes.Movie
import com.example.filmrecomendationapp.dataTypes.MovieRating

class FilmRepositoryImpl(
    private val watchedFilmsDao: WatchedFilmsDao,
    private val filmRatingsDao: FilmRatingsDao
) : FilmRepository {

    override suspend fun getWatchedFilms(): List<WatchedFilmsEntity> {
        val entity = watchedFilmsDao.getWatchedFilms()
        return entity.map { it }
    }
    override suspend fun getWatchedFilm(filmId: Int): Boolean {
        val entity = watchedFilmsDao.getWatchedFilm(filmId)
        if (entity != null) {
            return entity.watched
        }
        else
            return false
    }

    override suspend fun setWatchedFilm(filmId: Int, watched: Boolean)  {
        watchedFilmsDao.setWatchedFilm(WatchedFilmsEntity(filmId = filmId, watched = watched))
    }

    override suspend fun getFilmRatings(): List<MovieRating> {
        val entity = filmRatingsDao.getFilmRatings()
        return entity.map { MovieRating(it.filmId, it.rating) }
    }

    override suspend fun addFilmRating(id: Int, rating: Int) {
        filmRatingsDao.addFilmRating(FilmRatingsEntity(filmId = id, rating = rating))
    }

    override suspend fun updateFilmRating(id: Int, rating: Int) {
        filmRatingsDao.updateFilmRating(FilmRatingsEntity(filmId = id, rating = rating))
    }

    override suspend fun getFilmRating(id: Int): Int {
        val entity = filmRatingsDao.getFilmRating(id)
        return entity.rating
    }


}