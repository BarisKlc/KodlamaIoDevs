package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		
		languages.add(new Language(1,"Java"));
		languages.add(new Language(2,"C#"));
		languages.add(new Language(3,"Phyton"));
	}
	
	
	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) {
		
		for(Language language : languages) {
			if(language.getId()==id)
			{return language;}
		}
		System.out.println("Bu ID'ye ait bir dil bulunamamıştır.");
		return null;
	}

	@Override
	public void insertLanguage(Language language) {
		languages.add(language);
		
	}

	@Override
	public void deleteLanguage(Language language) {
		languages.remove(language);
		System.out.println("Dil silindi: " + language.getName());
		
	}

	@Override
	public void updateLanguage(Language language, String newName) {
		languages.get(language.getId()).setName(newName);
		
	}

}
