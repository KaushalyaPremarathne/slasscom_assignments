package Q3;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import ai.openai.gpt.Gpt;
import ai.openai.gpt.GptCompletionResponse;

public class Chatbot {

    private static final String API_KEY = "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";
    private static final String MODEL_NAME = "davinci";
    private static final int MAX_TOKENS = 50;
    private static final double TEMPERATURE = 0.5;
    private static final int MAX_CHAT_HISTORY = 10;

    private Gpt gpt;
    private Scanner scanner;
    private ChatHistory chatHistory;

    public Chatbot() {
        this.gpt = new Gpt(API_KEY, MODEL_NAME);
        this.scanner = new Scanner(System.in);
        this.chatHistory = new ChatHistory(MAX_CHAT_HISTORY);
    }

    public void start() {
        System.out.println("Welcome to our online sales store chatbot! How can I assist you today?");
        while (true) {
            String userInput = scanner.nextLine().trim();
            chatHistory.addCustomerMessage(userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            CompletableFuture<GptCompletionResponse> future = gpt.complete(userInput, MAX_TOKENS, TEMPERATURE);
            GptCompletionResponse response = null;
            try {
                response = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            if (response != null) {
                String chatbotResponse = response.getText().trim();
                System.out.println(chatbotResponse);
                chatHistory.addChatbotMessage(chatbotResponse);
            }
        }
    }
    
    private static class ChatHistory {
        private String[] customerMessages;
        private String[] chatbotMessages;
        private int index;

        public ChatHistory(int maxHistory) {
            this.customerMessages = new String[maxHistory];
            this.chatbotMessages = new String[maxHistory];
            this.index = 0;
        }

        public void addCustomerMessage(String message) {
            customerMessages[index] = message;
            index = (index + 1) % customerMessages.length;
        }

        public void addChatbotMessage(String message) {
            chatbotMessages[index] = message;
            index = (index + 1) % chatbotMessages.length;
        }

        public String getChatHistory() {
            StringBuilder sb = new StringBuilder();
            sb.append("Chat History:\n");
            for (int i = 0; i < customerMessages.length; i++) {
                if (customerMessages[i] != null) {
                    sb.append("Customer: ").append(customerMessages[i]).append("\n");
                }
                if (chatbotMessages[i] != null) {
                    sb.append("Chatbot: ").append(chatbotMessages[i]).append("\n");
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.start();
        System.out.println(chatbot.chatHistory.getChatHistory());
    }
}