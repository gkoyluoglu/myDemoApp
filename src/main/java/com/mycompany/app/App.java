package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int app(int[] arr1 , int[] arr2 , int index1 , int index2 , char operand){
        if(index1>arr1.length-1 || index2 > arr2.length-1){
            System.out.println("Given index is higer than legnth of the array.");
            return -1;
        }
        else if (operand=='+') {
            return arr1[index1]+arr2[index2];
        }else if(operand=='-'){
            return arr1[index1]-arr2[index2];
        }else if(operand=='/'){
            return arr1[index1]/arr2[index2];
        }else if(operand=='*'){
            return arr1[index1]*arr2[index2];
	}
	return 0;
    }
public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          int inputList[] = new int[10];
          int a=0;
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList[a]=value;
            a++;
          }
          System.out.println(inputList);
          int result = App.app(inputList, inputList , 1 , 2 , '+');

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
     return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

