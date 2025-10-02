package util;

import org.testng.annotations.DataProvider;

public class bookingDataProvider {
    @DataProvider
    public Object[][] bookingData(){
        return new Object[][]
        {{1},
         {2},
         {3}
        };
    }
    @DataProvider
    public Object[][] bookingCreationData(){
        return new Object[][]
        {{"John","Wick",140,true,"2022-08-09","2022-08-09","Mini Bar"},
         {"Wake","Alan",1320,false,"2022-06-03","2022-06-03","Breakfast"},
         {"Barry"," Seal",132,true,"2024-03-04","2024-03-04","Lunch"},
         {"Alex","Ben",234,false,"2023-02-02","2023-02-02","Pool Access"},
         {"Peter","Parker",654,true,"2025-06-05","2025-06-05","Internet"}
        };
    }
    @DataProvider
    public Object[][] bookingUpdationData(){
        return new Object[][]
        {{4,"Allison","Stone",140,true,"2022-08-09","2022-08-09","Mini Bar"},
         {5,"Neil","Boher",1320,false,"2022-06-03","2022-06-03","Breakfast"},
         {6,"Major"," Jonathan",132,true,"2024-03-04","2024-03-04","Lunch"}
        };
    }
}
