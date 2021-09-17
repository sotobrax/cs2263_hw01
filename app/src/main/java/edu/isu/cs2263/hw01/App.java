/*
 * This Java source file was generated by the Gradle 'init' task.
 * Braxton Soto
 */
package edu.isu.cs2263.hw01;

import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {


    Options options = new Options();
    CommandLineParser parser = new DefaultParser();
    Option batch = Option.builder ("b").longOpt("batch")
            .argName("file")
            .hasArg(false)
            .required(true)
            .desc("batch file containing expressions to evaluate").build();
    Option output = Option.builder ("o").longOpt("output")
            .argName("file")
            .hasArg(false)
            .required(true)
            .desc("output file").build();




        options.addOption("h", "help", false, "print help message");
        options.addOption(output);
        options.addOption(batch);


        try {
            CommandLine cmd = parser.parse( options, args);


            if(cmd.hasOption("h")){
                HelpFormatter formatter = new HelpFormatter();
                System.out.println("Evaluate simple mathematical expressions");
                formatter.printHelp("Options", options);
                System.exit(0);
            }
            else if (cmd.hasOption("b")){
                System.out.println("Batch File: "+ cmd.getOptionValue("b"));
                BatchEval.beval(cmd.getOptionValue("b"));

            }
            else if (cmd.hasOption("o")){
                System.out.println("Output File: " + cmd.getOptionValue("b"));
            }


        } catch (ParseException | FileNotFoundException e) {
           //e.printStackTrace();
            Eval.eval();


        }

    }
}

