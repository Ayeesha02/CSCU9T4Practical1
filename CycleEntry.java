package com.stir.cscu9t4practical1;

class CycleEntry extends Entry {
    private String Terrain;
    private String Tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String t, String t2) {
        super(n, d, m, y, h, min, s, dist);
        Terrain = t;
        Tempo = t2;
    }

    public String getTerrain() {
        return Terrain;
    }

    public String getTempo() {
        return Tempo;
    }

    public String getEntry() {
        String result = getName() + " cycled " + getDistance() + " km in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + " on "
                + getTerrain()+ " at " + getTempo() + " tempo\n";

        return result;
    }
}