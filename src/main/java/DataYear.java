import com.google.gson.*;
import java.io.*;

public class DataYear {

	public static JournalSet jSet = new JournalSet();

	public static int[] getYearRange(String fileName, String filePath) {
		int start = 999999;
		int end = -999999;
		int[] ans = new int[2];
		String line = null;

		try {

			FileReader fileReader = new FileReader(filePath + fileName + ".csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				String[] lineData = line.split(",");
				int currentYear = Integer.parseInt(lineData[1]);

				// System.out.println(start + "/" + end + " <= " + currentYear);

				if (currentYear > end) {
					end = currentYear;
				}
				if (currentYear < start) {
					start = currentYear;
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file " + "'" + fileName + "'");
		}
		ans[0] = start;
		ans[1] = end;
		System.out.println(start + " - " + end);
		return ans;
	}

	public static void insertDataIntoJSET(String journal, String type, String data, boolean createNewSet) {

		if (createNewSet) {
			jSet = new JournalSet();
		}

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
	}

	public static void main(String[] args) {
		Gson gson = new Gson();

		String fileName = "data1";
		String filePath = "json/";
		String line = null;

		int[] s0e1 = getYearRange(fileName, filePath);
		int startYear = s0e1[0];
		int endYear = s0e1[1];

		// Arbitrary large and small (negative) numbers
		try {

			FileReader fileReader = new FileReader(filePath + fileName + ".csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			PrintWriter writer = new PrintWriter(filePath + fileName + ".json", "UTF-8");
			line = null;

			writer.println("{");
			// line by line to console
			while ((line = bufferedReader.readLine()) != null) {

				String[] lineData = line.split(",");
				String type = lineData[0].toLowerCase();
				String year = lineData[1].toLowerCase();
				String journal = lineData[2].toLowerCase();
				String data = lineData[3].toLowerCase();

				// System.out.println("\"" + startYear + "\":");
				System.out.println("Comparing: " + startYear + " to " + year + " & Holding: " + year);

				while (startYear < Integer.parseInt(year)) {
					startYear++;
					System.out.println("new JournalSet for: " + startYear);
				}
				if (startYear == Integer.parseInt(year)) {
					System.out.println("OBJECT <<< DATA");
				}

				System.out.println("\n");

				// insertDataIntoJSET(journal, type, data, true);
				// writer.println(gson.toJson(jSet));

			}
			writer.println("}");

			writer.close();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file " + "'" + fileName + "'");
		}

	}

}
