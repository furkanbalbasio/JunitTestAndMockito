package com.muhammet.jnuttest;

import com.muhammet.Islemler;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test02_YasamDongusu {

    private static List<String> userList;
    private static Islemler islemler;
    // Her seyden once calistirmak istedigimiz bir metot varsa @BeforeAll kullanilir.
    @BeforeAll
    void initAll(){
        islemler = new Islemler();
        System.out.println("@BeforeAll: Ben herşeyden önce başlarım");
    }

    // Testlerden once calistirmak istedigimiz bir metot varsa @BeforeEach kullanilir.

    @BeforeEach
    void init(){
        userList = new ArrayList<>();
        userList.add("Muhammet");
        userList.add("Deniz");
        System.out.println("@BeforeEach: Testleden önce Çalışır");
    }
    @Test
    void denemeTest(){
        userList.add("Yeni ekleme Yapıldı.");
        System.out.println("Deneme test çalıştı"+ userList);
    }
    @Test
    void deneme2Test(){
        userList.add("Makarna");
        System.out.println("2. test...: "+userList);
    }
    //@Disabled testlerin disable olmasini saglar.
    @Test
    @Disabled
    void failingTest() throws InterruptedException {
        for(int i=1; i<=5;i++){
            Thread.sleep(1000L);

            if (i==4)
                Assertions.fail("çok uzun tam sayı nedeniyle fail oldu");
            //Test durduruluyor fail oluyor.
            else
                System.out.println("normal çalışma durumu..: "+ i);

        }

    }

    @Test
    @Disabled("bir süreliğine kapalı")
    void gerliliginiGeciciSureyleYitirmisTest(){
        System.out.println("Testt");
    }

    //Testlerden sonra calistirmak icin @AfterEach kullaniriz.
    @AfterEach
    void after(){
        System.out.println("@AfterEach: Her testten sonra ben varım.");
    }
    // Her seyden sonra metot calistirmak icin @AfterAll kullanilir.
    @AfterAll
    void afterAll(){
        System.out.println("@AfterAll: Ben son ütücüyüm :)");
    }
}
