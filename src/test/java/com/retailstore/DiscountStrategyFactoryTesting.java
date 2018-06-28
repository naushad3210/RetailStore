package com.retailstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
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
	
	@InjectMocks
	DiscountStrategyFactory discountStrategyFactoryMock;
	
	@Test
	public void nonGroceryStrategyTest() {
		assertNotNull(discountStrategyFactoryMock.getStrategy(ItemType.OTHER));
    }
	
	@Test
	public void groceryStrategyTest() {
		assertNotNull(discountStrategyFactoryMock.getStrategy(ItemType.GROCERY));
    }
	
	@Test(expected = ResourceNotFoundException.class)
	public void failStrategyTest() {
        assertEquals(null,discountStrategyFactoryMock.getStrategy(null));
    }

}
