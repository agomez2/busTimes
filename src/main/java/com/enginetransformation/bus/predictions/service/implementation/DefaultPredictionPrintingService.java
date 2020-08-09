package com.enginetransformation.bus.predictions.service.implementation;

import com.enginetransformation.bus.predictions.service.PredictionPrintingService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        LocalDateTime localDateTime = LocalDateTime.parse(iso8601Date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }


}
