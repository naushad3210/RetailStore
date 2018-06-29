package com.retailstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.retailstore.enums.ItemType;
import com.retailstore.exceptions.ResourceNotFoundException;
import com.retailstore.factory.DiscountStrategyFactory;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DiscountStrategyFactoryTesting {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscountStrategyFactoryTesting.class);
	
	@InjectMocks
	DiscountStrategyFactory discountStrategyFactoryMock;
	
	@Test
	public void nonGroceryStrategyTest() {
		LOGGER.info("-- Testing [DiscountStrategyFactoryTesting] [Method: nonGroceryStrategyTest()]");
		assertNotNull(discountStrategyFactoryMock.getStrategy(ItemType.OTHER));
    }
	
	@Test
	public void groceryStrategyTest() {
		LOGGER.info("-- Testing [DiscountStrategyFactoryTesting] [Method: groceryStrategyTest()]");
		assertNotNull(discountStrategyFactoryMock.getStrategy(ItemType.GROCERY));
    }
	
	@Test(expected = ResourceNotFoundException.class)
	public void failStrategyTest() {
		LOGGER.info("-- Testing [DiscountStrategyFactoryTesting] [Method: failStrategyTest()]");
        assertEquals(null,discountStrategyFactoryMock.getStrategy(null));
    }

}
