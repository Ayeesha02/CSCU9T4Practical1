package com.stir.cscu9t4practical1;

class SwimEntry  extends Entry{
    private String where;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
        super(n, d, m, y, h, min, s, dist);
        where= w;
    }


        public String getWhere(){
            if (where.equals("pool"))
                return "in a"+ where;
            else
                return where;
        }

        public String getEntry (){
        String result= getName()+ " swan " + getDistance()+ " Km in "
                + getHour()+ ":"+ getMin()+ ":"+ getSec() + " on"
                + getDay()+ "/"+ getMonth()+ "/" + getYear()
                + " at " + getWhere()+ "\n";
        return result;
    }
}


