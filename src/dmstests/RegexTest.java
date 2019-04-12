package dmstests;

import java.util.ArrayList;
import java.util.List;

public class RegexTest {
    private static final String CLEAR_AA_ALL_BUT_USER = "(?<=<aa\\s)(.*?)(?=ad=)(ad=\"\\S+\")(.*?)(?=(>|/>))";

    public static final void main(String[] args){

        List<String> toFilter = new ArrayList<>();
        toFilter.add("<aa ab=\"10.2.4.8.0\" ac=\"DMS_IS3_17/ 94860\" ad=\"intadmin\" ss=\"Uk9XLURUAAAmAFtDYzIABgrH\" ae=\"2018-07-09\"><cs></cs></aa> sdadasd ");
        toFilter.add("<aa ac=\"DMS_IS3_1794860\"ss=\"Uk9XLURUAAAmAFtDYzIABgrH\" ae=\"2018-07-09\"> asdasd</aa>");
        toFilter.add("<aa ab=\"10.2.4.8.0\" ad=\"intadmin\" ae=\"2018-07-09\">");
        toFilter.add("<aa ab=\"10.2.4.8.0\" ac=\"DMS_IS3_1794860\">");
        toFilter.add("<aa ad=\"admin\" ae=\"2018-07-10\">");
        toFilter.add("<aa ab=\"10.2.4.8.0\" ac=\"DMS_IS3_1794860\" ad=\"sadasd\" s=\"Uk9XLURUAAAmAFtDYzIABgrH\" ae=\"2018-07-09\">\n" +
                "<sdsb ab=\"10.2.4.8.0\" ac=\"DMS_IS3_1794860\" ss=\"Uk9XLURUAAAmAFtDYzIABgrH\" ae=\"2018-07-09\">\n" +
                "<xcf ab=\"10.2.4.8.0\" ac=\"DMS_IS3_1794860\" ss=\"Uk9XLURUAAAmAFtDYzIABgrH\" ae=\"2018-07-09\"></aa>");

        int index = 0;
        for(String s : toFilter){
            System.out.println(index + ": " + s.replaceAll(CLEAR_AA_ALL_BUT_USER, "$2"));
            index++;
        }

    }
}
