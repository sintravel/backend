package backend.sintravel.survey;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;


import static org.junit.jupiter.api.Assertions.*;

class SurveyServiceTest {


    @Test
    void recommendBySurveyResult() throws ExecuteException, IOException, InterruptedException {

        ArrayList<String> valueList = new ArrayList<>();

        String path = System.getProperty("user.dir");


        valueList.add("cmd.exe");
        valueList.add("/c");
        valueList.add("python");
        valueList.add("recommend.py");
        valueList.add("12783363");
        valueList.add("AD5");
        valueList.add("0");

        ProcessBuilder processBuilder = new ProcessBuilder(valueList).directory(new File(path + "/python_workplace"));

        Process start = processBuilder.start();

        start.waitFor();

    }


}