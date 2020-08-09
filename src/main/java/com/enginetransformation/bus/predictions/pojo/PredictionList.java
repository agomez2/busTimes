package com.enginetransformation.bus.predictions.pojo;

import java.util.ArrayList;
import java.util.List;

public class PredictionList {
    private List<Prediction> predictions;

    public PredictionList(){
        predictions = new ArrayList<Prediction>();
    }

    public PredictionList(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    @Override
    public String toString() {
        return "PredictionList{" +
                "predictions=" + predictions +
                '}';
    }
}
