import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class MusicBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String msg = update.getMessage().getText();
            if(msg.startsWith("/похоже")){
                String query = msg.replace("/похоже", "").trim();
                List<String> results = MusicRecommender.getRecommendations(query);
                String reply = "🎵 Похожие артисты:\n" + String.join("\n", results);
                sendMessage(update.getMessage().getChatId(),reply);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@advanced_music_bot";
    }

    @Override
    public String getBotToken() {
        return "8090490527:AAHhIqFsj-_YRtU-U5DY7BGvkLGwOA5L714";
    }
}
