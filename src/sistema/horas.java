package sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javafx.scene.control.Label;


public class horas implements ActionListener {
    Label dataH = new Label(); 

    @Override
    public void actionPerformed(ActionEvent ae) {
        Calendar now = Calendar.getInstance();
        dataH.setText(String.format("%1$tH:%1$tM:%1$tS", now));
    }
    
}
