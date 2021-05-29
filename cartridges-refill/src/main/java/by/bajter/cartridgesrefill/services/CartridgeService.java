package by.bajter.cartridgesrefill.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.repository.CartridgeRepository;

@Service
public class CartridgeService {

	private final String STARTER_UNIQ_IDENTIFY = "B2000";
	
	@Autowired
	private CartridgeRepository repository;

	public List<Cartridge> getAllCartridges() {
		return repository.findAll();
	}

	public void save(Cartridge cartridge) {
		repository.save(cartridge);
	}

	public void delete(Cartridge cartridge) {
		repository.delete(cartridge);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Cartridge findById(long id) {
		return repository.findById(id).get();
	}

	public String getUniqIdentify() {
		List<Cartridge> sortedCartridges = repository.findAll().stream().sorted(Comparator.comparing(Cartridge::getUniqIdentify)).collect(Collectors.toList());
		
		if(sortedCartridges.isEmpty()) {
			return STARTER_UNIQ_IDENTIFY;
		}
		
		int lastCartridgesIndex = sortedCartridges.size() - 1;
		
		String lastUniqIdentifyStr = sortedCartridges.get(lastCartridgesIndex).getUniqIdentify();
		
		int lastUniqIdentifyNum = Integer.parseInt(lastUniqIdentifyStr.substring(1));

		return "B" + ++lastUniqIdentifyNum;
	}

	public Cartridge findByUniqIdentify(String uniqIdentify) {
		return repository.findByUniqIdentify(uniqIdentify);
	}
}
