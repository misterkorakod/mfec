package com.example.mfec.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mfec.api.entities.Content;
import com.example.mfec.api.entities.Employee;
import com.example.mfec.repositories.ContentRepository;

@Service
public class ContentService {
	@Autowired
	private ContentRepository Cnrepo;
	public Content saveContent(Content content) {
		return Cnrepo.save(content);
	}
	public List<Content> saveAllContent(List<Content> content) {
		return Cnrepo.saveAll(content);
	}
	public List<Content> getAllContent(){
		return Cnrepo.findAll();
	}
	public Content getContent(Integer id){
		return Cnrepo.findById(id).orElse(null);
	}
	public Content updateContent(Content content) {
		Content exitingContent = Cnrepo.findById(content.getContentId()).orElse(null);
		exitingContent.setContentName(content.getContentName());
		exitingContent.setDetail(content.getDetail());
        return Cnrepo.save(exitingContent);
    }
	public String deleteContent(Integer id) {
		Cnrepo.deleteById(id);
		return "User remove::"+id;
	}
	
	

	
	
}

