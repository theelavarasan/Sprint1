package com.ZenPack.ZenPackTest;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Impl.ZenPackServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ZenPackServiceTest {
    @Mock
    private ZenPackRepository repository;

    @InjectMocks
    private ZenPackServiceImpl service;

    private ZenPackDto zenPackDto;
    private MenuDto menuDto;

	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String formattedDate = myDateObj.format(myFormatObj);

    @BeforeEach
    public void setUp(){
    	zenPackDto= new ZenPackDto();
    	zenPackDto.setZenPackId(210L);
    	zenPackDto.setName("Test_Controller");
    	zenPackDto.setCreatedDate(formattedDate);
    	zenPackDto.setCreatedBy("Team2");
    	zenPackDto.setUpdatedBy("Team2");
    	zenPackDto.setUpdatedTime(formattedDate);
    	
		menuDto = new MenuDto();
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
		zenPackDto.setFeatures(featureList);
		zenPackDto.setMenus(menuList);
    }
    @Test
    @DisplayName("Junit Test for Save List")
    void saveList(){
    	ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setAmbiguityIgnored(true);
		ZenPack zenPack = mapper.map(zenPackDto, ZenPack.class);

        given(repository.save(zenPack)).willReturn(zenPack);

//        System.out.println(repository);
//        System.out.println(service);

        //ResponseEntity<ZenPackDto> savedList = service.createZenPack(zenPackDto);

//        System.out.println(savedList);
        //assertThat(savedList).isNotNull();
    }


}
