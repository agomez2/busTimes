package com.enginetransformation.bus.predictions;


import com.enginetransformation.bus.predictions.service.PredictionPrintingService;
import com.enginetransformation.bus.predictions.service.implementation.DefaultPredictionPrintingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.ListUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App 
{
    private final PredictionPrintingService predictionPrintingService = new DefaultPredictionPrintingService();
    private final ObjectMapper mapper = new ObjectMapper();

    public static void main( String[] args ) throws IOException {
        App app = new App();
        app.run();
    }

    private void run() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        String stopGUrl = "https://api.tfl.gov.uk/StopPoint/490000091G/Arrivals?mode=bus";
        String stopHUrl = "https://api.tfl.gov.uk/StopPoint/490000091H/Arrivals?mode=bus";

        final String responseStopG = restTemplate.getForObject(stopGUrl, String.class);
        final String responseStopH = restTemplate.getForObject(stopHUrl, String.class);

        List<Map<String,String>> predictionsG = mapper.readValue(responseStopG, List.class);
        List<Map<String,String>> predictionsH = mapper.readValue(responseStopH, List.class);

        List<Map<String, String>> allPredictions = ListUtils.union(predictionsG, predictionsH);

        predictionPrintingService.print(allPredictions);
    }
}
