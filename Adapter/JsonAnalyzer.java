package Adapter;

//JAVA only have object adapter
public class JsonAnalyzer {
    // Enter Your Methods Here
    public static void main(String[] args) {
        String str = "xml data";
        JSONTool tool = new JSONTool();
        tool.setString(str);
        tool.analyzeJSON();

        System.out.println("----------");

        IJsonToXmlAdapter myAdapter = new JsonToXmlAdapter(tool,str);
        myAdapter.analyze();
    }
}

//adaptee
class JSONTool{
    String jsonStr;
    public void setString(String str){
        this.jsonStr = str;
    }

    public void analyzeJSON(){
        if(jsonStr.contains("******")){
            System.out.println("Analyzing json data");
        }else{
             System.out.println("Please enter valid JSON data");
        }
    }
}


interface IJsonToXmlAdapter{
    public void analyze();
}

class JsonToXmlAdapter implements IJsonToXmlAdapter{
    JSONTool tool;

    JsonToXmlAdapter(JSONTool tool,String str){
        this.tool = tool;
        if(!str.contains("******")){
            str += "******";
        }
        this.tool.setString(str);
    }

    @Override
    public void analyze() {
       this.tool.analyzeJSON();
    }

}