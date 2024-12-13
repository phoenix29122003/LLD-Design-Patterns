class DocEditor{
    public void writeText(){
        System.out.println("Writing text: Hello");
    }
    public void deleteText(){
        System.out.println("Deleting text: Hello");
    }
    public void undoText(){
        System.out.println("Undoing text: Hello");
    }
}

interface Command{
    void execute();
}

class WriteCommand implements Command{
    private DocEditor docEditor;
    public WriteCommand(DocEditor doc){
        this.docEditor=doc;
    }
    public void execute(){
        docEditor.writeText();
    }
}

class DeleteCommand implements Command{
    private DocEditor docEditor;
    public DeleteCommand(DocEditor doc){
        this.docEditor=doc;
    }
    public void execute(){
        docEditor.deleteText();
    }
}

class UndoCommand implements Command{
    private DocEditor docEditor;
    public UndoCommand(DocEditor doc){
        this.docEditor=doc;
    }
    public void execute(){
        docEditor.undoText();
    }
}

class RemoteControl{
    private Command command;
    public void setCommand(Command com){
        this.command=com;
    }
    public void execute(){
        command.execute();
    }
}


class Main {
    public static void main(String[] args) {
        DocEditor docEditor=new DocEditor();
        
        Command writeCommand=new WriteCommand(docEditor);
        Command deleteCommand=new DeleteCommand(docEditor);
        Command undoCommand=new UndoCommand(docEditor);
        
        RemoteControl remote=new RemoteControl();
        
        remote.setCommand(writeCommand);
        remote.execute();
        
        remote.setCommand(deleteCommand);
        remote.execute();
        
        remote.setCommand(undoCommand);
        remote.execute();
    }
}
