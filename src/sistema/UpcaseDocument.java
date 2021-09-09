package sistema;

import javax.swing.text.*;

public class UpcaseDocument extends PlainDocument {
    
    public UpcaseDocument(){
        super();
    }
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        String arg = str.toUpperCase();
        super.insertString(offset, arg, attr);
    }
}
