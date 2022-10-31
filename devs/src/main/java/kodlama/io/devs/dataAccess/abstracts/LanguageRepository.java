package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository {
	List<Language> getAll();
	Language getById(int id);
	void insertLanguage(Language language);
	void deleteLanguage(Language language);
	void updateLanguage(Language language,String newName);
}
