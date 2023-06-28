package com.mockitoCourse.Newsletter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NewsLetterSenderTest {

    //MOCK
    @Test
    public void constructorAssignsDatabase(){
        //This class is created just for NewsLetterSender constructor
        MessagingEngine messagingEngine = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsLetterSender newsLetterSender = new NewsLetterSender(subscribersDatabase, messagingEngine);

        assertEquals(subscribersDatabase, newsLetterSender.getSubscribersDatabase());
    }

    //STUB
    @Test
    public void numberOfSubscribers(){
        //The diference is tha stub has instructions for how to respond
        // to certain method calls
        SubscribersDatabase subscribersDatabaseMock = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngine = mock(MessagingEngine.class);

        NewsLetterSender sender = new NewsLetterSender(subscribersDatabaseMock, messagingEngine);

        //vWhen called will return the list
        List<String> subscribersList = Arrays.asList("email1", "email2", "email3");
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribersList);

        assertEquals(3, subscribersDatabaseMock.getSubscribers().size());
    }

    //SPY
    //Regular class instance with the ability to also stub
    //method calls
    @Test
    public void zeroSubscribersThrown(){
        assertThrows(ZeroSubscribersException.class, () -> {
            NewsLetterSender sender = new NewsLetterSender(new SubscribersDatabase(), new MessagingEngine()) ;
            //spy
            NewsLetterSender senderSpy = spy(sender);
            when(senderSpy.numberOfSubscribers()).thenReturn(0);

            senderSpy.sendNewsletter("SUBJECT");
        });



    }


}