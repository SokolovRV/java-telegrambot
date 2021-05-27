package com.github.SokolovRV.jtb.service;

import com.github.SokolovRV.jtb.bot.JavaTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private JavaTelegramBot javaTelegramBot;
    private SendBotMessageService sendBotMessageService;

    @BeforeEach
    public void init() {
        javaTelegramBot = Mockito.mock(JavaTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chatId";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(javaTelegramBot).execute(sendMessage);
    }
}