package com.mycompany.app;

/**
 * Hello world!
 *
 */
import static spark.Spark.*;

import java.util.*;

import spark.ModelAndView;

import spark.template.mustache.MustacheTemplateEngine;
public class App 
{
    



public static boolean search(String array[], String s, int number){
	int count=0;
	if(array==null||s==null||number<1) 
		return false;
	
	for (String str : array){
		if(s.equalsIgnoreCase(str)){
			count++;			
		}
	}

	if(count==number)
		return true;
	

	return false;
	
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
          
	
	String[] inputList = new String[20];
	int i=0;
          while (sc1.hasNext())
          {
	    inputList[i]=sc1.next().replaceAll("\\s","");
            i++;
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
         

	  String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);

          boolean result = App.search(inputList, input2, input3AsInt);

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
