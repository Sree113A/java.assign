package Utils;


import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class docreader {

    public static void main(String args[]) throws IOException,
      InvalidFormatException,
      org.apache.poi.openxml4j.exceptions.InvalidFormatException {
     try {
     // Set set=new HashSet();
      Set<String> data = new LinkedHashSet<String>();   
      int count = 0;
      String[] array={"Java","Python","PHP","C++","Oracle","Excel"};
      XWPFDocument doc = new XWPFDocument(
        OPCPackage.open("C:\\Users\\DSREEKUM\\Downloads\\Assignments_1\\Assignments_1\\src\\main\\java\\PDF_Solution.java"));
      for (XWPFParagraph p : doc.getParagraphs()) {
       List <XWPFRun>runs = p.getRuns();
       if (runs != null) {
        for (XWPFRun r : runs) {
         String text = r.getText(0);
         if (text != null ) 
         {
        	 for(String skill:array) {
          //text = text.replace("$$key$$", "ABCD");//your content
        		 if(text.contains(skill)) {
        			 data.add(skill);	 
        		 }
        	 }
          r.setText(text, 0);
         }
        }
       }
      }
      
      for(Object object : data) {
    	    String element = (String) object;
    	    System.out.println(element);
    	    for(String lang:array) {
    	    	if(lang.equals(element)) {
    	    		count++;
    	    	}
    	    }
    	}
      float per=(float)count/array.length;
      if(count!=0)  //Check for count not equal to zero
      {
         System.out.println("The given words are present for "+count+ " Times in the file "+per*100+" is percent match");
       }
      else
      {
         System.out.println("The given word is not present in the file");
      }
     } finally {

     }

    }

   }