import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OurFriendTelegramBot extends TelegramLongPollingBot implements MessengerBot  {

    private static final String token = "7871197046:AAH57GP5ny7lmH6cjNoMrsS3v05zJw-JcVc";
    private static final String username = "@our_very_good_friend_bot";


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String sayHello(String name) {
        return "Привет, " + name + "!";
    }

    public String sayBotMood() {
        List<String> moods = new ArrayList<>(List.of("Всё нормально!", "Всё плохо...", "Супер!!!", "Всё кисло =("));
        Collections.shuffle(moods);
        return moods.getFirst();
    }

    @Override
    public void onUpdateReceived(Update update) {
        sayBotHello(update);
        sayBotMood(update);
    }

    private void sayBotHello(Update update) {
        if (update.hasMessage()
                && update.getMessage().hasText()
                && update.getMessage().getText().toLowerCase().contains("привет")) {
            String firstName = update.getMessage().getFrom().getFirstName();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage message = new SendMessage(chatId, sayHello(firstName));

            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sayBotMood(Update update) {
        if (update.hasMessage()
                && update.getMessage().hasText()
                && update.getMessage().getText().toLowerCase().contains("как дела")) {
            String firstName = update.getMessage().getFrom().getFirstName();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage message = new SendMessage(chatId, sayBotMood());

            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
