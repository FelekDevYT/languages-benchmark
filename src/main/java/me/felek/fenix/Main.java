package me.felek.fenix;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args[0].equals("--combine") || args[0].equals("-c")) {//--combine MAX_VALUE
            Map<String, List<Integer>> ints = new HashMap<>();

            ObjectMapper mapper = new ObjectMapper();
            PhoenixTestJSON obj = mapper.readValue(Files.readString(Paths.get("tests/tests.json")), PhoenixTestJSON.class);
            for (var test : obj.languages) {
                ints.put(test.name, new ArrayList<>());
            }

            for (int i = 0; i < Integer.parseInt(args[1]) + 1; i++) {
                JsonNode node = mapper.readTree(new File("output_" + i + ".json"));

                for (var test : obj.languages) {
                    List<Integer> l = ints.get(test.name);
                    l.add(node.get(test.name).asInt());
                    ints.put(test.name, l);
                }
            }

            Map<String, Integer> avg = new HashMap<>();
            for (Map.Entry<String, List<Integer>> list : ints.entrySet()) {
                List<Integer> intsList = list.getValue();
                int avgNumber = 0;
                for (Integer i : intsList) {
                    avgNumber += i;
                }

                avg.put(list.getKey(), avgNumber / (Integer.parseInt(args[1]) + 1));
            }

            System.out.println(avg);
        } else if (args[0].equals("--execute") || args[0].equals("-e")) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            PhoenixTestJSON obj = mapper.readValue(Files.readString(Paths.get("tests/tests.json")), PhoenixTestJSON.class);
            TestingLists lsts = new TestingLists(new HashMap<>());

            System.out.println("INSTALLING DEPENDENCIES");
            for (var test : obj.languages) {
                CommandUtils.getCommandExecutionMillis(test.install);
            }
            System.out.println("INSTALLATION FINISHED");

            System.out.println("CREATING BINARY FOLDERS");
            for (var test : obj.languages) {
                new File("bin" + "/" + test.folder + "/").mkdirs();
            }
            System.out.println("COMPLEATE");

            System.out.println("COMPILING PROGRAMS");
            for (var test : obj.languages) {
                List<String> compileCmds = test.compile;

                for (var smth : compileCmds) {
                    smth = smth.replaceAll("\\$BF", "bin" + "/" + test.folder + "/");
                    smth = smth.replaceAll("\\$F", "tests" + "/" + test.folder + "/");
                    System.out.println("EXECUTING: " + smth);
                    CommandUtils.getCommandExecutionMillis(smth);
                }
            }
            System.out.println("COMPILATION COMPLETED!");

            System.out.println("RUNNING TESTS...");
            for (var test : obj.languages) {
                List<String> runCmds = test.run;

                long milliTime = 0;
                for (var smth : runCmds) {
                    smth = smth.replaceAll("\\$BF", "bin" + "/" + test.folder + "/");
                    smth = smth.replaceAll("\\$F", "tests" + "/" + test.folder + "/");
                    System.out.println("EXECUTING: " + smth);
                    milliTime += CommandUtils.getCommandExecutionMillis(smth);
                }

                lsts.getLanguageCounts().put(test.name, milliTime);
            }
            System.out.println("ALL TEST PASSED");

            System.out.println(lsts.getLanguageCounts());

            ObjectNode node = mapper.createObjectNode();
            for (Map.Entry<String, Long> entry : lsts.getLanguageCounts().entrySet()) {
                node.put(entry.getKey(), entry.getValue());
            }

            mapper.writeValue(new File("output_" + args[1] + ".json"), node);//java -jar tests -e 0
        }
    }
}