package coronavirus.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import coronavirus.domain.Country;
import coronavirus.domain.Global;
import coronavirus.repository.CountryRepository;
import coronavirus.repository.GlobalRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoronaVirusDataService {

    private static final String VIRUS_GLOBAL_DATA = "https://coronavirus-19-api.herokuapp.com/all";
    private static final String VIRUS_PER_COUNTRY_DATA = "https://coronavirus-19-api.herokuapp.com/countries";
	
	private final RestTemplate restTemplate;
	private final CountryRepository countryRepo;
	private final GlobalRepository globalRepo;
	
	@Autowired
	public CoronaVirusDataService(RestTemplateBuilder builder, CountryRepository countryRepo,
			GlobalRepository globalRepo) {
		this.restTemplate = builder.build();
		this.countryRepo = countryRepo;
		this.globalRepo = globalRepo;
	}
	
	@PostConstruct
	@Scheduled(cron = "0 0/30 * * * ?")
	public void fetchVirusData() {
		
		 Global global = restTemplate.getForObject(VIRUS_GLOBAL_DATA, Global.class);
		 Country[] countries = restTemplate.getForObject(VIRUS_PER_COUNTRY_DATA, Country[].class);
		 
		 globalRepo.save(global);
		 
		 Arrays.stream(countries, 7, 220)
		    .forEach(country -> countryRepo.save(country));
		
	}
}
