package com.ZenPack.ZenPackTest;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.controller.ZenPackController;
import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ZenPackControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZenPackRepository repository;

    @MockBean
    private ZenPackServiceImpl service;

    @InjectMocks
    private ZenPackController zenPackController;

    @Autowired
    private ObjectMapper objectMapper;
    
    private ZenPackDto zenPackDto; 
    private MenuDto menuDto;

	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String formattedDate = myDateObj.format(myFormatObj);


    @BeforeEach
    void init(){
    	zenPackDto = new ZenPackDto();
		zenPackDto.setZenPackId(210L);
		zenPackDto.setName("Test_Controller");
		zenPackDto.setCreatedDate(formattedDate);
		zenPackDto.setCreatedBy("Team2");
		zenPackDto.setUpdatedBy("Team2");
		zenPackDto.setUpdatedTime(formattedDate);
		
		menuDto = new MenuDto();
		menuDto.setParentMenuId(101);
		menuDto.setCreatedTime(formattedDate);
		menuDto.setCreatedBy("Team2");
		menuDto.setFeatureUrl("https://google.com");
		menuDto.setFeatureId("f202");
		menuDto.setIsSettingMenu(true);
		menuDto.setText("test Menu");
		menuDto.setDroppable(false);
		menuDto.setParent(101);
		
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
		
		zenPackDto.setMenus(menuList);
    }

    @Test
    public void shouldCreateZenPackTest() throws Exception {
    	ZenPackDto zenPackDto = new ZenPackDto();
		zenPackDto.setZenPackId(210L);
		zenPackDto.setName("Test_Controller");
		zenPackDto.setCreatedDate(formattedDate);
		zenPackDto.setCreatedBy("Team2");
		zenPackDto.setUpdatedBy("Team2");
		zenPackDto.setUpdatedTime(formattedDate);
		MenuDto menuDto = new MenuDto();
		//menuDto.setMenuName("Test_zenpack1_menu");
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
	//	menuDto.setFeatures(featureList);
		
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		menuList.add(menuDto);
		
		zenPackDto.setMenus(menuList);
		
		ResponseEntity<ZenPackDto> res = new ResponseEntity<ZenPackDto>(zenPackDto, HttpStatus.OK);
        when(service.createZenPack(zenPackDto)).thenReturn(res);

        this.mockMvc.perform(post("/api/v1/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(zenPackDto)))
                .andExpect(status().isOk())
                .andReturn();


    }
//
    @Test
    void shouldFetchAllList() throws Exception {

        List<ZenPackDto> zenPackDtoList = new ArrayList<>();
        zenPackDtoList.add(zenPackDto);

        when(service.getAllZenPack()).thenReturn(zenPackDtoList);

        this.mockMvc.perform(get("/api/v1/get_all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",CoreMatchers.is(zenPackDtoList.size())))
                .andExpect(jsonPath("$[0].name", CoreMatchers.is(zenPackDto.getName())))
                .andExpect(jsonPath("$[0].menus.[0].createdBy", CoreMatchers.is(menuDto.getCreatedBy())));
    }

    @Test
    void shouldDeleteList() throws Exception {

    	when(service.deleteByzenPackId(anyLong())).thenReturn("Deleted SuccessFully");

        this.mockMvc.perform(delete("/api/v1/delete/{zenPackId}", 2))
                .andExpect(status().isOk());

    }
	

}




