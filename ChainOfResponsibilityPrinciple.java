interface LoggingSystemHandler {
    void setNextHandler(LoggingSystemHandler nextHandler);
    void serveRequest(String request, String severity);
}

class InfoHandler implements LoggingSystemHandler {
    private LoggingSystemHandler nextHandler;

    public void setNextHandler(LoggingSystemHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void serveRequest(String request, String severity) {
        if (severity.equalsIgnoreCase("low")) { 
            System.out.println(request + " is served by InfoHandler because its severity is " + severity);
        } else if (nextHandler != null) {
            nextHandler.serveRequest(request, severity);
        } else {
            System.out.println("Request cannot be served");
        }
    }
}

class DebugHandler implements LoggingSystemHandler {
    private LoggingSystemHandler nextHandler;

    public void setNextHandler(LoggingSystemHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void serveRequest(String request, String severity) {
        if (severity.equalsIgnoreCase("medium")) { 
            System.out.println(request + " is served by DebugHandler because its severity is " + severity);
        } else if (nextHandler != null) {
            nextHandler.serveRequest(request, severity);
        } else {
            System.out.println("Request cannot be served.");
        }
    }
}

class ErrorHandler implements LoggingSystemHandler {
    private LoggingSystemHandler nextHandler;

    public void setNextHandler(LoggingSystemHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void serveRequest(String request, String severity) {
        if (severity.equalsIgnoreCase("high")) { 
            System.out.println(request + " is served by ErrorHandler because its severity is " + severity);
        } else if (nextHandler != null) {
            nextHandler.serveRequest(request, severity);
        } else {
            System.out.println("Request cannot be served.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        LoggingSystemHandler infoHandler = new InfoHandler();
        LoggingSystemHandler debugHandler = new DebugHandler();
        LoggingSystemHandler errorHandler = new ErrorHandler();

        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);

        String request1 = "Low Priority Request";
        String severity1 = "low";

        String request2 = "Medium Priority Request";
        String severity2 = "medium";

        String request3 = "High Priority Request";
        String severity3 = "high";

        String request4 = "Critical Priority Request";
        String severity4 = "unknown";

        infoHandler.serveRequest(request1, severity1); 
        infoHandler.serveRequest(request2, severity2); 
        infoHandler.serveRequest(request3, severity3); 
        infoHandler.serveRequest(request4, severity4); 
    }
}
