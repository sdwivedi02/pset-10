import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class Dictionary {

	public static ArrayList<Word> getWords() {
		try {

			Gson gson = new Gson();

			Reader reader = Files.newBufferedReader(Paths.get("src/words.json"));

			List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));

			ArrayList<Word> wordsAL = new ArrayList<Word>(words);

			// close reader
			reader.close();

			return wordsAL;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<String> getNames() {
		try {

			Gson gson = new Gson();

			Reader reader = Files.newBufferedReader(Paths.get("src/words.json"));

			List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));

			ArrayList<String> names = new ArrayList<String>();
			for (int i = 0; i < words.size(); i++) {
				names.add(words.get(i).getName());
			}

			// close reader
			reader.close();

			return names;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<Definition> getDefinitions(String name) {

		Reader reader;

		try {
			Gson gson = new Gson();
			reader = Files.newBufferedReader(Paths.get("src/words.json"));
			List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));

			ArrayList<Definition> defs = new ArrayList<Definition>();

			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).getName().equals(name)) {
					defs = (words.get(i).getDefinitions());
				}
			}

			return defs;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}