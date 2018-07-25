package com.retailstore.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.retailstore.billing.DiscountStrategy;
import com.retailstore.billing.GroceryDiscountStrategy;
import com.retailstore.billing.NonGroceryDiscountStrategy;
import com.retailstore.enums.ItemType;
import com.retailstore.exceptions.ResourceNotFoundException;

/**
 * The DiscountStrategyFactory is a factory class which creates and returns the
 *  appropriate DiscountStrategy object based on the item type
 *  
 * @author mohammadnaushad
 *
 */
@Component
public class DiscountStrategyFactory {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscountStrategyFactory.class);
	/**
	  * Use getStrategy method to get object of itemType
	 * @param itemType
	 * @return object of type DiscountStrategy
	 */
	public DiscountStrategy getStrategy(ItemType itemType){
	      if(itemType == null){
	    	 LOGGER.error("-- Inside [DiscountStrategyFactory] [Method: getStrategy()]] ItemType is NULL !!");
	         throw new ResourceNotFoundException("ItemType", "itemType", itemType);
	      }		
	      if(itemType == ItemType.GROCERY){
	         return new GroceryDiscountStrategy();
	         
	      } else if(itemType == ItemType.OTHER){
	         return new NonGroceryDiscountStrategy();
	      }
	      LOGGER.error("-- Inside [DiscountStrategyFactory] [Method: getStrategy()]] DiscountStrategy is NULL !!");
	      return null;
	   }
}
