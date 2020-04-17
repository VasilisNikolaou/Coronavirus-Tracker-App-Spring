package coronavirus.web;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import coronavirus.domain.Country;
import coronavirus.domain.Global;
import coronavirus.repository.CountryRepository;
import coronavirus.repository.GlobalRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/coronavirus")
@RequiredArgsConstructor
public class WebController {
	
	private final CountryRepository countryRepo;
	private final GlobalRepository globalRepo;
	
	@ModelAttribute(name = "global")
	public Global global() {
		return globalRepo.findById(Long.valueOf("1")).get();
	}
	
	@ModelAttribute(name = "countries")
	public List<Country> countries() {
		return countryRepo.findAll(Sort.by("cases").descending());
	}

	@GetMapping
	public String showHomePage() {
		return "covid";
	}
}
