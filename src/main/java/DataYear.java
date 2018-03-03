import com.google.gson.*;
import java.io.*;


public class DataYear {
			//dy = new DataYear();
			//json = gson.toJson(dy).toString();
			//System.out.println(json);
			
			
			//System.out.println(new File(".").getAbsolutePath());
			//dy.printFile();
	
	public static void main (String[] args) {
		Gson gson = new Gson();
		JournalSet jSet = new JournalSet();
		
		String fileName = "data1.csv";
		String filePath = "json/";
		String line = null;
		
		//Arbitrary large and small (negative) numbers
		int startYear = 999999;
		int endYear = -999999;
		
		
		
		try {
			FileReader fileReader = new FileReader(filePath + fileName);
			FileReader fileReader2 = new FileReader(filePath + fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
			
			//get max and min years in the data
        	while((line = bufferedReader2.readLine()) != null) {
        		String[] lineData = line.split(",");
        		int currentYear = Integer.parseInt(lineData[1]);
        		if (currentYear > endYear) {
        			endYear = currentYear;
        		} else if (currentYear < startYear) {
        			startYear = currentYear;
        		}
        	}
        	bufferedReader2.close();
        	System.out.println(startYear + " - " + endYear);
        	
        	
        	
        	line = null;
			//line by line to console
            while((line = bufferedReader.readLine()) != null) {
            	
            	
            	
            	
            	String[] lineData = line.split(",");
            	String type = lineData[0].toLowerCase();
            	String year = lineData[1].toLowerCase();
            	String journal = lineData[2].toLowerCase();
            	String data = lineData[3].toLowerCase();

            	
            	//System.out.println(line);
            	//System.out.println(type + year + journal + data);
            	
            	if (journal.equals("jep")) {
            		
            		if (type.equals("flat")) {
            			
            		} else if (type.equals("percussive")) {
            			
            		} else if (type.equals("undefined")) {
            			
            		} else if (type.equals("click/click train")) {
            			System.out.println(line);
            		} else if (type.equals("other")) {
            			
            		}
            	} else if (journal.equals("jasa")) {
            		if (type.equals("flat")) {
            			
            		} else if (type.equals("percussive")) {
            			
            		} else if (type.equals("undefined")) {
            			
            		} else if (type.equals("click/click train")) {
            			System.out.println(line);
            		} else if (type.equals("other")) {
            			
            		}
            		
            	} else if (journal.equals("app")) {
            		if (type.equals("flat")) {
            			
            		} else if (type.equals("percussive")) {
            			
            		} else if (type.equals("undefined")) {
            			
            		} else if (type.equals("click/click train")) {
            			
            		} else if (type.equals("other")) {
            			
            		}
            		
            	} else if (journal.equals("mp")) {
            		if (type.equals("flat")) {
            			
            		} else if (type.equals("percussive")) {
            			
            		} else if (type.equals("undefined")) {
            			
            		} else if (type.equals("click/click train")) {
            			
            		} else if (type.equals("other")) {
            			
            		}
            		
            	} else if (journal.equals("hr")) {
            		if (type.equals("flat")) {
            			
            		} else if (type.equals("percussive")) {
            			
            		} else if (type.equals("undefined")) {
            			
            		} else if (type.equals("click/click train")) {
            			
            		} else if (type.equals("other")) {
            			
            		}
            		
            	}
            	
            	
            } 
            bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");                
		} 
		catch (IOException ex) {
			System.out.println("Error reading file "+ "'" + fileName + "'");
		}
		
	}
		
}
