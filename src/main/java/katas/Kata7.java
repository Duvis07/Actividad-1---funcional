package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(peliculas -> peliculas.getVideos().stream()
                 .map(peli -> Map.of(
                     "id", peli.getId(),
                      "title", peli.getTitle(),
                      "box", peli.getBoxarts().stream()
                      .reduce((mayor, menor) -> mayor.getWidth() * mayor.getHeight() < menor.getWidth() * menor.getHeight() ? mayor : menor)))
                ).collect(Collectors.toList());


    }
}