import java.util.List;
import java.util.Map;

public class MusicRecommender {
    private static final Map<String, List<String>> data = Map.of(
            "Billie Eilish", List.of("Lana Del Rey", "Halsey", "Grimes"),
            "Imagine Dragons", List.of("OneRepublic", "X Ambassadors", "AWOLNATION")
    );

    public static List<String> getRecommendations(String artist){
        return data.getOrDefault(artist, List.of("Ничего не найдено :("));
    }
}
