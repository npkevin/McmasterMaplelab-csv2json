import com.google.gson.*;
import java.io.*;

public class DataYear {
	// dy = new DataYear();
	// json = gson.toJson(dy).toString();
	// System.out.println(json);

	// System.out.println(new File(".").getAbsolutePath());
	// dy.printFile();

	public static void main(String[] args) {
		Gson gson = new Gson();

		String fileName = "data1.csv";
		String filePath = "json/";
		String line = null;

		// Arbitrary large and small (negative) numbers
		int startYear = 999999;
		int endYear = -999999;

		try {
			FileReader fileReader = new FileReader(filePath + fileName);
			FileReader fileReader2 = new FileReader(filePath + fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

			// get max and min years in the data
			while ((line = bufferedReader2.readLine()) != null) {
				
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
			// line by line to console
			while ((line = bufferedReader.readLine()) != null) {
				
				JournalSet jSet = new JournalSet();
				
				String[] lineData = line.split(",");
				String type = lineData[0].toLowerCase();
				String year = lineData[1].toLowerCase();
				String journal = lineData[2].toLowerCase();
				String data = lineData[3].toLowerCase();

				// System.out.println(line);
				// System.out.println(type + year + journal + data);

				if (journal.equals("jep")) {

					if (type.equals("flat")) {
						jSet.JEP.flat = Double.parseDouble(data);
					} else if (type.equals("percussive")) {
						jSet.JEP.percussive = Double.parseDouble(data);
					} else if (type.equals("undefined")) {
						jSet.JEP.undefined = Double.parseDouble(data);
					} else if (type.equals("click/click train")) {
						jSet.JEP.click = Double.parseDouble(data);
					} else if (type.equals("other")) {
						jSet.JEP.other = Double.parseDouble(data);
					}

				} else if (journal.equals("jasa")) {
					if (type.equals("flat")) {
						jSet.JASA.flat = Double.parseDouble(data);
					} else if (type.equals("percussive")) {
						jSet.JASA.percussive = Double.parseDouble(data);
					} else if (type.equals("undefined")) {
						jSet.JASA.undefined = Double.parseDouble(data);
					} else if (type.equals("click/click train")) {
						jSet.JASA.click = Double.parseDouble(data);
					} else if (type.equals("other")) {
						jSet.JASA.other = Double.parseDouble(data);
					}

				} else if (journal.equals("app")) {
					if (type.equals("flat")) {
						jSet.APP.flat = Double.parseDouble(data);
					} else if (type.equals("percussive")) {
						jSet.APP.percussive = Double.parseDouble(data);
					} else if (type.equals("undefined")) {
						jSet.APP.undefined = Double.parseDouble(data);
					} else if (type.equals("click/click train")) {
						jSet.APP.click = Double.parseDouble(data);
					} else if (type.equals("other")) {
						jSet.APP.other = Double.parseDouble(data);
					}

				} else if (journal.equals("mp")) {
					if (type.equals("flat")) {
						jSet.MP.flat = Double.parseDouble(data);
					} else if (type.equals("percussive")) {
						jSet.MP.percussive = Double.parseDouble(data);
					} else if (type.equals("undefined")) {
						jSet.MP.undefined = Double.parseDouble(data);
					} else if (type.equals("click/click train")) {
						jSet.MP.click = Double.parseDouble(data);
					} else if (type.equals("other")) {
						jSet.MP.other = Double.parseDouble(data);
					}

				} else if (journal.equals("hr")) {
					if (type.equals("flat")) {
						jSet.HR.flat = Double.parseDouble(data);
					} else if (type.equals("percussive")) {
						jSet.HR.percussive = Double.parseDouble(data);
					} else if (type.equals("undefined")) {
						jSet.HR.undefined = Double.parseDouble(data);
					} else if (type.equals("click/click train")) {
						jSet.HR.click = Double.parseDouble(data);
					} else if (type.equals("other")) {
						jSet.HR.other = Double.parseDouble(data);
					}

				}
				
			String json = gson.toJson(jSet).toString();
			System.out.println(json);

			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file " + "'" + fileName + "'");
		}

	}

}
