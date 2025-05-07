import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MusicBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

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
