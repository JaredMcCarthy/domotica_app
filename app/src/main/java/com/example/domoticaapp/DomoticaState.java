package com.example.domoticaapp;

public class DomoticaState {
    private static DomoticaState instance;

    public boolean focoPp = false;
    public boolean focoSp = false;
    public boolean focoTp = false;
    public boolean focoGaraje = false;

    public boolean enchufePp = false;
    public boolean enchufeSp = false;
    public boolean enchufeTp = false;
    public boolean enchufeGaraje = false;

    private DomoticaState() {}

    public static synchronized DomoticaState getInstance() {
        if (instance == null) {
            instance = new DomoticaState();
        }
        return instance;
    }
}
