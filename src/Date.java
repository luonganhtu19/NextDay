public class Date implements Month,Day,Year {
    private int  day=0;
    private int month=0;
    private int year=0;


    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public Date(){};
    public Date(int day,int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    @Override
    public void checkMonth() {
        switch (month){
            case 2:
                if (checkDayIs28()){
                    if (checkYearIsLeapYear()){
                        day=increaseOneUnit(day);
                    }else{
                        month=increaseOneUnit(month);
                        day=1;
                    }
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if (checkDayIs30()){
                    month=increaseOneUnit(month);
                    day=1;
                    break;
                }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (checkDayIs31()){
                    if (month==12){
                        month=1;
                        day=1;
                        year=increaseOneUnit(year);
                    }else {
                        month=increaseOneUnit(month);
                        day=1;
                    }
                    break;
                }
            default:
                day=increaseOneUnit(day);
        }
    }

    @Override
    public boolean checkDayIs28() {
        if (day==28){
           return true;
        }
        return false;
    }
    public boolean checkDayIs30() {
        if (day==30){
            return true;
        }
        return false;
    }
    public boolean checkDayIs31() {
        if (day==31){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkYearIsLeapYear() {
        boolean dividedByFour       = year%4==0;
        boolean dividedByOneHunderd = year%100==0;
        boolean dividedByFourHunderd= year%400==0;
        if (dividedByFourHunderd) return true;
        if (dividedByFour&& !dividedByOneHunderd) return true;
        return false;
    }
    public int increaseOneUnit(int value){
        return value+1;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
