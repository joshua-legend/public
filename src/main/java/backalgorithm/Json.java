package backalgorithm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Json {

    static String textDisplay=null;


    public static void get(String str,String name,String category) throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(str);
        JSONArray personArray = (JSONArray) jsonObject.get("items");

        for(int i=0;i<personArray.size();i++){
            JSONObject itemObject = (JSONObject) personArray.get(i);
            JSONObject snippetObject =  (JSONObject)itemObject.get("snippet");
            JSONObject topLevelComment =  (JSONObject)snippetObject.get("topLevelComment");
            JSONObject snippetCoreObject =  (JSONObject)topLevelComment.get("snippet");
            int like = Integer.parseInt(snippetCoreObject.get("likeCount").toString());
            if(like > 5){
                textDisplay += snippetCoreObject.get("textDisplay").toString();
                System.out.println(like);
            }
        }

        File file = new File("D:\\politicsdata\\"+name+"_"+category+".txt");
        FileWriter writer = null;

        if(file.exists()){
            try {
                // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
                writer = new FileWriter(file, true);
                writer.write(textDisplay);
                writer.flush();
                System.out.println("DONE");
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(writer != null) writer.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            file.createNewFile();
            try {
                // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
                writer = new FileWriter(file, true);
                writer.write(textDisplay);
                writer.flush();
                System.out.println("DONE");
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(writer != null) writer.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        textDisplay=null;
    }

}
