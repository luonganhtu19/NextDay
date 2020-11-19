import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    void Chek(){
        Date date=new Date(31,3,300);
        String expect="Date{day=1, month=4, year=300}";
        date.checkMonth();
        assertEquals(expect,date.toString());
    }
}