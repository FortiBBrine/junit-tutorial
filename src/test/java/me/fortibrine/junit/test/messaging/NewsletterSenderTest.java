package me.fortibrine.junit.test.messaging;

import me.fortibrine.junit.messaging.MessagingEngine;
import me.fortibrine.junit.messaging.NewsletterSender;
import me.fortibrine.junit.messaging.SubscribeDatabase;
import me.fortibrine.junit.messaging.ZeroSubscribersException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NewsletterSenderTest {

    @Test
    public void constructorAssignsDatabase() {
        MessagingEngine engine = Mockito.mock(MessagingEngine.class);
        SubscribeDatabase database = new SubscribeDatabase();

        NewsletterSender sender = new NewsletterSender(database, engine);

        assertEquals(database, sender.getDatabase());
    }

    @Test
    public void numberOfSubscribers() {
        MessagingEngine engine = Mockito.mock(MessagingEngine.class);
        SubscribeDatabase database = Mockito.mock(SubscribeDatabase.class);

        NewsletterSender sender = new NewsletterSender(database, engine);

        List<String> subscribersList = List.of(
                "email1",
                "email2",
                "email3"
        );

        Mockito.when(database.getSubscribers()).thenReturn(subscribersList);

        assertEquals(3, sender.numberOfSubscribers());

    }

    @Test
    public void zeroSubscribersThrown() {

        assertThrows(
                ZeroSubscribersException.class,
                () -> {

                    NewsletterSender sender = new NewsletterSender(
                            new SubscribeDatabase(),
                            new MessagingEngine()
                    );
                    NewsletterSender newsletterSenderSpy = Mockito.spy(sender);

                    Mockito.when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0);

                    newsletterSenderSpy.sendNewsLetter("SUBJECT");

                }
        );

    }

}
