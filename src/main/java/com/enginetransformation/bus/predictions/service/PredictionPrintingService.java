package com.enginetransformation.bus.predictions.service;

import java.util.List;
import java.util.Map;

public interface PredictionPrintingService {

    void print(List<Map<String, String>> predictions);
}
