package Interfaces;

import Classes.Anime;
import Classes.Episode;
import Classes.Movie;

public interface FILTERable<T> {
    void sortByRatingHighToLow(T obj);

    void sortByRatingLowToHigh(T obj);

    void sortByDurationShortToLong(Movie m);

    void sortByDurationLongToShort(Movie m);

    void sortByDateNewToOld(T obj);

    void sortByDateOldToNew(T obj);

    void filterByType(Episode e, String Type);

    void filterByGenre(Anime a, String Genre);

    void filterByProductionCompany(Anime a, String pCompany);
}
