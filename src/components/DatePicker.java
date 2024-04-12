package components;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.util.Calendar;

public class DatePicker extends JDateChooser {
	private static final long serialVersionUID = 33L; //serialization
    public DatePicker() {
        super();
        // Set the default date to be 1 hour after the current time
        Calendar defaultDate = Calendar.getInstance();
        defaultDate.add(Calendar.HOUR_OF_DAY, 1);
        setDate(defaultDate.getTime());

        // Get the JCalendar instance of this JDateChooser
        JCalendar jcal = getJCalendar();

        // Set the upper date limit to January 01, 2024
        Calendar upperLimit = Calendar.getInstance();
        upperLimit.set(2024, Calendar.JANUARY, 1);
        jcal.setMaxSelectableDate(upperLimit.getTime());

        // Set the lower date limit to 1 hour after the current time
        Calendar lowerLimit = Calendar.getInstance();
        lowerLimit.add(Calendar.HOUR_OF_DAY, 1);
        jcal.setMinSelectableDate(lowerLimit.getTime());

        // Disable the text field of the JDateChooser
        ((JTextFieldDateEditor) getDateEditor()).setEditable(false);
    }
}
