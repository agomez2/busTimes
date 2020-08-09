package com.enginetransformation.bus.predictions.service.implementation;

import com.enginetransformation.bus.predictions.service.PredictionPrintingService;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DefaultPredictionPrintingService implements PredictionPrintingService {

    public void print(List<Map<String, String>> predictions) {
        predictions
                .forEach(this::printPrediction);
    }

    //lineName
    //expectedArrival
    //modeName == bus
    //direction?
    //platformName
    private void printPrediction(Map<String, String> prediction) {
        if ("bus".equals(prediction.get("modeName"))){
            System.out.print   ("Line: " + prediction.get("lineName") + " ");
            System.out.print   ("Stop name: " + prediction.get("platformName") + " ");
            System.out.println ("Time: " + printTime(prediction.get("expectedArrival")) + " ");
        }
    }

    private String printTime(String iso8601Date) {
        Instant instant = Instant.parse(iso8601Date);

        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDateTime( FormatStyle.SHORT )
                .withLocale( Locale.UK )
                .withZone( ZoneId.systemDefault() );

        return formatter.format(instant);
    }


}
