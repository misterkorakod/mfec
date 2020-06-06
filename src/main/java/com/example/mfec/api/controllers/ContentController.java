package com.example.mfec.api.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mfec.api.entities.Content;
import com.example.mfec.services.ContentService;

@RestController
public class ContentController {

	@Autowired
	ContentService Cnrepo;

///////////////////////////////////////Content///////////////////////////////////////
	
	
	
	@PostMapping("/addcontent")
	public Content addContent(@RequestBody Content content) {
		return Cnrepo.saveContent(content);
	}
	@PostMapping("/addallcontent")
	public List<Content> addAllContent(@RequestBody List<Content> content) {
		return Cnrepo.saveAllContent(content);
	}
	@PostMapping("/showallcontent")
	public List<Content> findAllContent() {
		return Cnrepo.getAllContent();
	}
	@PostMapping("/showcontentById/{id}")
	public Content findAllContent(@PathVariable Integer id) {
		return Cnrepo.getContent(id);
	}
	@PutMapping("/updatecontent")
	public void updateContent(@RequestBody Content content) {
		System.out.println(content.getDetail());
		Cnrepo.updateContent(content);
	}
	@DeleteMapping(value = "/deletecontent/{id}")
	public String deleteContentbyid(@PathVariable Integer id) {
		return Cnrepo.deleteContent(id);
	}

}
