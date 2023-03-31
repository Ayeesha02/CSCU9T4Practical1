package com.stir.cscu9t4practical1;

class SprintEntry extends Entry {
    private int Repetitions;
    private int Recovery;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int r, int r1) {
        super(n, d, m, y, h, min, s, dist);
        Repetitions = r;
        Recovery = r1;
    }

    public int getRepetitions() {
        return Repetitions;
    }

    public int getRecovery() {
        return Recovery;
    }

    @Override
    public String getEntry() {
        String result = getName() + " sprinted " + getRepetitions() + "X" + getDistance() + " in "
                + getHour() + ":" + getMin() + ":" + getSec() + " with "+ getRecovery()+ " minutes recovery on " + getDay() + "/" + getMonth() + "/" + getYear()
                + "\n";
        return result;
    }
}


