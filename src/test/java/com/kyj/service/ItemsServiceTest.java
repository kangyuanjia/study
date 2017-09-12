package com.kyj.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kyj.po.ItemsCustom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*xml" })
public class ItemsServiceTest {
	@Autowired
	private ItemsService itemsService;

	@Ignore
	@Test
	public void testFindItemsList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindItemsById() throws Exception {
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		assertThat( itemsCustom.getName(), equalTo( "台式机" ) );
	}
	
	@Ignore
	@Test
	public void testUpdateItems() {
		fail("Not yet implemented");
	}

}
