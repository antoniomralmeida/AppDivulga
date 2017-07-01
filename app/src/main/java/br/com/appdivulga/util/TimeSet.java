package br.com.appdivulga.util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by jardel on 24/06/2017.
 */

public class TimeSet {

    private Context context;

    public TimeSet(Context context) {
        this.context = context;
    }

    public void setData(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendarMin = Calendar.getInstance();
        int maxDays = 90;
        int minDays = 1;
        int myear = calendar.get(Calendar.YEAR);
        int mmonth = calendar.get(Calendar.MONTH);
        int mdayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        calendarMin.add(Calendar.DATE, +minDays);
        calendar.add(Calendar.DATE, +maxDays);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                textView.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(calendar.getTime()));

            }
        }, myear, mmonth, mdayOfMonth);
        datePickerDialog.getDatePicker().setMinDate(calendarMin.getTime().getTime());
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTime().getTime());
        datePickerDialog.setTitle("Selecione a Data");
        datePickerDialog.show();
    }

    public void setHora(final TextView textView) {
        Calendar calendar= Calendar.getInstance();
         int hour = calendar.get(Calendar.HOUR_OF_DAY);
         int min = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                textView.setText(new SimpleDateFormat("HH:mm", Locale.ROOT).format(calendar.getTime().getTime()));
            }
        },hour, min ,true);
        timePickerDialog.setTitle("Selecione a Hora");
        timePickerDialog.show();
    }
}
