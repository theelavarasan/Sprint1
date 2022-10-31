package com.ZenPack.ZenPackTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;

//@DataJpaTest
@AutoConfigureMockMvc
@SpringBootTest
public class ZenPackRepositoryTest {
    @Autowired
    private ZenPackRepository zenPackRepository;

    @Autowired
    private MockMvc mockMvc;

	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String formattedDate = myDateObj.format(myFormatObj);



    @Test
    @DisplayName("It Should save the list to database")
    void save(){
    	ZenPack zenpack = new ZenPack();
    	zenpack.setZenPackId(101L);
    	zenpack.setName("test zenpack1");
    	zenpack.setCreatedBy("team1");
    	zenpack.setCreatedDate(formattedDate);
    	zenpack.setUpdatedBy("Team1");
    	zenpack.setUpdatedTime(formattedDate);
    	
    	MenuDto menuDto = new MenuDto();
    	menuDto.setFeatureUrl("https://google.com");
		menuDto.setFeatureId("f202");
		menuDto.setIsSettingMenu(true);
		menuDto.setText("test Menu");
		menuDto.setDroppable(false);
		menuDto.setParent(101);
    	menuDto.setParentMenuId(101);
    	menuDto.setCreatedTime(formattedDate);
    	menuDto.setCreatedBy("Team2");
    	
    	FeatureDto featureDto = new FeatureDto();
    	featureDto.setFeatureId("202");
    	featureDto.setFeatureUrl("http://localhost:8091/api/v1/create");
    	featureDto.setIcon("feature1");
    	featureDto.setId(201);
    	featureDto.setIsSettingMenu(true);
    	featureDto.setParent(101);
    	featureDto.setText("Menu Feature");
    	
    	List<FeatureDto> featureList = new ArrayList<FeatureDto>();
    	featureList.add(featureDto);
    	
    	List<MenuDto> menuList = new ArrayList<MenuDto>();
    	menuList.add(menuDto);
    	zenpack.setFeatures(featureList);
    	zenpack.setMenus(menuList);
        ZenPack zenPack2 = zenPackRepository.save(zenpack);
        assertNotNull(zenPack2);
        assertThat(zenPack2.getZenPackId()).isNotEqualTo(null);
    }

}

