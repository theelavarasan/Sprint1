package com.ZenPack.FeaturesTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.FeaturedListRepository;

//@DataJpaTest
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeaturedListRepositoryTest {
    @Autowired
    private FeaturedListRepository featuredListRepository;

    @Autowired
    private MockMvc mockMvc;

    private FeaturedList list;
    private FeaturedList list1;


    @Test
    @Order(1)
    @Rollback(value = false)
    @DisplayName("It Should save the list to database")
    void save(){
        FeaturedList list=new FeaturedList();
        list.setId(1);
        list.setParent(0);
        list.setFeatureId("#");
        list.setText("Project Management");
        list.setFeatureUrl(null);
        list.setIcon("#");
        list.setIsSettingMenu(true);
        FeaturedList newList = featuredListRepository.save(list);
        assertNotNull(newList);
        assertThat(newList.getId()).isNotEqualTo(null);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    @DisplayName("It should return List from database")
    void getAllList(){
        List<FeaturedList> featuredLists = featuredListRepository.findAll();

        assertNotNull(featuredLists);
        assertThat(featuredLists).isNotNull();
        assertNotEquals(7,featuredLists.size());
    }
//
    @Test
    @Order(3)
    @Rollback(value = false)
    @DisplayName("It should update the list name with PROJECT")
    void updateList() {
        FeaturedList list=new FeaturedList();
        list.setId(8);
        list.setFeatureId("#");
        list.setText("Project Management");
        list.setFeatureUrl("#");
        list.setIcon("#");
        list.setIsSettingMenu(true);

        featuredListRepository.save(list);

        FeaturedList existingList = featuredListRepository.findById(list.getId()).get();
        existingList.setText("Project Management");
        FeaturedList updatedList = featuredListRepository.save(existingList);

        assertEquals("Project Management", updatedList.getText());
    }
//
    @Test
    @Order(4)
    @Rollback(value = false)
    @DisplayName("It should delete the existing list")
    void deleteList() {

        FeaturedList list=new FeaturedList();
        list.setId(11);
        list.setFeatureId("#");
        list.setText("Project Management");
        list.setFeatureUrl(null);
        list.setIcon("#");
        list.setIsSettingMenu(true);

        featuredListRepository.save(list);
        Integer id = list.getId();

        //featuredListRepository.save(list1);

        featuredListRepository.delete(list);

        List<FeaturedList> list1 = featuredListRepository.findAll();

        Optional<FeaturedList> existingList = featuredListRepository.findById(id);

//        assertEquals(5, list1.size());
        assertThat(existingList).isEmpty();

    }
}

