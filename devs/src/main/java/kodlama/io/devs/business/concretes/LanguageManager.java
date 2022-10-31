package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	@Override
	public String insert(Language language) {
		if(this.checkName(language.getName())) return "Bu isme sahip bir dil zaten var";
		
		if(language.getName().isBlank()|| language.getName().isEmpty()) return "İsim alanı boş olamaz";
		
		this.languageRepository.insertLanguage(language);
		return "Dil eklendi";
	}
	
	@Override
	public String update(Language language) {
		
		if(this.checkName(language.getName())) 
			return "Güncellemek istediğiniz isme sahip bir dil zaten var";
		
		if(language.getName().isBlank()|| language.getName().isEmpty()) 
			return "Güncellenecek isim alanı boş olamaz";
		
		this.languageRepository.updateLanguage(language,language.getName());
		return "Dil güncellendi";
	}
	
	@Override
	public List<Language> getAll() {
		return this.languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {
		return this.languageRepository.getById(id);
	}
	
	@Override
	public void delete(Language language) {
		languageRepository.deleteLanguage(language);
	}
	
	private boolean checkName(String languageName) {
		List<Language> languages = this.languageRepository.getAll();
		boolean result = false;
		
		for(Language language:languages) {
			if(language.getName().equalsIgnoreCase(languageName)) {
				result = true;
			}
		}
		return result;
	}
	
	
}







