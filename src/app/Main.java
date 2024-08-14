package app;

public class Main {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        Messenger.Message message = new Messenger.Message("John", null);
        Printer printer = (sender, text) -> {
            //if the user DOES NOT exist and the text DOES NOT exist
            if ((sender == null || sender.trim().isEmpty()) && (text == null || text.trim().isEmpty())) {
                System.out.println("An empty message from an anonymous user is being processed ");
            }
        };
        printer.print(message.getSender(), message.getText());
        messenger.print(message.getSender(), message.getText());
    }
}

@FunctionalInterface
interface Printer {
     void print(String sender, String text);
}

class Messenger implements Printer {
    @Override
    public void print(String sender, String text ) {
            // if the user DOES NOT exist and the text EXISTS
        if ((sender == null || sender.trim().isEmpty()) && !(text == null || text.trim().isEmpty())){
            System.out.println("User: anonymous \nSend a massage: " + text);
            // if the user EXIST and the text DOES NOT exist
        } else if (!(sender == null || sender.trim().isEmpty()) && (text == null || text.trim().isEmpty())) {
            System.out.println("User: " + sender + "\nSend an empty massage");
            // if the user EXISTS and the text EXISTS
        } else if (!(sender == null || sender.trim().isEmpty())) {
            System.out.println("User: " + sender + "\nSend a massage: " + text);
        }
    }

    public static class Message {
        private String sender;
        private String text;

        public Message(String sender, String text) {
                this.sender = sender;
                this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}


