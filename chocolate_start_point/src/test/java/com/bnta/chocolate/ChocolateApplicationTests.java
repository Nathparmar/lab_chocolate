package com.bnta.chocolate;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ChocolateApplicationTests {
	@Autowired
	EstateService estateService;

	@Autowired
	ChocolateService chocolateService;

	@Test
	void canReturnCocaValues() {

		List<Chocolate> actual = chocolateService.minCocoaPercentageChocolate(60);

		assertThat(actual.size()).isEqualTo(1);


	}

	
}
