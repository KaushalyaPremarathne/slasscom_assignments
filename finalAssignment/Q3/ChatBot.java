package Q3;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import ai.openai.gpt.Gpt;
import ai.openai.gpt.GptCompletionResponse;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chatbot {

    private static final String API_KEY = "sk-Gsv94h3B2xBS39FwOBIhT3BlbkFJIEdM9OoukkWzQVhujhi";
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
    	
    	 BorderPane root = new BorderPane();
         chatArea = new TextArea();
         chatArea.setEditable(false);
         chatArea.setWrapText(true);
         inputArea = new TextArea();
         inputArea.setPromptText("Type your message here");
         inputArea.setWrapText(true);
         Button sendButton = new Button("Send");
         
         sendButton.setOnAction(e -> {
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
         });
         
         HBox inputBox = new HBox(10, inputArea, sendButton);
         VBox chatBox = new VBox(10, new Label("Chat"), chatArea, inputBox);
         chatBox.setPadding(new Insets(10));
         root.setCenter(chatBox);

         Scene scene = new Scene(root, 600, 400);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Online Sales Store Chatbot");
         primaryStage.show();
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