//package com.ZenPack.excel;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import com.ZenPack.model.ZenPack;
//
//import java.io.IOException;
//
//import java.util.ArrayList;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.catalina.connector.Response;
//import org.junit.jupiter.api.Disabled;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.mock.web.MockHttpServletResponse;
//
//class ZenPackExcelExporterTest {
//    @Test
//    void testConstructor() {
//        new ZenPackExcelExporter(new ArrayList<>());
//    }
//
//    @Test
//    void testConstructor2() {
//        ZenPack zenPack = new ZenPack();
//        zenPack.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        zenPack.setCreatedDate("2020-03-01");
//        zenPack.setFeatures(new ArrayList<>());
//        zenPack.setInActive(true);
//        zenPack.setMenus(new ArrayList<>());
//        zenPack.setName("UUU/UUU");
//        zenPack.setUpdatedBy("2020-03-01");
//        zenPack.setUpdatedTime("2020-03-01");
//        zenPack.setZenPackId(123L);
//
//        ArrayList<ZenPack> zenPackList = new ArrayList<>();
//        zenPackList.add(zenPack);
//        new ZenPackExcelExporter(zenPackList);
//    }
//
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testExport() throws IOException {
//
//        ZenPackExcelExporter zenPackExcelExporter = new ZenPackExcelExporter(new ArrayList<>());
//        zenPackExcelExporter.export(new Response());
//    }
//
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testExport2() throws IOException {
//        ZenPack zenPack = new ZenPack();
//        zenPack.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        zenPack.setCreatedDate("2020-03-01");
//        zenPack.setFeatures(new ArrayList<>());
//        zenPack.setInActive(true);
//        zenPack.setMenus(new ArrayList<>());
//        zenPack.setName("UUU://");
//        zenPack.setUpdatedBy("2020-03-01");
//        zenPack.setUpdatedTime("2020-03-01");
//        zenPack.setZenPackId(123L);
//
//        ArrayList<ZenPack> zenPackList = new ArrayList<>();
//        zenPackList.add(zenPack);
//        ZenPackExcelExporter zenPackExcelExporter = new ZenPackExcelExporter(zenPackList);
//        zenPackExcelExporter.export(new Response());
//    }
//
////    @Test
//    void testExport3() throws IOException {
//        ZenPackExcelExporter zenPackExcelExporter = new ZenPackExcelExporter(new ArrayList<>());
//        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
//        zenPackExcelExporter.export(mockHttpServletResponse);
//        assertTrue(mockHttpServletResponse.isCommitted());
//    }
//
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testExport4() throws IOException {
//        (new ZenPackExcelExporter(new ArrayList<>())).export(null);
//    }
//}
//
