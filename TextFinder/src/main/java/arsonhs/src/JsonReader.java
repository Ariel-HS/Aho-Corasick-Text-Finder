/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arsonhs.src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ariel
 */
public class JsonReader {
    public static Pair<String, ArrayList<String>> readJson(String path) throws Exception { 
        // initialize result
        Pair<String, ArrayList<String>> result = new Pair();
        result.setValue(new ArrayList<>());
        
        Object jsonParser = new JSONParser().parse(new FileReader(path)); 
          
        // typecasting to JSONObject 
        JSONObject jsonObject = (JSONObject) jsonParser; 
          
        // getting text
        String text = jsonObject.get("text").toString();
        System.out.println(text); 
        result.setKey(text);
          
        // getting patterns
        JSONArray jsonArray = (JSONArray) jsonObject.get("patterns");
        Iterator iterator = jsonArray.iterator(); 
          
        while (iterator.hasNext())  
        { 
            String pattern = iterator.next().toString();
            System.out.println(pattern);
            
            ArrayList<String> patterns = result.getValue();
            patterns.add(pattern);
            result.setValue(patterns);
        } 
        
        return result;
    } 
}
