package me.fortibrine.junit.messaging;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NewsletterSender {

    private final SubscribeDatabase database;
    private final MessagingEngine engine;

    public void sendNewsLetter(String subject) {
        List<String> emails = database.getSubscribers();

        if (emails.isEmpty()) {
            throw new ZeroSubscribersException();
        }

        engine.sendEmail(subject, emails);
    }

    public int numberOfSubscribers() {
        return database.getSubscribers().size();
    }

}
